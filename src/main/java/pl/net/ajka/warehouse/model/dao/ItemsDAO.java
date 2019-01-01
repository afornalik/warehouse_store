package pl.net.ajka.warehouse.model.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import pl.net.ajka.warehouse.model.Items;
import pl.net.ajka.warehouse.model.ItemsAmount;
import pl.net.ajka.warehouse.model.Palette;

public interface ItemsDAO {
	
	public Items select(int id);
	
	public Set<ItemsAmount> selectAllItemsValues(int id);

	public ItemsAmount selectActualValue(int id);
	
	public ItemsAmount selectActualValue(Items items);
	
	public List<String> selectAllItemsNameFromPallete(int paletteid);
	
	public List<Integer> selectAllPaletteId();
	
	public Map<Integer, String[]> selectAllPaletteIdAndItemsName();
	
	public Map<Palette, List<Items>> selectAllPaletteFromShelve(String Localisation);
}
