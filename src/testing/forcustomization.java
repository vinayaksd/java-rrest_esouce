package testing;

public class forcustomization {

	public static void main(String[] args) {

		
		
		String dept= object.getStringAttribute("department");
		
		if (dept.equalsIgnoreCase("Human Resources"))
			object.put("employeType", "lessworkPeople");
		else {
			object.put("employeType", "non Hr people");
		}
return object;

	}

}
