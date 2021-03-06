<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<c:set var="countMoney" value="0"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>unique</title>
<link type="text/css" href="${contextPath}/assets/css/css.css" rel="stylesheet" />
<script type="text/javascript" src="${contextPath}/assets/js/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${contextPath}/assets/js/js.js"></script>
<script type="text/javascript" src="${contextPath}/assets/js/myjs.js"></script>
</head>

<body>
 <div class="hrader" id="header">
  <div class="top">
   <%@include file="header.jspf" %>
   <ul class="topNav">
    <li><a href="order.html">我的订单 </a></li>
    <li class="gouwuche"><a href="car.html">购物车</a> <strong style="color:#C94E13;">3</strong></li>
    <li class="shoucangjia"><a href="shoucang.html">收藏夹</a></li>
    <li class="kefus"><a href="#">联系客服</a></li>
<li><a href="#" class="lan">中文</a></li>
    <li><a href="#" class="lan">English</a></li>
    <div class="clears"></div>
   </ul><!--topNav/-->
  </div><!--top/-->
 </div><!--hrader/-->
 <div class="mid">
  <h1 class="logo" style="text-align:left;">
  <a href="index.html"><img src="${contextPath}/assets/images/logo.png" width="304" height="74" /></a>
  </h1>
  <form action="#" method="get" class="subBox">
   <div class="subBox2">
    <input type="text" class="subText" />
    <input type="image" src="${contextPath}/assets/images/sub.jpg" width="95" height="32" class="subImg" />
    <div class="hotci">
    <a href="#">酷派大神</a>
    <a href="#">三星s5</a>
    <a href="#">诺基亚1020</a>
    <a href="#">Iphone 6</a>
    <a href="#">htc one</a>
   </div><!--hotci/-->
   </div><!--subBox2/-->
  </form><!--subBox/-->
  <div class="ding-gou">
   <div class="ding">
    <a href="order.html"><img src="${contextPath}/assets/images/dingdan.jpg" width="106" height="32" /></a>
   </div><!--ding/-->
   <div class="gou">
    <a href="car.html"><img src="${contextPath}/assets/images/gouwuche.jpg" width="126" height="32" /></a>
   </div><!--gou/-->
   <div class="clears"></div>
  </div><!--ding-gou/-->
 </div><!--mid-->
 <div class="navBox navBg3">
  <ul class="nav">
   <li><a href="index.html">首页</a></li>
   <li><a href="buy.html">买家</a></li>
   <li><a href="sell.html">卖家</a></li>
   <li><a href="${contextPath}/vipinfo">会员中心</a></li>
   <li><a href="xuanshang.html">悬赏榜</a></li>
   <li><a href="luntan.html" class="luntan">论坛</a></li>
   <li class="navCur"><a href="help.html">帮助</a></li>
   <div class="clears"></div>
  </ul><!--nav/-->
 </div><!--navBox/-->
 <form action="${contextPath}/success" method="post" id="Immediate-settlement">
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
 <div class="car">
  <div class="cont">
   <div class="carImg"><img src="${contextPath}/assets/images/car1.jpg" width="951" height="27" /></div>
   <h4 class="orderTitle">收货地址</h4>
   <table class="ord">
   <c:forEach items="${address}" var="location">
    <tr>
     <td width="30%">
      <input type="radio" name="addressId" value="${location.id}"/>  ${location.addressee} 
     </td>
     <td width="50%">
    ${location.zone},${location.address},${location.code},${location.mobilephone}
     </td>
     <td>
      <span class="green upd">[修改]</span> | <span class="green add">[添加]</span> 
     </td>
    </tr>
    </c:forEach>
   </table><!--ord/-->
   <div class="address">
    <div class="addList">
     <label><span class="red">* </span>选择地区:</label>
     <select>
      <option>请选择省</option>
     </select>
     <select>
      <option>请选择市</option>
     </select>
     <select>
      <option>请选择地区</option>
     </select>
    </div><!--addList-->
    <div class="addList">
     <label><span class="red">* </span>详细地址:</label>
     <input type="text" />
    </div><!--addList-->
    <div class="addList">
     <label><span class="red">* </span>邮政编码:</label>
     <input type="text" />
    </div><!--addList-->
    <div class="addList">
     <label><span class="red">* </span>收件人:</label>
     <input type="text" />
    </div><!--addList-->
    <div class="addList">
     <label><span class="red">* </span>手机号码:</label>
     <input type="text" /> 或者固定电话 <input type="text" />
    </div><!--addList--> 
    <div class="addList2">
     <input type="image" src="${contextPath}/assets/images/queren.jpg" width="100" height="32" />
    </div><!--addList2/-->
   </div><!--address/-->
   <table class="orderList">
    <tr>
     <th width="20"> <input type="checkbox" name="checkall" onclick="checkAll(checkall)"/></th>
     <th width="450">商品 </th>
     <th width="130">单价</th>
     <th width="130">数量</th>
     <th width="130">总金额</th>
     <th width="105">操作</th>
    </tr>
    
    <c:forEach items="${cars}" var="car">
    <tr class="car${car.id}" name="car">
    
     <td colspan="5" style="text-align:left;color:#930; font-weight:bold;">
      <img src="images/dianpu.gif" width="20" height="15" style="position:relative;top:2px;" />
                       店铺：unique VIP店铺 上海分店
     </td>
    </tr>
    <tr class="car${car.id}" name="car">
     <td><input type="checkbox"  value="${car.commoditys.id}" name="proId"/></td>
     <td>
      <dl>
       <dt><a href="proinfo.html"><img src="${contextPath}/assets/images/phone.png" width="85" height="85" /></a></dt>
       <dd>${car.commoditys.title}<br /><span class="red">有货：</span>从上海出发</dd>
       <div class="clears"></div>
      </dl>
     </td>
     <td><strong class="red">￥${car.commoditys.price}</strong></td>
     <td>
     <div class="jia_jian">
      <img src="${contextPath}/assets/images/jian.jpg" width="21" height="25" class="jian" name="${car.id}" />
      <input type="text" class="shuliang" value="${car.goodscount}" name="goodscount" aa="${car.id}"/>
      <img src="${contextPath}/assets/images/jia.jpg" width="21" height="25" class="jia" name="${car.id}"/>
     </div>
     </td>
     <td><strong class="red" name="${car.id}">￥${car.commoditys.price * car.goodscount}</strong></td>
     
     <td>
     <a href="#" class="green" >收藏</a>
     <br />
     <a href="#" class="green" name="${car.id}">删除</a></td>
    
    </tr>
    <c:set var="countMoney" value="${countMoney+ car.commoditys.price * car.goodscount}"></c:set>
    <tr>
    </c:forEach>
    <tr>
     <td colspan="6"><div class="shanchu"><img src="${contextPath}/assets/images/lajio.jpg" /> 全部删除</div></td>
    </tr>
    
   </table><!--orderList/-->
   <div class="zongji">
    <strong>所需运费：</strong>￥0.00 &nbsp;&nbsp;
    <strong>总计(不含运费)：</strong><strong class="red" name="all">￥${countMoney}</strong>
   </div><!--zongji/-->
   <div class="jiesuan">
    <a href="${contextPath}/index" class="jie_1">继续购物&gt;&gt;</a>
    <input type="submit" value="立即结算&gt;&gt;" class="jie_2" id="Immediate-settlement"/>
    <div class="clears"></div>
   </div><!--jiesuan/-->
   <div class="clears"></div>
  </div><!--cont/-->
 </div><!--car/-->
 </form>
 <div class="footBox">
  <div class="footers">
   <div class="footersLeft">
    <a href="index.html"><img src="${contextPath}/assets/images/ftlogo.jpg" width="240" height="64" /></a>
    <h3 class="ftphone">400 000 0000 </h3>
    <div class="ftKe">
     客服 7x24小时(全年无休)<br />
     <span>客服邮箱：kefu@webqin.net </span>
    </div><!--ftKe/-->
   </div><!--footersLeft/-->
   <div class="footersRight">
    <ul>
     <li class="ftTitle">新手指南</li>
     <li><a href="#">购物流程</a></li>
     <li><a href="#">会员计划及划分</a></li>
     <li><a href="#">优惠券规则</a></li>
     <li><a href="#">联系客服</a></li>
     <li><a href="#">常见问题</a></li>
    </ul>
    <ul>
     <li class="ftTitle">付款方式</li>
     <li><a href="#">在线支付</a></li>
     <li><a href="#">礼品卡支付</a></li>
     <li><a href="#">货到付款</a></li>
     <li><a href="#">银行付款</a></li>
    </ul>
    <ul>
     <li class="ftTitle">配送服务</li>
     <li><a href="#">配送时效及运费</a></li>
     <li><a href="#">超时赔付</a></li>
     <li><a href="#">验货与签收</a></li>
     <li><a href="#">配货信息跟踪</a></li>
    </ul>
    <ul>
     <li class="ftTitle">售后服务</li>
     <li><a href="#">退换货政策</a></li>
     <li><a href="#">退换货区域</a></li>
     <li><a href="#">退款时限</a></li>
     <li><a href="#">先行赔付</a></li>
     <li><a href="#">发票说明</a></li>
    </ul>
    <ul>
     <li class="ftTitle">特色服务</li>
     <li><a href="#">礼品卡</a></li>
     <li><a href="#">产品试用</a></li>
     <li><a href="#">花粉中心</a></li>
     <li><a href="#">快速购物</a></li>
     <li><a href="#">推荐好友</a></li>
    </ul>
    
    <div class="clears"></div>
   </div><!--footersRight/-->
   <div class="clears"></div>
  </div><!--footers/-->
 </div><!--footBox/-->
 <div class="footer" style="text-align:left;">
  <a href="#">关于我们</a>
  <a href="#">友情链接</a>
  <a href="#">版权声明</a>
  <a href="#">网站地图</a>
  <br />
  <span>&copy; 2014 Unqezi 使用前必读 沪ICP备 12007626号-1</span>
 </div><!--footer/-->
 <script type="text/javascript">  
         function checkAll(checkall) {    
             arr = document.getElementsByName('proId');   
             if (checkall.checked == true) {   
                 for(i=0;i<arr.length;i++){   
                       
                     arr[i].checked = true;   
                 }  
   
                 }else{  
                     for(i=0;i<arr.length;i++){   
                         if((arr[i]).checked==false){  
                             arr[i].checked = true;  
                        }else  
                         {arr[i].checked = false; }  
                     }  
                 }  
     }    
  </script>
</body>
</html>