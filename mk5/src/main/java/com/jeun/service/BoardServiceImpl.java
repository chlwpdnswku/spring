package com.jeun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeun.domain.BoardVO;
import com.jeun.mapper.BoardMapper;

import lombok.Getter;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
//	@Getter
	private BoardMapper mapper;

	public List<BoardVO> getPostList() {
		// TODO Auto-generated method stub
		return mapper.getPostList();
	}

	public BoardVO searchPostId(int id) {
		// TODO Auto-generated method stub
		return mapper.searchPostId(id);
	}

	// int : affected row count
	public boolean insert(BoardVO vo) {
		return mapper.insert(vo) == 1;
	}

	public boolean update(BoardVO vo) {
		return mapper.update(vo) <= 1;
	}

	public boolean delete(int id) {
		return mapper.delete(id) <= 1;
	}

}
