package com.jeun.controller;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })

public class BoardControllerTests {
	@Autowired
	private WebApplicationContext ctx;

	// 이게 그냥 브라우저 대용
	private MockMvc mockMvc;

	@Before
	public void setup() {

		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	@Test
	public void testList() throws Exception {

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/board/list");
		// 브라우저에서 클릭을 시키고
		// 정보 꺼내고 리턴하고 모델나오기
		// perform에 url을 만듦
		ModelMap modelMap = mockMvc.perform(builder).andReturn().getModelAndView().getModelMap();
		System.out.println(modelMap);
	}
	
	@Test
	public void testPagingList() throws Exception {

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/board/list").param("pageNum", "2").param("amount", "50");
		ModelMap modelMap = mockMvc.perform(builder).andReturn().getModelAndView().getModelMap();
		System.out.println(modelMap);
	}

//	@Test
//	public void testRegister() throws Exception {
//		
//		
//
//		ModelMap resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
//				.param("title", "테스트 새글 제목 ")
//				.param("content","new content")
//				.param("author", "user00")
//				
//		).andReturn().getModelAndView().getModelMap();
//		System.out.println(resultPage);
//	}
	//이런식으로테스트해야할듯 !
	@Test
	public void testGet() throws Exception{
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/board/get").param("id", "2");
		// 브라우저에서 클릭을 시키고
		
		ModelMap modelMap = mockMvc.perform(builder).andReturn().getModelAndView().getModelMap();
		System.out.println(modelMap);
	}
//		@Test
//		public void testUpdate() throws Exception{
//			MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/board/update").param("id", "1").param("title", "첫번째테스트 제목 ")
//					.param("content", "first content test change ").param("author", "first author change");
//			// 브라우저에서 클릭을 시키고
//			ModelMap modelMap = mockMvc.perform(builder).andReturn().getModelAndView().getModelMap();
//			System.out.println(modelMap);
//		}

		
	

}
