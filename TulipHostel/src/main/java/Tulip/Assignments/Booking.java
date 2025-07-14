package Tulip.Assignments;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    private String bookingId;
    private String studentId;  // FK to Student table
    private String roomId;     // FK to Room table
    private String staffId;    // FK to Staff table
    private LocalDate requestDate;
    private LocalTime requestTime;
    private String statusType;

    public Booking(String bookingId, String studentId, String roomId, String staffId, LocalDate requestDate,
			LocalTime requestTime, String statusType) {
		super();
		this.bookingId = bookingId;
		this.studentId = studentId;
		this.roomId = roomId;
		this.staffId = staffId;
		this.requestDate = requestDate;
		this.requestTime = requestTime;
		this.statusType = statusType;
	}
    
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public LocalDate getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(LocalDate requestDate) {
		this.requestDate = requestDate;
	}
	public LocalTime getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(LocalTime requestTime) {
		this.requestTime = requestTime;
	}
	public String getStatusType() {
		return statusType;
	}
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
}
