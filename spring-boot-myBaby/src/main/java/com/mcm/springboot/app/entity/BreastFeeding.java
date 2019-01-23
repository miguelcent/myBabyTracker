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

import com.mcm.springboot.app.utils.BreastSide;

@Entity
@Table(name="breast_feeding")
public class BreastFeeding implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_breast_feeding")
	private Long id;
	
	@Column(name="breast")
	@NotEmpty
	private BreastSide breast;
	
	@NotEmpty
	@Column(name="start_date_breast_feeding")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	
	@Column(name="end_date_breast_feeding")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	@Column(name="comments_breast_feeding")
	private String comment;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_activiy_action_breast_feeding")
	private ActivityAction action;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_baby_breast_feeding")
	private Baby baby;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BreastSide getBreast() {
		return breast;
	}

	public void setBreast(BreastSide breast) {
		this.breast = breast;
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

	public ActivityAction getAction() {
		return action;
	}

	public void setAction(ActivityAction action) {
		this.action = action;
	}

	public Baby getBaby() {
		return baby;
	}

	public void setBaby(Baby baby) {
		this.baby = baby;
	}
	
	
}
