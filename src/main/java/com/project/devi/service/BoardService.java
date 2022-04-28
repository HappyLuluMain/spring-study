package com.project.devi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.devi.dao.BoardDao;
import com.project.devi.model.Board;

@Service
public class BoardService {
	
	private final BoardDao boardDao;
	
	@Autowired
	public BoardService(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	public Board findById(Long id) {
		
		return boardDao.findById(id);
	}
}
