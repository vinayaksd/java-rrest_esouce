package testing;
import java.util.ArrayList;
import java.util.List;

import sailpoint.api.PersistenceManager;
import sailpoint.api.SailPointContext;
import sailpoint.object.Identity;
import sailpoint.object.Permission;
import sailpoint.object.SailPointObject;
import sailpoint.tools.GeneralException;
public class getCapability {
	private static PersistenceManager context;

	public static void main(String[] args) throws GeneralException {
		
		/*Identity identity =context.getObjectByName(Identity.class,"spadmin");
		 String wg="";
		 int capcount=0;
		 
		  if(identity!=null){
				List capability=identity.getCapabilities();
				capcount= capability.size();
				 
		      for(Object i:capability) {
		        
		          System.out.println("capability: ");
		          wg+=(((SailPointObject)i).getName()+"\n");
		      }
		  }
		  return "\ncapabilites : "+wg+"\ncapcount "+capcount;
}*/
		
	
	}
}

