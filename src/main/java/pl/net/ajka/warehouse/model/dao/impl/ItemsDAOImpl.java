package pl.net.ajka.warehouse.model.dao.impl;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import pl.net.ajka.warehouse.model.Items;
import pl.net.ajka.warehouse.model.ItemsAmount;
import pl.net.ajka.warehouse.model.dao.ItemsDAO;

@Repository
public class ItemsDAOImpl implements ItemsDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public Items select(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Items)session.get(Items.class, id);
	}

	@Override
	public Set<ItemsAmount> selectAllItemsValues(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Set<ItemsAmount>) session.get(Items.class, id).getItemsAmount();
	}
}
