package servlet;

import service.GoodsService;
import service.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteGoods extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //获取id
    String id = req.getParameter("id");
    //创建service
    GoodsService goodsService=new GoodsServiceImpl();
     try {
      goodsService.deleteGoods(Integer.parseInt(id));
     } catch (SQLException e) {
      e.printStackTrace();
     }
     //重定向
     resp.sendRedirect(req.getContextPath()+"/selectAll");
 }
}
