package com.library.domain.book;

public class Book {
    int id;
    String name;
    String author;
    String pub;
    String edition;
    String classes;
    int all_num;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edtion) {
        this.edition = edtion;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public int getAll_num() {
        return all_num;
    }

    public void setAll_num(int all_num) {
        this.all_num = all_num;
    }

    public int getRemain_num() {
        return remain_num;
    }

    public void setRemain_num(int remain_num) {
        this.remain_num = remain_num;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getBorrow_num() {
        return borrow_num;
    }

    public void setBorrow_num(String borrow_num) {
        this.borrow_num = borrow_num;
    }

    int remain_num;
    String description;
    String path;
    String borrow_num;
}
