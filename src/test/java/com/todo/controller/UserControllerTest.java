package com.todo.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.google.gson.Gson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo.dto.LoginDTO;
import com.todo.dto.UserDTO;
import com.todo.service.User.UserServiceImpl;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    UserServiceImpl userService;


    /** 정상 유저 템플릿 */
    private UserDTO defaultUserDTO = UserDTO.builder().uid(0).username("user").email("user@naver.com").password("pass").affiliation(null).build();

    /** 테스트용 유저 리스트 */
    private UserDTO userDTO1 = UserDTO.builder().uid(1).username("user1").email("user1@naver.com").password("pass1").affiliation(1L).build();
    private UserDTO userDTO2 = UserDTO.builder().uid(2).username("user2").email("user2@naver.com").password("pass2").affiliation(2L).build();
    private UserDTO userDTO3 = UserDTO.builder().uid(3).username("user3").email("user3@naver.com").password("pass3").affiliation(3L).build();

    /**잘못된 회원가입 요청 */
    private UserDTO noUsernameInput = UserDTO.builder().uid(0).email("user@naver.com").password("user").build();
    private UserDTO noEmailInput = UserDTO.builder().uid(0).username("user").password("user").build();
    private UserDTO noPasswordInput = UserDTO.builder().uid(0).username("user").email("user@naver.com").build();

    private LoginDTO correctLoginDTO = LoginDTO.builder().email("user@naver.com").password("pass").build();

    // private LoginDTO notUserLoginDTO = LoginDTO.builder().email("notUser@naver.com").password("pass").build();
    // private LoginDTO wrongPasswordLoginDTO = LoginDTO.builder().email("user@naver.com").password("wrongPassword").build();

    @Test
    @DisplayName("유저 받아오기 테스트")
    void getUserTest() throws Exception {

        /** 조회될 유저 리스트 생성 */
        List<UserDTO> userList = new ArrayList<>();

        userList.add(userDTO1);
        userList.add(userDTO2);
        userList.add(userDTO3);
        

        given(userService.inquireUser()).willReturn(userList);

        mockMvc.perform(
            get("/user/list"))
            .andExpect(status().isOk())
            .andDo(print());


        verify(userService).inquireUser();
        
    }

    @Test
    @DisplayName("회원가입 성공 테스트")
    void joinSucceedTest() throws Exception {
        
        given(userService.join("user", "user@naver.com", "pass")).willReturn("success");

        Gson gson = new Gson();

        String content = gson.toJson(defaultUserDTO);

        /** 정상적인 회원가입 요청 */
        mockMvc.perform(
            post("/user/signup").content(content)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(print());

        verify(userService).join("user", "user@naver.com", "pass");        
    }

    @Test
    @DisplayName("회원가입 실패 테스트")
    void joinFailTest() throws Exception {

        Gson gson = new Gson();

        String noUsernameContent = gson.toJson(noUsernameInput);

        String noEmailContent = gson.toJson(noEmailInput);

        String noPasswordContent = gson.toJson(noPasswordInput);

        String emptyContent = gson.toJson(new UserDTO());
        
        /** 유저 이름이 존재하지 않는 경우 */
        mockMvc.perform(
            post("/user/signup").content(noUsernameContent)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest())
            .andDo(print());

        /** 이메일이 존재하지 않는 경우 */
        mockMvc.perform(
            post("/user/signup").content(noEmailContent)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest())
            .andDo(print());

        /** 비밀번호가 존재하지 않는 경우 */
        mockMvc.perform(
            post("/user/signup").content(noPasswordContent)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest())
            .andDo(print());

        /** 텅빈 값이 온 경우 */
        mockMvc.perform(
            post("/user/signup").content(emptyContent)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest())
            .andDo(print());

    }

    @Test
    @DisplayName("로그인 정보 전달 테스트")
    void loginSucceed() throws Exception {

        given(userService.login("user@naver.com", "pass")).willReturn(defaultUserDTO);

        Gson gson = new Gson();

        String content = gson.toJson(correctLoginDTO);

        /** 정상적인 로그인 요청 */
        mockMvc.perform(
            post("/user/login").content(content)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(print());

        verify(userService).login("user@naver.com", "pass");        

    }

}
