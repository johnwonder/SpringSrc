package com.john;

import org.junit.Test;
import org.springframework.util.DefaultPropertiesPersister;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/9/15
 */
public class PropertiesLoadTests {


	@Test
	public void propertiesPersisterWithReader() throws IOException {
		String propString = "code1=message1\ncode2:message2";
		Properties props = loadProperties(propString, true);

		String propString1 = "code1=message3\ncode2:message4";

		//todo code1 的值 被覆盖了 2020-09-15
		loadPropertiesAgain(props,propString1,true);

		System.out.println(props.getProperty("code1"));
	}

	private Properties loadProperties(String propString, boolean useReader) throws IOException {
		DefaultPropertiesPersister persister = new DefaultPropertiesPersister();
		Properties props = new Properties();
		if (useReader) {
			persister.load(props, new StringReader(propString));
		}
		else {
			persister.load(props, new ByteArrayInputStream(propString.getBytes()));
		}
		assertEquals("message1", props.getProperty("code1"));
		assertEquals("message2", props.getProperty("code2"));
		return props;
	}

	private Properties loadPropertiesAgain(Properties properties, String propString, boolean useReader) throws IOException {
		DefaultPropertiesPersister persister = new DefaultPropertiesPersister();

		if (useReader) {
			persister.load(properties, new StringReader(propString));
		}
		else {
			persister.load(properties, new ByteArrayInputStream(propString.getBytes()));
		}
		assertEquals("message1", properties.getProperty("code1"));
		assertEquals("message2", properties.getProperty("code2"));
		return properties;
	}
}
