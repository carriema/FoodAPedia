package persistent;
//User Class

public class User {
	
	//公有类
	//不带参数的构造方法
	//属性私有
	//属性setter/getter
	private int userId;
	private String userAccount;
	private String firstName;
	private String lastName;
	private String Address;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	private String phone;
	private String email;
	
	public User(){
	}
	
	public User(String userAccount, String firstName, String lastName) {
		this.userAccount = userAccount;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String toString() {
		return this.userId + "," + this.userAccount +", " + this.firstName + " " + lastName +".";
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
