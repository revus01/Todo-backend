package com.todo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class TodoApplicationTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	void contextLoads() {
		logger.debug("[DEBUG]");
		logger.info("[INFO]");
		logger.warn("[WARN]");
		logger.error("[ERROR]");
	}

}
