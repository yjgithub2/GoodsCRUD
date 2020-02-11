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

public class UpdateSave extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //执行修改，获取要修改的数据  ，注意不要忘记id
  String name = req.getParameter("name");
  String brand = req.getParameter("brand");
  String price = req.getParameter("price");
  String num = req.getParameter("num");
  String id = req.getParameter("id");

  Goods goods=new Goods();
  goods.setName(name);
  goods.setBrand(brand);
  goods.setPrice(Integer.parseInt(price));
  goods.setNum(Integer.parseInt(num));
  goods.setId(Integer.parseInt(id));

  //调用service修改方法，
     GoodsService goodsService=new GoodsServiceImpl();
     try {
      goodsService.updateGoods(goods);
     } catch (SQLException e) {
      e.printStackTrace();
     }
     //重定向
     resp.sendRedirect(req.getContextPath()+"/selectAll");

 }
}
