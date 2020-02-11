package servlet;

import entity.Goods;
import service.GoodsService;
import service.GoodsServiceImpl;
import util.PageBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SelectAll extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  GoodsService goodsService=new GoodsServiceImpl();
   List<Goods> list=null;
   //获取条件搜索的（内容）
  String name = req.getParameter("name");
  String brand = req.getParameter("brand");
  String priceFrom = req.getParameter("priceFrom");
  String priceTo = req.getParameter("priceTo");
  String numFrom = req.getParameter("numFrom");
  String numTo = req.getParameter("numTo");
  PageBean pageBean=new PageBean();
  pageBean.setName(name);
  pageBean.setBrand(brand);
  pageBean.setPriceFrom(priceFrom);
  pageBean.setPriceTo(priceTo);
  pageBean.setNumFrom(numFrom);
  pageBean.setNumTo(numTo);
  //获取当前页
  String pageIndex = req.getParameter("pageIndex");
  if (pageIndex==null){
     pageIndex="1";
  }
  pageBean.setPageIndex(Integer.parseInt(pageIndex));
   try {
      list= goodsService.selectAllGoods(pageBean);
     } catch (Exception e) {
      e.printStackTrace();
     }
     //将结果放入域中
   req.setAttribute("goodsList",list);
   req.setAttribute("pageBean",pageBean);
   //转发
   req.getRequestDispatcher("jsp/list.jsp").forward(req,resp);
   }

}
