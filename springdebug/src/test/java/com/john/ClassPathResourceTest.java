package com.john;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;

/**
 * Unit test for simple App.
 */
public class ClassPathResourceTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

	@Test
	public void testResouce() {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		System.out.println(loader.getResource("").getPath());

		System.out.println(loader.getResource("datasource4.xml").getPath());
		System.out.println(loader.getResource("datasource3.xml").getPath());

		System.out.println(this.getClass().getResource("").getPath());
		System.out.println(this.getClass().getResource("/").getPath());

		System.out.println(System.getProperty("user.dir"));
	}

	@Test
	public void testClassPathResource() throws IOException {
		Resource res = new ClassPathResource("res/datasource.xml");
		InputStream input = res.getInputStream();
		Assert.assertNotNull(input);
	}

	@Test
	public void testClassPathResource1() throws IOException {
		Resource res = new ClassPathResource("res/datasource1.xml");
		InputStream input = res.getInputStream();
		Assert.assertNotNull(input);
	}

	@Test
	public void testClassPathResource2() throws IOException {
		Resource res = new ClassPathResource("resources/datasource2.xml");
		InputStream input = res.getInputStream();
		Assert.assertNotNull(input);
	}

	@Test
	public void testClassPathResource4() throws IOException {
		Resource res = new ClassPathResource("datasource4.xml");
		InputStream input = res.getInputStream();
		Assert.assertNotNull(input);
	}

	//https://www.cnblogs.com/deityjian/p/11447721.html
	@Test
	public void testClassPathResource3() throws IOException {
		Resource resource = new ClassPathResource("datasource3.xml");

		try {
			InputStream stream = resource.getInputStream();
			System.out.println(stream.available());
			BufferedReader br = new BufferedReader(new InputStreamReader(stream));

			StringBuilder sb = new StringBuilder();

			String line;

			while ((line = br.readLine()) != null)

			{

				sb.append(line);

			}

			System.out.println(sb.toString());

			System.out.println("\nDone!");

		}
		catch (IOException e){
			System.out.println(e);
		}
		//File file = res.getFile();
		InputStream input = resource.getInputStream();
		Assert.assertNotNull(input);
	}
}
