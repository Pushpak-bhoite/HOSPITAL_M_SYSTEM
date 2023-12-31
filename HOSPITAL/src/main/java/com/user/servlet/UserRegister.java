package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;

@WebServlet("/user_register")
public class UserRegister extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String fullname=req.getParameter("fullname");
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			
			User u =new User(fullname,email,password);
			
			UserDao dao=new UserDao(DBConnect.getConn());//DBConnect - is class file ,using this class name and static method "getConn" we get connection 
			 									//UserDao is also a class
			
			HttpSession session=req.getSession();
			
			boolean f = dao.register(u);   //this method has return type boolean that it get into boolean
			
			if (f) {
				
				session.setAttribute("sucMsg","Register Successfully");
				resp.sendRedirect("signup.jsp");
			
			} else {
				
				session.setAttribute("errorMsg"," something wrong on server");
				resp.sendRedirect("signup.jsp");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}
