package pl.net.ajka.warehouse.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.net.ajka.warehouse.model.Items;
import pl.net.ajka.warehouse.model.ItemsKind;
import pl.net.ajka.warehouse.model.Palette;
import pl.net.ajka.warehouse.service.ItemsKindService;
import pl.net.ajka.warehouse.service.ItemsService;
import pl.net.ajka.warehouse.service.PaletteLocalizationService;
import pl.net.ajka.warehouse.service.PaletteService;
import pl.net.ajka.warehouse.service.UsersService;

@Controller
public class AddPaletteController {
	private ItemsKindService itemsKindService; 
	
	private PaletteLocalizationService paletteLocalizationService;
	private PaletteService paletteService;
	private ItemsService itemsService;
	private UsersService usersService;
	
	@Autowired(required=true)
	@Qualifier(value="itemsKindService")
	public void setItemsKindService(ItemsKindService itemsKindService) {
		this.itemsKindService = itemsKindService;
	}
	
	
	
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
	
	@Autowired(required = true)
	@Qualifier(value = "usersService")
	public void setUsersService( UsersService us) {
		this.usersService = us;
	}
	
	
	@RequestMapping(value="/addpalette", method=RequestMethod.POST)
	public String addPalette(@ModelAttribute(value="item")Items item,@RequestParam(value="axis", required=false) String axis, Model model) {
		System.out.println(item);
		if(axis != null) {List<String> place =  Arrays.asList(axis.split("\\s*,\\s*"));
		List<Integer> place2 = place
				.stream()
				//.map(x -> Arrays.asList(axis.split("\\s*,\\s*")))
				.map(x -> Integer.valueOf(x))
				.collect(Collectors.toList());
		model.addAttribute("axis",place2);
		paletteService.insert(new Palette(place2.get(0),place2.get(1),100,100,paletteLocalizationService.select(place2.get(2)),usersService.select(2)));
		}
		List<ItemsKind> itemsKinds = itemsKindService.selectAll();
		
		model.addAttribute("allkinds",itemsKinds.stream().map(x -> x.getName()).collect(Collectors.toList()));
		//model.addAttribute("allnames",itemsKindService.)
		
	
		return "addpalette";
	}
	
	@RequestMapping(value="/added", method=RequestMethod.POST)
	public String added( Items item, Model model) {
		model.addAttribute("addeditem",new Items());
		return "paletteadded";
	}
	
}
