package com.mcm.springboot.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.mcm.springboot.app.entity.ActivityAction;

public interface IActivityActionDAO  extends CrudRepository<ActivityAction, Long>{

}
