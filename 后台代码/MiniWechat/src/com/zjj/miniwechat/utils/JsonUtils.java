package com.zjj.miniwechat.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zjj.miniwechat.vo.JsonBean;



public class JsonUtils {
	public static void writeJsonStr(Object info, HttpServletResponse response){
		JsonBean bean = new JsonBean();
		bean.setInfo(info);
		
		SerializerFeature[] feature = new SerializerFeature[] {
				SerializerFeature.WriteDateUseDateFormat,
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteNullNumberAsZero,
			
		};
		
		
		String jsonString = JSON.toJSONString(bean,feature);
		try {
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	public static void writeJsonStr2(int code, Object info, HttpServletResponse response){
		JsonBean bean = new JsonBean();
		bean.setCode(code);
		bean.setInfo(info);
		
		SerializerFeature[] feature = new SerializerFeature[] {
				SerializerFeature.WriteDateUseDateFormat,
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteNullNumberAsZero,
			
		};
		
		
		String jsonString = JSON.toJSONString(bean,feature);
		try {
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
