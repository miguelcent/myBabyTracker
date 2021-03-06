package com.mcm.springboot.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "activity_category")
public class ActivityCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotEmpty
	@Column(name = "id_activity_category")
	private long id;

	@Column(name = "name_activity_category")
	private String name;

//Relation entities.	

	@OneToMany(mappedBy = "activityCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ActivityAction> activityActions;

	public ActivityCategory() {
		activityActions = new ArrayList<ActivityAction>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ActivityAction> getActivityActions() {
		return activityActions;
	}

	public void setActivityActions(List<ActivityAction> activityActions) {
		this.activityActions = activityActions;
	}

	public void addAction(ActivityAction action) {
		activityActions.add(action);
		action.setActivityCategory(this);
	}

	public void removeAction(ActivityAction action) {
		activityActions.remove(action);
		action.setActivityCategory(null);
	}

}
