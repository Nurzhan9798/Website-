package com.webapp.blog.blog;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.genericdao.RollbackException;
import com.webapp.blog.Dao.*;
import com.webapp.blog.DataBeans.*;
import com.webapp.blog.FormBeans.PostForm;

public class Post extends Action{
	private PostDAO postDao;
	private CommentDAO commentDao;
	private UserDAO userDao;
	
	public Post(Model model) {
		this.postDao = model.getPostDao();
		this.commentDao = model.getCommentDao();
		this.userDao = model.getUserDao();
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "post.do";
	}
	
   public String performGet(HttpServletRequest request) {
        return performPost(request);
    }

	
	public String performPost(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        
        try {
            User user = (User) (request.getSession()).getAttribute("todolist5_user");
            request.setAttribute("posts", postDao.getPosts(user));
            request.setAttribute("comments", commentDao.getComments());
            request.setAttribute("users", userDao.getUsers());
            
            PostForm form = new PostForm(request);
            request.setAttribute("form", form);

            errors.addAll(form.getValidationErrors());
            if(errors.size() != 0) {
            	return "home.jsp";
            }
            
            PostBean bean = new PostBean();
            bean.setDescription(request.getParameter("post"));
            
            String userName = user.getUserName(); 
            bean.setUserName(userName);
            
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd  'at' HH:mm:ss");
            bean.setDate(dateFormat.format(date));

            postDao.create(bean);
            // Fetch the items again, since we modified the list
            request.setAttribute("posts", postDao.getPosts(user));

            return "home.jsp";

        } catch (RollbackException e) {
            return "error.jsp";
        }
    }

}
