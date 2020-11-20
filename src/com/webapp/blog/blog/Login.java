package com.webapp.blog.blog;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.genericdao.*;

import com.webapp.blog.Dao.Model;
import com.webapp.blog.Dao.UserDAO;
import com.webapp.blog.FormBeans.LoginForm;
import com.webapp.blog.DataBeans.User;

public class Login extends Action{
	private UserDAO userDAO;

	public Login(Model model) {
		this.userDAO = model.getUserDao();
	}
	
	@Override
	public String getName() {
		return "login.do";
	}
    
	 public String performGet(HttpServletRequest request) {
	        // If user is already logged in, redirect to todolist.do
	        HttpSession session = request.getSession();
	        try {
				request.setAttribute("users", userDAO.getUsers());
			} catch (RollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        if (session.getAttribute("todolist5_user") != null) {
	            return "home.do";
	        }
	        
	        // Otherwise, just display the login page.
	        return "login.jsp";
	 }
	 
	 public String performPost(HttpServletRequest request)  {
	        // If user is already logged in, redirect to todolist.do
	        HttpSession session = request.getSession();
	        try {
				request.setAttribute("users", userDAO.getUsers());
			} catch (RollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        if (session.getAttribute("todolist5_user") != null) {
	            return "home.do";
	        }

	        List<String> errors = new ArrayList<String>();
	        request.setAttribute("errors", errors);

	        try {
	            LoginForm form = new LoginForm(request);
	            request.setAttribute("form", form);

	            // Any validation errors?
	            errors.addAll(form.getValidationErrors());
	            if (errors.size() != 0) {
	                return "login.jsp";
	            }

	            // Look up the user
	            User user = userDAO.read(form.getUserName());

	            if (user == null) {
	                errors.add("User Name not found");
	                return "login.jsp";
	            }

	            // Check the password
	            if (!user.getPassword().equals(form.getPassword())) {
	                errors.add("Incorrect password");
	                return "login.jsp";
	            }

	            // Attach (this copy of) the user bean to the session
	            session.setAttribute("todolist5_user", user);

	            // If redirectTo is null, redirect to the "todolist" action
	            return "home.do";
	        } catch (RollbackException e) {
	            errors.add(e.getMessage());
	            return "error.jsp";
	        }
	    }

}
