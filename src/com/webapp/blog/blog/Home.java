package com.webapp.blog.blog;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import com.webapp.blog.Dao.*;
import com.webapp.blog.Dao.Model;
import com.webapp.blog.Dao.PostDAO;
import com.webapp.blog.DataBeans.*;



public class Home extends Action{	
	private PostDAO postDao;
	private CommentDAO commentDao;
	private UserDAO userDao;

    public Home(Model model) {
        postDao = model.getPostDao();
        commentDao = model.getCommentDao();
        userDao = model.getUserDao();
    }
    
    @Override
	public String getName() {
		// TODO Auto-generated method stub
		return "home.do";
	}
    
    public String performGet(HttpServletRequest request) {
    	return performPost(request);
    }

    public String performPost(HttpServletRequest request) {
        User user = (User) (request.getSession()).getAttribute("todolist5_user");
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        
		try {
			request.setAttribute("users", userDao.getUsers());
			request.setAttribute("posts", postDao.getPosts(user));
			request.setAttribute("comments", commentDao.getComments());
		} catch (RollbackException e) {
			e.printStackTrace();
		}
        
		return ("home.jsp");
    }

}
