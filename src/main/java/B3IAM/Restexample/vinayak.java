package B3IAM.Restexample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import stringReturn.StringMessage;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@Path("vinayak")
public class vinayak {

	
	static String message=""; 
	

	@GET
	@Produces("text/plain")
	@Path("/training")
	public String wish() {
		return "hello vin,irf,arati";
	}

	@GET
	@Produces("text/plain")
	@Path("{username}")
	public String wish(@PathParam("username") String name) {
		return "hello: " + name + " welcome to rest";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("add/{add1}/{add2}")
	public String wish1(@PathParam("add1") String name, @PathParam("add2") String name2) {
		try {
			float sum = Float.parseFloat(name) + Float.parseFloat(name2);
			return "sum is : " + sum;
		}

		catch (Exception e) {
			return "plz enter the numbers only";
		}

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/read/{number1}/{filename1}")
	public String naser(@PathParam("number1") int number, @PathParam("filename1") String filename) {
		Scanner input = new Scanner(System.in);
		System.out.println("enter the number to create a file of table:");
		String values = "";
		try {

			FileWriter my = new FileWriter("D:\\infra\\" + "tab_" + number + ".txt");

			for (int i = 1; i <= 10; i++) {
				my.write(number + "*" + i + "=" + (number * i) + "," + "\n");

			}
			my.close();
			System.out.println("You're file is created: ");
			System.out.println("enter the filename to read: ");
			Scanner scfile = new Scanner(System.in);
			System.out.println("hi writing.....");

			FileInputStream fin = new FileInputStream("D:\\infra\\" + "tab_" + filename + ".txt");

			int i = 0;

			while ((i = fin.read()) != -1) {

				if (",".equals(i)) {
					System.out.println("are you going......");
					values = values + "<br>";
				} else
					values += (char) i;
			}
			fin.close();

		} catch (IOException e) {
			System.out.println(e);
		}

		return values;

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/objects")
	public String show() {
		studs s1 = new studs();
		studs s2 = new studs();
		s1.id = 101;
		s1.age = 25;
		s1.courses = "java";
		s1.name = "vinayak";
		studs.college = "sit tumkurrrrrrr";

		s2.id = 102;
		s2.age = 26;
		s2.courses = "css";
		s2.name = "akash";

		return s1 + "<br>" + s2;

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/salary")
	public String salary() {

		SalaryDisplay s1 = new SalaryDisplay();
		SalaryDisplay s2 = new SalaryDisplay();

		s1.name = "vinayak";
		s1.salary = 1000000;
		s1.id = 101;
		s1.annualSalary = (int) ((s1.salary) * 12);

		s2.name = "akash";
		s2.salary = 100;
		s2.id = 101;
		s2.annualSalary = (int) ((s2.salary) * 12);

		return s1 + "" + s2;

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/array")
	public String getarray() {
		// int a[]=new int[5];
		String s = "";
		String a[] = { "vin", "akash", "bheem sir", "arati" };
		// a[2]=5;
		for (int i = 0; i < a.length; i++) {
			s += a[i] + "<br>";
		}
		return s;
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("students")
	public String getstudsArray() {
		String s = "";
		studs arr[] = new studs[4];
		int ids[] = { 1, 2, 3, 4 };
		String names[] = { "vin", "akash", "naseer", "arati" };
		String courses[] = { "sailpoint", "java", "python", "java" };
		int ages[] = { 25, 23, 24, 25 };
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new studs();
			arr[i].id = ids[i];
			arr[i].name = names[i];
			arr[i].courses = courses[i];
			arr[i].age = ages[i];
			s += arr[i].id + ", " + arr[i].name + ", " + arr[i].courses + ", " + arr[i].age + "<br>";
		}
		return s;

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("salaryemp/{size}")
	public String getsalaryarray(@PathParam("size") int size) {

		String s = "<table border=2><tr><th>Id</th><th>Name</th><th>salary</th></tr>";
		SalaryDisplay sal[] = new SalaryDisplay[size];
		int ids[] = new int[size];
		String name[] = new String[size];
		double salary[] = new double[size];
		ids[0] = 10;
		name[0] = "vin";
		salary[0] = 10000;

		for (int i = 1; i < size; i++) {

			ids[i] = ids[i - 1] + 10;
		}
		for (int i = 1; i < size; i++) {

			name[i] = i + "vin";
		}
		for (int i = 1; i < size; i++) {

			salary[i] = salary[i - 1] + 10000;
		}

		for (int i = 0; i < sal.length; i++) {
			sal[i] = new SalaryDisplay(); // creating array objects out of declared class salarydisplay
			sal[i].id = ids[i];
			sal[i].name = name[i];
			sal[i].salary = salary[i];
			// s=s+"all" we are doing to capture all the objects inside this loop
			s += "<tr><td>" + sal[i].id + "</td><td>" + sal[i].name + "</td><td>" + sal[i].salary + "</tr>" + "<br>";

		}
		s += "</table>";
		return s;
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("amani/string/{str}")
	// method to demonstrate vowels and replace with its uppercase.

	public String amani(@PathParam("str") String s) {
		String res = s.substring(s.length() - 3, s.length()).toUpperCase();		
		int count = 0;
		String m="";
		int index_a = -1, index_e = -1, index_i = -1, index_o = -1, index_u = -1; // default values.

		for (int i = 0; i < s.length(); i++) {
			
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
					|| s.charAt(i) == 'u') {
				
				m=m+(s.charAt(i)+"").toUpperCase();
	 
				if (s.charAt(i) == 'a') {
					count++;
					index_a = s.indexOf(s.charAt(i));
					
				}
				else if (s.charAt(i) == 'e') {
					count++;
					index_e = s.indexOf(s.charAt(i));
				}
				else if (s.charAt(i) == 'i') {
					count++;
					index_i = s.indexOf(s.charAt(i));
				}
				else if (s.charAt(i) == 'o') {
					count++;
					index_o = s.indexOf(s.charAt(i));
				}
				else if (s.charAt(i) == 'u') {
					count++;
					index_u = s.indexOf(s.charAt(i));
				}
				
			}
			else {
				m=m+(s.charAt(i));
			
		}
		}
		return m + "<br>" + "---------------------------------" + "<br>" + "count of vowels: " + "<b>" + count
				+ "</b><br>" + "index_a: " + "<b>" + index_a + "</b>" + "<br>" + "index_e:" + "<b>" + index_e
				+ "</b><br>" + "index_i: " + "<b>" + index_i + "</b><br>" + "index_o: " + "<b>" + index_o + "</b><br>"
				+ "index_u: " + "<b>" + index_u + "</b><br>";
	}

	// 3 same method names for overloading (1.int, int) (2. float,float) (3.int, float)

	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("akash/addint/{y}/{x}")
	public String amani(@PathParam("y") int num1, @PathParam("x") int num2) {
		return "sum:"+(num1+num2);

	}

	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("floats/add/{float1}/{float2}")
	public String sum(@PathParam("float1") float x, @PathParam("float2") float y) {
		
		return "sum:  "+(x + y);

	}

	@GET							// int and float overloading method
	@Produces(MediaType.TEXT_HTML)
	@Path("int/add/{int1}/{float1}")
	public String sum(@PathParam("int1") int val1, @PathParam("float1") float val2) {
		float sum = val1 + val2;
		return "sum of int & float: "+sum;

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("arraylast/{input}") // give the array size and input seperated by commas.

	public String readlastcharOfArray(@PathParam("input") String input) {		
		String splitarr[] = input.split(",");		
		String s = "";
		s = "<table border=2><tr><th>String</th><th>Last character</th></tr>";

		for (int i = 0; i < splitarr.length; i++) {

			s += "<tr><td>last character of :" + splitarr[i] + " is :" + "</td>" + "<td>"
					+ splitarr[i].charAt(splitarr[i].length() - 1) + "</td></tr>" + "<br>";

		}
		s += "</table>";

		return s;
	}


	
		  
		// to check private variable can e accessed by public methods
	
		@GET
		@Produces(MediaType.TEXT_HTML)
		@Path("constructor/{pin}")
		public String constructorcall(@PathParam("pin") int value) {			
			
			StringMessage sm= new StringMessage(value);			
			
			return sm.msg();
			
		}
		
		@GET
		@Produces(MediaType.TEXT_HTML)
		@Path("integer/{float}")
		public String intreturn(@PathParam("float") float value) {
			int i=(int)value;              //casting done here
			return i+"";			
	
	}
		@GET
		@Produces(MediaType.TEXT_HTML)
		@Path("char/{c}")
		public String intreturn(@PathParam("c") String c) {
			int i=(int)c.charAt(0);              //casting done here to print ascii value of character
			return i+" is ascii value of: "+c+"space";			
	
	}
}
