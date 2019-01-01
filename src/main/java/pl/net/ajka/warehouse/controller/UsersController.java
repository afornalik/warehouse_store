package pl.net.ajka.warehouse.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.net.ajka.warehouse.model.Palette;
import pl.net.ajka.warehouse.model.Test;
import pl.net.ajka.warehouse.model.Users;
import pl.net.ajka.warehouse.service.ItemsAmountService;
import pl.net.ajka.warehouse.service.ItemsService;
import pl.net.ajka.warehouse.service.PaletteService;
import pl.net.ajka.warehouse.service.TestService;
import pl.net.ajka.warehouse.service.UsersService;

@Controller
public class UsersController {

		private ItemsAmountService itemsAmountService;
		private UsersService userService;
		private TestService testService;
		private ItemsService itemsService;
		private PaletteService paletteService;
		private Logger logger = LoggerFactory.getLogger(UsersController.class);
		
		@Autowired(required = true)
		@Qualifier(value = "paletteService")
		public void setPaletteService(PaletteService ps) {
			this.paletteService = ps;
		}
		
		@Autowired(required = true)
		@Qualifier(value = "itemsService")
		public void setItemsService(ItemsService is) {
			this.itemsService= is;
		}
		
		@Autowired(required = true)
		@Qualifier(value = "userService")
		public void setUserService( UsersService us) {
			this.userService = us;
		}
		
		@Autowired(required = true)
		@Qualifier(value = "testService")
		public void setTestService( TestService ts) {
			this.testService = ts;
		}
		
		@Autowired(required= true)
		@Qualifier(value ="itemsAmountService")
		public void setItemsAmountService( ItemsAmountService ia) {
			this.itemsAmountService = ia;
		}
		
		@RequestMapping(value="/items")
		public String getItems(Model model) {
			
			/*model.addAttribute("idOfAllPallet",itemsService.selectAllPaletteId());
			model.addAttribute("item1",itemsService.selectAllItemsNameFromPallete(4));
			model.addAttribute("item1",itemsService.selectAllItemsNameFromPallete(3));
			model.addAttribute("item1",itemsService.selectAllItemsNameFromPallete(1));
			*/
			model.addAttribute("placelist",paletteService.getAllLocalisations());
			model.addAttribute("item2",itemsService.selectAllPaletteIdAndItemsName());
			return "items";
			
		}
		
		
		
		@RequestMapping(value="/test", method=RequestMethod.GET)
		public String goTest(Model model) {
		/*	int i = 0;
			for (Test t :testService.getAll()) {
				i++;
				if (i == 5) {
					testService.remove(t);
				}
			}*/
			
			model.addAttribute("test",testService.getAll());
			
			model.addAttribute("test2", new Test());
			model.addAttribute("test3", new Test());
			
			return "test";
		}
		
		@RequestMapping(value="/test",method=RequestMethod.POST)
		public String addTest(@ModelAttribute("test2") Test t , Model model ) {
			testService.save(t);
			
			
			return "redirect:/test";
		}
		
		@RequestMapping(value="/test/remove/{id}")
		public String remTest(@PathVariable int id, Model model2) {
			testService.remove(id);
			
			return "redirect:/test";
		}
		
		@RequestMapping(value= {"/","/index"})
		public String goIndex(Model model) {
			model.addAttribute("kasa",new Integer(1033));
			return "index";
			
		}
		
		@RequestMapping(value = "/users", method = RequestMethod.GET)
		public String listPersons(Model model) {
			model.addAttribute("user",new Users());
			model.addAttribute("listUser", this.userService.userlist());
			return "users";
		}

		@RequestMapping(value = "/users/add", method = RequestMethod.POST)
		public String addUsers(@ModelAttribute("user") Users user) {
			System.out.println("aaaAAAAAAAAA"+ user);
			if (user.getId() == 0) {
				this.userService.addUser(user);
			}else {
				this.userService.updateUser(user);
			}
			return "redirect:/users";
		}
		
		@RequestMapping(value= "/remove/{id}")
		public String removeUser(@PathVariable("id") int id ) {
			this.userService.removeUser(id);
			return "redirect:/users";
		}
		
		@RequestMapping("/edit/{id}")
		public String editUser(@PathVariable("id") int id,Model model) {
			model.addAttribute("user" , this.userService.select(id));
			model.addAttribute("listUser" , this.userService.userlist());
			return "users";
		}
}
