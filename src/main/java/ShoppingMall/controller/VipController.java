package ShoppingMall.controller;

import java.io.File;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ShoppingMall.Service.VipService;
import ShoppingMall.entity.PasswordSetForm;
import ShoppingMall.entity.User;
import ShoppingMall.entity.VipAddress;

@Controller
public class VipController {
	
	private VipService vipService;
	
	
	private String uploadDir = "E:/upload";
	
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
	public String vipinfosave(@AuthenticationPrincipal(expression="user") User user1,@Valid @ModelAttribute User user,
			BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model) throws Exception{// 表单bean封装
	     	if(user.getPicture().getSize()==0||
					!user.getPicture().getContentType().toLowerCase().startsWith("image/")){
			      bindingResult.rejectValue("picture", "formError.pictureRequired", "请选择照片");	
			}
	  /*   	if(bindingResult.hasErrors()){
			       return "vip";
		}*/
		    //把我登录的id设进表单，得到要改的id
	     	//TODO
	     	user.setId(user1.getId());
	     	String filename = user.getPicture().getOriginalFilename();
	        String newFileName = String.valueOf(System.currentTimeMillis())+filename;
            user.getPicture().transferTo(new File(uploadDir,newFileName));
            user.setPicturePath(newFileName);
			vipService.saveinfo(user);
			model.addAttribute("panduan","aa" );
			
			// RedirectAttributes同时还可以作为Model用(addAttribute)，添加flash属性必须用addFlashAttribute
			 redirectAttributes.addFlashAttribute("save");
	     	  return "vip";
	}
	//密码修改
	@RequestMapping(method=RequestMethod.GET,value="/vipPwd")
	public String vippwd(){
		return "vipPwd";
	}
	@RequestMapping(method=RequestMethod.POST,value="/vipPwd")
	public String alterPassword(@AuthenticationPrincipal(expression="user")User user,
			@ModelAttribute PasswordSetForm pwd,Model model){
		if(!pwd.getPassword().equals(pwd.getPassword2())||pwd.getPassword().trim().isEmpty()){
			model.addAttribute("error", "密码错误,请重新输入");
			return "vipPwd";
		}else{
               Integer id = user.getId();
               String password = pwd.getPassword();
               vipService.alterPassword(id,password);
               model.addAttribute("Success", "修改成功");
		}
		return "vipPwd";
	}
	@RequestMapping(method=RequestMethod.GET,value="/vipAddress")
	public String vipAddress(@AuthenticationPrincipal(expression="user")User user ,Model model){
		 List<VipAddress> vipAddress = vipService.findAll(user.getId());
     	model.addAttribute("vipAddress", vipAddress);
		return "vipAddress";
}
	
	//地址添加
	@RequestMapping(method=RequestMethod.POST,value="/vipAddress")
   public String AddressAdd(@AuthenticationPrincipal(expression="user")User user, @ModelAttribute VipAddress address){
		address.setUser_id(user.getId());
		vipService.addAddress(address);
		return "redirect:/vipAddress";
   }	
	//删除
	@RequestMapping(method=RequestMethod.GET,value="/vipAddress/{id}/delete")
	public String AddressDelete(@PathVariable int id ){
		vipService.delete(id);
		return "redirect:/vipAddress";
	}
	
	//修改
	@RequestMapping(method=RequestMethod.GET,value="/vipAddress/{id}/alter")
	public String AddressAlter( @PathVariable Integer id,Model model){
		VipAddress address = vipService.findIdOneAddres(id);
		model.addAttribute("address", address);
		return "vipAddressAlter";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/vipAddress/{id}/alter")
	public String alter(@ModelAttribute VipAddress vipAddress ,@PathVariable Integer id ){
		vipAddress.setId(id);
		vipService.alterAddress(vipAddress);		
		return "redirect:/vipAddress";
	}
}
