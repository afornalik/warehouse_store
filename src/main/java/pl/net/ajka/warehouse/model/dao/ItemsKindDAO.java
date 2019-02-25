package pl.net.ajka.warehouse.model.dao;

import java.util.List;

import pl.net.ajka.warehouse.model.ItemsKind;

public interface ItemsKindDAO {
	
	public ItemsKind select(int id);
	
	public List<ItemsKind> selectAll();

}
