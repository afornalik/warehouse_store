package pl.net.ajka.warehouse.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import pl.net.ajka.warehouse.model.ItemsAmount;
import pl.net.ajka.warehouse.model.dao.ItemsAmountDAO;

@Repository
public class ItemsAmountDAOImpl implements ItemsAmountDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public ItemsAmount select(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (ItemsAmount) session.get(ItemsAmount.class, id);
	}

}
