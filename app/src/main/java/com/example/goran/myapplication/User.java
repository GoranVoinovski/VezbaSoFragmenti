package com.example.goran.myapplication;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by goran on 5.12.17.
 */

public class User implements Serializable{

    String mail;
    String password;
    ArrayList<Users> users;

    public User(String mail, String password, ArrayList<Users> users) {
        this.mail = mail;
        this.password = password;
        this.users = users;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Users> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Users> users) {
        this.users = users;
    }
}
