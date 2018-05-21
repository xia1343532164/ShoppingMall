package ShoppingMall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ShoppingMall.Service.CommodityService;
import ShoppingMall.entity.Commodity;

@Controller
public class GoodsController {
	
	@Autowired
	private CommodityService commodityService;
	
	@RequestMapping(method=RequestMethod.GET,value="/index")
	public String index(){
		return "index";
	}
	
	//商品列表展示
	@RequestMapping(method=RequestMethod.GET,value="/prolist")
	public String prolist(Model model){
		List<Commodity> commodity = commodityService.findAll();
		model.addAttribute("commodity", commodity);
		return "prolist";
	}
	
	//商品详情展示
	@RequestMapping(method=RequestMethod.GET,value="/buyinfo/{id}")
    public String buyinfo(@PathVariable int id ,Model model){
         Commodity commodity = commodityService.findOne(id);
         model.addAttribute("commodity",commodity);
		 return "buyinfo";
    }
    
}
