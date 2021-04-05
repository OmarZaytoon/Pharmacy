package com.example.pharmacy.models;

import com.google.gson.Gson;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Product implements Objects {
	private Integer product_id;
	private String product_name;
	private String product_desc;
	private Double product_price;
	private String adding_date;
	private Integer category;
	private String categoryname;
	private String tags;
	private Integer store;
	private String store_name;
	private String store_logo;
	private Double store_latitude;
	private Double store_longitude;
	private Double total_rate;
	private String product_image;
	private String[] stringsJoin= {"product_id","product_name","product_desc",
			"product_price","adding_date","category","category_name",
			"tags","store","store_name","store_logo","latitude","longitude",
			"count_rate","total_rate","product_image"};
	private String[] strings= {"product_id","product_name","product_desc",
			"product_price","adding_date","category",
			"tags","store","count_rate","total_rate","product_image"};
	@Override
	public ArrayList getValues() {
		ArrayList list=new ArrayList();
		list.add(product_id);
		list.add(product_name);
		list.add(product_desc);
		list.add(product_price);
		list.add(adding_date);
		list.add(category);
		list.add(tags);
		list.add(store);
		list.add(total_rate);
		list.add(product_image);
		return list;
	}
	@Override
	public String switchToGson() {
		return new Gson().toJson(this);
	}
	@Override
	public Objects getFromGson(String data) {
		return new Gson().fromJson(data, this.getClass());
	}
	@Override
	public String[] getStrings() {
	return strings;
	}
	@Override
	public ArrayList getDataFromResultSet(ResultSet resultSet) throws SQLException{
	ArrayList products=new ArrayList();
	while(resultSet.next()) {
		Product product=new Product();
		product.setProduct_id(resultSet.getInt(strings[0]));
		product.setProduct_name(resultSet.getString(strings[1]));
		product.setProduct_desc(resultSet.getString(strings[2]));
		product.setProduct_price(resultSet.getDouble(strings[3]));
		product.setAdding_date(resultSet.getString(strings[4]));
		product.setCategoryid(resultSet.getInt(strings[5]));
		product.setTags(resultSet.getString(strings[6]));
		product.setStoreid(resultSet.getInt(strings[7]));
		product.setTotal_rate(resultSet.getDouble(strings [9]));
		product.setProduct_image(resultSet.getString(strings[10]));
		products.add(product);
	}
	return products;
	}
	public ArrayList getValuesJoined() {
		ArrayList list=new ArrayList();
		list.add(product_id);
		list.add(product_name);
		list.add(product_desc);
		list.add(product_price);
		list.add(adding_date);
		list.add(category);
		list.add(categoryname);
		list.add(tags);
		list.add(store);
		list.add(store_name);
		list.add(store_logo);
		list.add(store_latitude);
		list.add(store_longitude);
		list.add(total_rate);
		list.add(product_image);
		return list;
	}
	public ArrayList getDataFromResultSetJoined(ResultSet resultSet) throws SQLException{
		ArrayList products=new ArrayList();
		while(resultSet.next()) {
			Product product=new Product();
			product.setProduct_id(resultSet.getInt(stringsJoin[0]));
			product.setProduct_name(resultSet.getString(stringsJoin[1]));
			product.setProduct_desc(resultSet.getString(stringsJoin[2]));
			product.setProduct_price(resultSet.getDouble(stringsJoin[3]));
			product.setAdding_date(resultSet.getString(stringsJoin[4]));
			product.setCategoryid(resultSet.getInt(stringsJoin[5]));
			product.setCategoryname(resultSet.getString(stringsJoin[6]));
			product.setTags(resultSet.getString(stringsJoin[7]));
			product.setStoreid(resultSet.getInt(stringsJoin[8]));
			product.setStore_name(resultSet.getString(stringsJoin[9]));
			product.setStore_logo(resultSet.getString(stringsJoin[10]));
			product.setStore_latitude(resultSet.getDouble(stringsJoin[11]));
			product.setStore_longitude(resultSet.getDouble(stringsJoin[12]));
			product.setTotal_rate(resultSet.getDouble(stringsJoin [14]));
			product.setProduct_image(resultSet.getString(stringsJoin[15]));
			products.add(product);
		}
		return products;
		}
		
	public String[] getJoinStrings() {
		return stringsJoin;
	}
	
	public Integer getCategory_id() {
		return category;
	}
	public void setCategory_id(Integer category_id) {
		this.category = category_id;
	}
	public Integer getStore_id() {
		return store;
	}
	public void setStore_id(Integer store_id) {
		this.store = store_id;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public void setProduct_price(Double product_price) {
		this.product_price = product_price;
	}
	public void setStore_latitude(Double store_latitude) {
		this.store_latitude = store_latitude;
	}
	public void setStore_longitude(Double store_longitude) {
		this.store_longitude = store_longitude;
	}
	
	public void setTotal_rate(Double total_rate) {
		this.total_rate = total_rate;
	}
	public double getTotal_rate() {
		return total_rate;
	}
	public void setTotal_rate(double total_rate) {
		this.total_rate = total_rate;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_desc() {
		return product_desc;
	}
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public String getAdding_date() {
		return adding_date;
	}
	public void setAdding_date(String adding_date) {
		this.adding_date = adding_date;
	}
	public int getCategoryid() {
		return category;
	}
	public void setCategoryid(int category_id) {
		this.category = category_id;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public int getStoreid() {
		return store;
	}
	public void setStoreid(int store_id) {
		this.store = store_id;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getStore_logo() {
		return store_logo;
	}
	public void setStore_logo(String store_logo) {
		this.store_logo = store_logo;
	}
	public double getStore_latitude() {
		return store_latitude;
	}
	public void setStore_latitude(double store_latitude) {
		this.store_latitude = store_latitude;
	}
	public double getStore_longitude() {
		return store_longitude;
	}
	public void setStore_longitude(double store_longitude) {
		this.store_longitude = store_longitude;
	}
	
	
	
	
}
