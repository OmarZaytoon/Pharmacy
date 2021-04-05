package com.example.pharmacy.models;

import java.util.ArrayList;

public class Chat {	
private int chat_id;
private int user_id;
private String username;
private int have_unseen;
private String user_profile_picture;
private ArrayList<Chat_Line> chat_Lines;
public int getChat_id() {
	return chat_id;
}
public void setChat_id(int chat_id) {
	this.chat_id = chat_id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public ArrayList<Chat_Line> getChat_Lines() {
	return chat_Lines;
}
public void setChat_Lines(ArrayList<Chat_Line> chat_Lines) {
	this.chat_Lines = chat_Lines;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getHave_unseen() {
	return have_unseen;
}
public void setHave_unseen(int have_unseen) {
	this.have_unseen = have_unseen;
}
public String getUser_profile_picture() {
	return user_profile_picture;
}
public void setUser_profile_picture(String user_profile_picture) {
	this.user_profile_picture = user_profile_picture;
}
}

