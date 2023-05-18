package com.zjj.miniwechat.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import com.zjj.miniwechat.entity.Goods;
import com.zjj.miniwechat.service.GoodsService;
import com.zjj.miniwechat.service.Impl.GoodsServiceImpl;
import com.zjj.miniwechat.utils.JsonUtils;

/**
 * Servlet implementation class AddGoodsServlet
 */
@WebServlet("/addGoods.do")
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private GoodsService goodsService = new GoodsServiceImpl();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddGoodsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String gname = request.getParameter("gname");
		String gprice = request.getParameter("gprice");
		String gdesc = request.getParameter("gdesc");
		String gnum = request.getParameter("gnum");
		String gimage = request.getParameter("gimage");
		String uid = request.getParameter("uid");
		
		Goods goods = new Goods();
		goods.setGname(gname);
		goods.setGprice(Integer.parseInt(gprice));
		goods.setGdesc(gdesc);
		goods.setGnum(Integer.parseInt(gnum));
		goods.setGimage(gimage);
		goods.setUid(Integer.parseInt(uid));
		
		try {
			goodsService.addGoods(goods);
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
