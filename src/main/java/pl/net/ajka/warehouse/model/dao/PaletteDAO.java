package pl.net.ajka.warehouse.model.dao;

import java.util.List;

import pl.net.ajka.warehouse.model.Palette;

public interface PaletteDAO {

	public Palette select(int id);
	
	public List<String> getItemsNameOnPallete(int id);
	
	public List<String> getAllLocalisations();
	
	
}
