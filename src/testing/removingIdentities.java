package testing;

import sailpoint.object.*;
import sailpoint.tools.GeneralException; 
import java.util.*;
 import sailpoint.api.SailPointContext;
import sailpoint.api.Terminator;   

public class removingIdentities {
	
	  
	        Terminator t = new Terminator(context);       
	  Filter myFilter = Filter.eq("links.application.name", "HR System- Employees");    
	     QueryOptions qo = new QueryOptions();   
	      qo.addFilter(myFilter);      
	   List identitys = context.getObjects(Identity.class,qo);
	        ArrayList list=new ArrayList();
	        String s="";
	        if(identitys!=null && identitys.size()>0 ){
	        for(int i =0;i<identitys.size();i++){
	        SailPointObject delId = (SailPointObject) identitys.get(i);     
	    t.deleteObject(delId);
	        list.add(delId+", ");
	        }
	        return list;
	    }
	    else
	    return "no deleted value ";
}


