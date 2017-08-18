package com.zhaopin.service.impl;

import com.zhaopin.entity.Person;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 测试类
 * Created by SYJ on 2017/8/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceImplTest extends TestCase {

    @Autowired
    private PersonServiceImpl personService;

    @Test
    public void testFindAll() throws Exception {
        List<Person> personList = personService.findAll();
        System.out.println("\n\n=================查询总数：" + personList.size() + "\n\n");
        Assert.assertNotEquals(0, personList.size());
    }
}