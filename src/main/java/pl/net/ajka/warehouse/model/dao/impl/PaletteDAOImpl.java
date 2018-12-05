package pl.net.ajka.warehouse.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import pl.net.ajka.warehouse.model.Palette;
import pl.net.ajka.warehouse.model.dao.PaletteDAO;

@Repository
public class PaletteDAOImpl implements PaletteDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Palette select(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Palette) session.get(Palette.class, id);
	}

}
