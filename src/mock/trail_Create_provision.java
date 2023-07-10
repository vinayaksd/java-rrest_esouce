package mock;

import java.sql.PreparedStatement;
import java.util.List;

import sailpoint.object.ProvisioningPlan;
import sailpoint.object.ProvisioningPlan.AccountRequest;

import sailpoint.object.ProvisioningPlan.AttributeRequest;

public class trail_Create_provision {
			
	
	
	
	
	AccountRequest accountRequests = new AccountRequest();
	for(AccountRequest accRequest: accountRequests){

		if(AccountRequest.Operation.Create.equals(accRequest.getOperation())){

		List attributeRequests = accRequest.getAttributeRequests();

		for(AttributeRequest attRequest: attributeRequests){

		if(ProvisioningPlan.Operation.Add.equals(attRequest.getOperation())){

		PreparedStatement statement = connection.prepareStatement(
				"insert into ohrm_user(user_role_id, emp_number, user_name, user_password) values (?,?,?,?)");

		statement.setString(2, plan.getNativeIdentity());

		statement.setString(1, getAttributeRequestValue(acctRequest, "user_role_id"));
		
		statement.executeUpdate();

		}

		}

		result.setStatus(ProvisioningResult.STATUS_COMMITTED);

		}
}


