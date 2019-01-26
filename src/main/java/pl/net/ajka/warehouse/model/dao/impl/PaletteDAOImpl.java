package pl.net.ajka.warehouse.model.dao.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import pl.net.ajka.warehouse.model.ItemsKind;
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
		
		return (List<Palette>) sessionFactory.getCurrentSession().createQuery("FROM Palette pal  JOIN FETCH pal.items item JOIN FETCH item.idItemsKind itkind JOIN  FETCH pal.itemsKind JOIN FETCH item.whoAdd WHERE pal.id = item.idPaleta AND pal.place.id =:paletteLocalizationId").setParameter("paletteLocalizationId", paletteLocalizationId).getResultList();
	}

}
