package com.storm.kafka;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.storm.util.LoggingUtil;

/**
 * @author 李斯
 * @date 2018年8月11日 上午10:16:46 
 * @version V1.0
 */
@Component
public class KafkaProducer{

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    /**
     * 发送消息的方法
     */
    public void send() {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(LocalDateTime.now());
        LoggingUtil.info("KafkaProducer", gson.toJson(message));
        kafkaTemplate.send("kafka_test1", gson.toJson(message));
    }
}