package mock;
import java.util.*;
import java.sql.SQLException;
import sailpoint.object.ProvisioningResult;
import sailpoint.object.ProvisioningPlan.AccountRequest;
import sailpoint.object.ProvisioningPlan.AttributeRequest;
import sailpoint.object.*;
import java.sql.*;
import sailpoint.object.ProvisioningPlan.*;
import java.io.*;




public class Provision_Rule_PreffredName_JDBC {

	public static void main(String[] args) {
		
		
		
		
		log.error("Plan in operationrule --------------->>>>>"+plan.toXml());
		log.error("Accounts in operationrule --------------->>>>>"+plan.getAccountRequests());
		ProvisioningResult result = new ProvisioningResult();
			
		if(plan!=null){
		List accounts = plan.getAccountRequests();

		   Statement stmt = connection.createStatement();
		   String query1 = "ALTER TABLE hs_hr_employee ADD prefferedName VARCHAR(100)";

		   stmt.execute(query1);
		PreparedStatement statement = connection.prepareStatement("insert into hs_hr_employee(prefferedName) values(?)");
		if(AccountRequest account : accounts){
		 AttributeRequest attrReq1 = account.getAttributeRequest("prefferedName");


		statement.setString(1, attrReq1.getValue());
		
		statement.executeUpdate();

		}
		result.setStatus(ProvisioningResult.STATUS_COMMITTED);

		}
		return result;

	}

}
