package pl.net.ajka.warehouse.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.net.ajka.warehouse.model.Test;
import pl.net.ajka.warehouse.model.dao.TestDAO;
import pl.net.ajka.warehouse.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	
	private TestDAO testDAO;
	
	public void setTestDAO(TestDAO testDAO) {
		this.testDAO = testDAO;
	}
	
	
	@Override
	@Transactional
	public void save(Test t) {
		this.testDAO.save(t);
		
	}

	@Override
	@Transactional
	public List<Test> getAll() {
		return this.testDAO.getAll();
	}
	
	@Override
	@Transactional
	public void remove(int id) {
		this.testDAO.remove(id);
	}

	
	
}
