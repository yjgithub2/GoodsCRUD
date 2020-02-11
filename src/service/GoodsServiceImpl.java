package service;

import dao.GoodsDao;
import dao.GoodsDaoImpl;
import entity.Goods;
import util.PageBean;

import java.sql.SQLException;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {
   GoodsDao goodsDao=new GoodsDaoImpl();
   //查询所有
   @Override
   public List<Goods> selectAllGoods() throws SQLException {
    return goodsDao.selectAllGoods();
   }

 @Override
 public List<Goods> selectAllGoods(PageBean pageBean) throws SQLException {
     //获取总条数
     long l = goodsDao.totalCount(pageBean);
     int totalCount=(int)l;
    //总页数= (总条数%每页条数)==0?(总条数/每页条数):(总条数/每页条数+1)
     int pageSize=pageBean.getPageSize();
     int pageTotal=(totalCount%pageSize==0)?totalCount/pageSize:(totalCount/pageSize+1);
     //将获取到的分页要素放入pageBean
     pageBean.setTotalCount(totalCount);
     pageBean.setTotalPage(pageTotal);

     System.out.println("totalCount=" +totalCount);
     System.out.println("pageTotal = " + pageTotal);
     //调用dao查询所有
     return goodsDao.selectAllGoods(pageBean);
 }

 //添加
   @Override
   public void addGoods(Goods goods) throws SQLException {
      goodsDao.addGoods(goods);
   }
  //删除
   @Override
   public void deleteGoods(Integer id) throws SQLException {
      goodsDao.deleteGoods(id);
   }
 //查询一条
   @Override
   public Goods selectOne(Integer id) throws SQLException {
      return goodsDao.selectOne(id);
   }
//修改保存
   @Override
   public void updateGoods(Goods goods) throws SQLException {
         goodsDao.updateGoods(goods);
   }
}
