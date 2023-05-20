package com.jeun.mapper;

import java.util.List;

import com.jeun.domain.BoardVO;

public interface BoardMapper {
	
	public List<BoardVO> getPostList();
	
	public BoardVO searchPostId(int id);
	
	public int insert(BoardVO vo);
	

	public int update(BoardVO vo);
	
	
	public int delete(int id);
	
}
