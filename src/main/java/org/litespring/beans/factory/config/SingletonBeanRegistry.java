package org.litespring.beans.factory.config;

/**
 * Created by xuyihao on 2018/11/20 14:19
 */

public interface SingletonBeanRegistry {
    void registerSingleton(String beanName,Object singletonObject);
    Object getSingleton(String beanName);
}
