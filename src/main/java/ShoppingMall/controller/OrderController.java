package ShoppingMall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ShoppingMall.Service.OrderService;
import ShoppingMall.entity.Order;
import ShoppingMall.entity.User;

@Controller
public  class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(method=RequestMethod.GET,value="/vipOrder")
	public String order(@AuthenticationPrincipal(expression="user")User user,Model model){
		List<Order> orders= orderService.findOrder(user.getId());
		model.addAttribute("order", orders);
		return "vipOrder";
	}
	@RequestMapping(method=RequestMethod.GET,value="/vipXiaofei/{id}")
	public String vipXiaofei(@PathVariable int id,Model model){
		Order details= orderService.findOrderdetails(id);
		model.addAttribute("order", details);
		return "vipXiaofei";
	}
	
 
/*	@RequestMapping(method=RequestMethod.GET,value="/success")
	public String success(){
		return "success";
	}*/
	@RequestMapping(method=RequestMethod.POST,value="/success")
	public String addorder(@AuthenticationPrincipal(expression="user" )User user,@RequestParam Integer addressId,
			@RequestParam List<Integer> proId,@RequestParam int goodscount){
		System.err.println(user.getId()+","+addressId+","+proId);
		Long ordernumber = System.currentTimeMillis();
		orderService.createOrder(user.getId(),addressId,proId,ordernumber,goodscount);
		orderService.delCar(proId);
		return "success";
	}
       
}
