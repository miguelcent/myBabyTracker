package com.mcm.springboot.app.service;


import java.util.List;
import java.util.Optional;

import com.mcm.springboot.app.dao.IActivityActionDAO;
import com.mcm.springboot.app.dao.IActivityCategoryDAO;
import com.mcm.springboot.app.entity.ActivityAction;

public class ActivityActionServiceImpl implements IActivityActionService {

	IActivityActionDAO activityActionDAO;
	IActivityCategoryDAO activityCategoryDAO;
	
	@Override
	public List<ActivityAction> findAll() {
		return (List<ActivityAction>)activityActionDAO.findAll();
	}

	@Override
	public void save(ActivityAction activityAction) {
		activityActionDAO.save(activityAction);
	}

	@Override
	public Optional<ActivityAction> findOne(Long id) {
		return activityActionDAO.findById(id);	
	}

	@Override
	public void delete(Long id) {
		activityActionDAO.deleteById(id);
	}

}
