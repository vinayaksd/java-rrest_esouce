package mock;
import sailpoint.object.*;
import sailpoint.tools.GeneralException;
import java.util.*;
import sailpoint.api.SailPointContext;
import sailpoint.api.Terminator;
import sailpoint.object.SailPointObject;

  

public class password {

	public static void main(String[] args) {
		SailPointContext context=null;
		ResourceObject account=null;
		/*Identity identity=null;
		Application appname =context.getObject(Application.class, "HR");
		
		appname.getName();
		Filter myFilter = Filter.eq("links.application.name", "HR");		
		QueryOptions qo = new QueryOptions();		
		qo.addFilter(myFilter);		
		
		List identitys = context.getObjects(Identity.class,qo);
		ArrayList list=new ArrayList();
		
		String firstname=identitys.getAttribute("firstName");
		String lastname= identitys.getAttribute("lastName");
		
		appname.getAttributeValue(lastname);
		int  addingFor2= 2;

		String finalName=firstname+"."+lastname+addingFor2;

		identity.setDisplayName(finalName);

		System.out.println("finalName is ========="+finalName);
*/
		
		
		 
		  
		  	Identity identity = context.getObjectByName(Identity.class, "7");
		  
				
		  return "\n"+"password: "+identity.getPassword()+"\n"+"decrepted password: "+context.decrypt(identity.getPassword());
	}

}
