package pl.net.ajka.warehouse.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.net.ajka.warehouse.model.Palette;
import pl.net.ajka.warehouse.model.dao.PaletteDAO;
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

}
