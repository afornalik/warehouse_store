package pl.net.ajka.warehouse.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pl.net.ajka.warehouse.model.Test;

@Repository
public class TestDAOImpl implements TestDAO {

private static final Logger logger = LoggerFactory.getLogger(TestDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public void save(Test t) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(t);
		logger.info("test added" + t);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Test> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Test> list = session.createQuery("from Test").list();
		
		return list;
	}

	@Override
	public void remove(int id) {
		Session session = sessionFactory.getCurrentSession();
		Test t = (Test) session.load(Test.class, id);
		
		session.delete(t);
		
		
	}

}
