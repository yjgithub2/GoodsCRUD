<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/10/14
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/updateSave" method="get">
    商品名称：<input type="text" name="name" value="${goods.name}"><br/><br/>
    品牌：<input type="text" name="brand" value="${goods.brand}"><br/><br/>
    价格：<input type="text" name="price" value="${goods.price}"><br/><br/>
    数量：<input type="text" name="num" value="${goods.num}"><br/><br/>
    <input type="hidden" name="id" value="${goods.id}">
    <input type="submit" value="修改">

</form>
</body>
</html>
