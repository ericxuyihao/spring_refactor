package org.litespring.context.support;

import org.litespring.beans.factory.support.DefaultBeanfactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;

/**
 * Created by xuyihao on 2018/11/7 18:09
 */

public class ClassPathXmlApplicationContext implements ApplicationContext {
    private DefaultBeanfactory factory = null;

    public ClassPathXmlApplicationContext(String configFile) {
        factory = new DefaultBeanfactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(configFile);
    }

    public Object getBean(String beanID) {
        return factory.getBean(beanID);
    }
}
