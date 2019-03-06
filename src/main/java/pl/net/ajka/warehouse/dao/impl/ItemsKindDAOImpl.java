package pl.net.ajka.warehouse.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import pl.net.ajka.warehouse.dao.ItemsKindDAO;
import pl.net.ajka.warehouse.model.ItemsKind;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemsKind> selectAll() {
		EntityManager entityManager = sessionFactory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ItemsKind> criteriaQuery = builder.createQuery(ItemsKind.class);
		Root<ItemsKind> root = criteriaQuery.from(ItemsKind.class);
		criteriaQuery.select(root);
		return (List<ItemsKind>) entityManager.createQuery(criteriaQuery).getResultList();
		
	}

	@Override
	public void insert(ItemsKind itemsKind) {
		Session session = sessionFactory.getCurrentSession();
		session.save("ItemsKind", itemsKind);
	}

}
