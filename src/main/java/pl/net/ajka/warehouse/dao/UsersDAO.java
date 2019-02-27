package pl.net.ajka.warehouse.dao;

import java.util.List;

import pl.net.ajka.warehouse.model.Users;

public interface UsersDAO {
	
	public void addUser(Users u);
	
	public void removeUser(int id);
	
	public List<Users> userlist();
	
	public void updateUser(Users u);
	
	public Users select(int id);
	

}
