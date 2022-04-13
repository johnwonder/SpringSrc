package com.john.beanFactory;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/9/11
 */
public class XmlBeanFactoryDemo {

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

//		Resource resource =new ClassPathResource("spring/spring-config-xmlfactory.xml");
//		XmlBeanFactory xmlBeanFactory =new XmlBeanFactory(resource);
//
//		System.out.println(xmlBeanFactory.getBean("export"));

		Resource resource = new ClassPathResource("spring/spring-config-xmlfactory.xml");

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder docBuilder = factory.newDocumentBuilder();

		Document doc=docBuilder.parse(resource.getInputStream());

		Element root=doc.getDocumentElement();


		//DefaultBeanDefinitionDocumentReader 读取Bean节点
		NodeList nl = root.getChildNodes();

		for (int i = 0; i < nl.getLength(); i++) {
			Node node = nl.item(i);
			if (node instanceof Element) {
				Element ele = (Element) node;

				System.out.println(ele.getAttribute("id"));
			}
		}

	}
}
