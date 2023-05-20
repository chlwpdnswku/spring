package com.jeun.persistance;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jeun.framwork.util.Criteria;
import com.jeun.mapper.BoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testList() {
		mapper.getPostList().forEach(vo->System.out.println(vo));
		
	}
	
	@Test
	public void testPaginglist() {
		System.out.println("PagingList");
		Criteria cri = new Criteria();
		mapper.getPagingList(cri).forEach(vo->System.out.println(vo));
	}
	

}
