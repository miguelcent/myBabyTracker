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

@Entity
@Table(name="bath")
public class Bath implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_bath")
	private Long id;
	
	@NotEmpty
	@Column(name="date_bath")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateBath;
	
	@Column(name="comments_bath")
	private String comments;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_baby_bath")
	private Baby baby;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_activity_action_bath")
	private ActivityAction action;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateBath() {
		return dateBath;
	}

	public void setDateBath(Date dateBath) {
		this.dateBath = dateBath;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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
