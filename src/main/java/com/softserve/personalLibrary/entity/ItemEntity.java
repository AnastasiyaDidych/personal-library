package com.softserve.personalLibrary.entity;

import java.util.Objects;

public class ItemEntity implements I_Entity {
    private String title;
    private String description;
    private String userLogin;
    private Long id;

    // setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // getters

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public Long getId() {
        return id;
    }


    // constructor

    public ItemEntity(String title, String description, String userLogin, Long id) {
        this.title = title;
        this.description = description;
        this.userLogin = userLogin;
        this.id = id;
    }

    @Override
    public String toString() {
        return "\n \nItem:\n" +
                "title: " + title  +
                "\ndescription:" + description  +
                "\nuser login: " + userLogin +
                "\nid: " + id ;
    }

    // equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemEntity that = (ItemEntity) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(userLogin, that.userLogin) &&
                Objects.equals(id, that.id);
    }
}
