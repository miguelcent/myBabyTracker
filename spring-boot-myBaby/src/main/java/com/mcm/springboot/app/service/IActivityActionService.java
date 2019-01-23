package com.mcm.springboot.app.service;

import java.util.List;
import java.util.Optional;

import com.mcm.springboot.app.entity.ActivityAction;


public interface IActivityActionService {

public List<ActivityAction> findAll();
	
	public void save(ActivityAction activityAction);
	
	public Optional<ActivityAction> findOne(Long id);
	
	public void delete(Long id);
	
	public List<ActivityAction> findAllByActivityCategoryId(Long categoryId);
	
	public void deleteAllByActivityCategoryID(Long categoryID);
}
