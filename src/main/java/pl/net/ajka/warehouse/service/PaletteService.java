package pl.net.ajka.warehouse.service;

import java.util.List;

import pl.net.ajka.warehouse.model.Palette;

public interface PaletteService {

	public Palette select(int id);
	
	public List<String> getItemsNameOnPallete(int id);
	
	public List<String> getAllLocalisations();
}
