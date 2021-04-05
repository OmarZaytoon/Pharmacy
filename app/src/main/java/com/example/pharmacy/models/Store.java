package com.example.pharmacy.models;

import com.google.gson.Gson;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Store implements Objects {
	private Integer store_id;
	private String store_name;
	private String store_desc;
	private String added_date;
	private Double latitude;
	private Double longitude;
	private Boolean is_active;
	private String store_logo;
	private String store_banner;
	private String[] strings= {"store_id","store_name","store_desc",
			"added_date","latitude","longitude","is_active",
			"store_logo","store_banner"};
	public Store(){}
	public Store(String name){this.store_name=name;}
	@Override
	public ArrayList getValues() {
		ArrayList list=new ArrayList();
		list.add(store_id);
		list.add(store_name);
		list.add(store_desc);
		list.add(added_date);
		list.add(latitude);
		list.add(longitude);
		list.add(is_active);
		list.add(store_logo);
		list.add(store_banner);
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
	ArrayList stores=new ArrayList();
	while(resultSet.next()) {
		Store store=new Store();
		store.setStore_id(resultSet.getInt(strings[0]));
		store.setStore_name(resultSet.getString(strings[1]));
		store.setStore_desc(resultSet.getString(strings[2]));
		store.setAdded_date(resultSet.getString(strings[3]));
		store.setLatitude(resultSet.getDouble(strings[4]));
		store.setLongitude(resultSet.getDouble(strings[5]));
		int active=resultSet.getInt(strings[6]);
		if(active==0) {store.setIs_active(false);}else {store.setIs_active(true);}
		store.setStore_logo(resultSet.getString(strings[7]));
		store.setStore_banner(resultSet.getString(strings[8]));
		stores.add(store);
	}
	return stores;
	}
	
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getStore_desc() {
		return store_desc;
	}
	public void setStore_desc(String store_desc) {
		this.store_desc = store_desc;
	}
	public String getAdded_date() {
		return added_date;
	}
	public void setAdded_date(String added_date) {
		this.added_date = added_date;
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
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	public String getStore_logo() {
		return store_logo;
	}
	public void setStore_logo(String store_logo) {
		this.store_logo = store_logo;
	}
	public String getStore_banner() {
		return store_banner;
	}
	public void setStore_banner(String store_banner) {
		this.store_banner = store_banner;
	}	
}
