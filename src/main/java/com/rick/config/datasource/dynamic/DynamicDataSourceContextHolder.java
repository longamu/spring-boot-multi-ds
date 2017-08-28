package com.rick.config.datasource.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc :  动态数据源上下文
 * User : RICK
 * Time : 2017/8/28 10:15
  */

public class DynamicDataSourceContextHolder {
    /*
    * 当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供独立的变量副本，
    * 所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
    */
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /*
     * 管理所有的数据源id;
     * 主要是为了判断数据源是否存在;
     */
    public static List<String> dataSourceIds = new ArrayList<>();


    /**
     * 使用setDataSourceType设置当前的
     * @param dataSourceType
     */
    public static void setDataSourceType(String dataSourceType){
        contextHolder.set(dataSourceType);
    }


    /**
     * Desc : 获取当前线程中的数据源
     * User : RICK
     * Time : 2017/8/28 10:21
      */
    public static String getDataSourceType(){
        return contextHolder.get();
    }


    /**
     * Desc :  删除当前线程池中的数据源
     * User : RICK
     * Time : 2017/8/28 10:22
      */
    public static void clearDataSourceType(){
        contextHolder.remove();
    }

/**
 * Desc :  
 * User : RICK 
 * Time : 2017/8/28 10:22
  */

    public static boolean containsDataSource(String dataSourceId){
        return dataSourceIds.contains(dataSourceId);
    }




}
