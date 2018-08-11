package com.storm.test;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.test.context.junit4.SpringRunner;

import com.storm.App;
import com.storm.kafka.KafkaProducer;
import com.storm.util.LoggingUtil;

/**
 * @author 李斯
 * @date 2018年8月11日 上午10:25:55 
 * @version V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class KafkaTest {
    @Autowired
    private KafkaProducer producer;
    @Test
    public void test() throws InterruptedException{
        for (int i = 0; i < 5; i++) {
            //调用消息发送类中的消息发送方法
        	producer.send();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread.sleep(Long.MAX_VALUE);
    }
}