package org.litespring.context.support;

import org.litespring.beans.factory.support.DefaultBeanfactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;
import org.litespring.core.io.FileSystemResource;
import org.litespring.core.io.Resource;

/**
 * Created by xuyihao on 2018/11/20 10:55
 */

public class FileSystemXmlApplicationContext extends  AbstractApplicationContext implements ApplicationContext {

    public FileSystemXmlApplicationContext(String configFile) {
        super(configFile);
    }

    protected Resource getResourceByPath(String path) {
        return new FileSystemResource(path);
    }
    String string;
}
