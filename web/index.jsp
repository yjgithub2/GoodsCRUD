<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/10/14
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
<%--  <body>
  <a href="${pageContext.request.contextPath}/selectAll">查询所有商品信息</a>
  </body>--%>
<frameset rows="20%,*">
   <%--标题--%>
  <frame src="top.jsp">
   <frameset cols="20%,*">
      <%--左侧导航--%>
      <frame src="left.jsp">
      <%--右侧内容显示区域--%>
      <frame src="main.jsp" name="main">
   </frameset>

</frameset>
</html>
