package B3IAM.Restexample;

public class SalaryDisplay {
		public String name;
		public double salary;
		public int id;
		public int annualSalary;
		
		public String toString() {
			return "<html><table width=\"600px\" border=\"1\" align=\"center\">"
					+ "<tr><td> name:</tr></td><tr><td>"+name+"</tr></td> </table></html>";
		}
}
