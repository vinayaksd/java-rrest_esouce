package testing;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sailpoint.api.PersistenceManager;
import sailpoint.api.SailPointContext;
import sailpoint.object.Application;
import sailpoint.object.Capability;
import sailpoint.object.Identity;
import sailpoint.object.Permission;
import sailpoint.object.SailPointObject;
import sailpoint.tools.GeneralException;
public class forApplicatoion {

	public static void main(String[] args) throws GeneralException {
		SailPointContext context=null;
		Identity identity =context.getObjectByName(Identity.class,"Frank.Rivera");
		/*
		 * List<Application> applications=context.getObjects(Application.class);
		 * if(applications!=null && applications.size()>0) { for(Application
		 * app:applications ) { System.out.println("your Application name: "+
		 * app.getName()+" type"+app.getType());
		 * System.out.println(app.getAccountCorrelationConfig()+app.getAggregationTypes(
		 * )); System.out.println("getConnector:  "+app.getConnector()); } } else {
		 * System.out.println("no applications ref"); }
		 */
		
		Application appname =context.getObject(Application.class, "HR");
		String firstname= (String) appname.getAttributeValue("firstName");
		String lastname= (String) appname.getAttributeValue("lastName");
		int  addingFor2= 2;

		String finalName=firstname+"."+lastname+addingFor2;

		identity.setDisplayName(finalName);
		identity.setUid(finalName);
		System.out.println("finalName is ========="+finalName);
		
	}

}
