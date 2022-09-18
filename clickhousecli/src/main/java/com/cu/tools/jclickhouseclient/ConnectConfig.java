package com.cu.tools.jclickhouseclient;

public class ConnectConfig {
    public static final String DRIVER = "ru.yandex.clickhouse.ClickHouseDriver";
    private String driverName;
    private String url;
    private String user;
    private String pw;

    public ConnectConfig(String driverName, String url, String user, String pw) {
        this.driverName = driverName;
        this.url = url;
        this.user = user;
        this.pw = pw;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPw() {
        return pw;
    }
}
