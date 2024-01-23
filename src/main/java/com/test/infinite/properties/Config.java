package com.test.infinite.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;
import org.testng.annotations.BeforeMethod;


import io.restassured.RestAssured;

public enum Config {

	INSTANCE;
	
	Properties prop = new Properties();
	protected static Logger log = Logger.getLogger(Config.class.getName());
	
	@BeforeMethod
	public void init() throws FileNotFoundException, IOException {
        try  {

        	String testConfigFile = new File(".").getCanonicalPath() + File.separator + "config" + File.separator + "qa" + File.separator + "test.properties";
    		
        	log.info("test properties loading.. " + testConfigFile);
			prop.load(new FileInputStream(testConfigFile));
    		RestAssured.baseURI = prop.getProperty("hostname");

        } catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Problem loading configurations : " + this.getClass().getName());
		}
	}	
}
