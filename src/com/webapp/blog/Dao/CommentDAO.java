package com.webapp.blog.Dao;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import com.webapp.blog.DataBeans.CommentBean;
import com.webapp.blog.DataBeans.User;


public class CommentDAO extends GenericDAO<CommentBean> {
	public CommentDAO(ConnectionPool cp, String tableName) throws DAOException{
		super(CommentBean.class, tableName, cp);
	}

	public CommentBean[] getComments() throws RollbackException {
		return match();
	}
	
	public CommentBean[] getCommentsWithPostId(String id) throws RollbackException {
		CommentBean[] comments = match(MatchArg.equals("postId", Integer.parseInt(id)));
		System.out.println(comments.length);
		return comments;
	}
}
