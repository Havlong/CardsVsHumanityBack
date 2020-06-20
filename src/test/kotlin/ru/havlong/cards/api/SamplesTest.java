package ru.havlong.cards.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import ru.havlong.cards.BaseWebTest;
import ru.havlong.cards.api.controller.SamplesController;
import ru.havlong.cards.store.entity.Sample;
import ru.havlong.cards.store.repository.SampleRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SamplesController.class)
public class SamplesTest extends BaseWebTest {

    @Autowired
    private WebApplicationContext webapp;

    @Autowired
    private SampleRepository sampleRepository;

    private final Logger logger = LogManager.getLogger();

    private MockMvc mvc;

    private static boolean isDataSetup = false;

    private void initData() {

        for (int i = 0; i < 5; ++i) {
            sampleRepository.saveAndFlush(new Sample());
        }
    }

    @Before
    public void before() {

        mvc = super.before(this.webapp);

        if (!isDataSetup) {

            initData();

            isDataSetup = true;
        }
    }

    @Test
    public void shouldReturnSampleList() throws Exception {

        mvc.perform(get("/api/samples"))
                .andExpect(status().isOk());
    }
}