package com.example.pharmacy.models;

import com.google.gson.Gson;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Rating implements Objects {
	private Integer rating_id;
	private Integer rate_number;
	private Integer user_id;
	private Integer product_id;
	private String rate_date;
	private String [] strings= {"rating_id","rate_number","user_id","product_id","rate_date"};
	@Override
	public ArrayList getValues() {
		ArrayList list=new ArrayList();
		list.add(rating_id);
		list.add(rate_number);
		list.add(user_id);
		list.add(product_id);
		list.add(rate_date);
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
	ArrayList ratings=new ArrayList();
	while (resultSet.next()) {
		Rating rating=new Rating();
		rating.setRating_id(resultSet.getInt(strings[0]));
		rating.setRate_number(resultSet.getInt(strings[1]));
		rating.setUser(resultSet.getInt(strings[2]));
		rating.setProduct(resultSet.getInt(strings[3]));
		rating.setRate_date(resultSet.getString(strings[4]));
		ratings.add(rating);
	}
	return ratings;
	}
	public int getRating_id() {
		return rating_id;
	}
	public void setRating_id(int rating_id) {
		this.rating_id = rating_id;
	}
	public int getRate_number() {
		return rate_number;
	}
	public void setRate_number(int rate_number) {
		this.rate_number = rate_number;
	}
	public int getUser() {
		return user_id;
	}
	public void setUser(int user) {
		this.user_id = user;
	}
	public int getProduct() {
		return product_id;
	}
	public void setProduct(int product_id) {
		this.product_id = product_id;
	}
	public String getRate_date() {
		return rate_date;
	}
	public void setRate_date(String rate_date) {
		this.rate_date = rate_date;
	}
	
	
}
