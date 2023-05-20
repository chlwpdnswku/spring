package com.jeun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jeun.domain.BoardVO;
import com.jeun.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	//Service로 연결해줌 
	@Autowired
	private BoardService service;

	
	//목록처리  L
	@GetMapping("/list")
	public void list(Model model) {
		System.out.println("list");
		model.addAttribute("boardlist",service.getPostList());
		
	}
	
	
	//등록처리  C 
	@PostMapping("/register")
	public String register(BoardVO board,RedirectAttributes rttr) {
		
		System.out.println("register");
		service.insert(board);
		rttr.addFlashAttribute("result",board.getId());
		
		return "redirect:/board/list";
	}
	//조회처리 R
	@GetMapping("/get")
	public void get(int id,Model model) {
		System.out.println("get");
		model.addAttribute("board", service.searchPostId(id));
		
	}
	
	//수정처리 U 
	@PostMapping("/update")
	public String update(BoardVO board,RedirectAttributes rttr)
	{
		
		System.out.println("update");
		if(service.update(board)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
}
