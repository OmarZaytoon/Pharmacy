package com.example.pharmacy.Requseter;

import android.os.StrictMode;
import android.util.Log;

import com.example.pharmacy.models.Cart;
import com.example.pharmacy.models.Categories;
import com.example.pharmacy.models.Home;
import com.example.pharmacy.models.Offers;
import com.example.pharmacy.models.Product;
import com.example.pharmacy.models.Store;
import com.example.pharmacy.models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Requseter {
    OkHttpClient client;
    final String url ="http://192.168.1.12:8080/pharmacies/webapi/UserAPIs/";
       public Requseter(){
            client = new OkHttpClient().newBuilder()
                   .build();
           int SDK_INT = android.os.Build.VERSION.SDK_INT;
           if (SDK_INT > 8)
           {
               StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                       .permitAll().build();
               StrictMode.setThreadPolicy(policy);

           }

       }

       public boolean createNewAccount(User user){
        boolean flag=false;
        try {
            String string=new Gson().toJson(user);
            MediaType mediaType = MediaType.parse("application/json");
             RequestBody body = RequestBody.create(mediaType, string);
             Request request = new Request.Builder()
                .url(url+"newUser")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
            Response response = client.newCall(request).execute();
            String str=response.body().string();;
            flag=Boolean.valueOf(str);
        } catch (IOException e) {
            Log.d("error",e.getMessage());
            e.printStackTrace();
        }
    return  flag;
    }
public HashMap<User, ArrayList<Store>> Login(User user){
        HashMap<User,ArrayList<Store>> hashMap=new HashMap<>();
       try{
           MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, new Gson().toJson(user));
        Request request = new Request.Builder()
            .url(url+"Login")
            .method("POST", body)
            .addHeader("Content-Type", "application/json")
            .build();
         Response response = client.newCall(request).execute();
         String string=response.body().string();
         Log.d("response",string);
           JSONObject jsonObj = new JSONObject(string);

//extracting data array from json string
           JSONObject jsonObject = jsonObj.getJSONObject("user");
           Log.d("user",jsonObj.getJSONObject("user").toString());
           user=new Gson().fromJson(jsonObj.getJSONObject("user").toString(),User.class);
//loop to get all json objects from data json array
           JSONArray jsonArray = jsonObj.getJSONArray("Items");
           int length=jsonArray.length();
           ArrayList<Store> list=new ArrayList<>();
           for(int i=0; i<length; i++)
           {
               JSONObject jObj = jsonArray.getJSONObject(i);
               // getting inner array Ingredients
               Log.d("store",jObj.toString());
                Store store=new Gson().fromJson(jObj.toString(), Store.class);
                list.add(store);
           }

           hashMap.put(user,list);
       }catch (IOException | JSONException e) {
           Log.d("error",e.getMessage());
           e.printStackTrace();
       }
    return hashMap;
    }
    public Home GoToHome(String string){
     Home home=new Home();
        try {

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, string);
            Request request = new Request.Builder()
                    .url(url + "Home")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();
            String strings=response.body().string();
            home=new Gson().fromJson(strings, Home.class);
            Log.d("Resopnse",strings);
        }catch (IOException e){
            e.printStackTrace();
        }
      return  home;
      }
public Cart getMyCart(String user_id){
       Cart cart=new Cart();
           try {
               MediaType mediaType = MediaType.parse("application/json");
               RequestBody body = RequestBody.create(mediaType, user_id);
               Request request = new Request.Builder()
                       .url(url+"getCart")
                       .method("POST", body)
                       .addHeader("Content-Type", "application/json")
                       .build();
               Response response = client.newCall(request).execute();
               String res=response.body().string();
               if(res==null){
                   cart=null;
               }else{
                   cart=new Gson().fromJson(res,Cart.class);
               }
           }catch (IOException e){
               e.printStackTrace();
           }
       return cart;
       }
    public Product getProductDetails(int id){
       Product product=new Product();
           try {
               MediaType mediaType = MediaType.parse("application/json");
               RequestBody body = RequestBody.create(mediaType, id+"");
               Request request = new Request.Builder()
                       .url(url+"getProductDetails")
                       .method("POST", body)
                       .addHeader("Content-Type", "application/json")
                       .build();
               Response response = client.newCall(request).execute();
               String str=response.body().string();
               product=new Gson().fromJson(str, Product.class);
           }catch (IOException e){e.printStackTrace();}
    return product;
       }
public boolean addToCart(String string){
           boolean flag=false;
    try{OkHttpClient client = new OkHttpClient().newBuilder()
            .build();
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = RequestBody.create(mediaType, string);
    Request request = new Request.Builder()
            .url(url+"AddToCart")
            .method("POST", body)
            .addHeader("Content-Type", "application/json")
            .build();
    Response response = client.newCall(request).execute();
    String str=response.body().string();
    flag=Boolean.parseBoolean(str);
    }catch (IOException e){e.printStackTrace();}
    return flag;
  }
    public int CreateNewCart(Cart cart){
        int id=-1;
        Log.d("cart",new Gson().toJson(cart));
        try{OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, new Gson().toJson(cart));
            Request request = new Request.Builder()
                    .url(url+"CreateNewCart")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();
            String str=response.body().string();
            Log.d("response",str);
            id=Integer.parseInt(str);
        }catch (IOException e){e.printStackTrace();}
        return id;
    }
    public ArrayList<Categories> getAllCategories(){
           ArrayList<Categories> categories=new ArrayList<Categories>();
           try{
               Request request = new Request.Builder()
                       .url(url+"GetAllCategory")
                       .method("GET", null)
                       .addHeader("Content-Type", "application/json")
                       .build();
               Response response = client.newCall(request).execute();
               categories = new Gson().fromJson(response.body().string(), new TypeToken<List<Categories>>(){}.getType());

           }catch (IOException e){}
    return categories;
       }
public ArrayList<Offers>getOffers(String string){
    ArrayList<Offers> offers=new ArrayList<>();
    try {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, string);
        Request request = new Request.Builder()
                .url(url+"getOffers")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        offers= new Gson().fromJson(response.body().string(), new TypeToken<List<Offers>>(){}.getType());
    }catch (IOException e){
        e.printStackTrace();
    }

    return offers;
  }
public ArrayList<Store> getAllStore(){
    ArrayList<Store> stores=new ArrayList<Store>();
    try {
        Request request = new Request.Builder()
                .url(url + "GetAllStore")
                .method("GET", null)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        stores=new Gson().fromJson(response.body().string(), new TypeToken<List<Store>>(){}.getType());
        }catch (IOException e){e.printStackTrace();}
    return  stores;
       }
}
