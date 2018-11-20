package org.litespring.beans.factory.config;

/**
 * Created by xuyihao on 2018/11/20 11:21
 */

public interface ConfigurableBeanFactory {
    void setBeanClassLoader(ClassLoader beanClassLoader);
    ClassLoader getBeanClassLoader();
}
