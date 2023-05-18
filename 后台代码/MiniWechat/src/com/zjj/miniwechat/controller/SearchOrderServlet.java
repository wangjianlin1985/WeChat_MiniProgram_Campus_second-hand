package com.zjj.miniwechat.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjj.miniwechat.service.OrderService;
import com.zjj.miniwechat.service.Impl.OrderServiceImpl;
import com.zjj.miniwechat.utils.JsonUtils;
import com.zjj.miniwechat.vo.VOrders;

/**
 * Servlet implementation class SearchOrderServlet
 */
@WebServlet("/searchSomeOrder.do")
public class SearchOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private OrderService orderService = new OrderServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		
//		System.out.println("name="+name);
//		System.out.println("type="+type);
		try {
			List<VOrders> list = orderService.findOrderBySomeThings(name, Integer.parseInt(type));
			JsonUtils.writeJsonStr2(1, list, response);
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
