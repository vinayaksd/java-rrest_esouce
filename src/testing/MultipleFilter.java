package testing;

import java.util.ArrayList;
import java.util.List;

import sailpoint.api.SailPointContext;
import sailpoint.object.Filter;
import sailpoint.object.Identity;
import sailpoint.object.QueryOptions;
import sailpoint.tools.GeneralException;

public class MultipleFilter {

	public static void main(String[] args) throws GeneralException {
		SailPointContext context=null;
		
		QueryOptions qo=new QueryOptions();
		Filter filter1 = Filter.eq("department","Information Technology");
		Filter filter2 = Filter.eq("Region","Americas");
		Filter finalfilter= Filter.and(filter1,filter2);
		qo.addFilter( finalfilter);
		
		
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
		

	}

}
