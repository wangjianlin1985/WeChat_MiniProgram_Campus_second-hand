package com.zjj.miniwechat.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjj.miniwechat.entity.Goods;
import com.zjj.miniwechat.service.GoodsService;
import com.zjj.miniwechat.service.Impl.GoodsServiceImpl;
import com.zjj.miniwechat.utils.JsonUtils;

/**
 * Servlet implementation class AdmintFindAllGoods
 */
@WebServlet("/admintFindAllGoods.do")
public class AdmintFindAllGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private GoodsService goodsService = new GoodsServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmintFindAllGoods() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// TODO Auto-generated method stub
			List<Goods> list = goodsService.findAllGoods();
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
