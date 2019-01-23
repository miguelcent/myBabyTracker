package com.mcm.springboot.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.mcm.springboot.app.entity.SleepSession;

public interface ISleepSessionDAO extends CrudRepository<SleepSession, Long> {

}
