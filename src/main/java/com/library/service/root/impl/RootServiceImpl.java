package com.library.service.root.impl;

import com.library.dao.root.RootBookDao;
import com.library.dao.root.RootUserDao;
import com.library.domain.book.Book;
import com.library.domain.book.User;
import com.library.service.root.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class RootServiceImpl implements RootService {
    @Autowired
    RootBookDao rootBookDao;

    @Autowired
    RootUserDao rootUserDao;

    /**
     * 查询所有书籍
     */
    public List<Book> rootSelectAllBooks() throws SQLException {
        String sql = "select id,name,author,pub,edition,classes,all_num allNum,remain_num remainNum from tbl_book";
        Object[] prams = new Object[]{};
        List<Book> books = rootBookDao.selectQuery(sql, prams);
        return books;
    }

    /**
     * 更新书籍
     */
    public boolean updateBookInfo(Object[] params) throws SQLException {
        String sql = "update tbl_book set classes = ?,name=?,author=?,all_num=? where id=?";
        return rootBookDao.updateQuery(sql, params);
    }

    /**
     * 删除书籍
     */
    public boolean deleteBook(Object[] params) throws SQLException {
        String sql = "delete from tbl_book where id = ?";
        boolean deleteSuccess = rootBookDao.deleteQuery(sql, params);
        return deleteSuccess;
    }

    /**
     * 增加书籍
     */
    public boolean addBookInformation(Object[] params) throws SQLException {
        String sql = "insert into tbl_book(name,author,pub,classes,all_num,remain_num,description,path,borrow_num) VALUES(?,?,?,?,?,?,?,?,?)";
        return rootBookDao.addQuery(sql, params);
    }

    /**
     * 模糊查询书籍
     */
    public List<Book> searchBook(Object[] params) throws SQLException {
        String sql = "select * from tbl_book where name like ?";
        List<Book> books = rootBookDao.selectQuery(sql, params);
        return books;
    }

    /**
     * 通过id查询书籍
     */
    public List<Book> searchIdBook(Object[] params) throws SQLException {
        String sql = "select * from tbl_book where id = ?";
        List<Book> books = rootBookDao.selectQuery(sql, params);
        return books;
    }

    /**
     * 查询所有用户
     */
    public List<User> selectAllUser() throws SQLException {
        String sql = "select * from tbl_user";
        return rootUserDao.selecetUser(sql, new Object[]{});
    }

    /**
     * 根据id查询用户
     */
    public List<User> selectUserById(Object[] params) throws SQLException {
        String sql = " select * from tbl_user where id = ?";
        return rootUserDao.selecetUser(sql, params);
    }
}
