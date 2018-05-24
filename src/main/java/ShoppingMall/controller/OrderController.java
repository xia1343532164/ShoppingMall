package ShoppingMall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ShoppingMall.Service.OrderService;
import ShoppingMall.entity.User;

@Controller
public  class OrderController {
	
	@Autowired
	private OrderService orderService;
	@RequestMapping(method=RequestMethod.GET,value="/vipOrder")
	public String order(){
		return "vipOrder";
	}
 
	@RequestMapping(method=RequestMethod.GET,value="/success")
	public String success(){
		return "success";
	}
	@RequestMapping(method=RequestMethod.POST,value="/success")
	public String addorder(@AuthenticationPrincipal(expression="user" )User user,@RequestParam Integer addressId,
			@RequestParam List<Integer> proId){
		orderService.createOrder(user.getId(),addressId,proId);
		orderService.delCar(proId);
		return "success";
	}
        
}
