package com.cu.tools.jclickhouseclient;

public interface Client {
    Client Instance(ConnectConfig connectConfig);
    void close(AutoCloseable... closeables);
    boolean insert(String sql,String ...params);
    boolean delete(String sql,String ...params);
}
