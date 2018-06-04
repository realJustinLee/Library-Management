package com.library.domain.book;

public class User {
    int id;
    String name;
    String nickname;
    String email;
    String number;
    String password;
    String role;
    String is_borrow;
    String recently_login;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getIs_borrow() {
        return is_borrow;
    }

    public void setIs_borrow(String is_borrow) {
        this.is_borrow = is_borrow;
    }

    public String getRecently_login() {
        return recently_login;
    }

    public void setRecently_login(String recently_login) {
        this.recently_login = recently_login;
    }
}
