package pl.net.ajka.warehouse.model.dao;

import java.util.List;

import pl.net.ajka.warehouse.model.Test;

public interface TestDAO {

	public void remove(int id);
	
	public void save(Test t);
	
	public List<Test> getAll();

	
}
