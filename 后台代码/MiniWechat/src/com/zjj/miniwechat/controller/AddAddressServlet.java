package com.zjj.miniwechat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjj.miniwechat.entity.Address;
import com.zjj.miniwechat.service.AddressService;
import com.zjj.miniwechat.service.Impl.AddressServiceImpl;
import com.zjj.miniwechat.utils.JsonUtils;

/**
 * Servlet implementation class AddAddressServlet
 */
@WebServlet("/addAddress.do")
public class AddAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private  AddressService addressService = new AddressServiceImpl();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String uid = request.getParameter("uid");
		//String aid = request.getParameter("aid");
//		System.out.println("dizhi" +address);
//		System.out.println("dianhua" +tel);
		Address userAddress = new Address();
		userAddress.setTel(tel);
		userAddress.setAddress(address);
		userAddress.setUid(Integer.parseInt(uid));
		
		try {
		
			addressService.addAddress(userAddress);
			JsonUtils.writeJsonStr(null, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			JsonUtils.writeJsonStr(e.getStackTrace(), response);
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
