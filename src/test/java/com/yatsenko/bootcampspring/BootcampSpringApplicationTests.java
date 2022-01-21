package com.yatsenko.bootcampspring;

import com.yatsenko.bootcampspring.entity.Cat;
import com.yatsenko.bootcampspring.repository.CatRepository;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails
class BootcampSpringApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CatRepository catRepository;

    @BeforeEach
    public void before() {
        Stream.of("Felix", "Garfield", "Whiskers").forEach(
                c -> catRepository.save(new Cat(c)));
    }

    @SneakyThrows
    @Test
    void catsReflectedInRead() {
        MediaType halJson = MediaType.parseMediaType("application/hal+json");
        StringBuilder contentAsString = new StringBuilder();
        this.mockMvc
                .perform(get("/cats"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(halJson))
                .andExpect(
                        mvcResult -> contentAsString.append(mvcResult.getResponse().getContentAsString()));
        System.out.println(contentAsString);
    }
}

