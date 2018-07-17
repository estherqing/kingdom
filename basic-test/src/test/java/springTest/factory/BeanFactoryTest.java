package springTest.factory;


import com.esther.code.modules.aop.HelloWorld;
import org.junit.Assert;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
public class BeanFactoryTest {

	public static void main(String[] args) {
		ClassPathResource resource = new ClassPathResource("/config/spring-servlet.xml");
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);
		HelloWorld hw3 = (HelloWorld) factory.getBean("helloWorldImp1");
		hw3.printHelloWorld();
		/**
		ApplicationContext ctx = new FileSystemXmlApplicationContext("");
		HelloWorld hw1 = (HelloWorld) ctx.getBean("helloWorldImp1"); 
		hw1.printHelloWorld();
		System.out.println();
		hw1.doPrint();
		**/
		 
		//Assert.assertEquals(2, 3);
		String str = null;
		Assert.assertNotNull("str is not null",str);
	}

}
