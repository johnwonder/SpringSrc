package com.johnmvc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/3/29
 */
@ControllerAdvice
public class MyGlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ModelAndView customException(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", e.getMessage());
		mv.setViewName("myerror");
		return mv;
	}
}