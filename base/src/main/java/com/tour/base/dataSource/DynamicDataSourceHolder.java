package com.tour.base.dataSource;

public class DynamicDataSourceHolder {

    private static final ThreadLocal<String> local = new ThreadLocal<>();

    public static void change2Read() {
        local.set(DataSourceType.read.getType());
    }

    public static void change2Write() {
        local.set(DataSourceType.write.getType());
    }

    public static String getDataSourceType() {
        return local.get();
    }
}
