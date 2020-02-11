package dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import entity.Goods;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.PageBean;

import java.sql.SQLException;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
   QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
  //查询所有
   @Override
 public List<Goods> selectAllGoods() throws SQLException {
   String sql="select * from goods";
    return qr.query(sql,new BeanListHandler<Goods>(Goods.class));
 }
//查询所有，分页
 @Override
 public List<Goods> selectAllGoods(PageBean pageBean) throws SQLException {
    String sql="select * from goods where 1=1 "; //sql中where添加一个永远正确的判定
    //查询名称
    if (pageBean.getName()!=null&&!"".equals(pageBean.getName().trim())){
     sql+=" and name like '%"+pageBean.getName()+"%' ";
    }
    //查询品牌
  if (pageBean.getBrand()!=null&&!"".equals(pageBean.getBrand().trim())){
   sql+="  and brand like '%"+pageBean.getBrand()+"%' ";
  }
   //查询价格：起始价格
   if (pageBean.getPriceFrom()!=null&&!"".equals(pageBean.getPriceFrom().trim())){
    sql+=" and price >= "+pageBean.getPriceFrom();
   }
  //查询价格：最高价格
  if (pageBean.getPriceTo()!=null&&!"".equals(pageBean.getPriceTo().trim())){
   sql+=" and price <= "+pageBean.getPriceTo();
  }
  //查询数量：最少数量
  if (pageBean.getNumFrom()!=null&&!"".equals(pageBean.getNumFrom().trim())){
   sql+=" and num >= "+pageBean.getNumFrom();
  }
  //查询数量：最大数量
  if (pageBean.getNumTo()!=null&&!"".equals(pageBean.getNumTo().trim())){
   sql+=" and num <= "+pageBean.getNumTo();
  }
     sql+=" limit ?,?";
    System.out.println(sql);
    //需要给两个参数：起始条的数据（下标），每页条数
    //当前页起始下标=（当前页page-1）*每页条数
    int pageSize=pageBean.getPageSize();  //每页条数
    int start=(pageBean.getPageIndex()-1)*pageSize; //起始下标
    return qr.query(sql,new BeanListHandler<Goods>(Goods.class),start,pageSize);

 }

 @Override
 public void addGoods(Goods goods) throws SQLException {
   String sql="insert into goods (name,brand,price,num) values(?,?,?,?)";
   qr.insert(sql,new BeanHandler<Goods>(Goods.class),
    goods.getName(),goods.getBrand(),goods.getPrice(),goods.getNum());
 }

 @Override
 public void deleteGoods(Integer id) throws SQLException {
    String sql="delete from goods where id=?";
    qr.update(sql,id);
 }
//查询一条
 @Override
 public Goods selectOne(Integer id) throws SQLException {
    String sql="select * from goods where id=?";
    return qr.query(sql,new BeanHandler<Goods>(Goods.class),id);

 }
//执行修改
 @Override
 public void updateGoods(Goods goods) throws SQLException {
   String sql="update goods set name=?,brand=?,price=?,num=? where id=?";
   qr.update(sql,goods.getName(),goods.getBrand(),goods.getPrice(),goods.getNum(),goods.getId());
 }
 /*//获得总条数
  @Override
  public long totalCount() throws SQLException {
     String sql="SELECT COUNT(*) FROM goods";
     return qr.query(sql,new ScalarHandler<Long>());
  }*/
//获取条件查询的总条数
 @Override
 public long totalCount(PageBean pageBean) throws SQLException {
  String sql="select count(*) from goods where 1=1 "; //sql中where添加一个永远正确的判定
  //查询名称
  if (pageBean.getName()!=null&&!"".equals(pageBean.getName().trim())){
   sql+=" and name like '%"+pageBean.getName()+"%' ";
  }
  //查询品牌
  if (pageBean.getBrand()!=null&&!"".equals(pageBean.getBrand().trim())){
   sql+="  and brand like '%"+pageBean.getBrand()+"%' ";
  }
  //查询价格：起始价格
  if (pageBean.getPriceFrom()!=null&&!"".equals(pageBean.getPriceFrom().trim())){
   sql+=" and price >= "+pageBean.getPriceFrom();
  }
  //查询价格：最高价格
  if (pageBean.getPriceTo()!=null&&!"".equals(pageBean.getPriceTo().trim())){
   sql+=" and price <= "+pageBean.getPriceTo();
  }
  //查询数量：最少数量
  if (pageBean.getNumFrom()!=null&&!"".equals(pageBean.getNumFrom().trim())){
   sql+=" and num >= "+pageBean.getNumFrom();
  }
  //查询数量：最大数量
  if (pageBean.getNumTo()!=null&&!"".equals(pageBean.getNumTo().trim())){
   sql+=" and num <= "+pageBean.getNumTo();
  }

  return qr.query(sql,new ScalarHandler<Long>());
 }
}
