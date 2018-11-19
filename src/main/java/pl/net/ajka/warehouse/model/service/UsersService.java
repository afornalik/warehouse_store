package pl.net.ajka.warehouse.model.service;

import java.util.List;

import pl.net.ajka.warehouse.model.Users;

public interface UsersService {
	

	public void addUser(Users u);
	
	public void removeUser(int id);
	
	public List<Users> userlist();
	
	public void updateUser(Users u);
	
	public Users getUserById(int id);
	

}
