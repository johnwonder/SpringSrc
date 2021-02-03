package org.wonder.frame.customBean;

import org.springframework.beans.factory.xml.DefaultNamespaceHandlerResolver;
import org.springframework.beans.factory.xml.NamespaceHandlerResolver;
import org.springframework.beans.factory.xml.PluggableSchemaResolver;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.xml.sax.InputSource;

import java.io.FileNotFoundException;
import java.io.IOException;

import static java.lang.String.format;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/1/25
 */
public class CustomXmlApplicationContext  extends AbstractXmlApplicationContext {

	private static final String CLASSNAME = CustomXmlApplicationContext.class.getSimpleName();
	private static final String FQ_PATH = "org/wonder/frame/customBean";

	private static final String NS_PROPS = format("%s/%s.properties", FQ_PATH, CLASSNAME);
	private static final String TEST_XSD = format("%s/%s.xsd", FQ_PATH, CLASSNAME);
	public CustomXmlApplicationContext(String... configLocations) {
		//AbstractRefreshableConfigApplicationContext的setConfigLocations方法
		setConfigLocations(configLocations);

	    refresh();
	}

	@Override
	protected void initBeanDefinitionReader(XmlBeanDefinitionReader reader) {
		super.initBeanDefinitionReader(reader);

		//1.指定resolver的 handlerMappingsLocation 就是 NamespaceHandler的 配置文件路径
		NamespaceHandlerResolver resolver = new DefaultNamespaceHandlerResolver(this.getClassLoader(), NS_PROPS);

		//2.设置resolver
		reader.setNamespaceHandlerResolver(resolver);
		//3.设置验证模式
		reader.setValidationMode(XmlBeanDefinitionReader.VALIDATION_XSD);
		//4.设置entityResolver
		reader.setEntityResolver(new CustomSchemaResolver());
	}

	private final class CustomSchemaResolver extends PluggableSchemaResolver {

		public CustomSchemaResolver() {
			super(CustomXmlApplicationContext.this.getClassLoader());
		}

		@Override
		public InputSource resolveEntity(String publicId, String systemId) throws IOException {
			InputSource source = super.resolveEntity(publicId, systemId);
			if (source == null) {
				try{
					//todo 指定了xsd路径
					Resource resource = new ClassPathResource(TEST_XSD);
					source = new InputSource(resource.getInputStream());
					source.setPublicId(publicId);
					source.setSystemId(systemId);
					return source;
				}
				catch (FileNotFoundException ex){

				}

			}
			return  null;

		}
	}
}
