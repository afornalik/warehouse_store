package pl.net.ajka.warehouse.model.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import pl.net.ajka.warehouse.model.Items;
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

	@Override
	public ItemsAmount selectActualItemAmount(Items items) {
		Session session = sessionFactory.getCurrentSession();
		String query="SELECT ia FROM ItemsAmount ia WHERE ia.items=:items";
		Query q= session.createQuery(query);
		q.setParameter("items", items);
		List<ItemsAmount> ia = (List<ItemsAmount>)q.getResultList(); 
		for(ItemsAmount iaa : ia) {
			System.out.println(iaa.getAmount());
		}
		return ia.get(0);
	}

}
