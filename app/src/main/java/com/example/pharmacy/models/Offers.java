package com.example.pharmacy.models;

import com.google.gson.Gson;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Offers implements Objects {
private Integer offer_id;
private ArrayList<Product> products;
private Float discount_value;
private String start_date;
private String end_date;
private int offer_status;
private int id_store;
private String store_name;
private String strings[]= {"offer_id","discount_value","start_date","end_date","offer_status"};
@Override
public String[] getStrings() {
	// TODO Auto-generated method stub
	return strings;
}
@Override
public ArrayList getDataFromResultSet(ResultSet resultSet) throws SQLException {
	ArrayList list=new ArrayList();
	while(resultSet.next()) {
		Offers offers=new Offers();
		offers.setOffer_id(resultSet.getInt(strings[0]));
		offers.setDiscount_value(resultSet.getFloat(strings[1]));
		offers.setStart_date(resultSet.getString(strings[2]));
		offers.setEnd_date(resultSet.getString(strings[3]));
		offers.setOffer_status(resultSet.getInt(strings[4]));
		list.add(offers);
	}
	return list;
}
@Override
public ArrayList getValues() {
	// TODO Auto-generated method stub
	ArrayList list=new ArrayList();
	list.add(offer_id);
	list.add(discount_value);
	list.add(start_date);
	list.add(end_date);
	list.add(offer_status);
	return list;
}
@Override
public String switchToGson() {
	// TODO Auto-generated method stub
	return new Gson().toJson(this);
}
@Override
public Objects getFromGson(String data) {
	// TODO Auto-generated method stub
	return new Gson().fromJson(data, this.getClass());
}
public Integer getOffer_id() {
	return offer_id;
}
public void setOffer_id(Integer offer_id) {
	this.offer_id = offer_id;
}
public ArrayList<Product> getProducts() {
	return products;
}
public void setProducts(ArrayList<Product> products) {
	this.products = products;
}
public Float getDiscount_value() {
	return discount_value;
}
public void setDiscount_value(Float discount_value) {
	this.discount_value = discount_value;
}
public String getStart_date() {
	return start_date;
}
public void setStart_date(String start_date) {
	this.start_date = start_date;
}
public String getEnd_date() {
	return end_date;
}
public void setEnd_date(String end_date) {
	this.end_date = end_date;
}
public int getOffer_status() {
	return offer_status;
}
public void setOffer_status(int offer_status) {
	this.offer_status = offer_status;
}
public int getId_store() {
	return id_store;
}
public void setId_store(int id_store) {
	this.id_store = id_store;
}
public String getStore_name() {
	return store_name;
}
public void setStore_name(String store_name) {
	this.store_name = store_name;
}


}
