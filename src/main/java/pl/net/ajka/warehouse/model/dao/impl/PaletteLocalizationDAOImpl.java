package pl.net.ajka.warehouse.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import pl.net.ajka.warehouse.model.PaletteLocalization;
import pl.net.ajka.warehouse.model.dao.PaletteLocalizationDAO;

@Repository
public class PaletteLocalizationDAOImpl implements PaletteLocalizationDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public PaletteLocalization select(int id) {
			return sessionFactory.getCurrentSession().get(PaletteLocalization.class, id);
	}

}
