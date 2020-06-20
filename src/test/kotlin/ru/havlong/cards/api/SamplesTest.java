package ru.havlong.cards.api;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import ru.havlong.cards.BaseWebTest;
import ru.havlong.cards.controllers.SamplesController;
import ru.havlong.cards.models.Sample;
import ru.havlong.cards.repositories.SampleRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SamplesController.class)
public class SamplesTest extends BaseWebTest {

    private static final int TEST_MODELS_COUNT = 5;
    private static final String TEST_PATH = "/api/samples";
    private static boolean isDataSetup = false;

    @Autowired
    private WebApplicationContext webapp;
    @Autowired
    private SampleRepository sampleRepository;
    private MockMvc mvc;

    private void initData() {

        for (int i = 0; i < TEST_MODELS_COUNT; ++i) {
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

        mvc.perform(get(TEST_PATH))
                .andExpect(status().isOk());
    }
}
