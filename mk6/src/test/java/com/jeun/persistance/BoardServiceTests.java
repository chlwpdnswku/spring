package com.jeun.persistance;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jeun.domain.BoardVO;
import com.jeun.framwork.util.Criteria;
import com.jeun.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardServiceTests {

	@Autowired
	private BoardService service;
	
	@Test
	public void testExist() {
		System.out.println("paging start");
		service.getPagingList(new Criteria(1,10)).forEach(vo->System.out.println(vo));
	}
	
	@Test 
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("new Title");
		board.setContent("hihihi");
		board.setAuthor("chlwdn");
		
		service.insert(board);
		System.out.println("new board service Tests" + board.getId());
	}
	
	
	
	
////	update 2~3번사이 
//	@Test
//	public void testUpdate() {
//		BoardVO vo = new BoardVO();
////		vo.setId(2);
//		vo.setTitle("2번째 title test");
//		vo.setContent("hihihihihi");
//		vo.setUpdateDate(new Date());
//		service.update(vo);
//
//	}
}
