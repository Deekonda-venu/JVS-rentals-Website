package Com.JVS.DAO_DTO;

public class Registration_Model {
	
	private String Firstname;
	private  String Lastname;
	private String email;
	private String mobilenumber;
	private String Password;
	private String date_of_birth;
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	
	
	
	public Registration_Model() {
		super();
	}
	public Registration_Model(String firstname, String lastname, String email, String mobilenumber, String Password,
			String date_of_birth) {
		super();
		Firstname = firstname;
		Lastname = lastname;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.Password = Password;
		this.date_of_birth = date_of_birth;
	}
	@Override
    public String toString() {
//        String date_of_birth = null;
		return "[firstName=" + Firstname + ", lastName=" + Lastname + ", email=" + email
                + ", mobileNumber=" + mobilenumber + ", password=" + Password
                + ", dateOfBirth=" + date_of_birth + "]";
    }

}
