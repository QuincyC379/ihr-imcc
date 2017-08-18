package com.zhaopin.controller;

import com.zhaopin.entity.Person;
import com.zhaopin.service.PersonService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/redis")
public class RedisTemplateController {

    private static final Logger logger = LoggerFactory.getLogger(RedisTemplateController.class);
    @Autowired
    private PersonService personService;

    @Autowired
    private RedisTemplate redisTemplate;
      
    @RequestMapping("/persons")
    public List<Person> persons(){
        List<Person> personList = personService.findAll();
        System.out.println("------------");
        System.out.println("查询总数:[" + personList.size() + "]");
        return personList;
    }

    @RequestMapping(value = "/set")
    public Boolean set(@RequestParam("key") String key, @RequestParam("value") String value) {
        try {
            ValueOperations<String, String> ops = redisTemplate.opsForValue();
            ops.set(key, value);
            logger.info("==================设置缓存:key={}, value={}", key, value);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/get")
    public String get(@RequestParam("key") String key) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String value = ops.get(key);
        logger.info("==================查询缓存:key={}, value={}", key, value);
        return StringUtils.isEmpty(value) ? "空" : value;

    }
}  