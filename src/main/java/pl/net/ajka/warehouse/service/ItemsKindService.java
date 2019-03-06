package pl.net.ajka.warehouse.service;

import java.util.List;

import pl.net.ajka.warehouse.model.ItemsKind;

public interface ItemsKindService {

	public ItemsKind select(int id);
	
	public List<ItemsKind> selectAll();
	
	public void insert(ItemsKind itemsKind);
}
