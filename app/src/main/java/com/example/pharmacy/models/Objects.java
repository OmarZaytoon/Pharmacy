package com.example.pharmacy.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Objects {
public String [] getStrings();
public ArrayList getDataFromResultSet(ResultSet resultSet) throws SQLException;
public ArrayList getValues();
public String switchToGson();
public Objects getFromGson(String data);
}