package com.mcm.springboot.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mcm.springboot.app.dao.IActivityCategoryDAO;
import com.mcm.springboot.app.entity.ActivityCategory;

public class ActivityCategoryServiceImpl implements IActivityCategoryService {

	@Autowired
	private IActivityCategoryDAO activityCategoryDAO;
	
	@Override
	@Autowired
	public List<ActivityCategory> findAll() {
		return (List<ActivityCategory>) activityCategoryDAO.findAll();
	}

	@Override
	@Transactional
	public void save(ActivityCategory activityCategory) {
		activityCategoryDAO.save(activityCategory);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<ActivityCategory> findOne(Long id) {
		return activityCategoryDAO.findById(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		activityCategoryDAO.deleteById(id);
	}

}
