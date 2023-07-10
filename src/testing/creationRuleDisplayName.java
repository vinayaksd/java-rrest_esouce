package testing;

import sailpoint.object.SailPointObject;
import sailpoint.api.SailPointContext;
import sailpoint.object.Identity;
import sailpoint.object.ResourceObject;
import sailpoint.tools.GeneralException;

public class creationRuleDisplayName {

	public static void main(String[] args)  throws GeneralException  {
		SailPointContext context=null;
		ResourceObject account=null;
		Identity identity=null;
		String firstName=(String)account.getAttribute("firstName");
		String lastName=(String)account.getAttribute("lastName");
		String finalName=firstName.substring(0, 1).concat(lastName);
		identity.setDisplayName(finalName);
		System.out.println("finalName is ========="+finalName);
	}

}
