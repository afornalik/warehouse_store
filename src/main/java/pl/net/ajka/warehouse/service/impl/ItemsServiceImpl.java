package pl.net.ajka.warehouse.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.net.ajka.warehouse.model.Items;
import pl.net.ajka.warehouse.model.ItemsAmount;
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
	
	

}
