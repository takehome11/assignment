package com.test.infinite.base;
import java.io.IOException;
import java.util.logging.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.test.infinite.properties.Config;

public class BaseTest {
	
	protected static Logger log = Logger.getLogger(BaseTest.class.getName());

	@BeforeTest
	public void setup() {
		try {
			log.info("test execution started..");
			Config.INSTANCE.init();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown() {
		log.info("test execution finished");

	}

}
