package pl.net.ajka.warehouse.service;

import java.util.Set;

import pl.net.ajka.warehouse.model.Items;
import pl.net.ajka.warehouse.model.ItemsAmount;

public interface ItemsService {

	public Items select(int id);
	
	public Set<ItemsAmount> selectAllItemsValues(int id);
}
