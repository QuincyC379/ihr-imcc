package com.zhaopin.mapper;

import com.zhaopin.entity.Discussion;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

/**
 * 测试讨论组操作
 * Created by SYJ on 2017/8/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscussionMapperTest extends TestCase {

    public static final Random RANDOM = new Random();

    @Autowired
    private DiscussionMapper discussionMapper;

    @Test
    public void testInsert() throws Exception {
        Discussion discussion = new Discussion();
        discussion.setFromid(Math.abs(RANDOM.nextLong()));
        discussion.setToid(Math.abs(RANDOM.nextLong()));
        discussion.setDiscussionid(Math.abs(RANDOM.nextInt()));
        int result = discussionMapper.insert(discussion);
        Assert.assertNotEquals(0, result);
    }

    @Test
    public void testSelectAll() throws Exception {
        List<Discussion> discussionList = discussionMapper.selectAll();
        System.out.println("\n\n================查询总数:" + discussionList.size());
        Assert.assertNotEquals(0, discussionList.size());
    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {
        Discussion discussion = discussionMapper.selectByPrimaryKey(16);
        System.out.println("\n\n================查询讨论组:" + discussion);
        Assert.assertNotNull(discussion);
    }

    @Test
    public void testSelectByFromidAndToid() throws Exception {
        Discussion discussion = discussionMapper.selectByFromidAndToid(1234567, 7654321);
        System.out.println("\n\n================根据fromid和toid查询讨论组:" + discussion);
        Assert.assertNotNull(discussion);
    }

    @Test
    public void testUpdateByPrimaryKey() throws Exception {
        Discussion discussion = new Discussion();
        discussion.setId(16);
        discussion.setFromid(12345678);
        discussion.setToid(87654321);
        int result = discussionMapper.updateByPrimaryKey(discussion);
        System.out.println("\n\n================修改条数:" + result);
        Assert.assertNotEquals(0, result);
    }

    @Test
    @Transactional
    public void testDeleteByPrimaryKey() throws Exception {
        int result = discussionMapper.deleteByPrimaryKey(16);
        System.out.println("\n\n================删除条数[删除后再回滚]:" + result);
        Assert.assertNotEquals(0, result);
    }
}