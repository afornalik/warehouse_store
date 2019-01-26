package pl.net.ajka.warehouse.model.dao;


import java.util.Map;

import pl.net.ajka.warehouse.model.PaletteLocalization;

public interface PaletteLocalizationDAO {
	
	public PaletteLocalization select(int id);
	
	public PaletteLocalization[] selectAll();
	
	public Map<Integer, String> selectAllName();

}
