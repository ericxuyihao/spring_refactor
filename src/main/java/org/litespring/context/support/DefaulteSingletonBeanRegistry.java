package org.litespring.context.support;

import org.litespring.beans.factory.config.SingletonBeanRegistry;
import org.litespring.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xuyihao on 2018/11/20 14:22
 */

public class DefaulteSingletonBeanRegistry implements SingletonBeanRegistry {

    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>(64);

    public void registerSingleton(String beanName, Object singletonObject) {
        Assert.notNull(beanName, "beanName must not be null");
        Object oldObject = singletonObjects.get(beanName);
        if (oldObject != null) {
            throw new IllegalStateException("could not register  ");
        }
        this.singletonObjects.put(beanName, singletonObject);
    }

    public Object getSingleton(String beanName) {

        return this.singletonObjects.get(beanName);
    }
}
