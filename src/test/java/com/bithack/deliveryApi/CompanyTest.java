package com.bithack.deliveryApi;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class CompanyTest {
    @Autowired
    private MockMvc mvc;
    @Test
    public void getCompany() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/api/companies").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testNotExistingCompany() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/api/companies/123124124").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testNotNumericFormat() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/api/companies/SSSSS").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
