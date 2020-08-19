package com.rest.webservices.restfulwebservices.user;

import java.util.Date;

public class User {
    private Integer id;
    private Date birthDate;
    private String name;

    public User(Integer id, Date birthDate, String name) {
        this.id = id;
        this.birthDate = birthDate;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", birthDate=" + birthDate +
                ", name='" + name + '\'' +
                '}';
    }
}
