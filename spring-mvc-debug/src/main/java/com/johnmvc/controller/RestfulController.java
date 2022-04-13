package com.johnmvc.controller;

import com.johnmvc.response.DataResult;
import com.johnmvc.vo.PersonInfoVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/27
 */
@RestController
@RequestMapping("rest")
public class RestfulController {
	/**
	 * 返回一个字符串
	 *
	 * @return
	 */
	@GetMapping("resultString")
	public String resultString() throws Exception {
		throw new Exception("sss");
		//return "我是一个字符串！";
	}

	/**
	 * 返回一个json数据
	 *
	 * @return
	 */
	@GetMapping("resultJson")
	public DataResult<PersonInfoVO> resultJson() {
		DataResult<PersonInfoVO> dataResult = new DataResult<>();
		PersonInfoVO personInfoVO = new PersonInfoVO();
		personInfoVO.setUserName("我是张三");
		personInfoVO.setPassWord("woshizhangsan");
		dataResult.setData(personInfoVO);
		dataResult.setSuccess(true);
		return dataResult;
	}
}
