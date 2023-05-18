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
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/addUser.do")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获得前台出来的参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		//查询用户是否存在
		User findUser = userService.findUser(username);
		if (null == findUser) {
			try {
				//用户不存在，添加
				userService.addUser(user);
				JsonUtils.writeJsonStr2(1, null, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.getStackTrace();
				JsonUtils.writeJsonStr2(0, e.getMessage(), response);
			}
		} else {
			JsonUtils.writeJsonStr2(0, "用户名已存在", response);
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
