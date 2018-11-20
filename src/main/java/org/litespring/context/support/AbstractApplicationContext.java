package org.litespring.context.support;

import org.litespring.beans.factory.support.DefaultBeanfactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;
import org.litespring.core.io.Resource;
import org.litespring.util.ClassUtils;

/**
 * Created by xuyihao on 2018/11/20 11:07
 */

public abstract  class AbstractApplicationContext implements ApplicationContext {
    private DefaultBeanfactory factory;
    private ClassLoader beanClassLoader;

    public AbstractApplicationContext(String configFile){
        factory=new DefaultBeanfactory();
        factory.setBeanClassLoader(this.getBeanClassLoader());
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
        Resource resource=this.getResourceByPath(configFile);
        reader.loadBeanDefinitions(resource);

    }

    public Object getBean(String beanID) {
        return factory.getBean(beanID);
    }

    protected abstract Resource getResourceByPath(String path);

    public ClassLoader getBeanClassLoader() {
        return (this.beanClassLoader!=null?this.beanClassLoader: ClassUtils.getDefaultClassLoader());
    }

    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.beanClassLoader = beanClassLoader;
    }
}
