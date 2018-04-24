package com.juho.springmvctest.controller;

import com.juho.springmvctest.config.ControllerConfig;
import com.juho.springmvctest.model.MyUser;
import com.juho.springmvctest.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ControllerConfig.class})
public class UserControllerTest {

//    private MockMvc mockMvc;

    @Autowired
    private UserService userServiceMock;

    @Test
    public void findOne_GetUserForNo() {
        MyUser user01 = new MyUser();
        user01.setId(1);
        user01.setUsername("Test01");

        when(userServiceMock.findById(1)).thenReturn(user01);

//        mockMvc.perform(get("/user/get/no/{userNo}", 1))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(jsonPath("$.userNo", is(1)))
//                .andExpect(jsonPath("$.userName", is("Test01")));
    }
}
