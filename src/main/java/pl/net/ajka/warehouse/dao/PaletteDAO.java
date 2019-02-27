package pl.net.ajka.warehouse.dao;

import java.util.List;

import pl.net.ajka.warehouse.model.Palette;

public interface PaletteDAO {

	public Palette select(int id);
	
	public List<Palette> selectByTheShelf(int paletteLocalizationId);
	
	public List<String> getItemsNameOnPallete(int id);
	
	public List<String> getAllLocalisations();
	
	public void insert(Palette palette);
	
	
}
