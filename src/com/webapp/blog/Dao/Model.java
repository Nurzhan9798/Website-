package com.webapp.blog.Dao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;

public class Model {
	private UserDAO userDao;
	private PostDAO postDao;
	private CommentDAO commentDao;
	
	public Model(ServletConfig config) throws ServletException{
		try {
            String jdbcDriver = config.getInitParameter("jdbcDriverName");
            String jdbcURL = config.getInitParameter("jdbcURL");

            ConnectionPool pool = new ConnectionPool(jdbcDriver, jdbcURL);

            userDao = new UserDAO(pool, "todolist5_user");
            postDao = new PostDAO(pool, "posts");
            commentDao = new CommentDAO(pool, "comments");
        } catch (DAOException e) {
            throw new ServletException(e);
        }
		
	}
		
	
	public UserDAO getUserDao() { return userDao; }
	public PostDAO getPostDao() { return postDao; }
	public CommentDAO getCommentDao() { return commentDao; }
}

