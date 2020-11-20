package com.webapp.blog.Dao;

public class DAOException extends org.genericdao.DAOException {
	private static final long serialVersionUID = 1L;

    public DAOException(Exception e) {
        super(e);
    }

    public DAOException(String s) {
        super(s);
    }
}
