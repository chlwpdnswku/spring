package com.jeun.service;

import java.util.List;

import com.jeun.domain.BoardVO;

public interface BoardService {
	
	public List<BoardVO> getPostList();
	
	public BoardVO searchPostId(int id);
	
	public boolean insert(BoardVO vo);
	
	public boolean update(BoardVO vo);
	
	public boolean delete(int id);
	
	
	
}

