package com.jeun.mapper;

import java.util.List;

import com.jeun.domain.BoardVO;
import com.jeun.framwork.util.Criteria;

public interface BoardMapper {
	
	public List<BoardVO> getPostList();
	

	public BoardVO searchPostId(Long id);
	
	public int insert(BoardVO vo);

	public int update(BoardVO vo);
	
	public int delete(int id);
	
	
	//paging
	public List<BoardVO> getPagingList(Criteria cri);
	
}
