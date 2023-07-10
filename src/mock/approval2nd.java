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
public class approval2nd {

	public static void main(String[] args) {
		String approverName;
		   Map approvalMap = new LinkedHashMap();
		  if(identityName!=null){
				Identity identity = context.getObjectByName(Identity.class, identityName);
				  approverName=identity.getManager();
		  }
					  newSet = (ApprovalSet) approvalMap.get(approverName);
		        if (newSet == null) {
		          newSet = new ApprovalSet();
		        }
		        newSet.add((ApprovalItem) XMLObjectFactory.getInstance().clone(item, context));
		        approvalMap.put(approverName, newSet);
				log.error("approverName-----1----------------->>>>>>>>   "+approverName);
				
				List entList = new ArrayList();
				entList.add("cn=cad-user_app,ou=groups,dc=sailpoint,dc=sp");
				entList.add("cn=cck-user_app,ou=groups,dc=sailpoint,dc=sp");
				entList.add("1");
				
					   Object itemValueObj = item.getValue();
					   
					   
					   if (entList.contains(itemValueObj)){
						   
					   ManagedAttribute ma = ManagedAttributer.get(context,context.getObject(Application.class, item.getApplication()), (String) item.getName(),
		              itemValueObj);
					  
					   if (ma.getOwner() == null) {
		                approverName = fallBackApprover;
		              } else {
		                approverName = ma.getOwner().getName();
		              }
					  
					  newSet = (ApprovalSet) approvalMap.get(approverName);
					  
					   if (newSet == null) {
		            newSet = new ApprovalSet();
		          }
				  
		          newSet.add((ApprovalItem) XMLObjectFactory.getInstance().clone(item, context));
		          
				  approvalMap.put(approverName, newSet);
		           log.error("approverName-----2----------------->>>>>>>>   "+approverName);
				  
					   }
		  
				  
				  IdentityApprovalGenerator   iag = new IdentityApprovalGenerator(wfcontext);
				newApprovals = iag.buildApprovalsFromMap(approvalMap, "Request");
				
				for (Approval newApproval : newApprovals) {
					List args = approval.getArgs();
					Arg emailTemplateArg = new Arg("workItemNotificationTemplate", approvalEmailTemplate);
					args.add(emailTemplateArg);
					newApproval.setArgs(args);
				}
		  
		  return newApprovals;

	}

}
