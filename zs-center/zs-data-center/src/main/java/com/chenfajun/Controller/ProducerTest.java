package com.chenfajun.Controller;

import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
/**
 * @Author: HU_zhenwei
 * @Date: 2018/9/14上午9:13
 * @Descripton:
 */
public class ProducerTest {
    public static void main(String[] args) {
        producer_test1(args);

        //producer_test2();
    }
    //10.161.11.207:7667,10.161.11.208:7667,10.161.11.209:7667
    //134.83.2.203:9090,134.83.2.203:9091,134.83.2.203:9092
    private static void producer_test2() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.1.129:9092,192.168.1.127:9092,192.168.1.128:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        for(int i = 0; i < 10; i++)
            producer.send(new ProducerRecord<String, String>("97_00", Integer.toString(i), Integer.toString(i)));

        producer.close();
    }

    private static void producer_test1(String[] args) {
        String arg0 = args != null && args.length > 0 ? args[0] : "10";
        long events = Long.parseLong(arg0);
        Random rnd = new Random();

        //    /opt/kafka_2.12-1.1.0/bin/kafka-console-producer.sh --broker-list 192.178.0.111:9092 --sync --topic kafkatopic
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.1.129:9092,192.168.1.127:9092,192.168.1.128:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // 配置partitionner选择策略，可选配置
        //props.put("partitioner.class", "com.dx.SimplePartitioner2");

        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        for (long nEvents = 0; nEvents < events; nEvents++) {
            long runtime = new Date().getTime();
            String ip = "192.178.0." + rnd.nextInt(255);
            String msg = runtime + "---Jeky,www.example.com," + ip;
            ProducerRecord<String, String> data = new ProducerRecord<String, String>("97_00", ip, msg);
            Future<RecordMetadata> send = producer.send(data,
                    new Callback() {
                        public void onCompletion(RecordMetadata metadata, Exception e) {
                            if (e != null) {
                                e.printStackTrace();
                            } else {
                                System.out.println("回调返回信息: " + metadata.offset());
                            }
                        }
                    });
        }
        producer.close();
    }
}
