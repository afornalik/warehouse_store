package pl.net.ajka.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.net.ajka.warehouse.model.PaletteLocalization;
import pl.net.ajka.warehouse.service.ItemsService;
import pl.net.ajka.warehouse.service.PaletteLocalizationService;
import pl.net.ajka.warehouse.service.PaletteService;

@Controller
public class SelectPlaceController {

	private PaletteLocalizationService paletteLocalizationService;
	private PaletteService paletteService;
	private ItemsService itemsService;
	
	@Autowired(required=true)
	@Qualifier(value="paletteLocalizationService")
	public void setPaletteLocalizationService (PaletteLocalizationService paletteLocalizationService) {
		this.paletteLocalizationService = paletteLocalizationService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="itemsService")
	public void setItemsService (ItemsService is) {
		this.itemsService = is;
	}
	
	@Autowired(required=true)
	@Qualifier(value="paletteService")
	public void  setPaletteService (PaletteService ps) {
		this.paletteService = ps;
	}
	
	
	
	@RequestMapping(value="/shelves",method=RequestMethod.GET)
	public String selectPlace(Model model) {
		
		model.addAttribute("shelves",paletteLocalizationService.selectAllName());
		return "showPlace";
	}
	
	@RequestMapping(value="/shelves",method=RequestMethod.POST)
	public String placeWasSelected(@RequestParam(value="selectedShelve",required=false)Integer selectedShelve,Model model) {
		
		
		
		
		model.addAttribute("shelves",paletteLocalizationService.selectAllName());
		model.addAttribute("newSelectedShelve",paletteLocalizationService.select(selectedShelve));
		model.addAttribute("paletteListOnTheShelf",paletteService.selectByTheShelf(selectedShelve));
		
		
		
		
		
		
	/*	model.addAttribute("placeList",paletteLocalizationService.selectAll());
		
		model.addAttribute("selected","wybrałęś : "+item);
		
		model.addAttribute("maploc",itemsService.selectAllPaletteFromShelve(item));*/
		return "showPlace";
	}
}
