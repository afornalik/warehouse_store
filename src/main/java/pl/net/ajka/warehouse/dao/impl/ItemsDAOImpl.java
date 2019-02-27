package pl.net.ajka.warehouse.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static java.lang.Math.toIntExact;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import pl.net.ajka.warehouse.dao.ItemsDAO;
import pl.net.ajka.warehouse.model.Items;
import pl.net.ajka.warehouse.model.ItemsAmount;
import pl.net.ajka.warehouse.model.Palette;

@Repository
public class ItemsDAOImpl implements ItemsDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public Items select(int id) {
		Session session = sessionFactory.getCurrentSession();
		Items items = (Items) session
				.createQuery("SELECT it FROM Items it" + " JOIN FETCH it.whoAdd add "
						+ "	JOIN FETCH it.idItemsKind kind " + " JOIN FETCH it.idPaleta paleta "
						+ " JOIN FETCH it.itemsAmount amount " + " WHERE it.id = :itemid")
				.setParameter("itemid", id).getSingleResult();
		System.out.println(items);
		return items;
	}

	@Override
	public Set<ItemsAmount> selectAllItemsValues(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Set<ItemsAmount>) session.get(Items.class, id).getItemsAmount();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ItemsAmount selectActualValue(int id) {
		Session session = sessionFactory.getCurrentSession();
		String query = "SELECT i.itemsAmount FROM Items i WHERE i.id = 2 ORDER BY i.id DESC";
		Query q = session.createQuery(query);
		q.setMaxResults(1);

		return (ItemsAmount) q.getSingleResult();
	}

	@Override
	public ItemsAmount selectActualValue(Items items) {

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> selectAllItemsNameFromPallete(int paletteid) {
		Session session = sessionFactory.getCurrentSession();
		List<String> allItemsNamesFromPallete = (List<String>) session
				.createQuery("SELECT ik.name FROM ItemsKind ik, Items it , Palette pl"
						+ " WHERE ik.id = it.idItemsKind.id AND pl.id = it.idPaleta.id and pl.id = :pid")
				.setParameter("pid", paletteid).getResultList();
		for (String s : allItemsNamesFromPallete) {
			System.out.println(s);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> selectAllPaletteId() {
		Session session = sessionFactory.getCurrentSession();

		return (List<Integer>) session.createQuery("SELECT pl.id FROM Palette pl").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, String[]> selectAllPaletteIdAndItemsName() {
		Session session = sessionFactory.getCurrentSession();
		Map<Integer, String[]> allIdAndCorrespondingNames = new HashMap<Integer, String[]>();
		List<Integer> paletteIdKey = (List<Integer>) session.createQuery("SELECT pl.id FROM Palette pl")
				.getResultList();
		for (Integer oneKey : paletteIdKey) {
			List<String> allItemsName = ((List<String>) session
					.createQuery("SELECT ik.name FROM ItemsKind ik, Items it , Palette pl"
							+ " WHERE ik.id = it.idItemsKind.id AND pl.id = it.idPaleta.id and pl.id = :pid")
					.setParameter("pid", oneKey).getResultList());
			allIdAndCorrespondingNames.put(oneKey, (String[]) allItemsName.toArray(new String[allItemsName.size()]));
		}
		return allIdAndCorrespondingNames;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Palette, List<Items>> selectAllPaletteFromShelve(String Localisation) {
		Session session = sessionFactory.getCurrentSession();
		Map<Palette, List<Items>> palmap = new HashMap<Palette, List<Items>>();
		List<Palette> palette = session.createQuery("SELECT pl FROM Palette pl WHERE pl.place.localizationName =:loc")
				.setParameter("loc", Localisation).getResultList();

		for (Palette p : palette) {
			List<Items> items = session
					.createQuery("SELECT it FROM Items it" + 
							" JOIN FETCH it.idItemsKind ik " + 
							" JOIN FETCH it.idPaleta pl " +
							" JOIN FETCH it.whoAdd us"+
							"  WHERE pl.id = it.idPaleta.id AND pl.id =:pal ")
					.setParameter("pal", p.getId()).getResultList();
			
			palmap.put(p, items);
		}

		return palmap;
	}
}
