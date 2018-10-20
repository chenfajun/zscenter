package com.chenfajun.Controller;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

/**
 * @Author: HU_zhenwei
 * @Date: 2018/9/13下午7:30
 * @Descripton:
 */
public class ConsumerMain {
    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.129:9092,192.168.1.127:9092,192.168.1.128:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG ,"test4") ;
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList("97_00"));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                Thread.sleep(5000);
            }
        }
    }
}
