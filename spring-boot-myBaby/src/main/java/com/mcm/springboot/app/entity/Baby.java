package com.mcm.springboot.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.mcm.springboot.app.utils.BirthEyesColor;
import com.mcm.springboot.app.utils.BirthHairColor;

@Entity
@Table(name = "baby")
public class Baby implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_baby")
	private Long id;

	@NotEmpty
	@Column(name = "name_baby")
	private String name;

	@Column(name = "surname_baby")
	private String surname;

	@NotEmpty
	@Column(name = "birth_date_baby")
	// Tag "@Temporal" is useful to dates. It makes easier the conversions between
	// different Date types in Databases engines and Date part of java.util
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;

	@Column(name = "birth_weight_baby")
	private int weight;

	@Column(name = "birth_height_baby")
	private int height;

	@Column(name = "comments_baby")
	private String comments;

	@Enumerated(EnumType.STRING)
	@Column(name = "birth_hair_color_baby")
	private BirthHairColor hair_color;

	@Column(name = "birth_eyes_color_baby")
	@Enumerated(EnumType.STRING)
	private BirthEyesColor eyes_color;

// Relations in entities	

	@OneToMany(mappedBy = "baby", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ActivityAction> activityActions;



	public Baby() {
		activityActions = new ArrayList<ActivityAction>();
	
	}

//getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public BirthHairColor getHair_color() {
		return hair_color;
	}

	public void setHair_color(BirthHairColor hair_color) {
		this.hair_color = hair_color;
	}

	public BirthEyesColor getEyes_color() {
		return eyes_color;
	}

	public void setEyes_color(BirthEyesColor eyes_color) {
		this.eyes_color = eyes_color;
	}

	public List<ActivityAction> getActivityActions() {
		return activityActions;
	}

	public void setActivityAction(List<ActivityAction> activityActions) {
		this.activityActions = activityActions;
	}

	

//add / remove methods

	public void addActivityAction(ActivityAction activityAction) {
		activityActions.add(activityAction);
		activityAction.setBaby(this);
	}

	public void removeActivityAction(ActivityAction activityAction) {
		activityActions.remove(activityAction);
		activityAction.setBaby(null);
	}

	

}
