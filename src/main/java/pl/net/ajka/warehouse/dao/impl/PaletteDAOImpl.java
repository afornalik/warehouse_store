package pl.net.ajka.warehouse.dao.impl;

import java.io.Serializable;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import pl.net.ajka.warehouse.dao.PaletteDAO;
import pl.net.ajka.warehouse.model.ItemsKind;
import pl.net.ajka.warehouse.model.Palette;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getItemsNameOnPallete(int id) {
		Session session = sessionFactory.getCurrentSession();
		List<ItemsKind> itemsKind = (List<ItemsKind>)session.createQuery("SELECT pal.itemsKind FROM Palette pal "
				+ "WHERE pal.id =:id").setParameter("id", id).getResultList();
		for(ItemsKind ik : itemsKind) {
			System.out.println(ik.getName());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllLocalisations() {
		Session session = sessionFactory.getCurrentSession();
		return (List<String>) session.createQuery("SELECT DISTINCT pal.place FROM Palette pal").getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Palette> selectByTheShelf(int paletteLocalizationId) {
		
		return (List<Palette>) sessionFactory.getCurrentSession().createQuery("SELECT DISTINCT pal FROM Palette pal "+
				"JOIN FETCH pal.items item " + 
				" JOIN FETCH item.idItemsKind   "+
				" JOIN  FETCH  pal.users  "+
				"JOIN FETCH pal.place    "+
				"WHERE pal.id = item.idPaleta "+
				"AND pal.place.id =:paletteLocalizationId")
				.setParameter("paletteLocalizationId", paletteLocalizationId).getResultList();
	}


	@Override
	public void insert(Palette palette) {
		sessionFactory.getCurrentSession().persist(palette);;
		
	}

}
