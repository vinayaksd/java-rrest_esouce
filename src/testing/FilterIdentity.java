package testing;

import java.util.ArrayList;
import java.util.List;

import sailpoint.api.SailPointContext;
import sailpoint.object.Filter;
import sailpoint.object.Identity;
import sailpoint.object.QueryOptions;
import sailpoint.tools.GeneralException;

public class FilterIdentity {

	public static void main(String[] args) throws GeneralException {
		
		SailPointContext context=null;
		
		/*Filter filter = Filter.eq("department","Information Technology");
		QueryOptions qo=new QueryOptions();
		qo.addFilter(filter);
		
		
		List<Identity> Identitys=context.getObjects(Identity.class,qo);
		ArrayList list=new ArrayList();
		
		System.out.println("ids Having workgroups...");
		System.out.println("size: "+Identitys.size());
		if(Identitys!=null && Identitys.size()>0) {
		for(Identity ids: Identitys) {
			System.out.println("ids:"+ids.getFullName());
			list.add("ids:"+ids.getFullName());
		}
		
		}
		*/
		
		  ArrayList identityNames=new ArrayList();
	        ArrayList adding =new ArrayList();
	        Filter dpFilter=Filter.eq("department","Finance");
	        Filter wgFilter=Filter.eq("region", "Americas");
	        adding.add(dpFilter);
	        adding.add(wgFilter);
	        Filter finalfilter= Filter.and(adding);
System.out.println("finalfilter: "+finalfilter);
	        QueryOptions qo=new QueryOptions();
	        qo.addFilter(finalfilter);

	        //qo.addFilter(dpFilter);


	        List<Identity>identities=context.getObjects(Identity.class,qo);
	        if(identities!=null && identities.size()>0){


	        for(Identity identity:identities)
	        {
	        System.out.println("Identity:"+identity.getFirstname());
	        System.out.println("Identity:"+identity.getName());

	        identityNames.add(identity.getName());

	        }

	 

	    }

	}

}
