package com.example.pharmacy.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Categories implements Objects {
private Integer category_id;
private String category_name;
private Boolean is_active;
private String image_url;
private String[] strings= {"category_id","category_name","isActive","image_url"}; 

@Override
public String[] getStrings() {
	return strings;
}
@Override
public ArrayList getValues() {
	ArrayList list=new ArrayList();
	list.add(category_id);
	list.add(category_name);
	list.add(is_active);
	list.add(image_url);
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
public ArrayList<Categories> getDataFromResultSet(ResultSet resultSet) throws SQLException{
ArrayList<Categories>categorieslist=new ArrayList<Categories>();
while(resultSet.next()) {
	Categories categories=new Categories();
	categories.setCategory_id(resultSet.getInt(strings[0]));
	categories.setCategory_name(resultSet.getString(strings[1]));
	int active=resultSet.getInt(strings[2]);
	if(active==0) {categories.setIs_active(false);}else {categories.setIs_active(true);}
	categories.setImage_url(resultSet.getString(strings[3]));
	categorieslist.add(categories);	
}
return categorieslist;
}
public int getCategory_id() {
	return category_id;
}
public void setCategory_id(int category_id) {
	this.category_id = category_id;
}
public String getCategory_name() {
	return category_name;
}
public void setCategory_name(String category_name) {
	this.category_name = category_name;
}
public boolean isIs_active() {
	return is_active;
}
public void setIs_active(boolean is_active) {
	this.is_active = is_active;
}
public String getImage_url() {
	return image_url;
}
public void setImage_url(String image_url) {
	this.image_url = image_url;
}

}
