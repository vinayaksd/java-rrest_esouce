package mock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import sailpoint.object.ProvisioningPlan;
import sailpoint.object.ProvisioningPlan.AccountRequest;
import sailpoint.object.ProvisioningResult;

 
public class provisioning_Disable {

	public static void main(String[] args) {


        ProvisioningResult result=new ProvisioningResult();
        List accountRequest=plan.getAccountRequests();
        log.error(plan.toXml());
        for(ProvisioningPlan.AccountRequest acct:accountRequest)
        {
            if(AccountRequest.Operation.Disable.equals(acct.getOperation()))
            {
                log.error(acct.getOperation());
                PreparedStatement statement=connection.prepareStatement("update ohrm_user set status='0' where id=?");
                statement.setString(1, acct.getNativeIdentity());
                statement.executeUpdate();
                result.setStatus(ProvisioningResult.STATUS_COMMITTED);
            }
            else 
                result.setStatus(ProvisioningResult.STATUS_FAILED);
        }
        return result;

	}

}
