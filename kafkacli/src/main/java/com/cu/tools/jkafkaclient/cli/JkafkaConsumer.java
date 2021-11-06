package com.cu.tools.jkafkaclient.cli;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

public class JkafkaConsumer extends Thread{
    private String topic;

    public JkafkaConsumer(String topic){
        super();
        this.topic = topic;
    }


    @Override
    public void run() {
        ConsumerConnector consumer = createConsumer();
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, 1); // 一次从主题中获取一个数据
        Map<String, List<KafkaStream<byte[], byte[]>>>  messageStreams = consumer.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> stream = messageStreams.get(topic).get(0);// 获取每次接收到的这个数据
        ConsumerIterator<byte[], byte[]> iterator =  stream.iterator();
        while(iterator.hasNext()){
            String message = new String(iterator.next().message());
            System.out.println("接收到: " + message);
        }
    }

    private ConsumerConnector createConsumer() {
        Properties properties = new Properties();
        properties.put("zookeeper.connect", "192.168.1.154:2181");//声明zk
        properties.put("auto.offset.reset","smallest");
        properties.put("group.id", "group1");// 必须要使用别的组名称， 如果生产者和消费者都在同一组，则不能访问同一组内的topic数据
        ConsumerConfig consumerConfig = new ConsumerConfig(properties);
        System.out.println("consumerConfig.offsetsCommitMaxRetries():"+consumerConfig.offsetsCommitMaxRetries());
        System.out.println("consumerConfig.offsetsChannelBackoffMs():"+consumerConfig.offsetsChannelBackoffMs());
        System.out.println("consumerConfig.offsetsChannelSocketTimeoutMs():"+consumerConfig.offsetsChannelSocketTimeoutMs());
        System.out.println("consumerConfig.autoOffsetReset():"+consumerConfig.autoOffsetReset());
        System.out.println("consumerConfig.offsetsStorage():"+consumerConfig.offsetsStorage());
        return Consumer.createJavaConsumerConnector(consumerConfig);
    }


    public static void main(String[] args) {
        new JkafkaConsumer("test").start();// 使用kafka集群中创建好的主题 test

    }
}
