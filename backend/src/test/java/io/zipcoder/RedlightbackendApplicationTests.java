package io.zipcoder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zipcoder.RedlightbackendApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RedlightbackendApplication.class)
@WebAppConfiguration
public class RedlightbackendApplicationTests {

	@Test
	public void contextLoads() {
	}

}
