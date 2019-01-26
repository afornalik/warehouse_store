package pl.net.ajka.warehouse.service;

import java.util.Map;

import pl.net.ajka.warehouse.model.PaletteLocalization;

public interface PaletteLocalizationService {

	
	public PaletteLocalization select(int id);
	
	public PaletteLocalization[] selectAll();
	
	public Map<Integer, String> selectAllName();
	
	
}
