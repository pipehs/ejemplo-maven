package com.devopsusach2020;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DevOpsUsach2020ApplicationTests {

	@Test
	void contextLoads() {
		assertThat(DevOpsUsach2020Application.main()).isNull();  // Fest assertion
	}

}
