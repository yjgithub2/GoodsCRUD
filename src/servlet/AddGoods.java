package servlet;

import entity.Goods;
import service.GoodsService;
import service.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddGoods extends HttpServlet {
 //添加商品
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //获取页面商品信息
    String name = req.getParameter("name");
    String brand = req.getParameter("brand");
    String price = req.getParameter("price");
    String num = req.getParameter("num");

    Goods goods=new Goods(name,brand,Integer.parseInt(price),Integer.parseInt(num));
    //调用service方法实现添加,创建service对象
   GoodsService goodsService=new GoodsServiceImpl();

      try {
       goodsService.addGoods(goods);
      } catch (SQLException e) {
       e.printStackTrace();
      }
    //重定向，页面更新结果
    resp.sendRedirect(req.getContextPath()+"/selectAll");

 }
}
