package pl.net.ajka.warehouse.service;

import java.util.List;

import pl.net.ajka.warehouse.model.Test;

public interface TestService {

	public void remove(int id);
	
	public void save(Test t);
	
	public List<Test> getAll();
}
