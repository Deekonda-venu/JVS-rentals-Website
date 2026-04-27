package Com.JVS.DAO_DTO;

public class Login_Model {
	private String email;
	private String Password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	
	public Login_Model() {
		super();
		
	}
	
	
	public Login_Model(String email, String password) {
		super();
		this.email = email;
		this.Password = password;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Login_Model [email=" + email + ", password=" + Password + "]";
	}
	

}
