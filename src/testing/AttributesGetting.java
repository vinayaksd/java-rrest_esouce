package testing;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sailpoint.api.SailPointContext;
import sailpoint.object.Application;
import sailpoint.object.Attributes;
import sailpoint.object.Filter;
import sailpoint.object.Identity;
import sailpoint.object.QueryOptions;
import sailpoint.tools.GeneralException;
public class AttributesGetting {

	public static void main(String[] args) throws GeneralException {
		SailPointContext context=null;
		
		Identity identity = context.getObject(Identity.class,"Samuel.Marshall");
		Attributes atts=identity.getAttributes();
		if(atts!=null) {
			 for (Map.Entry set :
				 atts.entrySet()) {
	 
	            // Printing all elements of a Map
	            System.out.println(set.getKey() + " = "
	                               + set.getValue());
	        }
		
		}
	}
		
		
		/*
		QueryOptions qo=new QueryOptions();
		Filter filter = Filter.eq("costcenter","R03e, L09");
		qo.addFilter( filter);
		
		
		List<Identity> Identitys=context.getObjects(Identity.class,qo);
		ArrayList list=new ArrayList();
		
		System.out.println("ids Having costcenter...");
		System.out.println("size: "+Identitys.size());
		if(Identitys!=null && Identitys.size()>0) {
		for(Identity ids: Identitys) {
			System.out.println("ids:"+ids.getFullName());
			list.add("ids:"+ids.getFullName());
		}
		
		}
		*/
		
		/*
		 * List<Application> applications=context.getObjects(Application.class);
Attributes atts=applications.getAttributes();

if(atts!=null) {
			 for (Map.Entry get :
				 atts.entrySet()) {
	 
	            // Printing all elements of a Map
	            System.out.println(FilePath is  + " = "
	                               + get.get(file));
	        }
		
		}
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		

	
	

