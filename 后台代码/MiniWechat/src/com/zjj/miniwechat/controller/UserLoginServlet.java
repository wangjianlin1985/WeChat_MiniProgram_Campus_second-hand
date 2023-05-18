package com.zjj.miniwechat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjj.miniwechat.dao.UserDao;
import com.zjj.miniwechat.entity.User;
import com.zjj.miniwechat.service.UserService;
import com.zjj.miniwechat.service.Impl.UserServiceImpl;
import com.zjj.miniwechat.utils.JsonUtils;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/user/login.do")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private UserService userService = new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        
		String uname = request.getParameter("username");
		try {
			
			User user = userService.findUser(uname);
			if (user != null ) {
				JsonUtils.writeJsonStr(user, response);
			} else {
				JsonUtils.writeJsonStr(null, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			JsonUtils.writeJsonStr(e.getMessage(), response);
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
