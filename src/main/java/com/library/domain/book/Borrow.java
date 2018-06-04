package com.library.domain.book;

public class Borrow {
    int id;
    int book_id;
    int user_id;
    String boorow_start_time;
    String borrow_end_time;
    String borrow_return_time;
    String borrow_is_return;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getBoorow_start_time() {
        return boorow_start_time;
    }

    public void setBoorow_start_time(String boorow_start_time) {
        this.boorow_start_time = boorow_start_time;
    }

    public String getBorrow_end_time() {
        return borrow_end_time;
    }

    public void setBorrow_end_time(String borrow_end_time) {
        this.borrow_end_time = borrow_end_time;
    }

    public String getBorrow_return_time() {
        return borrow_return_time;
    }

    public void setBorrow_return_time(String borrow_return_time) {
        this.borrow_return_time = borrow_return_time;
    }

    public String getBorrow_is_return() {
        return borrow_is_return;
    }

    public void setBorrow_is_return(String borrow_is_return) {
        this.borrow_is_return = borrow_is_return;
    }
}
