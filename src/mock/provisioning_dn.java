package mock;

import sailpoint.api.SailPointContext;
import sailpoint.object.Filter;
import sailpoint.object.*;
import sailpoint.object.QueryOptions;
import sailpoint.api.PasswordGenerator;
import sailpoint.tools.GeneralException;

public class provisioning_dn {

	public static void main(String[] args) {
		
		Identity identity =null;
		SailPointContext context=null;
		
		/*String enterpriseuid = "";
		int count = 1;
		int i;
		String uid = identity.getFirstname() + "." + identity.getLastname();
		String userid = identity.getFirstname() + "." + identity.getLastname();
		
		do {
			QueryOptions qo = new QueryOptions();
			Filter a = Filter.eq("uid", uid);

			qo.addFilter(a);
			i = context.countObjects(Identity.class, qo);
			if (i > 1) {
				count++;
				uid = userid + count;
				identity.setUid(uid);
			}
		} while (i != 0);
		identity.setUid(uid);
		String p1 = "uid=";
		String p2 = ",ou=people,dc=sailpoint,dc=sp";
		String finalDn = p1 + uid + p2;
		return finalDn;
*/
		Identity id = context.getObjectByName(Identity.class,identity.getName());
		Application ldapApplication = context.getObjectByName(Application.class,"Enterprise Directory");
		PasswordGenerator passwordGenerator = new PasswordGenerator(context);

		return passwordGenerator.generatePassword(id,ldapApplication);
		
		
		
		
		// for uid ----------------------------------------------------
		int count = 1;
		int i;
		String uid = identity.getFirstname() + "." + identity.getLastname();
		String userid = identity.getFirstname() + "." + identity.getLastname();
		
		do {
			QueryOptions qo = new QueryOptions();
			Filter a = Filter.eq("uid", uid);

			qo.addFilter(a);
			i = context.countObjects(Identity.class, qo);
			if (i > 1) {
				count++;
				uid = userid + count;
			}
		} while (i != 0);
		String p1 = "uid=";
		String p2 = ",ou=people,dc=sailpoint,dc=sp";
		String finalDn = p1 + uid + p2;
		return finalDn;
		
	}

}
