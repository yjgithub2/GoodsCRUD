<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/10/16
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>左侧导航</title>
</head>
<body>
   <table align="center">
       <tr>
       <td>
            <a href="${pageContext.request.contextPath}/selectAll" target="main">所有商品</a>
       </td>
       </tr>
       <tr>
       <td>
            <a href="jsp/add.jsp" target="main">添加商品</a>
       </td>
       </tr>
   </table>
</body>
</html>
