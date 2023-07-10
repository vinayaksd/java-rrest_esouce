package mock;
import sailpoint.object.Application;
import sailpoint.object.Bundle;
import sailpoint.object.Identity;
		import sailpoint.api.Provisioner;
		import sailpoint.api.SailPointContext;
		import sailpoint.object.Application;
		import sailpoint.object.Identity;
		import sailpoint.object.ProvisioningPlan;
		import sailpoint.object.ProvisioningPlan.AccountRequest;
		import sailpoint.tools.GeneralException;
		import  sailpoint.object.ProvisioningPlan.AttributeRequest;
		import java.util.ArrayList;
			
public class provisioning_plan {

	public static void main(String[] args) {
		
		SailPointContext context = null;
			String appName = "Enterprise Directory";

				System.out.println("identityName" + identityName);

				Identity identityName1 = context.getObject(Identity.class, identityName);

				ProvisioningPlan plan = new ProvisioningPlan();
				ArrayList accountRequestList = new ArrayList();

				plan.setIdentity(identityName1);

				AccountRequest adAccountRequest = new AccountRequest();

				Application AppName1 = context.getObject(Application.class, appName);

				adAccountRequest.setApplication(AppName1.getName());
				adAccountRequest.setOperation(AccountRequest.Operation.Create);

				AttributeRequest fnAttRequest = new AttributeRequest("givenName", ProvisioningPlan.Operation.Set,
						identityName1.getFirstname());
				AttributeRequest mailAttRequest = new AttributeRequest("mail", identityName1.getEmail());
			

				AttributeRequest groupsatts = new AttributeRequest("groups",
						"cn=vpn-corp_ssl,ou=groups,dc=sailpoint,dc=sp");
				
				int dept=Integer.parseInt(identityName1.getAttribute("department_code"));
				  
			  	if(dept==20) {
			  	  Bundle assignedBundleRole = context.getObject(Bundle.class, "Tool Design Role");
			  	identityName1.addAssignedRole(assignedBundleRole);
			  		
			  	}
				if(dept==19) {
				  	  Bundle assignedBundleRole = context.getObject(Bundle.class, "Engineering Role");
				  	identityName1.addAssignedRole(assignedBundleRole);
				  		
				  	}
				adAccountRequest.add(fnAttRequest);
				adAccountRequest.add(mailAttRequest);
				//adAccountRequest.add(employeeIDAttRequest);
				adAccountRequest.add(groupsatts);

				//String finalName = "CN=" + identityName1.getName() + ",CN=people,DC=sailpoint,DC=sp";

				//System.out.println("Final name --->" + finalName);
				//adAccountRequest.setNativeIdentity(finalName);

				accountRequestList.add(adAccountRequest);

				plan.setAccountRequests(accountRequestList);

				System.out.println("Plan ---->" + plan.toXml());

				Provisioner p = new Provisioner(context);

				p.compile(plan);
				p.execute();
			   System.out.println("Starting Plan---->"+ plan);
				return plan;
		}


	}

}
