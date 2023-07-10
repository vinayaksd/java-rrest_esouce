package mock;

import sailpoint.object.Application;
import sailpoint.object.Identity;
import sailpoint.api.Provisioner;
import sailpoint.api.SailPointContext;
import sailpoint.object.Application;
import sailpoint.object.Identity;
import sailpoint.object.ProvisioningPlan;
import sailpoint.object.ProvisioningPlan.AccountRequest;
import sailpoint.tools.GeneralException;
import  sailpoint.object.ProvisioningPlan.AttributeRequest;



public class leaverTransfer {

	public static void main(String[] args) {
	
		  
		  
		  
		  String identityName="9;

		 



		  Identity identityName1 = context.getObject(Identity.class, identityName);

		return identityName1.getName();


		ProvisioningPlan plan = new ProvisioningPlan();
		        ArrayList accountRequestList=new ArrayList();



		        plan.setIdentity(identityName1);

		 

		        AccountRequest adAccountRequest = new AccountRequest();

		 

		         Application AppName1 = context.getObject(Application.class,"Enterprise Directory");



		        adAccountRequest.setApplication(AppName1.getName());
		        adAccountRequest.setOperation(AccountRequest.Operation.Modify);
		        adAccountRequest.setNativeIdentity("uid=201@Vin@201.201desh,ou=people,dc=sailpoint,dc=sp");


		        adAccountRequest.add(new AttributeRequest("AC_NewParent",ProvisioningPlan.Operation.Set,"ou=Terminated OU,dc=sailpoint,dc=sp"));


		 

		        
		        accountRequestList.add(adAccountRequest);

		        plan.setAccountRequests(accountRequestList);

		        System.out.println("Plan ---->"+plan.toXml());

		      Provisioner p=new Provisioner(context);

		        p.compile(plan);
		        p.execute(); 
		        return plan;
		  

	}

}
