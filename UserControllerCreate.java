package in.edac.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.edac.dao.User;
import in.edac.dao.UserDao;

/**
 * Servlet implementation class UserControllerCreate
 */
@WebServlet("/user-create")
public class UserControllerCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		try {
			String username1 = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String moblie = request.getParameter("mobile");
			
			UserDao dao=new UserDao();
			User user=new User();
			user.setUsername(username1);
			user.setEmail(email);
			user.setPassword(password);
			user.setMobile(moblie);
			
			dao.createUser(user);
			request.getRequestDispatcher("user-read").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
