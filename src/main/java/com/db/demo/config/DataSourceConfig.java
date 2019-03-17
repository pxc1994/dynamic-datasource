package com.db.demo.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.db.demo.datasource.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * @author allenpeng
 */

@Configuration
public class DataSourceConfig {


    @Value("${spring.datasource.master.url}")
    private String masterDBUrl;
    @Value("${spring.datasource.master.username}")
    private String masterDBUser;
    @Value("${spring.datasource.master.password}")
    private String masterDBPassword;
    @Value("${spring.datasource.master.driver-class-name}")
    private String masterDBDreiverName;

    @Bean
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = DynamicDataSource.getInstance();
        DruidDataSource masterDataSource = new DruidDataSource();
        masterDataSource.setDriverClassName(masterDBDreiverName);
        masterDataSource.setUrl(masterDBUrl);
        masterDataSource.setUsername(masterDBUser);
        masterDataSource.setPassword(masterDBPassword);
        Map<Object,Object> map = new HashMap<>();
        map.put("master", masterDataSource);
        dynamicDataSource.setTargetDataSources(map);
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource);
        return dynamicDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(
            @Qualifier("dynamicDataSource") DataSource dynamicDataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory)
            throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
