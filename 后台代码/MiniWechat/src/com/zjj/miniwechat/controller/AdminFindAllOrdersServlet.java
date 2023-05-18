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
 * Servlet implementation class AdminFindAllgoodsServlet
 */
@WebServlet("/adminFindAllOrders.do")
public class AdminFindAllOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	private OrderService orderService = new OrderServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFindAllOrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// TODO Auto-generated method stub
			List<VOrders> list = orderService.findAllOrder();
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
