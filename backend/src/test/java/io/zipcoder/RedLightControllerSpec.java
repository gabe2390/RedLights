package io.zipcoder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import zipcoder.RedlightbackendApplication;
import zipcoder.models.RedLightDAO;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ghumphrey on 11/9/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= RedlightbackendApplication.class)
@WebAppConfiguration
public class RedLightControllerSpec {

    private MockMvc mvc;
    @Autowired
    private RedLightDAO redLightDAO;
    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp(){
       this.mvc= MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testReadCamera() throws Exception {
        this.mvc.perform(get("/camera"))
                .andExpect(status().isOk());

    }
}

