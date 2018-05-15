package ShoppingMall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GoodsController {
	
	@RequestMapping(method=RequestMethod.GET,value="/index")
	public String index(){
		return "index";
	}
	//商品列表展示
	@RequestMapping(method=RequestMethod.GET,value="/prolist")
	public String prolist(){
		return "prolist";
	}

}
