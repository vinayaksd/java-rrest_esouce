package stringReturn;

public class StringMessage {
	
	private String msg;

	public StringMessage(int n) {
		if (4 == n)
			this.msg = "Authentication is successful";
		else
			this.msg = "Authentication failuer";
	}
	
	public String msg() {
		return  msg;		
	}

}
