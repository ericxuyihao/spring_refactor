package org.litespring.context.support;

import org.litespring.beans.factory.support.DefaultBeanfactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;
import org.litespring.core.io.ClassPathResource;
import org.litespring.core.io.Resource;

/**
 * Created by xuyihao on 2018/11/7 18:09
 */

public class ClassPathXmlApplicationContext extends AbstractApplicationContext  {

    public ClassPathXmlApplicationContext(String configFile) {
        super(configFile);
    }

    @Override
    protected Resource getResourceByPath(String path) {
        return new ClassPathResource(path,this.getBeanClassLoader());
    }
}
