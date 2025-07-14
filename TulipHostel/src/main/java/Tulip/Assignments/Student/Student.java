package Tulip.Assignments.Student;

public class Student {
    private String studentId;     // PK
    private String fullName;
    private String gender;
    private String course;
    private int semester;
    private String phoneNumber;
    private String email;
    private String password;
	

	public Student(String studentId, String fullName, String gender, String course, int semester, String phoneNumber,
			String email, String password) {
		super();
		this.studentId = studentId;
		this.fullName = fullName;
		this.gender = gender;
		this.course = course;
		this.semester = semester;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
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
