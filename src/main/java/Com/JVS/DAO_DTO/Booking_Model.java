package Com.JVS.DAO_DTO;

public class Booking_Model {

	private String userEmail;
	private String bikeName;
	private String pickupLocation;
	private String pickupDate;
	private int days;
	private String phone;

	public Booking_Model() {
	}

	public Booking_Model(String userEmail, String bikeName, String pickupLocation, String pickupDate, int days, String phone) {
		this.userEmail = userEmail;
		this.bikeName = bikeName;
		this.pickupLocation = pickupLocation;
		this.pickupDate = pickupDate;
		this.days = days;
		this.phone = phone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getBikeName() {
		return bikeName;
	}

	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public String getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Booking_Model [userEmail=" + userEmail + ", bikeName=" + bikeName + ", pickupLocation=" + pickupLocation
				+ ", pickupDate=" + pickupDate + ", days=" + days + ", phone=" + phone + "]";
	}
}
