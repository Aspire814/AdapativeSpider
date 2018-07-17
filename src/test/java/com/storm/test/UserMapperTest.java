package com.storm.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.storm.App;
import com.storm.mapper.UserMapper;
import com.storm.model.User;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
public class UserMapperTest {

    @Autowired
    UserMapper dao;

    @Test
    public void queryById() throws Exception {
        User user = dao.selectByPrimaryKey(1);
        System.out.println("***************************");
        System.out.println(user);
        System.out.println("***************************");
    }

}