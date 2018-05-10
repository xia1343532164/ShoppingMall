package ShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ShoppingMall.Service.VipService;
import ShoppingMall.entity.User;

@Controller
public class VipController {
	
	private VipService vipService;
	
	@Autowired
	public VipController(VipService vipService) {
		this.vipService = vipService;
	}

	@RequestMapping(method=RequestMethod.GET,value="/vipinfo")
	public String vipinfo(){
		return "vip";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/vipinfo")
	//user1是登录的,user是表单提交的
	public String vipinfosave(@AuthenticationPrincipal(expression="user") User user1,@ModelAttribute User user){
//		if(bindingResult.hasErrors()){
//			return "vip";
//		}else{
//			user.setId(id);
//			user1.setEmail(user.getEmail());
//			System.out.println(user);
			user.setId(user1.getId());
			//把我登录的id设进表单，得到要改的id
			System.out.println(user);
			vipService.saveinfo(user);
			return "vip";
//		}
	}
}
