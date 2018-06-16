package org.litespring.beans.factory.support;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.util.ClassUtils;

public class Defaultbeanfactory implements BeanFactory {

	public static final String ID_ATTRIBUTE="id";
	public static final String CLASS_ATTRIBUTE="class";
	private final Map<String,BeanDefinition> beanDefinitionMap=
			new ConcurrentHashMap<String, BeanDefinition>() ;

	public Defaultbeanfactory(String configFile) {
		loadBeanDefinition(configFile);
		
	}

	private void loadBeanDefinition(String configFile) {
		InputStream is=null;
		try {
			ClassLoader cl=ClassUtils.getDefaultClassLoader();
			is=cl.getResourceAsStream(configFile);
			SAXReader reader=new SAXReader();
			Document doc=reader.read(is);
			Element root=doc.getRootElement();//<beans>
			Iterator<Element> iter=root.elementIterator();
			while(iter.hasNext()){
				Element ele=(Element)iter.next();
				String id=ele.attributeValue(ID_ATTRIBUTE);
				String beanClassName=ele.attributeValue(CLASS_ATTRIBUTE);
				BeanDefinition bd=new GenericBeanDefinition(id,beanClassName);
				this.beanDefinitionMap.put(id,bd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(is!=null){
				try{
					is.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		
	}


	

	public Object getBean(String beanID) {
		BeanDefinition bd=this.getBeanDefinition(beanID);
		if(bd==null){
			return null;
		}
		ClassLoader cl=ClassUtils.getDefaultClassLoader();
		String beanClassName=bd.getBeanClassName();
		try {
			Class<?> clz=cl.loadClass(beanClassName);
			// �޲ι��캯����������
			return clz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		}catch (InstantiationException e) {
			e.printStackTrace();
			// TODO: handle exception
		}catch (IllegalAccessException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	public BeanDefinition getBeanFactoryDefiniton(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public BeanDefinition getBeanDefinition(String beanID) {
		
		return this.beanDefinitionMap.get(beanID);
	}

	
	
}
