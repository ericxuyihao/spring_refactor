package org.litespring.beans.factory.support;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.beans.factory.config.ConfigurableBeanFactory;
import org.litespring.context.support.DefaulteSingletonBeanRegistry;
import org.litespring.util.ClassUtils;

public class DefaultBeanfactory extends DefaulteSingletonBeanRegistry implements ConfigurableBeanFactory,BeanDefinitionRegistry{
    private static final String ID_ATTRIBUTE = "id";
    private static final String CLASS_ATTRIBUTE = "class";
    private final Map<String,BeanDefinition> beanDefinitionMap=
            new ConcurrentHashMap<String, BeanDefinition>();
    private ClassLoader beanClassLoader;


    public DefaultBeanfactory() {

    }

    public void registerBeanDefinition (String beanID, BeanDefinition bd){
        this.beanDefinitionMap.put(beanID,bd);
    }

    public BeanDefinition getBeanDefinition(String beanID){
        return this.beanDefinitionMap.get(beanID);
    }

    public Object getBean(String beanID) {
        BeanDefinition bd=this.getBeanDefinition(beanID);
        if(bd==null){
            return  null;
        }
        if(bd.isSigleton()){
            Object bean=this.getSingleton(beanID);
            if(bean==null){
                bean=createBean(bd);
                this.registerSingleton(beanID,bean);
            }
            return bean;
        }
        return createBean(bd);
    }

    private Object createBean(BeanDefinition bd) {
        ClassLoader cl=this.getBeanClassLoader();
        String beanClassName=bd.getBeanClassName();
        try {
            Class<?> clz=cl.loadClass(beanClassName);
            return clz.newInstance();
        } catch (Exception e) {
            throw new BeanCreationException("create error");
        }
    }


    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.beanClassLoader=beanClassLoader;
    }

    public ClassLoader getBeanClassLoader() {
        return (this.beanClassLoader!=null?this.beanClassLoader:ClassUtils.getDefaultClassLoader());
    }
}
