package pl.net.ajka.warehouse.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import pl.net.ajka.warehouse.dao.PaletteLocalizationDAO;
import pl.net.ajka.warehouse.model.PaletteLocalization;

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

	@SuppressWarnings("unchecked")
	@Override
	public PaletteLocalization[] selectAll() {
		int count = ((Long)sessionFactory.getCurrentSession().createQuery("SELECT count(*) FROM PaletteLocalization").uniqueResult()).intValue();
		PaletteLocalization[] allnames = (PaletteLocalization[]) sessionFactory.getCurrentSession().createQuery(" FROM PaletteLocalization ").getResultList().toArray(new PaletteLocalization[count]);
		return  allnames;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, String> selectAllName() {
		Session session = sessionFactory.getCurrentSession();
		List<PaletteLocalization> paletteLocalization =session.createQuery("FROM PaletteLocalization").getResultList();
		Map<Integer,String> paletteMap = new HashMap<Integer,String>();
		for(PaletteLocalization ploc : paletteLocalization) {
			paletteMap.put(ploc.getId(), ploc.getLocalizationName());
		}
		
		/*List<Integer> paletaLocalizationId = ((List<Integer>) session.createQuery("SELECT ploc.id  FROM PaletteLocalization ploc").getResultList());
		for (Integer i : paletaLocalizationId) {
			String name = (String) session.createQuery("SELECT ploc.localizationName FROM paletteLocalizatin  ploc WHERE ploc.id =:idpal").setParameter("idpal", i).getSingleResult();
		}*/
		return paletteMap;
	}

}
