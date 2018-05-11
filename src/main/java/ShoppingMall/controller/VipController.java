package ShoppingMall.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
			BindingResult bindingResult,RedirectAttributes redirectAttributes) throws Exception{// 表单bean封装
		
	     	String filename = user.getPicture().getOriginalFilename();
			
	     	if(user.getPicture().getSize()==0||
					!user.getPicture().getContentType().toLowerCase().startsWith("image/")){
			      bindingResult.rejectValue("picture", "formError.pictureRequired", "请选择照片");	
			}else{
				//把我登录的id设进表单，得到要改的id
	     	user.setId(user1.getId());
            user.getPicture().transferTo(new File(uploadDir,filename));
            user.setPicturePath(filename);
 	     	System.out.println(user);
			vipService.saveinfo(user);
			
			// RedirectAttributes同时还可以作为Model用(addAttribute)，添加flash属性必须用addFlashAttribute
			 redirectAttributes.addFlashAttribute("save");
		}
	     	return "vip";
	}
}
