package mock;

import sailpoint.object.Workflow;

import sailpoint.object.Workflow.Approval;

import sailpoint.object.Identity;

import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;

import sailpoint.object.Application;

import sailpoint.api.IdentityService;

import sailpoint.object.Link;

import sailpoint.api.ManagedAttributer;

import sailpoint.object.ApprovalItem;

import sailpoint.object.ManagedAttribute;

import sailpoint.tools.Util;

import sailpoint.object.ApprovalSet;

import sailpoint.tools.xml.XMLObjectFactory;

import sailpoint.object.Workflow.Arg;

import sailpoint.object.*;

import java.util.ArrayList;

import java.util.List;

import sailpoint.workflow.IdentityApprovalGenerator;

import java.util.*;

public class secondLevelApprover {

	public static void main(String[] args) {



		
		try {
			List<String> entList = new ArrayList();
			List finalApproval = new ArrayList();
			entList.add("cn=cad-user_app,ou=groups,dc=sailpoint,dc=sp");
			entList.add("cn=cck-user_app,ou=groups,dc=sailpoint,dc=sp");
			entList.add("Admin");


			 

			log.error("************* ENTERING THE SampleRule **************");
			List approvals = new ArrayList(); // use generics for type safety

			 

			    Identity id = context.getObjectByName(Identity.class, identityName);
			String identityDisplayName = id.getDisplayName();
			    log.error("********** SampleRule CALLING | identity *********::" + id);

			 

			    Identity manager = id.getManager();                            //manager we got here
			    log.error("********** SampleRule CALLING | manager *********::" + manager);

			 

			    

			 

			    for (ApprovalItem item : approvalSet.getItems()) {
				        log.error("**********approvalSet item object *********::" + item.toXml());
				        String itemAppName = item.getApplicationName();
				        log.error("********** itemAppName *********::" + itemAppName);

				 

				        String itemName = item.getName();
				String itemOwner = item.getOwner();
				        log.error("********** SampleRule CALLING | itemName ==> "+ itemName );

				 

				        Object itemValueObj = item.getValue();
				        log.error("********** SampleRule CALLING | itemValueObj ==> "+ itemValueObj );

				 

				        Application app = context.getObjectByName(Application.class, itemAppName);
				        Identity identity = app.getOwner();
				        String appOwner = identity.getName();
				        log.error("********** identity Appowner ==> "+ identity);
				        log.error("********** identity appOwner New ==> "+ appOwner);

				 

				        if (null != itemAppName &amp;&amp; !itemAppName.isEmpty()) {
					            log.error("********** INSIDE PAM CALL | App Owner Approval *********::" );

					 

					            // Check if ent needs two level approval
					boolean val=false;
					for(String s: entList) {
						
						if(itemValueObj==s)
					            val=true;					
					}
					
					if (val)
					{
						   log.error("********** INSIDE Owner for approval *********::" );
						//adding owner approval for exception list of ent
						           		ApprovalSet ownerApprovalSet = new ApprovalSet();
						ownerApprovalSet.add(item);
						Approval ownerApproval = new Approval();
						ownerApproval.addArg("workItemTargetClass", "sailpoint.object.Identity");
						ownerApproval.addArg("workItemTargetName", identityName);
						ownerApproval.setMode("serial");
						ownerApproval.setApprovalSet(ownerApprovalSet);
						ownerApproval.setOwner(itemOwner);
						ownerApproval.setDescription("Owner Approval for - " + identityDisplayName);
						approvals.add(ownerApproval);  
						            }

					//adding manager approval
					ApprovalSet mgrApprovalSet = new ApprovalSet();
					mgrApprovalSet.add(item);
					Approval mgrApproval = new Approval();
					mgrApproval.addArg("workItemTargetClass", "sailpoint.object.Identity");
					mgrApproval.addArg("workItemTargetName", identityName);
					mgrApproval.setMode("serial");
					mgrApproval.setApprovalSet(mgrApprovalSet);
					mgrApproval.setOwner(manager.getName());
					mgrApproval.setDescription("Manger Approval for - " + identityDisplayName);
					approvals.add(mgrApproval);

					Approval setItemToChildrenEntitlementApproval = new Approval();
					            setItemToChildrenEntitlementApproval.setChildren(approvals);
					            setItemToChildrenEntitlementApproval.setMode("serial");
					            finalApproval.add(setItemToChildrenEntitlementApproval);
					        }
				    }
		} catch (Exception e) {
			    e.printStackTrace();
			    log.error("exception in setting approval");
		}

		 

		return finalApproval;

	}

}
