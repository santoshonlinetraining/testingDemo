package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties prop;
		FileInputStream fis;
		
		prop = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Config\\config.properties");
		
		//load the file using below command
		prop.load(fis);
		
		System.out.println("username is : "+prop.getProperty("username"));
		System.out.println("password is : "+prop.getProperty("password"));
		
	}

}

