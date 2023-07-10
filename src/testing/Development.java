package testing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import sailpoint.api.PersistenceManager;
import sailpoint.api.Provisioner;
import sailpoint.api.SailPointContext;
import sailpoint.object.Application;
import sailpoint.object.Capability;
import sailpoint.object.Identity;
import sailpoint.object.Permission;
import sailpoint.object.ProvisioningPlan;
import sailpoint.object.ProvisioningPlan.AccountRequest;
import sailpoint.object.SailPointObject;
import sailpoint.tools.GeneralException;

public class Development {

	public static void main(String[] args) throws GeneralException {

		SailPointContext context = null;
		Identity identity = context.getObjectByName(Identity.class, "Frank.Rivera");
		List<Application> applications = context.getObjects(Application.class);
		if (applications != null && applications.size() > 0)
			for (Application app : applications)
				System.out.println("your Application name: " + app.getName() + " type" + app.getType());

		if (identity != null) {
			System.out.println("your identity name: " + identity.getName());
			System.out.println("your Firstname name: " + identity.getFirstname());
			System.out.println("your Lastname name: " + identity.getLastname());
			System.out.println("Location: " + identity.getAttribute("location"));
			System.out.println("Department: " + identity.getAttribute("department"));
			identity.getStringAttribute("department");

			String pass = identity.getPassword() == null ? "no value" : context.decrypt(identity.getPassword());
			System.out.println("password: " + pass);

			String passHist = identity.getPasswordHistory() == null ? "no value" : identity.getPasswordHistory();
			System.out.println("passwordHistory: " + passHist);

			System.out.println("LastLogin : " + identity.getLastLogin());
			System.out.println("ManagerNmae : " + identity.getManager().getName());
			System.out.println("ManagerEmail : " + identity.getManager().getEmail());
			List Workgrps = identity.getWorkgroups();
			String wg = "";
			int w = Workgrps.size();
			for (Object i : Workgrps)
				wg += ((SailPointObject) i).getName() + " ";

			System.out.println("\nfWorkgrps:  " + Workgrps);
			System.out.println("\nWorkgrps:  " + wg);
			System.out.println("email: " + identity.getEmail());
			System.out.println("Region: " + identity.getAttribute("region"));
			System.out.println("DisplayName: " + identity.getDisplayName());
			Date RefreshTime = identity.getLastRefresh();
				identity.setUid("");
			boolean hasCapability = identity.hasCapability("spadmin");
			System.out.println("hasCapability  " + hasCapability);
			boolean isInactive = identity.isInactive();
			System.out.println("isInactive=" + identity.isInactive());
			String AuthApplication = identity.getAuthApplication();

			System.out.println("AuthApplication=" + AuthApplication);
			Object costcenter = identity.getAttribute("costcenter") == null ? "no value"
					: identity.getAttribute("costcenter");

			System.out.println("CostCenter: " + costcenter);
			System.out.println("Region: " + identity.getLastRefresh());
			identity.getManager();
		} else {
			System.out.println("has null value");
		}

	}
	/*
	 * SailPointContext context = null; String name = "Akash"; String appname =
	 * "active"; ArrayList list = new ArrayList(); ProvisioningPlan plan = new
	 * ProvisioningPlan(); Identity identity = context.getObject(Identity.class,
	 * "name"); plan.setIdentity(identity); AccountRequest ar = new
	 * AccountRequest(); Application application =
	 * context.getObject(Application.class, appname);
	 * ar.setApplication(application.getName());
	 * ar.setOperation(AccountRequest.Operation.Create); ar.setNativeIdentity(name);
	 * 
	 * list.add(ar); //adding acct req to a list plan.setAccountRequests(list);
	 * //setting list to plan
	 * 
	 * Provisioner p = new Provisioner(context); p.compile(plan); // provisioner
	 * object passing provisionig plan p.execute();
	 */

}
