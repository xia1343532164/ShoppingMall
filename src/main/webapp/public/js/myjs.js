$(function(){
/*	// 获取meta中的csrf token
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	// 将token作为请求头发送
	var headers = {};
	headers[header] = token;*/
	$(".jian").click(function(){
		var id1 = $(this).attr("name");
		console.log($(".shuliang[aa='"+id1+"']").val());
		$.ajax({			
			url:"/ShoppingMall/minus",
			type:"GET",
			data:{id:id1,goodscount:$(".shuliang[aa='"+id1+"']").val()},
			success:function(carStr){
				console.log($("strong.red[aa='"+id1+"']")[0]);	
				if(!carStr){
					$(".car"+id1).remove();
				}else{
//					console.log($(".shuliang").val());
//					console.log(parseInt(($("strong.red[name='"+id1+"']")[0].innerHTML).substr(1)));
//					console.log($("."+id1+"").val());
					
					$(".shuliang[aa='"+id1+"']").val(carStr.goodscount);
					$("strong.red[name='"+id1+"']")[0].innerHTML="￥"+(carStr.commoditys.price * carStr.goodscount);
					$("strong.red[name='all']")[0].innerHTML="￥"+(parseInt(($("strong.red[name='all']")[0].innerHTML).substr(1))-carStr.commoditys.price);
				}
			},
			error:function(){
				alert("aaa");
			}
		});
	});
	
	$(".jia").click(function(){
		var id1 = $(this).attr("name");
	    $.ajax({
			url:"/ShoppingMall/adding",
			type:"GET",
			data:{id:id1,goodscount:$(".shuliang[aa='"+id1+"']").val()},
		success:function(carStr){
			/*console.log(carStr);
			console.log($(".shuliang[name='"+id1+"']"));
			console.log($("strong.red[name='"+id1+"']")[0]);*/
		$(".shuliang[aa='"+id1+"']").val(carStr.goodscount);
		$("strong.red[name='"+id1+"']")[0].innerHTML="￥"+(carStr.commoditys.price * carStr.goodscount);
		$("strong.red[name='all']")[0].innerHTML="￥"+(parseInt(($("strong.red[name='all']")[0].innerHTML).substr(1))+parseInt(carStr.commoditys.price));
					}
				});
			});
	
	$(".green").click(function() {
		var id1 = $(this).attr("name");
		$.ajax({
			url:"/ShoppingMall/del/"+id1,
			type:"GET",
			data:{id:id1},
			success:function(carstr){
				  $(".car"+id1).remove();
			}
		});
	});
	
	$(".shanchu").click(function() {
		$.ajax({
			url:"/ShoppingMall/del/all",
			type:"GET",
			success:function(carstr){
				  $("tr[name='car']").remove();
			}
	     });
     });
	
	$(".jiaruCar").click(function() {
		var proid = $(this).attr("name");
		$.ajax({
			url:"/ShoppingMall/addCar/"+proid,
			type:"GET",
			success:function(carstr){
				alert("添加成功");
			}
		});
	});
	
	$(".buy-mai").click(function() {
		var proid = $(this).attr("name");
		$.ajax({
			url:"/ShoppingMall/addCar/"+proid,
			type:"GET",
			success:function(carstr){
				alert("添加成功");
			}
		});
	});
	
	//表单必须选地址和商品才能提交
	$('#Immediate-settlement').submit(function() {
		if ($('input[name=addressId]:checked', this).val() && 
				$('input[name=proId]:checked', this).val()) {
			return true;
		} else if ($('input[name=addressId]:checked', this).val()) {
			alert('请选择要购买的商品');
			return false;
		} else if ($('input[name=proId]:checked', this).val()) {
			alert('请选择收货地址');
			return false;
		} else {
			alert('请选择收货地址和商品');
			return false;
		}
	});
	
});
