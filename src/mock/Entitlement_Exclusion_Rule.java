package mock;
import java.util.Iterator;

import java.util.List;

import sailpoint.object.Bundle;

import sailpoint.object.Certifiable;

import sailpoint.object.*;

public class Entitlement_Exclusion_Rule {

	public static void main(String[] args) {
		
	
		String excludeGroup1 = "cn=cck-admin_app,ou=groups,dc=sailpoint,dc=sp";// cn=admin,mysql,dir
		String excludeGroup2 = "cn=dir-admin_net,ou=groups,dc=sailpoint,dc=sp";
		String excludeGroup3 = "cn=mysql-admin_dba,ou=groups,dc=sailpoint,dc=sp";
		
		Iterator iter = items.iterator();

		HashMap groupMap = new HashMap();

		while (iter.hasNext()) {

		sailpoint.object.EntitlementGroup item = (sailpoint.object.EntitlementGroup) iter.next();
	Attributes attrs = item.getAttributes();

		groupMap = attrs.getMap();
	for(String key: groupMap.keySet()) {

		String groupName = groupMap.get(key);
		log.error("groupName===================>>>>>>>>>>>>>"+groupName);
	if(!groupName.endsWith(excludeGroup1) && !groupName.endsWith(excludeGroup2) && !groupName.endsWith(excludeGroup3)) {
  			itemsToExclude.add(item);
		  iter.remove();
		     }

		}

		}

		//item.removeAll(itemsToExclude);
 
		return "Removed Entitlements except all three(cck,dir,mysql)";

	}

}
