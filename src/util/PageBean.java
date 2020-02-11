package util;

public class PageBean {
 //分页要素：
 private int pageIndex;     //当前页
 private int pageSize=2;    //每页条数
 private int totalCount;  //总条数
 private int totalPage;   //总页数

 //条件搜索属性
 private String name;     // 商品名称
 private String brand;    //品牌
 private String priceFrom;//起始价格
 private String priceTo;  //最高价格
 private String numFrom;  //最少数量
 private String numTo;    //最大数量

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getBrand() {
  return brand;
 }

 public void setBrand(String brand) {
  this.brand = brand;
 }

 public String getPriceFrom() {
  return priceFrom;
 }

 public void setPriceFrom(String priceFrom) {
  this.priceFrom = priceFrom;
 }

 public String getPriceTo() {
  return priceTo;
 }

 public void setPriceTo(String priceTo) {
  this.priceTo = priceTo;
 }

 public String getNumFrom() {
  return numFrom;
 }

 public void setNumFrom(String numFrom) {
  this.numFrom = numFrom;
 }

 public String getNumTo() {
  return numTo;
 }

 public void setNumTo(String numTo) {
  this.numTo = numTo;
 }

 public PageBean() {
 }

 public PageBean(int pageIndex, int pageSize, int totalCount, int totalPage) {
  this.pageIndex = pageIndex;
  this.pageSize = pageSize;
  this.totalCount = totalCount;
  this.totalPage = totalPage;
 }

 public int getPageIndex() {
  return pageIndex;
 }

 public void setPageIndex(int pageIndex) {
  this.pageIndex = pageIndex;
 }

 public int getPageSize() {
  return pageSize;
 }

 public void setPageSize(int pageSize) {
  this.pageSize = pageSize;
 }

 public int getTotalCount() {
  return totalCount;
 }

 public void setTotalCount(int totalCount) {
  this.totalCount = totalCount;
 }

 public int getTotalPage() {
  return totalPage;
 }

 public void setTotalPage(int totalPage) {
  this.totalPage = totalPage;
 }

 @Override
 public String toString() {
  return "PageBean{" +
   "pageIndex=" + pageIndex +
   ", pageSize=" + pageSize +
   ", totalCount=" + totalCount +
   ", totalPage=" + totalPage +
   '}';
 }
}
