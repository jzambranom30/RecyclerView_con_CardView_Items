package com.example.recyclerview_con_cardview_items.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class User {
    private String name;
    private String email;
    private String image;
    private String university;
    private String phone;
    private String maidenName;
    private String domain;
    private String username;
    private String ein;

    public User(JSONObject jsonData) throws JSONException {
        name = jsonData.getString("firstName") + " " +
                jsonData.getString("lastName");
        email = jsonData.getString("email");
        image = jsonData.getString("image");
        university = jsonData.getString("university");
        phone = jsonData.getString("phone");
        maidenName = jsonData.getString("maidenName");
        domain = jsonData.getString("domain");
        username = jsonData.getString("username");
        ein = jsonData.getString("ein");
    }

    public static ArrayList<User> JsonObjectsBuild(JSONArray jsonDato) throws JSONException {
        ArrayList<User> users = new ArrayList<>();
        for (int i=0; i<jsonDato.length() && i<20;  i++){
            users.add(new User(jsonDato.getJSONObject(i)));
        }
        return users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEin() {
        return ein;
    }

    public void setEin(String ein) {
        this.ein = ein;
    }
}
