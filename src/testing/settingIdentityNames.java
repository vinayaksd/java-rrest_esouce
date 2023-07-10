package testing;

import sailpoint.object.Identity;
import sailpoint.object.ResourceObject;
import java.util.logging.Level;
import java.util.logging.Logger;
public class settingIdentityNames {

	public static void main(String[] args) {
		Identity identity;
		ResourceObject object;
		Logger log=Logger.getLogger("SailPoint");
		log.log(Level.INFO,"This is message-1");
		log.log(Level.WARNING,"This is message-2");
		log.info("Rule starting......");
		System.out.println("Rule starting......");
		String fName=object.getStringAttribute("firstName");
		String LName=object.getStringAttribute("lastName");
		String FinalName=fName.substring(0,1)+LName;
		identity.setFirstname(FinalName);
		System.out.println("Rule Ending....");
		log.info("Rule Ending......"); 

	}

}
