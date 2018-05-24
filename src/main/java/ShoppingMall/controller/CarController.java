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
import org.springframework.web.bind.annotation.ResponseBody;

import ShoppingMall.Service.CarService;
import ShoppingMall.Service.VipService;
import ShoppingMall.entity.Car;
import ShoppingMall.entity.User;
import ShoppingMall.entity.VipAddress;

@Controller
public class CarController {
 
	@Autowired
	private CarService carService;
	
	@Autowired
	private VipService vipService;
	
	@RequestMapping(method=RequestMethod.GET,value="/car")
	public String car(@AuthenticationPrincipal(expression="user") User user,Model model){
		Integer id = user.getId();
        List<VipAddress> address = vipService.findAll(id);
        model.addAttribute("address", address);
		
        List<Car> car = carService.findAll(id);
		model.addAttribute("cars", car);
		return "car";
	}
	@RequestMapping(method=RequestMethod.GET,value="/addCar/{id}")
	public String addCar(@AuthenticationPrincipal(expression="user") User user, @PathVariable Integer id,Model model){
		Integer userId = user.getId();
		System.err.println(id);
		Car car = carService.checkCar(userId,id);
		System.out.println(car);
        if(car==null){
        	System.out.println(car);
        	carService.addCar(userId,id);
        }else{
        	carService.addCount(userId,id);
        }
		return "redirect:/car";
	}
	@RequestMapping(method=RequestMethod.GET,value="/del/{id}")
	public  @ResponseBody
	Car delCar(@PathVariable Integer id ){
		carService.delCar(id);
		return new Car();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/del/all")
	public String delAll(@AuthenticationPrincipal(expression="user") User user){
		carService.delAll(user.getId());
		return "car";
	}
	@RequestMapping(method=RequestMethod.GET,value="/minus")
    public  @ResponseBody
    Car minus(@AuthenticationPrincipal(expression="user") User user,@RequestParam Integer id,@RequestParam int goodscount){
		
		System.err.println(goodscount);
		
		if(goodscount<=1){
			System.out.println("minus:"+id);
			carService.delCar(id);
		}else{
			carService.minusCount(id);
		}
    	return carService.findOneCar(id);
    }
	
    @RequestMapping(method=RequestMethod.GET,value="/adding")	
	public  @ResponseBody
	Car adding(@AuthenticationPrincipal(expression="user") User user,@RequestParam Integer id ){	
    	   
          	carService.addCarCount(id);
    	    
	        return carService.findOneCar(id) ;	
	} 
}
