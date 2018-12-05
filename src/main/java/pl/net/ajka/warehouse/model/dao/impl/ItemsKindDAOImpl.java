package pl.net.ajka.warehouse.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import pl.net.ajka.warehouse.model.ItemsKind;
import pl.net.ajka.warehouse.model.dao.ItemsKindDAO;

@Repository
public class ItemsKindDAOImpl  implements ItemsKindDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public ItemsKind select(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (ItemsKind) session.get(ItemsKind.class, id);
	}

}
