package ShoppingMall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VipController {

	@RequestMapping(method=RequestMethod.GET,value="/vipinfo")
	public String vipinfo(){
		return "vip";
	}
}
