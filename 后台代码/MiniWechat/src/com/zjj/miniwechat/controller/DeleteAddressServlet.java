package com.zjj.miniwechat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjj.miniwechat.service.AddressService;
import com.zjj.miniwechat.service.Impl.AddressServiceImpl;
import com.zjj.miniwechat.utils.JsonUtils;

/**
 * Servlet implementation class DeleteAddressServlet
 */
@WebServlet("/deleteAddress.do")
public class DeleteAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	private AddressService addressService = new AddressServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String aid = request.getParameter("aid");
		try {
			addressService.deleteAddress(Integer.parseInt(aid));
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
