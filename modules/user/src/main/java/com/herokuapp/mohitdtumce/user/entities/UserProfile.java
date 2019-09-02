package com.herokuapp.mohitdtumce.user.entities;

import com.herokuapp.mohitdtumce.user.constants.Constants;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = Constants.USER_PROFILE_TABLE)
public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = Constants.USER_PROFILE_ATTR_USER_ID)
	private Long userId;

	@Column(name = Constants.USER_PROFILE_ATTR_DESIGNATION)
	private String designation;

	@Column(name = Constants.USER_PROFILE_ATTR_ORGANIZATION)
	private String organization;

	@Column(name = Constants.USER_PROFILE_ATTR_ABOUT)
	private String about;

	@Column(name = Constants.USER_PROFILE_ATTR_CREATED_AT)
	private DateTime createdAt;

	@Column(name = Constants.USER_PROFILE_ATTR_UPDATED_AT)
	private DateTime updatedAt;

	@OneToOne(targetEntity = UserInfo.class)
	private UserInfo userInfo;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
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

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
}
