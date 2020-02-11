<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/10/14
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addGoods" >
    商品名称：<input type="text" name="name"><br/><br/>
    品牌：<input type="text" name="brand"><br/><br/>
    价格：<input type="text" name="price"><br/><br/>
    数量：<input type="text" name="num"><br/><br/>
    <input type="submit" value="添加">
</form>
</body>
</html>
