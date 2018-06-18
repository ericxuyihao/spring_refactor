package org.litespring.test.v1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.beans.factory.support.DefaultBeanfactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.core.io.ClassPathResource;
import org.litespring.service.v1.PetStoreService;

public class BeanFactoryTest {
	DefaultBeanfactory factory=null;
	XmlBeanDefinitionReader reader=null;
	@Before
	public void setUP(){
		factory=new DefaultBeanfactory();
		reader=new XmlBeanDefinitionReader(factory);
	}
	
	@Test
	public void testGetBean() {
		
		reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
		BeanDefinition bd=factory.getBeanDefinition("petStore");
		assertTrue(bd.isSingleton());
		assertFalse(bd.isPrototype());
		assertEquals(BeanDefinition.SCOPE_DEFAULT, bd.getScope());
		assertEquals("org.litespring.service.v1.PetStoreService",
				bd.getBeanClassName());
		PetStoreService petStore=(PetStoreService)factory.getBean("petStore");
		assertNotNull(petStore);
		PetStoreService petStore1=(PetStoreService)factory.getBean("petStore");

		assertTrue(petStore1.equals(petStore));
	}
	
	@Test
	public void testInvalidBean(){
		reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
		try {
			factory.getBean("invalidBean");
		} catch (BeanCreationException e) {
			return;
		}
		Assert.fail("expect BeanCreationException");
	}
	
	@Test
	public void testInvalidXML(){
		try {
			reader.loadBeanDefinitions(new ClassPathResource("pets.xml"));
		} catch (BeanDefinitionStoreException e) {
			return;
		}
		Assert.fail("except BeanDefinitionStoreException");
	}

}
