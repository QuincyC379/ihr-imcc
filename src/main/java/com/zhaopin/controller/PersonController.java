package com.zhaopin.controller;

import com.zhaopin.core.common.ResultModel;
import com.zhaopin.entity.Person;
import com.zhaopin.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 测试类
 * Created by SYJ on 2017/4/13.
 */
@RestController
@RequestMapping("/person")
public class PersonController {
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	PersonService personService;

	/**
	 * 测试
	 * @return
	 */
	@GetMapping("/test")
	public ResultModel test() {
		long time = System.currentTimeMillis();
		ResultModel<Object> resultModel = new ResultModel<>();
		resultModel.setCode(200);
		resultModel.setData(time);
		return resultModel;
	}

	/**
	 * 根据id查询
	 * @param personId
	 * @return
	 */
	@GetMapping("/selectById")
	public ResultModel selectByPrimaryKey(@RequestParam("id") Integer personId) {
		Person person = personService.selectByPrimaryKey(personId);
		ResultModel<Object> resultModel = new ResultModel<>();
		resultModel.setCode(200);
		resultModel.setData(person);
		return resultModel;
	}

	/**
	 * 根据id查询
	 * @param personId
	 * @return
	 */
	@GetMapping("/select")
	public ResultModel selectOne(@RequestParam("id") Integer personId) {
		Person person = personService.selectByPrimaryKey(personId);
		ResultModel<Object> resultModel = new ResultModel<>();
		resultModel.setCode(200);
		resultModel.setData(person);
		return resultModel;
	}

	/**
	 * 查询所有
	 * @param request
	 * @return
	 */
	@GetMapping("/selectAll")
	public ResultModel selectAll(HttpServletRequest request) {
		List<Person> pList = personService.findAll();
		ResultModel<Object> resultModel = new ResultModel<>();
		resultModel.setCode(200);
		resultModel.setData(pList);
		return resultModel;
	}

	/**
	 * 添加
	 * @param person
	 * @return
	 */
	@PostMapping("/insert")
	public ResultModel insert(Person person) {
		personService.insert(person);
		ResultModel<Object> resultModel = new ResultModel<>();
		resultModel.setCode(200);
		resultModel.setData(person);
		return resultModel;
	}

	/**
	 * 修改
	 * @param person
	 * @return
	 */
	@PostMapping("/update")
	public ResultModel updateByPrimaryKey(Person person) {
		int count = personService.updateByPrimaryKey(person);
		ResultModel<Object> resultModel = new ResultModel<>();
		resultModel.setCode(200);
		resultModel.setData(count);
		return resultModel;
	}

	/**
	 * 根据id删除
	 * 该接口要求参数是Form表单的形式;
	 * 即Content-Type为application/x-www-form-urlencoded;
	 * 且请求body中的参数为id=12的形式;
	 * @param personId
	 * @return
	 */
	@PostMapping("/deleteById")
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public ResultModel deleteByPrimaryKey(/*@FormParam("id") */Integer personId) {
		int count = personService.deleteByPrimaryKey(personId);
		ResultModel<Object> resultModel = new ResultModel<>();
		resultModel.setCode(200);
		resultModel.setData(count);
		return resultModel;
	}

	/**
	 * 根据id删除
	 * 该接口要求参数是json的形式
	 * @param person
	 * @return
	 */
	@PostMapping("/deleteByPersonId")
	public ResultModel deleteByPrimaryKey2(Person person) {
		int count = personService.deleteByPrimaryKey(person.getPersonId());
		ResultModel<Object> resultModel = new ResultModel<>();
		resultModel.setCode(200);
		resultModel.setData(count);
		return resultModel;
	}

}
