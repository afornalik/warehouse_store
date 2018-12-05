package pl.net.ajka.warehouse.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.net.ajka.warehouse.model.ItemsKind;
import pl.net.ajka.warehouse.model.dao.ItemsKindDAO;
import pl.net.ajka.warehouse.service.ItemsKindService;

@Service
public class ItemsKindServiceImpl implements ItemsKindService{

	private ItemsKindDAO itemsKindDAO;
	
	public void setItemsKindDAO (ItemsKindDAO itemsKindDAO) {
		this.itemsKindDAO = itemsKindDAO;
	}
	
	@Transactional
	@Override
	public ItemsKind select(int id) {
		return (ItemsKind) itemsKindDAO.select(id);
	}

}
