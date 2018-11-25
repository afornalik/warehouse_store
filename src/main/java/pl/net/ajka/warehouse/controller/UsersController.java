package pl.net.ajka.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.net.ajka.warehouse.model.Users;
import pl.net.ajka.warehouse.service.UsersService;

@Controller
public class UsersController {

	
		private UsersService userService;
		
		@Autowired(required = true)
		@Qualifier(value = "userService")
		public void setUserService( UsersService us) {
			this.userService = us;
		}
		
		@RequestMapping(value = "/users", method = RequestMethod.GET)
		public String listPersons(Model model) {
			model.addAttribute("user",new Users());
			model.addAttribute("listUser", this.userService.userlist());
			return "users";
		}

		@RequestMapping(value = "/users/add", method = RequestMethod.POST)
		public String addUsers(@ModelAttribute("user") Users u) {
			if (u.getId() == 0) {
				this.userService.addUser(u);
			}else {
				this.userService.updateUser(u);
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
			model.addAttribute("user" , this.userService.getUserById(id));
			model.addAttribute("listUser" , this.userService.userlist());
			return "users";
		}
}
