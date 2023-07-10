package mock;


import sailpoint.object.ProvisioningResult;
import sailpoint.object.ProvisioningPlan;
import sailpoint.object.ProvisioningPlan.AccountRequest;
import sailpoint.object.ProvisioningPlan.AttributeRequest;
//import sailpoint.object.Filter;
import sailpoint.object.ManagedAttribute;
import sailpoint.object.Link;
import sailpoint.tools.Util;
import sailpoint.api.IdentityService;
import java.util.List;

import java.util.HashMap;
import java.sql.PreparedStatement; 

public class provisiong_hrself {

	public static void main(String[] args) {

		
		
		
		public String getAttributeRequestValue(AccountRequest acctReq, String attribute)
		{
					
		if (acctReq != null )
		{

		AttributeRequest attrReq = acctReq.getAttributeRequest(attribute);

		if ( attrReq != null )
		{		
		return attrReq.getValue();
		}

		}
		return null;
		}
		log.error("starting of rule create provisioning rule");
	 
		ProvisioningResult result = new ProvisioningResult();

		
		 AccountRequest acctRequest=(AccountRequest) request;  
	try
		{
		String operation=acctRequest.getOperation().toString();
		 PreparedStatement statement = connection.prepareStatement("insert into ohrm_user(id,user_role_id, emp_number, user_name, user_password) values (?,?,?,?,?)"); 
		
		statement.setInt(3, Integer.parseInt(acctRequest.getNativeIdentity()));
	
		statement.setString(1, getAttributeRequestValue(acctRequest, "id"));
		
		statement.setString(2, getAttributeRequestValue(acctRequest, "user_role_id"));
		
		//statement.setString(2, getAttributeRequestValue(acctRequest, "emp_number"));

		statement.setString(4, getAttributeRequestValue(acctRequest,"user_name"));
		

		statement.setString(5, getAttributeRequestValue(acctRequest, "user_password")); 
		
		statement.executeUpdate();
	
	result.setStatus(ProvisioningResult.STATUS_COMMITTED);
		}

		//}

		catch (Exception e) {

	e.printStackTrace();

	result.setStatus(ProvisioningResult.STATUS_FAILED);

		throw new Exception(e.getMessage());

		}
		return result;
}
