package com.zjj.miniwechat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjj.miniwechat.entity.Collection;
import com.zjj.miniwechat.service.CollectionService;
import com.zjj.miniwechat.service.Impl.CollectionServiceImpl;
import com.zjj.miniwechat.utils.JsonUtils;

/**
 * Servlet implementation class AddCollection
 */
@WebServlet("/addCollection.do")
public class AddCollection extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	private CollectionService collectionService = new CollectionServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCollection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String gid = request.getParameter("gid");
		String uid = request.getParameter("uid");
		
		
		Collection collection = new Collection();
		
		collection.setGid(Integer.parseInt(gid));
		collection.setUid(Integer.parseInt(uid));
		
		try {
			collectionService.addCollection(collection);
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
