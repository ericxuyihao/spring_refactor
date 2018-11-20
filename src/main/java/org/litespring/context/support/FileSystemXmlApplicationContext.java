package org.litespring.context.support;

import org.litespring.beans.factory.support.DefaultBeanfactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;
import org.litespring.core.io.FileSystemResource;
import org.litespring.core.io.Resource;

/**
 * Created by xuyihao on 2018/11/20 10:55
 */

public class FileSystemXmlApplicationContext implements ApplicationContext {
    private DefaultBeanfactory factory=null;

    public FileSystemXmlApplicationContext(String configFile) {
        factory=new DefaultBeanfactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
        Resource resource=new FileSystemResource(configFile);
        reader.loadBeanDefinitions(resource);
    }

    public Object getBean(String beanID) {
        return this.factory.getBean(beanID);
    }
}
