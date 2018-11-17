package org.litespring.beans.factory.support;

import org.litespring.beans.BeanDefinition;

/**
 * Created by xuyihao on 2018/11/7 17:09
 */

public interface BeanDefinitionRegistry {
    BeanDefinition getBeanDefinition(String beanID);
    void registerBeanDefinition(String beanID , BeanDefinition bd);
}
