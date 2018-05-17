package ShoppingMall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public  class OrderController {
	
	@RequestMapping(method=RequestMethod.GET,value="/vipOrder")
	public String order(){
		return "vipOrder";
	}
}
