package mock;
import java.util.ArrayList;


public class testlist {

	public static String
    removeFirstandLast(String str)
    {
 
        // Removing first and last character
        // of a string using substring() method
        str = str.substring(1, str.length() - 1);
 
        // Return the modified string
        return str;
    }
 
	public static void main(String[] args) {
		ArrayList<String> entList = new ArrayList();
		entList.add("cn=cad-user_app,ou=groups,dc=sailpoint,dc=sp");
		entList.add("cn=cck-user_app,ou=groups,dc=sailpoint,dc=sp");
		entList.add("Admin");
		String itemValueObj="[cn=cck-user_app,ou=groups,dc=sailpoint,dc=sp]";
		
		String itemValueObj1=itemValueObj.substring(1, itemValueObj.length() - 1);
		System.out.println("itemValueObj1=>"+ itemValueObj1  );
		String FinalitemValueObj1=removeFirstandLast(itemValueObj1);
		System.out.println("After =>"+ FinalitemValueObj1  );
		System.out.println("entList.contains(FinalitemValueObj1)--->"+ entList.contains(FinalitemValueObj1));

		
		
	}

}
