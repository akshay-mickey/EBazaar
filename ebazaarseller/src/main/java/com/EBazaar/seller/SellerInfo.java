package com.EBazaar.seller;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SellerInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sellerId;
	// Personal Information
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String gender;

	// Contact Information
	private String email;
	private Long phoneNumber;
	private String streetAdress;
	private String city;
	private String state;
	private Long pincode;
	private String nationality;

	// Login Credentials
	private String userName;
	private String password;
	
	

	
    public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
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
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStreetAdress() {
		return streetAdress;
	}
	public void setStreetAdress(String streetAdress) {
		this.streetAdress = streetAdress;
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
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public SellerInfo(Long sellerId, String firstName, String lastName, LocalDate dateOfBirth, String gender,
			String email, Long phoneNumber, String streetAdress, String city, String state, Long pincode,
			String nationality, String userName, String password) {
		super();
		this.sellerId = sellerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.streetAdress = streetAdress;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.nationality = nationality;
		this.userName = userName;
		this.password = password;
	}
	@Override
	public String toString() {
		return "SellerInfo [sellerId=" + sellerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", streetAdress=" + streetAdress + ", city=" + city + ", state=" + state + ", pincode="
				+ pincode + ", nationality=" + nationality + ", userName=" + userName + ", password=" + password + "]";
	}
	public SellerInfo() {

	}

	Long setSellerInfo (Long sellerId) {
		return this.sellerId = sellerId;
	}
}
