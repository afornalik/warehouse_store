package pl.net.ajka.warehouse.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.net.ajka.warehouse.dao.PaletteDAO;
import pl.net.ajka.warehouse.model.Palette;
import pl.net.ajka.warehouse.service.PaletteService;

@Service
public class PaletteServiceImpl implements PaletteService{

	private PaletteDAO paletteDAO;
	
	public void setPaletteDAO ( PaletteDAO paletteDAO) {
		this.paletteDAO = paletteDAO;
	}
	
	@Transactional
	@Override
	public Palette select(int id) {
		return (Palette) paletteDAO.select(id) ;
	}

	@Transactional
	@Override
	public List<String> getItemsNameOnPallete(int id) {
		return paletteDAO.getItemsNameOnPallete(id);
	}

	@Transactional
	@Override
	public List<String> getAllLocalisations() {
		return paletteDAO.getAllLocalisations();
	}

	@Transactional
	@Override
	public List<Palette> selectByTheShelf(int paletteLocalizationId) {
		return paletteDAO.selectByTheShelf(paletteLocalizationId);
	}

	@Transactional
	@Override
	public void insert(Palette palette) {
		paletteDAO.insert(palette);
		
	}

}
