package org.litespring.test.v1;

import static org.junit.Assert.*;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.beans.factory.support.DefaultBeanfactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.core.io.ClassPathResource;
import org.litespring.service.v1.PetStoreService;

public class BeanFactoryTest {

    DefaultBeanfactory factory = null;
    XmlBeanDefinitionReader reader = null;

    @Before
    public void setUp() {

        factory = new DefaultBeanfactory();

        reader = new XmlBeanDefinitionReader(factory);
    }

    @Test
    public void testGetBean() {

        reader.loadBeanDefinitions(new ClassPathResource("petStore-v1.xml"));

        BeanDefinition bd = factory.getBeanDefinition("petStore");



        assertEquals("org.litespring.service.v1.PetStoreService", bd.getBeanClassName());

        PetStoreService petStoreService = (PetStoreService) factory.getBean("petStore");

        assertNotNull(petStoreService);
    }

    @Test
    public void testInvalidBean() {

        reader.loadBeanDefinitions(new ClassPathResource("petStore-v1.xml"));
        try {
            factory.getBean("invalidBean");
        } catch (BeanCreationException e) {
            return;
        }

        Assert.fail("expect BeanCreation exception...");
    }

    @Test
    public void testInvalidXML() {
        try {

            reader.loadBeanDefinitions(new ClassPathResource("xxx-v1.xml"));
        } catch (Exception e) {
            return;
        }
        Assert.fail("expect BeanDefinitionStore exception ...");
    }


}
