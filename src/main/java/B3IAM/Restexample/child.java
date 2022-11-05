package B3IAM.Restexample;

public class child extends parent {
	private int sal;

	public void setsal() {
		
		this.sal = 20000 ;
	}

	public int getsal() {
		
		return this.sal;
	}
	
	public String getallsalary() {
		int childsal=this.getsal();		
		int parentsal= super.getsal();
		return  "childsal: "+childsal+" parentsal is : "+parentsal;
	}
	
	public static void main(String[] args) {
		child ch=new child();
		parent p = new parent();
		ch.setsal();
		p.setsal();
		System.out.println(ch.getallsalary());
	}
}
