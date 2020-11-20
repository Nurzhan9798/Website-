package com.webapp.blog.blog;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.genericdao.RollbackException;

import com.webapp.blog.Dao.*;
import com.webapp.blog.DataBeans.CommentBean;
import com.webapp.blog.DataBeans.User;

public class DeletePost extends Action{
	private PostDAO postDao;
	private CommentDAO commentDao;
	private UserDAO userDao;
	
	public DeletePost(Model model) {
		this.postDao = model.getPostDao();
		this.commentDao = model.getCommentDao();
		this.userDao = model.getUserDao();
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "delete.do";
	}

	
	
	public String performPost(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);

        try {
        	String id = request.getParameter("id");
            postDao.delete(Integer.parseInt(id));
            CommentBean[] comments = commentDao.getCommentsWithPostId(id);
            for(int i = 0; i < comments.length; i++) {
            	int idComment = comments[i].getCommentId();
            	System.out.println(idComment);
            	commentDao.delete(idComment);
            }
            
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
