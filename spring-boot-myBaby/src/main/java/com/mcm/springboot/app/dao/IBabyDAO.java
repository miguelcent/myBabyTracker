package com.mcm.springboot.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.mcm.springboot.app.entity.Baby;

//With "extends CrudRepository" we have implemented automatically all CRUD methods (findOne, findAll, save, delete....)
public interface IBabyDAO extends CrudRepository<Baby, Long> {

}
