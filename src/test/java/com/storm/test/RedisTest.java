package com.storm.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.storm.App;

/**
 * @author 李斯
 * @date 2018年8月13日 上午10:51:04 
 * @version V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class RedisTest {
	 @Autowired
	    private StringRedisTemplate stringRedisTemplate;
	    
		@Autowired
		private RedisTemplate<String, String> redisTemplate;

	    @Test
	    public void test() throws Exception {
	        stringRedisTemplate.opsForValue().set("bbb", "222");
	    }
	    
//	    @Test
//	    public void testObj() throws Exception {
//	        User user=new User("aa@126.com", "aa", "aa123456", "aa","123");
//	        ValueOperations<String, User> operations=redisTemplate.opsForValue();
//	        operations.set("com.neox", user);
//	        operations.set("com.neo.f", user,1,TimeUnit.SECONDS);
//	        Thread.sleep(1000);
//	        //redisTemplate.delete("com.neo.f");
//	        boolean exists=redisTemplate.hasKey("com.neo.f");
//	        if(exists){
//	        	System.out.println("exists is true");
//	        }else{
//	        	System.out.println("exists is false");
//	        }
//	       // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
//	    }
}
