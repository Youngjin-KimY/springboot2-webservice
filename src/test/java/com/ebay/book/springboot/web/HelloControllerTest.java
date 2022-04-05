package com.ebay.book.springboot.web;

import com.ebay.book.springboot.domain.user.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
@ActiveProfiles("test")
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void helloWiilBeReturned() throws Exception {
        String ExpectedString = "hi";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(ExpectedString));
    }

    @Test
    public void helloDtoWillBeReturned() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                .param("name",name)
                .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));

    }

    @Test
    public void test() {
        System.out.println(Role.USER.name());
    }
}
