package pl.net.ajka.warehouse.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.net.ajka.warehouse.model.Items;
import pl.net.ajka.warehouse.model.ItemsAmount;
import pl.net.ajka.warehouse.model.Palette;
import pl.net.ajka.warehouse.model.dao.ItemsDAO;
import pl.net.ajka.warehouse.service.ItemsService;


@Service
public class ItemsServiceImpl implements ItemsService{

	private ItemsDAO itemDAO;
	
	public void setItemsDAO(ItemsDAO itemsDAO) {
		this.itemDAO = itemsDAO;
	}
	
	@Transactional
	@Override
	public Items select(int id) {
		return itemDAO.select(id);
	}

	@Transactional
	@Override
	public Set<ItemsAmount> selectAllItemsValues(int id) {
		return itemDAO.selectAllItemsValues(id);
	}

	@Transactional
	@Override
	public ItemsAmount selectActualValue(int id) {
		return itemDAO.selectActualValue(id);
	}

	@Transactional
	@Override
	public List<String> selectAllItemsNameFromPallete(int paletteid) {
		return itemDAO.selectAllItemsNameFromPallete(paletteid);
	}

	
	@Transactional
	@Override
	public List<Integer> selectAllPaletteId() {
		return itemDAO.selectAllPaletteId();
	}

	@Transactional
	@Override
	public Map<Integer, String[]> selectAllPaletteIdAndItemsName() {
		return itemDAO.selectAllPaletteIdAndItemsName();
	}

	@Transactional
	@Override
	public Map<Palette, List<Items>> selectAllPaletteFromShelve(String Localisation) {
		return itemDAO.selectAllPaletteFromShelve(Localisation);
	}
	
	

}
