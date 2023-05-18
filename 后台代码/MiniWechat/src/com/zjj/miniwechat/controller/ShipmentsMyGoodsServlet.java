package com.zjj.miniwechat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjj.miniwechat.service.GoodsService;
import com.zjj.miniwechat.service.OrderService;
import com.zjj.miniwechat.service.Impl.GoodsServiceImpl;
import com.zjj.miniwechat.service.Impl.OrderServiceImpl;
import com.zjj.miniwechat.utils.JsonUtils;

/**
 * Servlet implementation class ShipmentsMyGoodsServlet
 */
@WebServlet("/shipmentsMyGoods.do")
public class ShipmentsMyGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private GoodsService goodsService = new GoodsServiceImpl();
	
	
	private OrderService orderService = new OrderServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShipmentsMyGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String gid = request.getParameter("gid");
		try {
			goodsService.shipmentsGoods(Integer.parseInt(gid));
			orderService.updateOrderByGid(Integer.parseInt(gid));
			JsonUtils.writeJsonStr(null, response);
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
