package com.mcm.springboot.app.service;

import java.util.List;
import java.util.Optional;

import com.mcm.springboot.app.entity.ActivityCategory;;

public interface IActivityCategoryService {
	public List<ActivityCategory> findAll();
	
	public void save(ActivityCategory activityCategory);
	
	public Optional<ActivityCategory> findOne(Long id);
	
	public void delete(Long id);
}
