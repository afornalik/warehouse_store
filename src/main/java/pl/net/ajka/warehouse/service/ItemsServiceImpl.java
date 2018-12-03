package pl.net.ajka.warehouse.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.net.ajka.warehouse.model.Items;
import pl.net.ajka.warehouse.model.dao.ItemsDAO;


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
	
	

}
