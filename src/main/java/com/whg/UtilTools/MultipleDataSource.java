package com.whg.UtilTools;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource ;
//多数据源java实现


public class MultipleDataSource extends AbstractRoutingDataSource {

private static final ThreadLocal<String> dataSourceKey=new InheritableThreadLocal<String>();
public static void setDataSourceKey(String dataSource){
dataSourceKey.set(dataSource) ;
}

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }
}
