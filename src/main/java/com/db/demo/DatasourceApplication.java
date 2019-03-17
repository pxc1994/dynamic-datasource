package com.db.demo;

import com.alibaba.druid.pool.DruidDataSource;
import com.db.demo.datasource.DynamicDataSource;
import com.db.demo.domain.DBInfo;
import com.db.demo.mapper.DBMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class DatasourceApplication implements CommandLineRunner {


    public static void main(String[] args) {SpringApplication.run(DatasourceApplication.class, args); }

    @Resource
    private DBMapper dbMapper;

    @Override
    public void run(String... args) throws Exception {
        List<DBInfo> list = dbMapper.dbList();
        Map<Object, Object> dataSourceMap = DynamicDataSource.getInstance().getDataSourceMap();

        for(DBInfo info : list){
            DruidDataSource source = new DruidDataSource();
            source.setDriverClassName(info.getDriver());
            source.setUrl(info.getUrl());
            source.setUsername(info.getUsername());
            source.setPassword(info.getPassword());
            dataSourceMap.put(info.getBrand().toUpperCase(),source);
        }
        DynamicDataSource.getInstance().setTargetDataSources(dataSourceMap);
    }
}
