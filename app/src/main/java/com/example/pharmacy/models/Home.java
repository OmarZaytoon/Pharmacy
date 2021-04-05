package com.example.pharmacy.models;

import java.util.ArrayList;

public class Home {
private ArrayList<Categories> categories;
private ArrayList<Offers> offers;
private ArrayList<Store> favStores;

public ArrayList<Categories> getCategories() {
	return categories;
}
public void setCategories(ArrayList<Categories> categories) {
	this.categories = categories;
}
public ArrayList<Offers> getOffers() {
	return offers;
}
public void setOffers(ArrayList<Offers> offers) {
	this.offers = offers;
}
public ArrayList<Store> getFavStores() {
	return favStores;
}
public void setFavStores(ArrayList<Store> favStores) {
	this.favStores = favStores;
}

}
