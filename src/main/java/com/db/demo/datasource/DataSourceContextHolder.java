package com.db.demo.datasource;

public class DataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static synchronized void setDBType(String dbType){
        contextHolder.set(dbType);
    }

    public static String getDBType(){
        return contextHolder.get();
    }

    public static void clearDBType(){
        contextHolder.remove();
    }


}
