package com.wakawakavendor.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.wakawakavendor.models.enums.Country;
import com.wakawakavendor.models.enums.Sex;
import com.wakawakavendor.models.enums.SpokenLanguage;
import com.wakawakavendor.models.enums.Status;
import javax.persistence.*;
import java.util.Date;

/**
 * POJO model for vendor.
 * 
 * @apiNote Model for vendor
 * @author idisimagha dublin-green
 */
@Entity
@Table(name = "vendors")
public class Vendor {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "middle_name", nullable = false)
    private String middleName;
    
	@Column(name = "last_name", nullable = false)
    private String lastName;
	
	private String email;

	@Column(name = "alt_email", nullable = false)
	private String altEmail;
	
	private String telephone;
	
	@Column(name = "alt_telephone", nullable = false)
	private String altTelephone;
	
	private String city;
	
	private String country = Country.NIGERIA.toString();
	
	@Column(name = "spoken_language", nullable = false)
	private String spokenLanguage = SpokenLanguage.ENGLISH.toString();

	@Column(name = "reason_for_suspension", nullable = false)
	private String reasonForSuspension;
	
	@Column(name = "bio")
	private String bio;
	
	private String sex = Sex.MALE.toString();
	
	private String status = Status.NOTACTIVE.toString();

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAltEmail() {
		return altEmail;
	}

	public void setAltEmail(String altEmail) {
		this.altEmail = altEmail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAltTelephone() {
		return altTelephone;
	}

	public void setAltTelephone(String altTelephone) {
		this.altTelephone = altTelephone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSpokenLanguage() {
		return spokenLanguage;
	}

	public void setSpokenLanguage(String spokenLanguage) {
		this.spokenLanguage = spokenLanguage;
	}

	public String getReasonForSuspension() {
		return reasonForSuspension;
	}

	public void setReasonForSuspension(String reasonForSuspension) {
		this.reasonForSuspension = reasonForSuspension;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

}
