package com.cu.tools.jkafkaclient.config;

public class JkafkaConfig {
    /**
     properties.put("zookeeper.connect", "192.168.1.154:2181");//声明zk
     properties.put("auto.offset.reset","smallest");
     properties.put("group.id", "group1");// 必须要使用别的组名称， 如果生产者和消费者都在同一组，则不能访问同一组内的topic数据
     properties.put("serializer.class", StringEncoder.class.getName());
     properties.put("metadata.broker.list", "192.168.1.154:9092");// 声明kafka broker
     *
     */
    public final static String ZOOKEEPER_CONNECT = "zookeeper.connect";
    public final static String METADATA_DROKER_LIST = "metadata.broker.list";
    public final static String AUTO_OFFSET_RESET = "auto.offset.reset";
    public final static String GROUP_ID="group.id";
    public final static String SERIALIZER_CLASS="serializer.class";

    private String zookeeperConnect;
    private String autoOffsetReset;
    private String groupId;
    private String serializerClass;
    private String metadataBrokerList;

    public String getZookeeperConnect() {
        return zookeeperConnect;
    }

    public void setZookeeperConnect(String zookeeperConnect) {
        this.zookeeperConnect = zookeeperConnect;
    }

    public String getAutoOffsetReset() {
        return autoOffsetReset;
    }

    public void setAutoOffsetReset(String autoOffsetReset) {
        this.autoOffsetReset = autoOffsetReset;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getSerializerClass() {
        return serializerClass;
    }

    public void setSerializerClass(String serializerClass) {
        this.serializerClass = serializerClass;
    }

    public String getMetadataBrokerList() {
        return metadataBrokerList;
    }

    public void setMetadataBrokerList(String metadataBrokerList) {
        this.metadataBrokerList = metadataBrokerList;
    }

    @Override
    public String toString() {
        return "JkafkaConfig{" +
                "zookeeperConnect='" + zookeeperConnect + '\'' +
                ", autoOffsetReset='" + autoOffsetReset + '\'' +
                ", groupId='" + groupId + '\'' +
                ", serializerClass='" + serializerClass + '\'' +
                ", metadataBrokerList='" + metadataBrokerList + '\'' +
                '}';
    }
}
