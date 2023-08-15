package com.qa.gorest.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.qa.gorest.frameworkexception.APIFrameworkException;

public class ConfigurationManager {
	private Properties prop;
	private FileInputStream ip;
	
	
	
	
	public Properties initProp() {
		prop = new Properties();
		String envName =System.getProperty("env");
		try {
		if(envName==null) {
			System.out.println("no env is given ---hence running test on QA env...");
			ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
		}else {
			System.out.println("Runnning test on env...." + envName);
			
			switch (envName.toLowerCase()) {
			case "qa":
				ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
			break;
			case "dev":	
			ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
			break;
			case "stage":
			ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
			break;

			default:
				System.out.println("Please Pass the right env name..."+envName);
				throw new APIFrameworkException("NO ENV IS GIVEN");
				}
			}
		}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			
			}
		
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		return prop;
			
	}
	
}
