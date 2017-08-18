package com.zhaopin.service.impl;

import com.zhaopin.entity.Person;
import com.zhaopin.mapper.PersonMapper;
import com.zhaopin.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SYJ on 2017/4/20.
 */
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonMapper personMapper;

	@Override
	public List<Person> findAll() {
		List<Person> personList = personMapper.findAll();
		return personList;
	}

	@Override
	public int updateByPrimaryKey(Person record) {
		return personMapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer personId) {
		return personMapper.deleteByPrimaryKey(personId);
	}

	@Override
	public Person selectByPrimaryKey(Integer personId) {
		return personMapper.selectByPrimaryKey(personId);
	}

	@Override
	public int insert(Person person) {
		return personMapper.insert(person);
	}

}
