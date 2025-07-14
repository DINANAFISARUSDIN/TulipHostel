package Tulip.Assignments;

public class Staff {
    private String staffId;       // PK
    private String fullName;
    private String role;
    private String phoneNumber;
    private String email;
    private String password;
    
	public Staff(String staffId, String fullName, String role, String phoneNumber, String email, String password) {
		super();
		this.staffId = staffId;
		this.fullName = fullName;
		this.role = role;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
	}
	
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
    
}
