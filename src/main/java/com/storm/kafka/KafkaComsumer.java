package com.storm.kafka;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.storm.util.LoggingUtil;

/**
 * @author 李斯
 * @date 2018年8月11日 上午10:22:23 
 * @version V1.0
 */
@Component
public class KafkaComsumer{

    @KafkaListener(topics = {"kafka_test1"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message =  kafkaMessage.get();
            LoggingUtil.info("KafkaComsumer" , message.toString());
        }
    }
}