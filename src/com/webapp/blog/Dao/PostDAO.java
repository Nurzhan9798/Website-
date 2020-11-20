package com.webapp.blog.Dao;
import java.util.Arrays;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import com.webapp.blog.DataBeans.PostBean;
import com.webapp.blog.DataBeans.User;
//
public class PostDAO extends GenericDAO<PostBean>{
	public PostDAO(ConnectionPool cp, String tableName) throws DAOException{
		super(PostBean.class, tableName, cp);
	}
	
	public PostBean[] getPosts(User user) throws RollbackException {
		String username = user.getUserName();
		PostBean[] posts = match(MatchArg.equals("userName", username));
		Arrays.sort(posts, (PostBean i1, PostBean i2) -> i2.getPostId() - i1.getPostId());
		return posts;
	}
}
