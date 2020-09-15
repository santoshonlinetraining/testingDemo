package testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogTest {
	public Logger log = LogManager.getLogger(LogTest.class.getName());
	
	@Parameters({"username", "password"})
	@Test
	void testingLogs(String user, String pass) throws IOException {
		// debug, error, info and fatal
		/*log.debug("i am from debug");
		log.error("i am from error");
		log.info("i am from error");
		log.fatal("i am from error");*/
		
		System.out.println("==>"+user);
		
		System.out.println("==>"+pass);
		
	}
	
}
