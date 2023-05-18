package com.zjj.miniwechat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjj.miniwechat.entity.User;
import com.zjj.miniwechat.service.UserService;
import com.zjj.miniwechat.service.Impl.UserServiceImpl;
import com.zjj.miniwechat.utils.JsonUtils;

/**
 * Servlet implementation class AdmitLoginServlet
 */
@WebServlet("/adminLogin.do")
public class AdmitLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	private UserService userService = new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmitLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			User findUser = userService.findUser(username);
			
			if (findUser != null ) {
				//判断用户名和密码是否正确
				if (findUser.getUsername().equals(username) && findUser.getPassword().equals(password)) {
					//判断权限
					if (1 == findUser.getUroleId()) {
						JsonUtils.writeJsonStr2(1, null, response);
					} else {
						RuntimeException exception = new RuntimeException("权限不足，无法进入后台");
						JsonUtils.writeJsonStr2(0, exception , response);
					}
					
				} else {
					RuntimeException exception = new RuntimeException("用户名或者密码不正确");
					JsonUtils.writeJsonStr2(0, exception , response);
				}
			} else {
				RuntimeException exception = new RuntimeException("用户名或者密码不正确");
				JsonUtils.writeJsonStr2(0, exception , response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			JsonUtils.writeJsonStr2(0, e.getMessage(), response);
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
