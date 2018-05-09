<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>unique</title>
<link type="text/css" href="${contextPath}/assets/css/css.css" rel="stylesheet" />
<script type="text/javascript" src="${contextPath}/assets/js/jquery.js"></script>
<script type="text/javascript" src="${contextPath}/assets/js/js.js"></script>
</head>

<body>

<c:if test="${param.error!=null }">
<h4 style="color:red;">登录失败，账号或密码错误</h4>
</c:if>
 <div class="hrader" id="header">
  <a href="login.jsp" style="color:#FD7306;margin-left:20px;">请登录</a> 
  <a href="reg.jsp">注册</a>
  <div class="topNav">
   <a href="index.jsp" style="color:#FD7306;">首页</a>
   <a href="buy.jsp">买家</a>
   <a href="sell.jsp">卖家</a>
   <a href="vip.jsp">会员中心</a>
   <a href="xuanshang.jsp">悬赏榜</a>
   <a href="luntan.jsp" class="luntan">论坛</a>
   <a href="help.jsp">帮助</a>
   <a href="#">&nbsp;</a>
   <a href="#" class="lan">中文</a>
   <a href="#" class="lan">English</a>
  </div><!--topNav/-->
 </div><!--hrader/-->
 <div class="mainCont">
  <h1 class="logo" style="text-align:left;">
  <a href="index.jsp"><img src="${contextPath}/assets/images/logo.png" width="304" height="74" /></a>
  </h1>
  <div class="loginBox">
   <div class="loginLeft">
    <img src="${contextPath}/assets/images/login.jpg" width="567" height="348" />
   </div><!--loginLeft/-->
   <div class="loginRight">
    <form class="login" action="${contextPath}/login" method="POST">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
     <label>邮箱/用户名/已验证手机</label>
     <input type="text" class="username" id ="username" name="username"/>
     <label>密码</label>
     <input type="password" class="password" id="password" name="password" />
     <div class="jizhu">
      <input type="checkbox" id="remember-me" name="remember-me"/> 一周内免登陆 <a href="#">忘记密码</a>
     </div><!--jizhu/-->
     <div class="loginSub">
      <input type="submit" value=" 登 录 " />
     </div><!--loginSub/-->
     <h2>合作伙伴登录：</h2>
     <img src="${contextPath}/assets/images/hezuo.jpg" width="260" height="30" />
    </form><!--login/-->
   </div><!--loginRight/-->
   <div class="clears"></div>
  </div><!--loginBox/-->
 </div><!--mainCont/-->
 <div class="footBox">
  <div class="footers">
   <div class="footersLeft">
    <a href="index.jsp"><img src="${contextPath}/assets/images/ftlogo.jpg" width="240" height="64" /></a>
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
</body>
</html>