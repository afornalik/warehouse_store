package pl.net.ajka.warehouse.controller;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.net.ajka.warehouse.model.ItemsKind;
import pl.net.ajka.warehouse.service.ItemsKindService;
import pl.net.ajka.warehouse.service.UsersService;

@Controller
public class AddNewKind {
	
	private ItemsKindService itemsKindService;
	private UsersService usersService;
	
	@Autowired(required=true)
	@Qualifier(value= "usersService")
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	
	@Autowired(required=true)
	@Qualifier(value = "itemsKindService")
	public void setItemsKindService(ItemsKindService itemsKindService) {
		this.itemsKindService = itemsKindService;
	}
	
	@ModelAttribute("addNewKind")
	public void populateKind(Model model) {
			model.addAttribute("addNewKind", new ItemsKind());
	}
	
	@RequestMapping(value="/addnewkind", method= RequestMethod.GET)
	public String addNewKind(@ModelAttribute("addNewKind")ItemsKind itemsKind,BindingResult bindingResult,Model model) {
			itemsKind.setAddDate(new Date());
			itemsKind.setUsers(usersService.select(2));
			
			return "addnewkind";
	}
	
	@RequestMapping(value="/addnewkind", method= RequestMethod.POST)
	public String addedNewKind(@ModelAttribute("addNewKind")ItemsKind itemsKind,BindingResult bindingResult,Model model) {
		itemsKindService.insert(itemsKind);
		model.addAttribute("itemsKindFullList", itemsKindService.selectAll());
			//model.addAttribute("addedKind",itemsKind);
			return "addnewkind";
	}

}
