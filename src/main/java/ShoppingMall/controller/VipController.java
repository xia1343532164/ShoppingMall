package ShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String vipinfo(@AuthenticationPrincipal(expression = "user") User user1,Model model){
		model.addAttribute("user", user1);
		return "vip";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/vipinfo")
	//user1是登录的,user是表单提交的
	//@AuthenticationPrincipal(expression="") 获取当前登录的对象
	public String vipinfosave(@AuthenticationPrincipal(expression="user") User user1,@ModelAttribute User user,
			RedirectAttributes redirectAttributes){// 表单bean封装
			user.setId(user1.getId());
			//把我登录的id设进表单，得到要改的id
			System.out.println(user);
			vipService.saveinfo(user);
			
			// RedirectAttributes同时还可以作为Model用(addAttribute)，添加flash属性必须用addFlashAttribute
			 redirectAttributes.addFlashAttribute("save");
			return "vip";
//		}
	}
}
