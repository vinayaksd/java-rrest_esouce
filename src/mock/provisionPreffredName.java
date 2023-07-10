package mock;

import java.util.ArrayList;

import sailpoint.api.Provisioner;
import sailpoint.object.Application;
import sailpoint.object.Identity;
import sailpoint.object.ProvisioningPlan;
import sailpoint.object.ProvisioningPlan.AccountRequest;
import sailpoint.object.ProvisioningPlan.AttributeRequest;
import sailpoint.object.Workflow;

public class provisionPreffredName {

	public static void main(String[] args) {
		
		
		Identity identityName1 = context.getObject(Identity.class, identityName);
		String NativeIdentity=(String) identityName1.getAttribute("employee_id");
		ProvisioningPlan plan = new ProvisioningPlan();
		ArrayList accountRequestList = new ArrayList();

		plan.setIdentity(identityName1);

		AccountRequest adAccountRequest = new AccountRequest();
    adAccountRequest.setApplication("IIQ");
		adAccountRequest.setOperation(AccountRequest.Operation.Create);
		
		AttributeRequest prefferedNameReq = new AttributeRequest("prefferedName",identityModel.get("prefferedName"));
adAccountRequest.add(prefferedNameReq);  
        
		
         log.error("prefferedNameReq =================---->"+ identityModel.get("prefferedName"));
         
         log.error("prefferedNameReq completed.......Account req for enterprise dirctory started =================---->");
         
         AccountRequest adAccountRequestED = new AccountRequest();
         
         adAccountRequestED.setApplication("Enterprise Directory");
       
        
         
         AttributeRequest Common_NameAttr = new AttributeRequest("cn",ProvisioningPlan.Operation.Add, identityModel.get("cn"));
			log.error("Common_NameAttr---->" + identityModel.get("cn"));
		AttributeRequest uidAttr = new AttributeRequest("uid", ProvisioningPlan.Operation.Add,identityModel.get("uid"));
		log.error("uidAttrr---->" + identityModel.get("uid"));
		AttributeRequest mailAttr = new AttributeRequest("mail",ProvisioningPlan.Operation.Add, identityModel.get("email"));
		log.error("mailAttr---->" + identityModel.get("email"));
		AttributeRequest givennameAttr = new AttributeRequest("givenName", ProvisioningPlan.Operation.Add,identityModel.get("givenName"));
		log.error("givennameAttr---->" + identityModel.get("givenName"));
		if(identityModel.get("postalAddress")!=null) {
		AttributeRequest postalAddressAttr = new AttributeRequest("postalAddress",ProvisioningPlan.Operation.Add, identityModel.get("postalAddress"));
		log.error("postalAddressAttr---->" + identityModel.get("postalAddress"));
		adAccountRequestED.add(postalAddressAttr);
		}
		
		
		
		
         
         adAccountRequestED.add(Common_NameAttr);
         adAccountRequestED.add(uidAttr);
         adAccountRequestED.add(mailAttr);
         adAccountRequestED.add(givennameAttr);
         adAccountRequestED.add(postalAddressAttr);
         
		accountRequestList.add(adAccountRequest);
		accountRequestList.add(adAccountRequestED);
plan.setAccountRequests(accountRequestList);
		
		

		Provisioner p = new Provisioner(context);

		p.compile(plan);
		p.execute();
	  log.error("executed Plan---->"+ plan);
		return plan;

			
		/*adAccountRequest.setOperation(AccountRequest.Operation.Create);
		adAccountRequest.setNativeIdentity(NativeIdentity);
		AttributeRequest prefferedNameReq = new AttributeRequest("prefferedName",identityModel.get("prefferedName"));
		identityModel.put("prefferedName",identityModel.get("prefferedName"));
		
		
		adAccountRequest.add(prefferedNameReq);  
		
		accountRequestList.add(adAccountRequest); 			//Adding in list

		plan.setAccountRequests(accountRequestList);
		
		System.out.println("Plan ---->" + plan.toXml());

		Provisioner p = new Provisioner(context);

		p.compile(plan);
		p.execute();
	   System.out.println("Starting Plan---->"+ plan);
		return plan;
		*/
		
		
		
		/* backup===================================================================================
		 * 
		 * 
		 * 
		 * <?xml version='1.0' encoding='UTF-8'?>
<!DOCTYPE Workflow PUBLIC "sailpoint.dtd" "sailpoint.dtd">
<Workflow created="1681372940816" explicitTransitions="true" id="7f0000018778150a818779a30a100a57" modified="1682288867318" name="Form_prefferedName_Workflow" type="LCMProvisioning">
  <Variable input="true" name="quickLinkIdentityId"/>
  <Variable name="identityName">
    <Description>The name of the identity we&amp;#39;re supposed to update.</Description>
    <Script>
      <Source>
          if(quickLinkIdentityId!=null) {
             Identity iden = context.getObjectById(Identity.class,quickLinkIdentityId);
             return iden.getName();
         }
</Source>
    </Script>
  </Variable>
  <Variable name="plan"/>
  <Variable initializer="true" input="true" name="trace"/>
  <Variable input="true" name="requester"/>
  <Variable name="identityModel"/>
  <Step icon="Start" name="Start" posX="32" posY="38">
    <Script>
      <Source>
log.error("starting workflow");
log.error("requester: "+requester);
log.error("identityName: "+identityName);
log.error("quickLinkIdentityId: "+quickLinkIdentityId);
</Source>
    </Script>
    <Transition to="initialize"/>
  </Step>
  <Step action="getIdentityModel" icon="Default" name="initialize" posX="160" posY="39" resultVariable="identityModel">
    <Arg name="identityName" value="ref:identityName"/>
    <Description>Initialize Identity Model.</Description>
    <Transition to="prefferedName"/>
  </Step>
  <Step icon="Default" name="prefferedName" posX="322" posY="38">
    <Approval name="preffered_Name_form" owner="1" return="identityModel" send="identityModel">
      <Arg name="workItemFormBasePath" value="identityModel"/>
      <Form name="preffered_Name_form">
        <Attributes>
          <Map>
            <entry key="pageTitle" value="preffered_Name_form"/>
            <entry key="title" value="prefferd_Name_form"/>
          </Map>
        </Attributes>
        <Section name="prefferedName">
          <Field displayName="Common Name" name="cn" type="string"/>
          <Field displayName="uid" name="uid" type="string"/>
          <Field displayName="mail" name="email" type="string"/>
          <Field displayName="FirstName" name="givenName" type="string"/>
          <Field displayName="postalAddress" name="postalAddress" type="string"/>
          <Field displayName="prefferedName" name="prefferedName" type="string"/>
        </Section>
        <Button action="next" label="Next"/>
        <Button action="cancel" label="Cancel"/>
      </Form>
    </Approval>
    <Transition to="Set prefferedName"/>
  </Step>
  <Step name="Set prefferedName" posX="507" posY="6" resultVariable="plan">
    <Script>
      <Source>
       
import java.util.ArrayList;

import sailpoint.api.Provisioner;
import sailpoint.object.Application;
import sailpoint.object.Identity;
import sailpoint.object.ProvisioningPlan;
import sailpoint.object.ProvisioningPlan.AccountRequest;
import sailpoint.object.ProvisioningPlan.AttributeRequest;
import sailpoint.object.Workflow;
        
        
        
		log.error("identityName" + identityName);

		Identity identityName1 = context.getObject(Identity.class, identityName);
		String NativeIdentity=(String) identityName1.getAttribute("employee_id");
		ProvisioningPlan plan = new ProvisioningPlan();
		ArrayList accountRequestList = new ArrayList();

		plan.setIdentity(identityName1);

		AccountRequest adAccountRequest = new AccountRequest();
    adAccountRequest.setApplication("IIQ");
		adAccountRequest.setOperation(AccountRequest.Operation.Create);
		log.error("IdentityModel:========"+identityModel);
		AttributeRequest prefferedNameReq = new AttributeRequest("prefferedName",identityModel.get("prefferedName"));
adAccountRequest.add(prefferedNameReq);  
        
		
         log.error("prefferedNameReq =================---->"+ identityModel.get("prefferedName"));
		
	
		accountRequestList.add(adAccountRequest);
		
		plan.setAccountRequests(accountRequestList);

		log.error("executed Plan---->" + plan.toXml());
		return plan;
      </Source>
    </Script>
    <Transition to="buildPlanFromIdentityModel"/>
  </Step>
  <Step action="buildPlanFromIdentityModel" icon="Default" name="buildPlanFromIdentityModel" posX="489" posY="38" resultVariable="plan">
    <Arg name="identityName" value="ref:identityName"/>
    <Arg name="identityModel" value="ref:identityModel"/>
    <Transition to="lcm"/>
  </Step>
  <Step icon="Default" name="lcm" posX="660" posY="40">
    <Arg name="identityEmailTemplate"/>
    <Arg name="enableRetryRequest"/>
    <Arg name="securityOfficerElectronicSignature"/>
    <Arg name="fallbackApprover"/>
    <Arg name="endOnManualWorkItems"/>
    <Arg name="userEmailTemplate"/>
    <Arg name="policiesToCheck"/>
    <Arg name="project"/>
    <Arg name="workItemComments"/>
    <Arg name="identityRequestId"/>
    <Arg name="approvalSplitPoint"/>
    <Arg name="source"/>
    <Arg name="identityDisplayName"/>
    <Arg name="foregroundProvisioning"/>
    <Arg name="ownerElectronicSignature"/>
    <Arg name="batchRequestItemId"/>
    <Arg name="saveUnmanagedPlan_WithProjectArgument"/>
    <Arg name="splitPlans"/>
    <Arg name="doRefresh"/>
    <Arg name="plan" value="ref:plan"/>
    <Arg name="flow"/>
    <Arg name="identityElectronicSignature"/>
    <Arg name="identityName"/>
    <Arg name="approvalSet"/>
    <Arg name="violationReviewDecision"/>
    <Arg name="filterRejects"/>
    <Arg name="splitProjects"/>
    <Arg name="requireCommentsForDenial"/>
    <Arg name="requesterEmailTemplate"/>
    <Arg name="approvalEmailTemplate"/>
    <Arg name="ticketManagementApplication"/>
    <Arg name="securityOfficerName"/>
    <Arg name="approvingIdentities"/>
    <Arg name="managerEmailTemplate"/>
    <Arg name="ticketId"/>
    <Arg name="approvalScheme"/>
    <Arg name="allowRequestsWithViolations"/>
    <Arg name="workItemPriority"/>
    <Arg name="managerElectronicSignature"/>
    <Arg name="requireViolationReviewComments"/>
    <Arg name="splitApprovalSet"/>
    <Arg name="approvalMode"/>
    <Arg name="trace"/>
    <Arg name="endOnProvisioningForms"/>
    <Arg name="splitWorkItemComments"/>
    <Arg name="requireCommentsForApproval"/>
    <Arg name="notificationScheme"/>
    <Arg name="policyViolations"/>
    <Arg name="policyScheme"/>
    <Arg name="setPreviousApprovalDecisions"/>
    <Arg name="optimisticProvisioning"/>
    <Arg name="securityOfficerEmailTemplate"/>
    <WorkflowRef>
      <Reference class="sailpoint.object.Workflow" id="7f00000187221bc1818722f9eaa60036" name="LCM Provisioning"/>
    </WorkflowRef>
    <Transition to="Stop"/>
  </Step>
  <Step icon="Stop" name="Stop" posX="852" posY="39"/>
</Workflow>
*/
		 
		
	}

}
