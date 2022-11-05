package B3IAM.Restexample;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class studs {

	public int id;
	public String name;
	public String courses;
	public int age;
	public static String college="sit tumkur";
	
	public String toString() {
		return id+"  "+name+"  "+courses+"  "+age+"   "+college;
	}
}
