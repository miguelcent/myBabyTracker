package com.mcm.springboot.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.mcm.springboot.app.entity.ActivityCategory;

public interface IActivityCategoryDAO extends CrudRepository<ActivityCategory, Long> {

}
