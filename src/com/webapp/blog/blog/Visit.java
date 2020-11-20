package com.webapp.blog.blog;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import com.webapp.blog.Dao.*;
import com.webapp.blog.Dao.Model;
import com.webapp.blog.Dao.PostDAO;
import com.webapp.blog.DataBeans.*;



public class Visit extends Action{	
	private PostDAO postDao;
	private CommentDAO commentDao;
	private UserDAO userDao;

    public Visit(Model model) {
        postDao = model.getPostDao();
        commentDao = model.getCommentDao();
        userDao = model.getUserDao();
    }
    
    @Override
	public String getName() {
		// TODO Auto-generated method stub
		return "visit.do";
	}
    
    public String performGet(HttpServletRequest request) {
    	return performPost(request);
    }

    public String performPost(HttpServletRequest request) {
    	System.out.println("VISIT");
        String username = (request.getParameter("user"));
        User visitUser = null;
		try {
			visitUser = userDao.read(username);
		} catch (RollbackException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        
        User user = (User) (request.getSession().getAttribute("todolist5_user"));
        if(user != null && (user.getUserName()).equals(visitUser.getUserName())) {
        	try {
				request.setAttribute("users", userDao.getUsers());
				request.setAttribute("posts", postDao.getPosts(user));
				request.setAttribute("comments", commentDao.getComments());
			} catch (RollbackException e) {
				e.printStackTrace();
			}
	        
			return ("home.jsp");
        }else {
			try {
				request.setAttribute("visitUser", visitUser);
				request.setAttribute("users", userDao.getUsers());
				request.setAttribute("posts", postDao.getPosts(visitUser));
				request.setAttribute("comments", commentDao.getComments());
			} catch (RollbackException e) {
				e.printStackTrace();
			}
	        
			return ("visit.jsp");
        }
    }

}
