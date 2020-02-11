package entity;

public class Goods {
   private Integer id;  //商品编号
   private String name; //商品名称
   private String brand;//品牌
   private Integer price;//价格
   private Integer num;  //数量

 public Goods() {
 }

 public Goods(Integer id, String name, String brand, Integer price, Integer num) {
  this.id = id;
  this.name = name;
  this.brand = brand;
  this.price = price;
  this.num = num;
 }

 public Goods(String name, String brand, Integer price, Integer num) {
  this.name = name;
  this.brand = brand;
  this.price = price;
  this.num = num;
 }

 public Integer getId() {
  return id;
 }

 public void setId(Integer id) {
  this.id = id;
 }

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

 public Integer getPrice() {
  return price;
 }

 public void setPrice(Integer price) {
  this.price = price;
 }

 public Integer getNum() {
  return num;
 }

 public void setNum(Integer num) {
  this.num = num;
 }

 @Override
 public String toString() {
  return "Goods{" +
   "id=" + id +
   ", name='" + name + '\'' +
   ", brand='" + brand + '\'' +
   ", price=" + price +
   ", num=" + num +
   '}';
 }
}
