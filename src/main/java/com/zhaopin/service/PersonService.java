package com.zhaopin.service;

import com.zhaopin.entity.Person;

import java.util.List;

/**
 * Created by SYJ on 2017/4/20.
 */
public interface PersonService {
	int deleteByPrimaryKey(Integer personId);
	Person selectByPrimaryKey(Integer personId);
	int insert(Person person);
	List<Person> findAll();
	int updateByPrimaryKey(Person record);
}
