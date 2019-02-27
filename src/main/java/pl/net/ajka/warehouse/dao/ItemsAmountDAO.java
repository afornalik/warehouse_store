package pl.net.ajka.warehouse.dao;

import pl.net.ajka.warehouse.model.Items;
import pl.net.ajka.warehouse.model.ItemsAmount;

public interface ItemsAmountDAO {

	public ItemsAmount select(int id);
	
	public ItemsAmount selectActualItemAmount(Items items);
}
