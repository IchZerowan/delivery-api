package com.bithack.deliveryApi;
import com.bithack.deliveryApi.model.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import static org.hamcrest.Matchers.equalTo;
import net.minidev.json.parser.ParseException;
import org.json.JSONException;

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
public class OrderTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void putOrder() throws Exception{
        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/api/orders").content("{\"phoneNumber\":\"+380999999999\",\"clientName\":\"Ihor\",\"dishes\":[{\"dishId\":2,\"count\":2},{\"dishId\":3,\"count\":2}]}").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();
    }

    @Test
    public void getOrder() throws Exception{
        MvcResult putResult = mvc.perform(MockMvcRequestBuilders.post("/api/orders").content("{\"phoneNumber\":\"+380999999999\",\"clientName\":\"Ihor\",\"dishes\":[{\"dishId\":2,\"count\":2},{\"dishId\":3,\"count\":2}]}").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();
        MvcResult getResult = mvc.perform(MockMvcRequestBuilders.get("/api/orders/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void getNotExistOrder() throws  Exception{
        MvcResult getResult = mvc.perform(MockMvcRequestBuilders.get("/api/orders/200").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound()).andReturn();
    }

    @Test
    public void invalidCommandException() throws  Exception {
        MvcResult putResult = mvc.perform(MockMvcRequestBuilders.post("/api/orders").content("{\"phoneNumber\":\"+380999999999\",\"clientName\":\":[{\"dishId\":2,\"count\":2},{\"dishId\":3,\"count\":2}]}").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest()).andReturn();
    }

    @Test
    public void dupicateDishException() throws  Exception{
        MvcResult putResult = mvc.perform(MockMvcRequestBuilders.post("/api/orders").content("{\"phoneNumber\":\"+380999999999\",\"clientName\":\"Ihor\",\"dishes\":[{\"dishId\":2,\"count\":2},{\"dishId\":2,\"count\":2}]}").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest()).andExpect(content().string(equalTo("{\"status\":400,\"error\":\"Duplicate dish id found: 2\"}"))).andReturn();
    }

    @Test
    public void dishesFromDifferentCompaniesException() throws  Exception{
        MvcResult putResult = mvc.perform(MockMvcRequestBuilders.post("/api/orders").content("{\"phoneNumber\":\"+380999999999\",\"clientName\":\"Ihor\",\"dishes\":[{\"dishId\":1,\"count\":2},{\"dishId\":2,\"count\":2}]}").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest()).andExpect(content().string(equalTo("{\"status\":400,\"error\":\"Order should contain dishes from a single company, found dishes from companies 1 and 2\"}"))).andReturn();
    }

    @Test
    public void invalidDishException() throws  Exception{
        MvcResult putResult = mvc.perform(MockMvcRequestBuilders.post("/api/orders").content("{\"phoneNumber\":\"+380999999999\",\"clientName\":\"Ihor\",\"dishes\":[{\"dishId\":1,\"count\":2},{\"dishId\":200,\"count\":2}]}").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound()).andExpect(content().string(equalTo("{\"status\":404,\"error\":\"Couldn't find Dish with id 200\"}"))).andReturn();
    }

    @Test
    public void emptyDishesException() throws  Exception{
        MvcResult putResult = mvc.perform(MockMvcRequestBuilders.post("/api/orders").content("{\"phoneNumber\":\"+380999999999\",\"clientName\":\"Ihor\",\"dishes\":[]}").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest()).andExpect(content().string(equalTo("{\"status\":400,\"error\":\"The order is empty\"}"))).andReturn();
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
