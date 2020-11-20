package com.webapp.blog.blog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;

import com.webapp.blog.Dao.Model;
import com.webapp.blog.Dao.UserDAO;

/**
 * Servlet implementation class Logout
 */
public class Logout extends Action {
	private UserDAO userDAO;
    public Logout(Model model) {
    	this.userDAO = model.getUserDao();
    }
    @Override
	public String getName() {
		// TODO Auto-generated method stub
		return "logout.do";
	}

    public String performGet(HttpServletRequest request) {
    	return performPost(request);
    }
    
    public String performPost(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        try {
			request.setAttribute("users", userDAO.getUsers());
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        session.setAttribute("todolist5_user", null);

        return "login.jsp";
    }

}
