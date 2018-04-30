package com.juho.springmvctest.controller;

import com.juho.springmvctest.config.ControllerConfig;
import com.juho.springmvctest.model.MyUser;
import com.juho.springmvctest.service.UserService;
import com.juho.springmvctest.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {ControllerConfig.class})
public class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserServiceImpl userServiceMock;

    @Mock
    private UserController userControllerMock;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userControllerMock).build();
    }

    @Test
    public void findOne_GetUserForNo() throws Exception{
        MyUser user01 = new MyUser();
        user01.setId(1);
        user01.setUsername("Test01");

        when(userServiceMock.findById(1)).thenReturn(user01);

        mockMvc.perform(get("/user/get/no/{userNo}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
