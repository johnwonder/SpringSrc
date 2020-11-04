package com.john.javabase;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/4
 */
public class FileSystemClassLoader extends ClassLoader{

	private String directory;

	public FileSystemClassLoader(String directory) {
		this.directory = directory;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] clsBytes = getClassBytes(name);
		if(clsBytes == null)
		throw new ClassNotFoundException();
		return defineClass(name, clsBytes, 0, clsBytes.length);
	}

	private byte[] getClassBytes(String name) {
		String location = getClassLoc(name);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(location);
			byte[] buffer = new byte[4096];
			int readLen = 0;
			while( (readLen = fis.read(buffer)) != -1 ) {
				baos.write(buffer, 0, readLen);
			}
			baos.flush();
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	private String getClassLoc(String name) {
		return this.directory + File.separatorChar + name.replace('.', File.separatorChar) + ".class";
	}

}
