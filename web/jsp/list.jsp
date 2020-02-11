<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/10/14
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询所有页面</title>
</head>
<style type="text/css">
    input{
        width: 100px;
    }
    td{
        width: 80px;
        text-align: center;
    }
</style>
<body>
<div align="center">
<form  id="myForm" action="${pageContext.request.contextPath}/selectAll" method="get">
    商品名称：<input type="text" name="name" value="${pageBean.name}"> <br/><br/>
    商品品牌：<input type="text" name="brand" value="${pageBean.brand}"> <br/><br/>
    价格：<input type="text" name="priceFrom" value="${pageBean.priceFrom}">--
        <input type="text" name="priceTo" value="${pageBean.priceTo}"><br/><br/>
    数量：<input type="text" name="numFrom" value="${pageBean.numFrom}">--
        <input type="text" name="numTo" value="${pageBean.numTo}"><br/><br/>
     <input id="pi" type="hidden" name="pageIndex" value="${pageBean.pageIndex}">
    <input type="submit" value="搜索"><br/><br/>
</form>
</div>
    <table align="center" border="1px" >
        <tr>
            <th colspan="6" align="center">
                商品信息表
            </th>
        </tr>
        <tr>
            <td>商品编号</td>
            <td>商品名称</td>
            <td>品牌</td>
            <td>价格</td>
            <td>商品数量</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${goodsList}" var="g">
            <tr>
                <td>${g.id}</td>
                <td>${g.name}</td>
                <td>${g.brand}</td>
                <td>${g.price}</td>
                <td>${g.num}</td>
                <td><a href="${pageContext.request.contextPath}/updateEdit?id=${g.id}">修改</a>||<a href="${pageContext.request.contextPath}/deleteGoods?id=${g.id}">删除</a></td>
            </tr>
        </c:forEach>

   <%--<tr>
       <td colspan="6" align="center">
       <a href="${pageContext.request.contextPath}/selectAll?pageIndex=1">首页</a>
       <a href="${pageContext.request.contextPath}/selectAll?pageIndex=${pageBean.pageIndex>1?pageBean.pageIndex-1:1}">上一页</a>
       <a href="${pageContext.request.contextPath}/selectAll?pageIndex=${pageBean.pageIndex<pageBean.totalPage?pageBean.pageIndex+1:pageBean.pageIndex}">下一页</a>
       <a href="${pageContext.request.contextPath}/selectAll?pageIndex=${pageBean.totalPage}">尾页</a>
       第${pageBean.pageIndex}页/共${pageBean.totalPage}页
       </td>
   </tr>--%>
    <tr>
        <td colspan="6" align="center">
            <a href="javascript:homePage();">首页</a>
            <a href="javascript:upPage();">上一页</a>
            <a href="javascript:downPage();">下一页</a>
            <a href="javascript:endPage();">尾页</a>
            第${pageBean.pageIndex}页/共${pageBean.totalPage}页
        </td>
    </tr>
    </table>
</body>
    <script type="text/javascript">
        <%--首页--%>
        function homePage() {
            var pi = document.getElementById("pi");
            pi.value="1";
            var myForm = document.getElementById("myForm");
            myForm.submit()
        }
        <%--上一页--%>
        function upPage() {
            var pi = document.getElementById("pi");
            pi.value=${pageBean.pageIndex>1?pageBean.pageIndex-1:1};
            var myForm = document.getElementById("myForm");
            myForm.submit();
        }
        <%--下一页--%>
        function downPage() {
            var pi = document.getElementById("pi");
            pi.value=${pageBean.pageIndex<pageBean.totalPage?pageBean.pageIndex+1:pageBean.pageIndex};
            var myForm = document.getElementById("myForm");
            myForm.submit()
        }
        <%--尾页--%>
        function endPage() {
            var pi = document.getElementById("pi");
            pi.value=${pageBean.totalPage};
            var myForm = document.getElementById("myForm");
            myForm.submit()
        }
    </script>
</html>
