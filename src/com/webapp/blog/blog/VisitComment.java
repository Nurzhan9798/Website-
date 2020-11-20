package com.webapp.blog.blog;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.genericdao.RollbackException;
import com.webapp.blog.Dao.*;
import com.webapp.blog.DataBeans.CommentBean;
import com.webapp.blog.DataBeans.User;
import com.webapp.blog.FormBeans.CommentForm;

public class VisitComment extends Action{
	private CommentDAO commentDao;
	private PostDAO postDao;
	private UserDAO userDao;
	
	public VisitComment(Model model) {
		this.commentDao = model.getCommentDao();
		this.postDao = model.getPostDao();
		this.userDao = model.getUserDao();
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "visitComment.do";
	}
	
   public String performGet(HttpServletRequest request) {
        return performPost(request);
    }

	
	public String performPost(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        
        try {
            // Fetch the items now, so that in case there is no form or there are errors
            // We can just dispatch to the JSP to show the item list (and any errors)
        	User user = (User) (request.getSession()).getAttribute("todolist5_user");
        	String visitUserName =(request).getParameter("visitUser");
            User visitUser = userDao.read(visitUserName);
            request.setAttribute("visitUser", visitUser);
            request.setAttribute("comments", commentDao.getComments());
            request.setAttribute("users", userDao.getUsers());
            request.setAttribute("posts", postDao.getPosts(visitUser));
            
            CommentForm form = new CommentForm(request);
            request.setAttribute("form", form);

            errors.addAll(form.getValidationErrors());
            if(errors.size() != 0) {
            	System.out.println("ERROR");
            	return "visit.jsp";
            }
            
            CommentBean bean = new CommentBean();
            bean.setDescription(request.getParameter("comment"));
            
            String userName = user.getUserName(); 
            bean.setUserName(userName);
            
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd  'at' HH:mm:ss");
            bean.setDate(dateFormat.format(date));

            bean.setPostId(Integer.parseInt(request.getParameter("postId")));
            
            commentDao.create(bean);
            
            request.setAttribute("comments", commentDao.getComments());
            return "visit.jsp";

        } catch (RollbackException e) {
            return "error.jsp";
        }
    }

}
