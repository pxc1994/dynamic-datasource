package com.db.demo.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author allenpeng
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static DynamicDataSource instance;

    private static byte[] lock=new byte[0];

    private static Map<Object,Object> dataSourceMap = new HashMap<Object, Object>();


    public void setTargetDataSources(Map<Object,Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);
        dataSourceMap.putAll(targetDataSources);
        super.afterPropertiesSet();
    }

    public Map<Object, Object> getDataSourceMap() {
        return dataSourceMap;
    }

    public static synchronized DynamicDataSource getInstance(){
        if(instance==null){
            synchronized (lock){
                if(instance==null){
                    instance=new DynamicDataSource();
                }
            }
        }
        return instance;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDBType();
    }
}
