package ShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ShoppingMall.Service.UserService;
import ShoppingMall.entity.User;

@Controller
public class UserController {
	
	private UserService userService;
    @Autowired	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method=RequestMethod.GET,value="/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/register")
	public String register(){
		return "reg";
	}
	@RequestMapping(method=RequestMethod.POST,value="/register")
	public String regis(@ModelAttribute User user,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "redirect:/reg";
		}else{
			userService.create(user);
		}
		return "redirect:/login";
		
	}
}
