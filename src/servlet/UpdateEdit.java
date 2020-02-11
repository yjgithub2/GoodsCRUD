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

public class UpdateEdit extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //获取要修改信息的id
  String id = req.getParameter("id");
  //调用service查询一条的方法
  GoodsService goodsService=new GoodsServiceImpl();
  Goods goods=null;
  try {
     goods= goodsService.selectOne(Integer.parseInt(id));
    } catch (SQLException e) {
     e.printStackTrace();
    }
    req.setAttribute("goods",goods);
   //转发:目标页面
    req.getRequestDispatcher("jsp/edit.jsp").forward(req,resp);
 }
}
