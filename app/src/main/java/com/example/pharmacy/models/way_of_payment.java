package com.example.pharmacy.models;

import com.google.gson.Gson;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class way_of_payment implements Objects {
private Integer way_of_payment_id;
private String type;
private String[] strings= {"way_of_payment_id","type"};
@Override
public String[] getStrings() {
	return strings;
}
@Override
public ArrayList getDataFromResultSet(ResultSet resultSet) throws SQLException {
	// TODO Auto-generated method stub
	ArrayList list=new ArrayList();
	while(resultSet.next()) {
		way_of_payment way=new way_of_payment();
		way.setWay_of_payment_id(resultSet.getInt(strings[0]));
		way.setType(resultSet.getString(strings[1]));
		list.add(way);
	}
	return list;
}
@Override
public ArrayList getValues() {
	// TODO Auto-generated method stub
	ArrayList list=new ArrayList();
	list.add(way_of_payment_id);
	list.add(type);
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
public Integer getWay_of_payment_id() {
	return way_of_payment_id;
}
public void setWay_of_payment_id(Integer way_of_payment_id) {
	this.way_of_payment_id = way_of_payment_id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

}
