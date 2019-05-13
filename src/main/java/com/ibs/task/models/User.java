package com.ibs.task.models;

public class User {
    private Integer Id;
    private String email;
    private String name;
    private String surname;

    public User() {
    }

    public User(Integer Id, String email, String name, String surname) {
        this.Id = Id;
        this.email = email;
        this.name = name;
        this.surname = surname;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
