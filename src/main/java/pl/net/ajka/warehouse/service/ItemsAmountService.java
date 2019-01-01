package pl.net.ajka.warehouse.service;

import pl.net.ajka.warehouse.model.Items;
import pl.net.ajka.warehouse.model.ItemsAmount;

public interface ItemsAmountService {

	public ItemsAmount select(int id);
	
	public ItemsAmount selectActualItemAmount(Items items);
}
