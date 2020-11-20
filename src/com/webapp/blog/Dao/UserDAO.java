package com.webapp.blog.Dao;

import org.genericdao.*;

import com.webapp.blog.DataBeans.User;


//
public class UserDAO extends GenericDAO<User>  {
	public UserDAO(ConnectionPool cp, String tableName) throws org.genericdao.DAOException {
        super(User.class, tableName, cp);
    }
	
	public User[] getUsers() throws RollbackException {
		return match();
	}
}















