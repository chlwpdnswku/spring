package com.jeun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jeun.domain.BoardVO;
import com.jeun.framwork.util.Criteria;
import com.jeun.framwork.util.PageDTO;
import com.jeun.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	// Service로 연결해줌
	@Autowired
	private BoardService service;

	// 목록처리 L
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		System.out.println("list & paging");
//		model.addAttribute("boardlist", service.getPostList());
		model.addAttribute("boardlist", service.getPagingList(cri));
		
		model.addAttribute("pageMake", new PageDTO(100,cri));

	}

	// 조회처리 R
	// 이름이 같을 때 RequestParam을 안해도됨 getMapping이 get 이고 void return 이 get이어야함
	// 그리고 Long으로선언해줘야 오류안걸리고 잘된다 왜지?
	//http://localhost:8080/board/showDetail?id=1 이렇게 넣어줘야 값이 들어가서 api를 보여주지 
	
	@GetMapping({ "/showDetail", "/updateBoard" })
	// 화면에다가 뿌려줘야됨
	public void get(Long id, Model model) {
		// 그다음에 서비스 출격io
//		System.out.println("")
		model.addAttribute("single", service.searchPostId(id));
		
		

	}

	@GetMapping("/boardreg")
	public void boardreg() {

	}

	// 등록처리 C
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {

		System.out.println("register");
		service.insert(board);
		rttr.addFlashAttribute("result", board.getId());

		return "redirect:/board/list";
	}

	// 수정처리 U
	@PostMapping("/update")
	public String update(BoardVO board, RedirectAttributes rttr) {
		System.out.println("update");
		if (service.update(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	//D 삭제 처리 
	@PostMapping("delete")
	public String delete(int id, RedirectAttributes rttr) {
		// 입력이 되면 리다이렉트를함
		if (service.delete(id)) {
			// 식별자를 던져줌 -> 몇번째 게시물 등록이 됬음?
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
}
