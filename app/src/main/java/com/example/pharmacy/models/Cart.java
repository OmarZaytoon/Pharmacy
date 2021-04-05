package com.example.pharmacy.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Cart implements Objects{
private Integer cart_id;
private String added_date;
private Integer user_id;
private User user;
private String username;
private ArrayList<Product>products;
private Double latitude;
private Double longitude;
private Integer status;
private Integer way_of_payment_id;
private String[]stringsJoined= {"cart_id","added_date","user_id","username","latitude","longitude","status","way_of_payment_id"};
private String[]strings= {"cart_id","added_date","user_id","latitude","longitude","status","way_of_payment_id"};
@Override
public ArrayList getValues() {
	ArrayList list=new ArrayList();
	list.add(cart_id);
	list.add(added_date);
	list.add(user_id);
	list.add(latitude);
	list.add(longitude);
	list.add(status);
	list.add(way_of_payment_id);
	return list;
}
@Override
public ArrayList<Cart> getDataFromResultSet(ResultSet resultSet) throws SQLException{
ArrayList<Cart> carts=new ArrayList<Cart>();
while(resultSet.next()) {
	Cart cart=new Cart();
	cart.setCart_id(resultSet.getInt(strings[0]));
	cart.setAdded_date(resultSet.getString(strings[1]));
	cart.setUserid(resultSet.getInt(strings[2]));
	cart.setLatitude(resultSet.getDouble(strings[3]));
	cart.setLongitude(resultSet.getDouble(strings[4]));
	cart.setStatus(resultSet.getInt(strings[5]));
	cart.setWay_of_payment_id(resultSet.getInt("way_of_payment_id"));
	carts.add(cart);
}
return carts;
}
@Override
public String[] getStrings() {
	return strings;
}

@Override
public String switchToGson() {
	return new Gson().toJson(this);
}
@Override
public Objects getFromGson(String data) {
	return new Gson().fromJson(data, this.getClass());
}
public ArrayList getValuesJoined() {
	ArrayList list=new ArrayList();
	list.add(cart_id);
	list.add(added_date);
	list.add(user_id);
	list.add(username);
	list.add(latitude);
	list.add(longitude);
	list.add(status);
	list.add("way_of_payment_id");
	return list;
}
public ArrayList<Cart> getDataFromResultSetJoined(ResultSet resultSet) throws SQLException{
ArrayList<Cart> carts=new ArrayList<Cart>();
while(resultSet.next()) {
	Cart cart=new Cart();
	cart.setCart_id(resultSet.getInt(stringsJoined[0]));
	cart.setAdded_date(resultSet.getString(stringsJoined[1]));
	cart.setUserid(resultSet.getInt(stringsJoined[2]));
	cart.setUsername(resultSet.getString(stringsJoined[3]));
	cart.setLatitude(resultSet.getDouble(stringsJoined[4]));
	cart.setLongitude(resultSet.getDouble(stringsJoined[5]));
	cart.setStatus(resultSet.getInt(stringsJoined[6]));
	cart.setWay_of_payment_id(resultSet.getInt("way_of_payment_id"));
	carts.add(cart);
}
return carts;
}

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Integer getWay_of_payment_id() {
	return way_of_payment_id;
}
public void setWay_of_payment_id(Integer way_of_payment_id) {
	this.way_of_payment_id = way_of_payment_id;
}
public void setCart_id(Integer cart_id) {
	this.cart_id = cart_id;
}
public void setUserid(Integer userid) {
	this.user_id = userid;
}
public void setLatitude(Double latitude) {
	this.latitude = latitude;
}
public void setLongitude(Double longitude) {
	this.longitude = longitude;
}
public void setStatus(Integer status) {
	this.status = status;
}
public ArrayList<Product> getProducts() {
	return products;
}
public void setProducts(ArrayList<Product> products) {
	this.products = products;
}
public int getCart_id() {
	return cart_id;
}
public void setCart_id(int cart_id) {
	this.cart_id = cart_id;
}
public String getAdded_date() {
	return added_date;
}
public void setAdded_date(String added_date) {
	this.added_date = added_date;
}
public int getUserid() {
	return user_id;
}
public void setUserid(int userid) {
	this.user_id = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public double getLatitude() {
	return latitude;
}
public void setLatitude(double latitude) {
	this.latitude = latitude;
}
public double getLongitude() {
	return longitude;
}
public void setLongitude(double longitude) {
	this.longitude = longitude;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}

}
