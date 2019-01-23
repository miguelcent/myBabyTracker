package com.mcm.springboot.app.service;


import java.util.List;
import java.util.Optional;

import com.mcm.springboot.app.dao.IActivityActionDAO;
import com.mcm.springboot.app.dao.IActivityCategoryDAO;
import com.mcm.springboot.app.entity.ActivityAction;
import com.mcm.springboot.app.entity.ActivityCategory;

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

	@Override
	public List<ActivityAction> findAllByActivityCategoryId(Long categoryId) {
		ActivityCategory cat = activityCategoryDAO.findById(categoryId).get();
		List<ActivityAction> actions = (List<ActivityAction>)activityActionDAO.findAll();
		for (ActivityAction i : actions) {
			if (i.getActivityCategory().getId()!=cat.getId()) {
				actions.remove(i.getActivityCategory());
			}
		}
		return actions;
	}

	@Override
	public void deleteAllByActivityCategoryID(Long categoryID) {
		for (ActivityAction act : this.findAllByActivityCategoryId(categoryID)) {
			activityActionDAO.deleteById(act.getId());
		}
	}

}
