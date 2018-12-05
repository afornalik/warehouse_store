package pl.net.ajka.warehouse.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.net.ajka.warehouse.model.ItemsAmount;
import pl.net.ajka.warehouse.model.dao.ItemsAmountDAO;
import pl.net.ajka.warehouse.service.ItemsAmountService;

@Service
public class ItemsAmountServiceImpl implements ItemsAmountService{

	private ItemsAmountDAO itemsAmountDAO;
	
	public void setItemsAmountDAO (ItemsAmountDAO itemsAmountDAO) {
		this.itemsAmountDAO = itemsAmountDAO;
	}

	@Transactional
	@Override
	public ItemsAmount select(int id) {
		return itemsAmountDAO.select(id);
	}

}
