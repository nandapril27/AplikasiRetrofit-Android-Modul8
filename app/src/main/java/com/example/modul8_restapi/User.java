package com.example.modul8_restapi;

public class User {
    private int id;
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;    }

    public int getId() {  return id;    }

    public String getName() { return name;    }

    public String getEmail() { return email;    }
}
