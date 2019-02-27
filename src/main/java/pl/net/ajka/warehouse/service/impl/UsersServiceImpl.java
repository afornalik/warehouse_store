package pl.net.ajka.warehouse.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.net.ajka.warehouse.dao.UsersDAO;
import pl.net.ajka.warehouse.model.Users;
import pl.net.ajka.warehouse.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{

	private UsersDAO usersDAO;
	
	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
	
	@Override
	@Transactional
	public void addUser(Users u) {
		this.usersDAO.addUser(u);
		
	}

	@Override
	@Transactional
	public void removeUser(int id) {
		this.usersDAO.removeUser(id);
		
	}

	@Override
	@Transactional
	public List<Users> userlist() {
		return this.usersDAO.userlist();
	}

	@Override
	@Transactional
	public void updateUser(Users u) {
		this.usersDAO.updateUser(u);
	}

	@Override
	@Transactional
	public Users select(int id) {
		return this.usersDAO.select(id);
	}

}
