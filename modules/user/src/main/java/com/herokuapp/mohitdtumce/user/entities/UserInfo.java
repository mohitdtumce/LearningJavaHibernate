package com.herokuapp.mohitdtumce.user.entities;


import com.herokuapp.mohitdtumce.user.constants.Constants;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = Constants.USER_INFO_TABLE)
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = Constants.USER_INFO_ATTR_USER_ID, nullable = false)
	@PrimaryKeyJoinColumn
	private Long userId;

	@Column(name = Constants.USER_INFO_ATTR_USER_NAME, nullable = false)
	private String userName;

	@Column(name = Constants.USER_INFO_ATTR_GENDER)
	private boolean gender;

	@Column(name = Constants.USER_INFO_ATTR_DOB)
	private Date dateOfBirth;

	@Column(name = Constants.USER_INFO_ATTR_CONTACT)
	private String contactNumber;

	@Column(name = Constants.USER_INFO_ATTR_EMAIL, nullable = false)
	private String email;

	@Column(name = Constants.USER_INFO_ATTR_CREATED_AT)
	private DateTime createdAt;

	@Column(name = Constants.USER_INFO_ATTR_UPDATED_AT)
	private DateTime updatedAt;

	@OneToOne(targetEntity = UserProfile.class, cascade = CascadeType.ALL)
	private UserProfile userProfile;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean getGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}

	public DateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(DateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
}
