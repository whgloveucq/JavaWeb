package com.whg.controller;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.whg.UtilTools.MultipleDataSource;
import com.whg.service.DataBaseOne ;
import com.whg.service.DataBaseTwo ;
/*数据库连接自动切换AOP处理
Order 优先级设置到最高，因为在所有service方法调用前都必须把数据源确定
Order 数值小优先级越高*/
@Component
@Aspect
@Order(1)
public class MultipleDataSourceAspectAdvice {

    private static final Logger LOGGER=Logger.getLogger(MultipleDataSourceAspectAdvice.class);

    public MultipleDataSourceAspectAdvice(){

     LOGGER.info("MultipleDataSourceAspectAdvice 加载成功");
    }
    //定义切面
    @Pointcut("execution(* com.whg.service.*.*(..))")
    public void pointCut(){ }
    //dataSourceOneKey  dataSourceTwoKey  dataSourceThreeKey
    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint jp) throws Throwable {
        if(jp.getTarget() instanceof DataBaseOne ){
            LOGGER.debug("使用数据库连接：dataSourceOneKey");
            MultipleDataSource.setDataSourceKey("dataSourceOneKey");
        } else if(jp.getTarget() instanceof  DataBaseTwo){
            LOGGER.debug("使用数据库连接：dataSourceTwoKey");
            MultipleDataSource.setDataSourceKey("dataSourceTwoKey");

        }
        else {            // 默认是dataSourceOneKey
            LOGGER.debug("使用数据库链接：dataSourceOneKey");
            MultipleDataSource.setDataSourceKey("dataSourceOneKey");
        }        return jp.proceed();

    }



}
