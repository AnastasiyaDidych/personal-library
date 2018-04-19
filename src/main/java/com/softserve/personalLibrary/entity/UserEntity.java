package com.softserve.personalLibrary.entity;

import java.util.Objects;

public class UserEntity implements I_Entity{

    private String login;
    private String email;
    private String lastName;
    private String password;
    private Long id;

    // setters

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // getters

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    // constructor

    public UserEntity(String login, String email, String lastName, String password, Long id) {
        this.login = login;
        this.email = email;
        this.lastName = lastName;
        this.password = password;
        this.id = id;
    }

    // equals


    @Override
    public String toString() {
        return "\n \nUser:\n" +
                "login: " + login  +
                "\nemail:" + email  +
                "\nlast name: " + lastName +
                "\npassword: " + password  +
                "\nid: " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(login, that.login) &&
                Objects.equals(email, that.email) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(password, that.password) &&
                Objects.equals(id, that.id);
    }

}
