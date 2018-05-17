package ShoppingMall.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ShoppingMall.Service.SellerService;
import ShoppingMall.entity.Commodity;

@Controller
public class SellerCenterController {
	
	@Autowired
   private  SellerService sellerService;
	
   private String uploadDir= "E:/sellerUpload";
	
	//卖家中心
	@RequestMapping(method=RequestMethod.GET,value="/vip-sell")
	public String sellerCenter(){
		return "vip-sell";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/vip-product")
	public String  addPro(){
		return "vip-product";
	}
	@RequestMapping(method=RequestMethod.POST,value="/vip-product")
	public String addCommodity(@ModelAttribute Commodity commodity,BindingResult bindingResult,Model model) throws Exception{
		if(commodity.getPicture().getSize()==0||
				!commodity.getPicture().getContentType().toLowerCase().startsWith("image/")){
		      bindingResult.rejectValue("picture", "formError.pictureRequired", "请选择照片");	
		}
		if(bindingResult.hasErrors()){
			return "vip-product";
		}		
		  String filename = commodity.getPicture().getOriginalFilename();
		  String newFileName = String.valueOf(System.currentTimeMillis())+filename;
		  commodity.getPicture().transferTo(new File(uploadDir,newFileName));
		  commodity.setPicturePath(newFileName);
		
		  sellerService.addCommodity(commodity);
		  model.addAttribute("success", "发布产品成功");
		  return "vip-product";
	}
}
