package com.john;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/9/13
 */
public class XmlDocumentTest {

	//https://www.cnblogs.com/564085446java/p/5197343.html
	//https://www.jianshu.com/p/f26fa567b3e6 Spring读取xml配置文件
	@Test
	public void testLoadXml() throws Exception {
		Resource resource = new ClassPathResource("datasource3.xml");

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

//		NodeList nodeList = root.getElementsByTagName("bean");
//
//		Node node0 = nodeList[0];

		//node0.getAttributes()
	}
}
