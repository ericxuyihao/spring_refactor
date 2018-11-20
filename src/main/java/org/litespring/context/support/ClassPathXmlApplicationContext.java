package org.litespring.context.support;

import org.litespring.beans.factory.support.DefaultBeanfactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;
import org.litespring.core.io.ClassPathResource;
import org.litespring.core.io.Resource;

/**
 * Created by xuyihao on 2018/11/7 18:09
 */

public class ClassPathXmlApplicationContext implements ApplicationContext {
    private DefaultBeanfactory factory = null;

    public ClassPathXmlApplicationContext(String configFile) {
        factory = new DefaultBeanfactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource=new ClassPathResource(configFile);
        reader.loadBeanDefinitions(resource);
    }

    public Object getBean(String beanID) {
        return factory.getBean(beanID);
    }
}
