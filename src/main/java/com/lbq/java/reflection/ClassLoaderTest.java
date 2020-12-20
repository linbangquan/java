package com.lbq.java.reflection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

/**
 * 了解类的加载器
 * @author 14378
 *
 */
public class ClassLoaderTest {

	@Test
	public void test1() {
		//对于自定义类，使用系统类加载器进行加载
		ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
		System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@6d06d69c
		//调用系统类加载器的getParent():获取扩展类加载器
		ClassLoader classLoader1 = classLoader.getParent();
		System.out.println(classLoader1);//sun.misc.Launcher$ExtClassLoader@7f31245a
		//调用扩展类加载器的getParent():无法获取引导类加载器
		//引导类加载器主要负责加载java的核心类库，无法加载自定义类的。
		ClassLoader classLoader2 = classLoader1.getParent();
		System.out.println(classLoader2);//null
		
		ClassLoader classLoader3 = String.class.getClassLoader();
		System.out.println(classLoader3);//null
	}
	
	/**
	 * Properties: 用来读取配置文件。
	 * @throws IOException 
	 */
	@Test
	public void test2() throws IOException {
		Properties pros = new Properties();
		//此时的文件默认在当前的module下。
		//读取配置文件的方式一：
//		FileInputStream fis = new FileInputStream("D:/DevInstall/test/java/jdbc1.properties");
//		FileInputStream fis = new FileInputStream("src/jdbc2.properties");
		File file = new File("jdbc3.properties");
		if(!file.exists()) {
			file.createNewFile();
		}
		System.out.println(file.getAbsolutePath());//D:\DevInstall\test\java\jdbc3.properties
		FileInputStream fis = new FileInputStream("jdbc1.properties");
		pros.load(fis);
		
		//读取配置文件的方式二：使用ClassLoader
		//配置文件默认识别为：当前module的src下
//		ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
//		InputStream is = classLoader.getResourceAsStream("jdbc.properties");//jdbc.properties在根目录
//		pros.load(is);
		
		String user = pros.getProperty("user");
		String password = pros.getProperty("password");
		System.out.println("user=" + user + ", password=" + password);
		
		//放在src/main/resources目录下的jdbc.properties文件，打包后，在jar的根目录，与com同级
	}
}