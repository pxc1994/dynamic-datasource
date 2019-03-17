package com.db.demo.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.db.demo.datasource.DataSourceContextHolder;
import com.db.demo.mapper.DBMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author allenpeng
 */
@Component
@Aspect
public class HandleAop {

    @Resource
    private DBMapper dbMapper;

    //拦截注解的方法
    @Pointcut("@annotation(com.db.demo.annotation.Check)")
    void servicePointCut(){}

    @Before("servicePointCut()")
    public void doBefore(JoinPoint joinPoint){
        String json = JSONObject.toJSONString(joinPoint.getArgs()[0]);
        JSONObject obj = JSON.parseObject(json);
        String brand = (String)obj.get("brand");
        //对应的数据源
        DataSourceContextHolder.setDBType(brand.toUpperCase());
    }

    @After("servicePointCut()")
    public void doAfter(){
        DataSourceContextHolder.clearDBType();
    }
}
