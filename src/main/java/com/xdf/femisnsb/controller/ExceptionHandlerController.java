package com.xdf.femisnsb.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.xdf.femisnsb.model.JsonData;

@Controller
public class ExceptionHandlerController {
	private static Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);
			
	@ExceptionHandler(RuntimeException.class)
	public JsonData handleGlobalException(RuntimeException ex,HttpServletRequest req) {
		logger.info("==============这里是全局异常处理类的方法handleGlobalException===============");
		logger.info("异常的内容是：" + ex.getMessage());
		
		return JsonData.fail(ex.getMessage());
	}
}
