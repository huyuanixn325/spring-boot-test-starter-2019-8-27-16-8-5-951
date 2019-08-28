package com.oocl.web.sampleWebApp.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.web.sampleWebApp.model.User;
import net.minidev.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void should_return_list_when_given_mock_user() throws Exception {
        mockMvc.perform(get("/users")).andDo(print())
                .andExpect(content ().string("[{\"userName\":\"luna\"},{\"userName\":\"liuyinping\"}]"));
    }

    @Test
    public void should_return_201_given_post_request() throws Exception {

        
        MockHttpServletRequestBuilder requestBuilder = post("/users").
                content("{\"userName\":\"luna\"}")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        ResultActions perform = mockMvc.perform(requestBuilder);
        perform
                .andDo(print()).andExpect(status().isCreated());
    }
}