package com.mcm.springboot.app.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.mcm.springboot.app.utils.BreastSide;
import com.mcm.springboot.app.utils.DiaperStatus;
import com.mcm.springboot.app.utils.TypePlaceSleeping;

@Entity
@Table(name = "activity_action")
public class ActivityAction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotEmpty
	@Column(name = "id_activity_action")
	private Long id;

	@NotEmpty
	@Column(name = "activity_start_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@NotEmpty
	@Column(name = "activity_endt_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	@Column(name = "activity_comment")
	private String comment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ActivityCategory activityCategory;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Baby baby;
	
	@Enumerated(EnumType.STRING)
	@Column(name="activity_sleepSession")
	private TypePlaceSleeping sleepSessions;
	
	@Column(name="activity_bath", nullable=false)
	private Boolean bath;

	@Enumerated(EnumType.STRING)
	@Column(name="activity_diaper_status")
	private DiaperStatus diaperStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(name="activity_breast_side")
	private BreastSide breastSide;

	@Column(name="activity_other_feeding")
	private Boolean otherFeeding;
	
	public ActivityAction() {
		this.breastSide = null;
		this.diaperStatus = null;
		this.sleepSessions = null;
		this.bath = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ActivityCategory getActivityCategory() {
		return activityCategory;
	}

	public void setActivityCategory(ActivityCategory activityCategory) {
		this.activityCategory = activityCategory;
	}

	public Baby getBaby() {
		return baby;
	}

	public void setBaby(Baby baby) {
		this.baby = baby;
	}

	public TypePlaceSleeping getSleepSessions() {
		return sleepSessions;
	}

	public void setSleepSessions(TypePlaceSleeping sleepSessions) {
		this.sleepSessions = sleepSessions;
	}

	public Boolean getBath() {
		return bath;
	}

	public void setBath(Boolean bath) {
		this.bath = bath;
	}

	public DiaperStatus getDiaperStatus() {
		return diaperStatus;
	}

	public void setDiaperStatus(DiaperStatus diaperStatus) {
		this.diaperStatus = diaperStatus;
	}

	public BreastSide getBreastSide() {
		return breastSide;
	}

	public void setBreastSide(BreastSide breastSide) {
		this.breastSide = breastSide;
	}

	public Boolean getOtherFeeding() {
		return otherFeeding;
	}

	public void setOtherFeeding(Boolean otherFeeding) {
		this.otherFeeding = otherFeeding;
	}

	
}
