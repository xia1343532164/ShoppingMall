package ShoppingMall.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String register(@ModelAttribute User user){
		return "reg";
	}
	@RequestMapping(method=RequestMethod.POST,value="/register")
	public String regis(@Valid @ModelAttribute User user,BindingResult bindingResult,String password1,Model model){
		if(bindingResult.hasErrors()){
			return "reg";
		}else if(!user.getPassword().equals(password1)){
                  model.addAttribute("model","密码不一致,请重新输入");
                  return "reg";
		}else
		     userService.create(user);
		     return "redirect:/login";
		
	}
}
