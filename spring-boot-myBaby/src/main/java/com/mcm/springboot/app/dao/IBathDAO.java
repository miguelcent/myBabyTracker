package com.mcm.springboot.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.mcm.springboot.app.entity.Bath;

public interface IBathDAO extends CrudRepository<Bath, Long> {

}
