package com.bithack.deliveryApi;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

import net.minidev.json.parser.ParseException;

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
public class DishTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getDishes() throws Exception{
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/api/dishes?category_id=1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        String content = result.getResponse().getContentAsString();
        assertThat(isJSONValid(content));
        JSONParser parser = new JSONParser();
        JSONArray array = (JSONArray) parser.parse(content);
        JSONObject object = (JSONObject) array.get(0);

        MvcResult secondResult = mvc.perform(MockMvcRequestBuilders.get("/api/dishes/" + object.getAsString("id")).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void dishesFormatExceptionWhileGettingFromCategory() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/api/dishes?category_id=SSSS").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void dishesBadRequestExceptionWhileGettingFromCategory() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/api/dishes?some_command=1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void dishesFormatException() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/api/dishes/SSSSS").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void dishesNotFoundException() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/api/dishes/124").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    public boolean isJSONValid(String test) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray object = (JSONArray) parser.parse(test);
        }  catch (ParseException e) {
            // edited, to include @Arthur's comment
            // e.g. in case JSONArray is valid as well...
            try {
                JSONParser parser = new JSONParser();
                JSONArray array = (JSONArray) parser.parse(test);
            } catch (ParseException e1) {
                return false;
            }
        }
        return true;
    }
}
