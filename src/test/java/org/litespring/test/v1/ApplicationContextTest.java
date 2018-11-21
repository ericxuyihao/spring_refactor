package org.litespring.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.context.ApplicationContext;
import org.litespring.context.support.ClassPathXmlApplicationContext;
import org.litespring.context.support.FileSystemXmlApplicationContext;
import org.litespring.service.v1.PetStoreService;

/**
 * Created by xuyihao on 2018/11/7 18:01
 */

public class ApplicationContextTest {

    @Test
    public void testGetBean(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("petstore-v1.xml");

        PetStoreService petStoreService= (PetStoreService) ((ClassPathXmlApplicationContext) ctx).getBean("petStore");
        Assert.assertNotNull(petStoreService);
    }

    @Test
    public void testGetBeanFromFileSystemContext(){
            ApplicationContext ctx=new FileSystemXmlApplicationContext("D:\\gitHub\\spring_refactor\\src\\test\\resources\\petstore-v1.xml");
            PetStoreService petStore=(PetStoreService) ((FileSystemXmlApplicationContext) ctx).getBean("petStore");
            Assert.assertNotNull(petStore);
    }



}
