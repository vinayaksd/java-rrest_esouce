package mock;

import sailpoint.object.QueryOptions;
import sailpoint.api.SailPointContext;
import sailpoint.object.Identity;
import sailpoint.object.Attributes;
import sailpoint.tools.GeneralException;
import sailpoint.object.Filter;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class forUid {

	public static void main(String[] args) {
		Filter myFilter = Filter.eq("links.application.name", "HR");
		Filter filter2 = Filter.eq("links.application.name", "Enterprise Directory");
		Filter finalfilter= Filter.or(myFilter,filter2);
		QueryOptions qo = new QueryOptions();		
		qo.addFilter(finalfilter);		

		List identitys = context.getObjects(Identity.class,qo);
		List list = ArrayList();
		String s="";
		String 	uid;
		int i=0;
		
			for(Object ids:identitys){  
				   
				
		  list.add(ids.getName());

		  Identity identity = context.getObject(Identity.class,list.get(i)) ;
			i++;
			if(i==0) {
		 	uid=identity.getFirstname()+"."+identity.getLastname();
			}
			else
		uid=identity.getFirstname()+"."+identity.getLastname()+i;
			
		String userid = identity.getFirstname() + "." + identity.getLastname();
		
		do {
			QueryOptions qo1 = new QueryOptions();
			Filter a = Filter.eq("uid", uid);

			qo.addFilter(a);
			i = context.countObjects(Identity.class, qo);
			
			if (i > 1) {
			
				
				uid = userid + i;
                
			}
		} while (i != 0);
		
		String p1 = "uid=";
		String p2 = ",ou=people,dc=sailpoint,dc=sp";
		String finalDn = p1 + uid + p2;
		
		return finalDn;
}
	
}
}
