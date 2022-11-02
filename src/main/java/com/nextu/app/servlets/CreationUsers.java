package com.nextu.app.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nextu.app.beans.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/**
 * Servlet implementation class CreationUsers
 */
public class CreationUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CreationUsers() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		HttpSession session = request.getSession();
		User u = new User();
		u.setFirstname(firstname);
		u.setLastname(lastname);
		List<User> users;
		if(session.getAttribute("users")!=null) {
			users = (ArrayList<User>)session.getAttribute("users");
			
		}else {
			users = new ArrayList<User>();
			session.setAttribute("users", users);
		}
		if(!users.contains(u)) {
			users.add(u);
		}
		response.sendRedirect("admin.jsp");
	}

}
