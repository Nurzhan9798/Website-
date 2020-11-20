package com.webapp.blog.blog;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;
import com.webapp.blog.Dao.*;
import com.webapp.blog.DataBeans.*;

public class DeleteComment extends Action{
	private CommentDAO commentDao;
	private PostDAO postDao;
	private UserDAO userDao;
	
	public DeleteComment(Model model) {
		this.commentDao = model.getCommentDao();
		this.postDao = model.getPostDao();
		this.userDao = model.getUserDao();
	}
	
	@Override
	public String getName() {
		return "deleteComment.do";
	}
	
	public String performPost(HttpServletRequest request) {

        try {
            commentDao.delete(Integer.parseInt(request.getParameter("id")));
            String visitUserName =(request).getParameter("visitUser");
            User visitUser = userDao.read(visitUserName);
            request.setAttribute("comments", commentDao.getComments());
            request.setAttribute("users", userDao.getUsers());
            request.setAttribute("visitUser", visitUser);
			request.setAttribute("posts", postDao.getPosts(visitUser));
            return "visit.jsp";

        } catch (RollbackException e) {
            return "error.jsp";
        }
    }
	

}
