package com.mcm.springboot.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.mcm.springboot.app.entity.DiaperChange;

public interface IDiaperChangeDAO extends CrudRepository<DiaperChange, Long> {

}
