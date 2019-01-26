package pl.net.ajka.warehouse.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.net.ajka.warehouse.model.PaletteLocalization;
import pl.net.ajka.warehouse.model.dao.PaletteLocalizationDAO;
import pl.net.ajka.warehouse.service.PaletteLocalizationService;

@Service
public class PaletteLocalizationServiceImpl implements PaletteLocalizationService {

	private PaletteLocalizationDAO paletteLocalizationDAO; 
	
	public void setPaletteLocalizationDAO ( PaletteLocalizationDAO paletteLocalizationDAO) {
		this.paletteLocalizationDAO = paletteLocalizationDAO;
	}
	
	@Transactional
	@Override
	public PaletteLocalization select(int id) {
		return paletteLocalizationDAO.select(id);
	}

	@Transactional
	@Override
	public PaletteLocalization[] selectAll() {
		return paletteLocalizationDAO.selectAll();
	}

	@Transactional
	@Override
	public Map<Integer, String> selectAllName() {
		return paletteLocalizationDAO.selectAllName();
	}

	
	
}
