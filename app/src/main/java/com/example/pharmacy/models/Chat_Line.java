package com.example.pharmacy.models;

import com.google.gson.Gson;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Chat_Line implements Objects {
	private Integer chat_line_id;
	private String line_text;
	private String send_at;
	private Integer user_id;
	private Integer chat_id;
	private Boolean sender;
	private String username;
	private String strings[]= {"chat_line_id","line_text","send_at","chat_id","sender"};
	private String stringsJoin[]= {"chat_line_id","line_text","send_at","chat_id","user_id","sender","username"};
	@Override
	public String[] getStrings() {
		return strings;
	}
	@Override
	public ArrayList getDataFromResultSet(ResultSet resultSet) throws SQLException {
		ArrayList list=new ArrayList();
		while(resultSet.next()) {
			Chat_Line chat_Line=new Chat_Line();
			chat_Line.setChat_line_id(resultSet.getInt("chat_line_id"));
			chat_Line.setLine_text(resultSet.getString("line_text"));
			chat_Line.setSend_at(resultSet.getString("send_at"));
			chat_Line.setChat_id(resultSet.getInt("chat_id"));
			chat_Line.setSender(resultSet.getBoolean("sender"));
			list.add(chat_Line);
		}
		return list;
	}
	@Override
	public ArrayList getValues() {
		ArrayList list=new ArrayList();
		list.add(chat_line_id);
		list.add(line_text);
		list.add(send_at);
		list.add(chat_id);
		list.add(sender);
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
	public ArrayList getDataFromResultSetJoined(ResultSet resultSet) throws SQLException {
		ArrayList list=new ArrayList();
		while(resultSet.next()) {
			Chat_Line chat_Line=new Chat_Line();
			chat_Line.setChat_line_id(resultSet.getInt("chat_line_id"));
			chat_Line.setLine_text(resultSet.getString("line_text"));
			chat_Line.setSend_at(resultSet.getString("send_at"));
			chat_Line.setUser_id(resultSet.getInt("user_id"));
			chat_Line.setChat_id(resultSet.getInt("chat_id"));
			chat_Line.setSender(resultSet.getBoolean("sender"));
			chat_Line.setUsername(resultSet.getString("username"));
			list.add(chat_Line);
		}
		return list;
	}
	public ArrayList getValuesJoined() {
		ArrayList list=new ArrayList();
		list.add(chat_line_id);
		list.add(line_text);
		list.add(send_at);
		list.add(chat_id);
		list.add(user_id);
		list.add(sender);
		list.add(username);
		return list;
	}
	public Integer getChat_line_id() {
		return chat_line_id;
	}
	public void setChat_line_id(Integer chat_line_id) {
		this.chat_line_id = chat_line_id;
	}
	public String getLine_text() {
		return line_text;
	}
	public void setLine_text(String line_text) {
		this.line_text = line_text;
	}
	public String getSend_at() {
		return send_at;
	}
	public void setSend_at(String send_at) {
		this.send_at = send_at;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Boolean getSender() {
		return sender;
	}
	public void setSender(Boolean sender) {
		this.sender = sender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getChat_id() {
		return chat_id;
	}
	public void setChat_id(Integer chat_id) {
		this.chat_id = chat_id;
	}
	
}
