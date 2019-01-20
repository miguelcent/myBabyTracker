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

import com.mcm.springboot.app.utils.DiaperStatus;

@Entity
@Table(name="diaper_change")
public class DiaperChange implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_diaper_change")
	private Long id;
	
	@Column(name="diaper_status")
	@NotEmpty
	private DiaperStatus status;
	
	@Column(name="comments_diaper")
	private String comment;
	
	@NotEmpty
	@Column(name="date_diaper_change")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateDiaperChange;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_activiy_action_diaper_change")
	private ActivityAction action;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_baby_diaper_change")
	private Baby baby;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DiaperStatus getStatus() {
		return status;
	}

	public void setStatus(DiaperStatus status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDateDiaperChange() {
		return dateDiaperChange;
	}

	public void setDateDiaperChange(Date dateDiaperChange) {
		this.dateDiaperChange = dateDiaperChange;
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
