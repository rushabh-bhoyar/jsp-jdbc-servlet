package in.edac.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.edac.dao.User;
import in.edac.dao.UserDao;


@WebServlet("/user-update")
public class UserControllerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     
	     try {
	    	 String username = request.getParameter("username");
				String password = request.getParameter("password");
				String email = request.getParameter("email");
				String mobile = request.getParameter("mobile");
				String idStr = request.getParameter("id");
				int id = Integer.parseInt(idStr);
				
				UserDao dao = new UserDao();

				User user = new User();
				user.setId(id);
				user.setUsername(username);
				user.setEmail(email);
				user.setPassword(password);
				user.setMobile(mobile);
				
				request.getRequestDispatcher("success.jsp").forward(request, response);
				

		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
