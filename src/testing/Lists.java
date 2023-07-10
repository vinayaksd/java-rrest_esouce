package testing;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import sailpoint.api.PersistenceManager;
import sailpoint.api.SailPointContext;
import sailpoint.api.logging.SyslogAppender;
import sailpoint.object.Bundle;
import sailpoint.object.Capability;
import sailpoint.object.Identity;
import sailpoint.object.Link;
import sailpoint.object.Permission;
import sailpoint.object.SailPointObject;
import sailpoint.tools.GeneralException;

public class Lists {

	public static void main(String[] args) throws GeneralException {
		SailPointContext context=null;
		
		Identity identity=null;
	
		String part1="cn=";
		String part2=",cn=Users,DC=Test,DC=local";
		
		
		
		String fullCn=part1+identity.getName()+part2;
		
		System.out.println(fullCn);
		
		return fullCn;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
				
		
		
		
		
		
		
		/*Identity identity = context.getObject(Identity.class,"Albert.Woods");
		Application app = context.getObject(Application.class,"TRAKK");
		String appname= app.getName();
		List<Capability> capabilities = id.getCapabilities();
		
		List<Link> links=identity.getLinks();
		Map mapOfLinks= new HashMap<String,Object>();
		ArrayList listLinks=new ArrayList();
		
		for(Link link:links) {
		System.out.println("APP NAME: "+link.getApplicationName()+"IDName: "+link.getDisplayName()+
				"ID: "+link.getId());
		listLinks.add(link.getApplicationName()+" "+link.getDisplayName()+" "+link.getId()+"name: "+link.getName());
			}
		
		
		List<Bundle> bundles=identity.getBundles();
		ArrayList bundle=new ArrayList();
		
		for(Bundle bund: bundles )
		bundle.add(bund.getAssignedRoles());
		
		ArrayList list=new ArrayList();
		if(capabilities!=null && capabilities.size()>0) {
		for(Capability cap:capabilities) {
			System.out.println(cap.getName()+" ");
			list.add(cap.getName());
		}
		}
		else {
			System.out.println("no Capabilities.....");
		}*/
	}

}
