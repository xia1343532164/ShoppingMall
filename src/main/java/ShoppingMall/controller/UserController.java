package ShoppingMall.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	private PasswordEncoder passwordEncoder;

	@Autowired
	 public UserController(UserService userService, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String login() {
		return "login";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/register")
	public String register(@ModelAttribute User user) {
		return "reg";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public String regis(@Valid @ModelAttribute User user, BindingResult bindingResult, String password1, Model model) {
		if (bindingResult.hasErrors()) {
			return "reg";
		} else if (!user.getPassword().equals(password1)) {
			model.addAttribute("error", "两次密码不一致");
			return "reg";
		} else {
			String encode = passwordEncoder.encode(user.getPassword());
			user.setPassword(encode);
			userService.create(user);
		}
		return "redirect:/login";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/index")
	public String index(@AuthenticationPrincipal(expression = "user") User curuser ){
		System.out.println(curuser);
		return "index";
	}
	@RequestMapping(method=RequestMethod.GET,value="/prolist")
	public String prolist(){
		return "prolist";
	}
}
