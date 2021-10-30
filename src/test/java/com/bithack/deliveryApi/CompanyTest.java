package com.bithack.deliveryApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CompanyTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getCompany() throws Exception{
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/api/companies").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        String content = result.getResponse().getContentAsString();
        assertThat(isJSONValid(content));
    }

    @Test
    public void testNoSuchCompanyException() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/api/companies/123124124").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }

    @Test
    public void testNotNumericFormatException() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/api/companies/SSSSS").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    public boolean isJSONValid(String test) {
        try {
            new JSONObject(test);
        } catch (JSONException ex) {
            // edited, to include @Arthur's comment
            // e.g. in case JSONArray is valid as well...
            try {
                new JSONArray(test);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }
}
