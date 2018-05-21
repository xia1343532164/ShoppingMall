package ShoppingMall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ShoppingMall.Service.CarService;
import ShoppingMall.entity.Car;
import ShoppingMall.entity.User;

@Controller
public class CarController {
 
	@Autowired
	private CarService carService;
	
	@RequestMapping(method=RequestMethod.GET,value="/car")
	public String car(@AuthenticationPrincipal(expression="user") User user,Model model){
		Integer id = user.getId();
		List<Car> car = carService.findAll(id);
		model.addAttribute("cars", car);
		return "car";
	}
	@RequestMapping(method=RequestMethod.GET,value="/addCar/{id}")
	public String addCar(@AuthenticationPrincipal(expression="user") User user, @PathVariable int id,Model model){
		Integer userId = user.getId();
		carService.addCar(userId,id);
		return "redirect:/car";
	}
	@RequestMapping(method=RequestMethod.GET,value="/del/{id}")
	public String delCar(@PathVariable int id ){
		carService.delCar(id);
		return "redirect:/car";
	}
}
