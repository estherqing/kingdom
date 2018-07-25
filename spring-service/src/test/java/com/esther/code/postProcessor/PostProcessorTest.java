package com.esther.code.postProcessor;

import org.junit.Test;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

/**
 * @author esther
 * 2018-07-24 19:21
 * $DESCRIPTION}
 */

public class PostProcessorTest {
    static XmlBeanFactory beanFactory = null;

    static {
        beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
    }

    @Test
    public void test() {
        // PropertyPlaceholderConfigurer是一种BeanFactoryPostProcessor，在BeanFactory构造出来之后，对BeanFactory做修改。
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocation(new ClassPathResource("book.properties"));
        propertyPlaceholderConfigurer.postProcessBeanFactory(beanFactory);

        Book book = (Book) beanFactory.getBean("book");
        System.out.println(book);
    }
}
