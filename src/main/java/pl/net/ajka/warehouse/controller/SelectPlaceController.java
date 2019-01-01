package pl.net.ajka.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.net.ajka.warehouse.service.ItemsService;
import pl.net.ajka.warehouse.service.PaletteService;

@Controller
public class SelectPlaceController {

	private PaletteService paletteService;
	private ItemsService itemsService;
	
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
	
	@RequestMapping(value="/show_places",method=RequestMethod.GET)
	public String selectPlace(Model model) {
		model.addAttribute("placeList",paletteService.getAllLocalisations());
		
		return "showPlace";
	}
	
	@RequestMapping(value="/show_places",method=RequestMethod.POST)
	public String placeWasSelected(@RequestParam("listItem") String item,Model model) {
		model.addAttribute("placeList",paletteService.getAllLocalisations());
		model.addAttribute("selected","wybra³eœ : "+item);
		model.addAttribute("maploc",itemsService.selectAllPaletteFromShelve(item));
		return "showPlace";
	}
}
