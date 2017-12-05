package com.example.goran.myapplication;

import java.io.Serializable;

/**
 * Created by goran on 5.12.17.
 */

public class Users implements Serializable{

    String name;
    String lastname;
    String username;

    public Users() {
        name = " ";
        lastname = " ";
        username = "Guest";
    }


    public Users(String name, String lastname, String username) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
