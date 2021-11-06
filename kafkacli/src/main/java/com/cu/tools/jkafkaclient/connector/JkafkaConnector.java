package com.cu.tools.jkafkaclient.connector;

import com.cu.tools.jkafkaclient.config.JkafkaConfig;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.javaapi.producer.Producer;
import kafka.producer.ProducerConfig;

import java.util.Properties;

public class JkafkaConnector {
    private static JkafkaConfig jkafkaConfig;
    private static Properties properties = new Properties();
    private static Producer producer = null;

    private JkafkaConnector(){}
    public static void init(JkafkaConfig config){
        jkafkaConfig = config;
        properties.put(JkafkaConfig.ZOOKEEPER_CONNECT,config.getZookeeperConnect());
        properties.put(JkafkaConfig.METADATA_DROKER_LIST,config.getMetadataBrokerList());
        properties.put(JkafkaConfig.AUTO_OFFSET_RESET,config.getAutoOffsetReset());
        properties.put(JkafkaConfig.GROUP_ID,config.getGroupId());
        properties.put(JkafkaConfig.SERIALIZER_CLASS,config.getSerializerClass());



    }
    private static void initProdeucter(){
        producer = new Producer<Integer, String>(new ProducerConfig(properties));
    }
    private static void initConsumer(){
        ConsumerConfig consumerConfig = new ConsumerConfig(properties);
        System.out.println("consumerConfig.offsetsCommitMaxRetries():"+consumerConfig.offsetsCommitMaxRetries());
        System.out.println("consumerConfig.offsetsChannelBackoffMs():"+consumerConfig.offsetsChannelBackoffMs());
        System.out.println("consumerConfig.offsetsChannelSocketTimeoutMs():"+consumerConfig.offsetsChannelSocketTimeoutMs());
        System.out.println("consumerConfig.autoOffsetReset():"+consumerConfig.autoOffsetReset());
        System.out.println("consumerConfig.offsetsStorage():"+consumerConfig.offsetsStorage());
        ConsumerConnector consumer = Consumer.createJavaConsumerConnector(consumerConfig);
    }

}
