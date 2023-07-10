package mock;

import sailpoint.api.Provisioner;
import sailpoint.object.Identity;
import sailpoint.object.ProvisioningPlan;
import sailpoint.object.ProvisioningPlan.AccountRequest.Operation;
import sailpoint.tools.GeneralException;
import sailpoint.object.ProvisioningPlan.AccountRequest;
import sailpoint.object.ProvisioingPlan.AttributeRequest;

 

public class ProvisionPlan_Terminated_OU {

	public static void main(String[] args) {



		List accReqs= plan.getAccountRequests();
		
		log.error("accReqs List------------------>>  "+accReqs);
		for(AccountRequest accReq :accReqs)
		{

			if(ProvisioningPlan.AccountRequest.Operation.Delete.equals(accReq.getOperation()))
			{

				if(accReq.getResult() != null  &amp;&amp; accReq.getResult().isCommitted())
				{

					Object identity=plan.getIdentity();

					log.error("+++++++++++++"+ identity +"+++++++++++++");

					String nativeIdentity = accReq.getNativeIdentity();
					AccountRequest newAccReq=new AccountRequest();
					newAccReq.setApplication("Enterprise Directory");
					log.error("+++++++++++++"+ identity.getFirstname() +"+++++++++++++");
					
					if(null != nativeIdentity){
						nativeIdentity = nativeIdentity.replace("ou=people","ou=Terminated OU");
						}
					
					 newAccReq.setNativeIdentity(nativeIdentity);
					 newAccReq.setOperation(AccountRequest.Operation.Create);
					 ProvisioningPlan plan1=new ProvisioningPlan();
					 plan1.setIdentity(identity);
					 plan1.add(newAccReq);
					log.error("#############Printing Plan##############");
					log.error(plan1.toXml());
					Provisioner p=new Provisioner(context);
					p.compile(plan1);
					p.execute();
					}

			}

		}
