package dao;

import entity.Goods;
import util.PageBean;

import java.sql.SQLException;
import java.util.List;

public interface GoodsDao {
  //查询所有
  public List<Goods> selectAllGoods() throws SQLException;
  //查询所有，分页
  public List<Goods> selectAllGoods(PageBean pageBean) throws SQLException;
  //添加商品
  public void addGoods(Goods goods) throws SQLException;
  //删除
  public void deleteGoods(Integer id) throws SQLException;
  //修改：首先查询一条
  public Goods selectOne(Integer id) throws SQLException;
  //执行修改
  public void updateGoods(Goods goods) throws SQLException;
  //获取总条数
  /*public long totalCount() throws SQLException;*/
  //获取条件查询的总条数
  public long totalCount(PageBean pageBean) throws SQLException;
}
