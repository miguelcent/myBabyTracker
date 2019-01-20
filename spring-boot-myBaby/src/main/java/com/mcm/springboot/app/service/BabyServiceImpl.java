package com.mcm.springboot.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcm.springboot.app.dao.IBabyDAO;
import com.mcm.springboot.app.entity.Baby;

//Service: Software pattern fachade: create isolation from DAO layer to Controller and now,
//Controller is able to be connected to different DAO classes.
//Now we can use the transactions (@Transactional) from Service and not fro DAO (@Transactional moved from DAOImpl)
@Service
public class BabyServiceImpl implements IBabyService {
	
	@Autowired
	private IBabyDAO babyDAO;
	
	@Override
	@Autowired
	public List<Baby> findAll() {
		return (List<Baby>) babyDAO.findAll();
	}
	
	@Override
	@Transactional
	public void save(Baby baby) {
		babyDAO.save(baby);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Optional<Baby> findOne(Long id) {
		return babyDAO.findById(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		babyDAO.deleteById(id);
	}

}
