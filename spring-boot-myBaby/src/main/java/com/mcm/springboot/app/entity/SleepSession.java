package com.mcm.springboot.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.mcm.springboot.app.utils.TypePlaceSleeping;

@Entity
@Table(name="sleep_session")
public class SleepSession implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_sleep_session")
	private Long id;
	
	@NotEmpty
	@Column(name="start_date_sleep_session")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	
	@Column(name="end_date_sleep_session")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	@Column(name="place_sleep_session")
	private TypePlaceSleeping place;
	
	@Column(name="comment_sleep_session")
	private String comment;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_baby_sleep_session")
	private Baby baby;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_activity_action_sleep_session")
	private ActivityAction action;

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

	public TypePlaceSleeping getPlace() {
		return place;
	}

	public void setPlace(TypePlaceSleeping place) {
		this.place = place;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Baby getBaby() {
		return baby;
	}

	public void setBaby(Baby baby) {
		this.baby = baby;
	}

	public ActivityAction getAction() {
		return action;
	}

	public void setAction(ActivityAction action) {
		this.action = action;
	}
	
	
}
