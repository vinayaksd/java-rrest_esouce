package mock;
import sailpoint.api.SailPointContext;
import sailpoint.object.EmailTemplate;
import sailpoint.object.SailPointObject;
public class emailTemplet {

	public static void main(String[] args) {
		/*SailPointContext context=null;
		EmailTemplate et = context.getOb 
*/
		
		
		[14:49] Mohammed  Naser




		import sailpoint.object.Identity;

		import sailpoint.tools.Util;

		import sailpoint.object.QueryOptions;

		import sailpoint.object.Filter;

		import sailpoint.object.IdentityRequest;

		import org.apache.commons.logging.Log;

		import org.apache.commons.logging.LogFactory;
		
		

		private static Log logger = LogFactory.getLog("rule.KPNT.LCE");

		logger.debug("KPNT-IdentitySelector-LeaverDisableTrigger :: Start");

		boolean retFlag = false;

		// Check if the IdentityRequest has already been created for this user


		try {

		String targetId = identity.getId();

		QueryOptions qo = new QueryOptions();

		qo.add(new Filter[] { Filter.eq("targetId", targetId) });

		qo.add(new Filter[] { Filter.eq("type", "SSF LeaverDisable") });

		//qo.add(new Filter[] { Filter.ne("executionStatus", "completed") });

		int totalRequests = context.countObjects(IdentityRequest.class, qo);

		// if (totalRequests > 0) {

		if (totalRequests > 3) {

		logger.debug("Found a open identity request for this user, totalRequests = " + totalRequests);

		return false;

		}

		} catch (Exception e) {

		logger.fatal("Exception during KPNT-IdentitySelector-LeaverDisableTrigger, Exception = " + e.getMessage());

		}


		if(identity != null) {

		logger.debug("Disable Trigger - Identity = " + identity.getName());

		//Fix to not process old records

		List links = identity.getLinks();

		if (links != null) {

		logger.debug("Number of Apps : " + links.size());

		if (links.size() &lt;= 1){

		logger.debug("Old record - no need to process");

		return false;

		}

		}

		String status = identity.getAttribute("Status");

		logger.debug("status = " + status);

		String rStatus = identity.getAttribute("EmploymentStatus");

		logger.debug("rStatus = " + rStatus);

		if(((null != status) &amp;&amp; ("Terminated".equalsIgnoreCase(status)) &amp;&amp; (null != rStatus) &amp;&amp; ("T".equalsIgnoreCase(rStatus)))||

		((null != status) &amp;&amp; ("Retired".equalsIgnoreCase(status)) &amp;&amp; (null != rStatus) &amp;&amp; ("R".equalsIgnoreCase(rStatus)))){

		String termDate = identity.getAttribute("TerminationDate");

		String disableDelete;

		if (!Util.isNullOrEmpty(termDate)) {

		if (!moreThan30Days(termDate)) {

		retFlag = true;

		}

		}

		}

		logger.debug("retFlag = " + retFlag);

		}

		logger.debug("KPNT-IdentitySelector-LeaverDisableTrigger :: End");

		return retFlag;



		</Source>

		</Rule>






	}

}
