package com.mcm.springboot.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="activity_action")
public class ActivityAction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotEmpty
	@Column(name="id_activity_action")
	private Long id;
	
	@Column(name="action_name")
	@NotEmpty
	private String actionName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_activity_category_activity_action")
	private ActivityCategory activityCategory;
	
	@OneToMany(mappedBy="action")
	private List<SleepSession> sleepSessions;
	
	@OneToMany(mappedBy="action")
	private List<Bath> bath;
	
	@OneToMany(mappedBy="action")
	private List<DiaperChange> diaperChange;

	@OneToMany(mappedBy="baby")
	private List<BreastFeeding> breastFeeding;
	
	@OneToMany(mappedBy="baby")
	private List<OtherFeeding> otherFeeding;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public ActivityCategory getActivityCategory() {
		return activityCategory;
	}

	public void setActivityCategory(ActivityCategory activityCategory) {
		this.activityCategory = activityCategory;
	}
	
	public void addSleepSession(SleepSession session) {
		sleepSessions.add(session);
		session.setAction(this);
	}
	
	public void removeSleepSession(SleepSession session) {
		sleepSessions.remove(session);
		session.setAction(null);
	}
	
	public void addBath(Bath bath) {
		this.bath.add(bath);
		bath.setAction(this);
	}
	
	public void removeBath(Bath bath) {
		this.bath.remove(bath);
		bath.setAction(null);
	}
	
	public void addDiaperChange(DiaperChange diaperChange) {
		this.diaperChange.add(diaperChange);
		diaperChange.setAction(this);
	}
	
	public void removeDiaperChange(DiaperChange diaperChange) {
		this.diaperChange.remove(diaperChange);
		diaperChange.setAction(null);
	}
	
	public void addBreastFeeding(BreastFeeding breastFeeding) {
		this.breastFeeding.add(breastFeeding);
		breastFeeding.setAction(this);
	}
	
	public void removeBreastFeeding(BreastFeeding breastFeeding) {
		this.breastFeeding.remove(breastFeeding);
		breastFeeding.setAction(null);
	}
	
	public void addOtherFeeding(OtherFeeding otherFeeding) {
		this.otherFeeding.add(otherFeeding);
		otherFeeding.setAction(this);
	}
	
	public void removeOtherFeeding(OtherFeeding otherFeeding) {
		this.otherFeeding.remove(otherFeeding);
		otherFeeding.setAction(null);
	}
}
