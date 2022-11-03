package me.mocadev.mocadevprojectboard.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-11-04
 **/
@DisplayName("Data Rest - API Test")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTest {

	private final MockMvc mockMvc;

	public DataRestTest(@Autowired MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}

	@Test
	void test() throws Exception {
		mockMvc.perform(get("/articles"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
			.andDo(print());
	}
}
