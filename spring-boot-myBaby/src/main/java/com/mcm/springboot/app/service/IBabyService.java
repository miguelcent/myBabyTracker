package com.mcm.springboot.app.service;

import java.util.List;
import java.util.Optional;

import com.mcm.springboot.app.entity.Baby;

public interface IBabyService {
	public List<Baby> findAll();
	
	public void save(Baby Baby);
	
	public Optional<Baby> findOne(Long id);
	
	public void delete(Long id);
}
