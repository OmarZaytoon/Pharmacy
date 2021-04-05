package com.example.pharmacy.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.annotations.Since;

public class User implements Objects {
	private Integer user_id;
	private String username;
	private String password;
	private String register_date;
	private String user_profile_picture;
	private boolean haveAcart;
	@Since(1.0)
	private String email;
	private String phone_number;
	ArrayList<Store> favShops;
	private String [] strings= {"user_id","username","password","register_date","user_profile_picture","email","phone_number"};
	@Override
	public ArrayList getValues() {
		ArrayList list=new ArrayList();
		list.add(user_id);
		list.add(username);
		list.add(password);
		list.add(register_date);
		list.add(user_profile_picture);
		list.add(email);
		list.add(phone_number);
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
		ArrayList users=new ArrayList();
		while(resultSet.next()) {
			User user=new User();
			user.setUser_id(resultSet.getInt(strings[0]));
			user.setUsername(resultSet.getString(strings[1]));
			user.setPassword(resultSet.getString(strings[2]));
			user.setRegister_date(resultSet.getString(strings[3]));
			user.setUser_profile_picture(resultSet.getString(strings[4]));
			user.setEmail(resultSet.getString(strings[5]));
			user.setPhone_number(resultSet.getString(strings[6]));
			users.add(user);
		}
		return users;
	}
	
	
	public ArrayList<Store> getFavShops() {
		return favShops;
	}
	public void setFavShops(ArrayList<Store> favShops) {
		this.favShops = favShops;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegister_date() {
		return register_date;
	}
	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}
	public String getUser_profile_picture() {
		return user_profile_picture;
	}
	public void setUser_profile_picture(String user_profile_picture) {
		this.user_profile_picture = user_profile_picture;
	}

	public boolean HaveAcart() {
		return haveAcart;
	}

	public void setHaveAcart(boolean haveAcart) {
		this.haveAcart = haveAcart;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	

}
