package pl.net.ajka.warehouse.model.dao.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pl.net.ajka.warehouse.model.Users;
import pl.net.ajka.warehouse.model.dao.UsersDAO;

@Repository
public class UsersDAOImpl implements UsersDAO{

	private static final Logger logger = LoggerFactory.getLogger(UsersDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addUser(Users u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(u);
		logger.info("User saved successfully, User Details = "+ u);
		
	}

	@Override
	public void removeUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Users u  = (Users) session.load(Users.class, new Integer(id));
		if (null != u) {
			session.delete(u);
			logger.info("User deleted successfully , user details = "+ u );
		} else {
			logger.info("User not found");
		}
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> userlist() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Users> userList = session.createQuery("from Users").list();
		for(Users u :userList) {
			logger.info("Person List : " +u);
		}
		return userList;
	}

	@Override
	public void updateUser(Users u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(u);
		logger.info("User updated successfully, User Details = "+ u);
		
	}

	@Override
	public Users select(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Users u  = (Users) session.load(Users.class, new Integer(id));
		logger.info("User loaded successfully, Users detail = " + u);
		return u;
	}

}
