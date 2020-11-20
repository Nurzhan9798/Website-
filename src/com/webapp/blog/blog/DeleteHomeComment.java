package com.webapp.blog.blog;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;
import com.webapp.blog.Dao.*;
import com.webapp.blog.DataBeans.*;

public class DeleteHomeComment extends Action{
	private CommentDAO commentDao;
	private PostDAO postDao;
	private UserDAO userDao;
	
	public DeleteHomeComment(Model model) {
		this.commentDao = model.getCommentDao();
		this.postDao = model.getPostDao();
		this.userDao = model.getUserDao();
	}
	
	@Override
	public String getName() {
		return "deleteHomeComment.do";
	}
	
	public String performPost(HttpServletRequest request) {

        try {
            commentDao.delete(Integer.parseInt(request.getParameter("id")));
            User user = (User) (request.getSession()).getAttribute("todolist5_user");
            request.setAttribute("comments", commentDao.getComments());
            request.setAttribute("users", userDao.getUsers());
            request.setAttribute("posts", postDao.getPosts(user));
            return "home.jsp";

        } catch (RollbackException e) {
            return "error.jsp";
        }
    }
	

}
