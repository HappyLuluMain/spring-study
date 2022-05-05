package com.project.devi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.devi.dao.BoardDao;
import com.project.devi.dao.UserDao;
import com.project.devi.dto.BoardResponseDto;
import com.project.devi.dto.BoardSaveRequestDto;
import com.project.devi.model.Board;

@Service
public class BoardService {
	
	private final BoardDao boardDao;
	private final UserDao userDao;
	
	@Autowired
	public BoardService(BoardDao boardDao, UserDao userDao) {
		this.boardDao = boardDao;
		this.userDao = userDao;
	}
	
	// 게시글 하나 가져오기
	public Board findById(Long id) {
		
		return boardDao.findById(id);
	}
	
	// 게시글 여러개 가져오기(게시판)
	// Board 객체를 가져와서 BoardResponseDto에 매핑, Board 객체에는 username이 없기때문에 username 설정을 위해 forEach 사용
	// 가독성이 크게 나쁜것 같지는 않지만 좀 비효율적으로 보임 -----------------
	public List<BoardResponseDto> findAll(int pageIndex){
		
		List<BoardResponseDto> list = boardDao.findAll(pageIndex).stream()
				.map(BoardResponseDto::new)
				.collect(Collectors.toList());
		list.forEach(dto -> dto.setUsername(userDao.findUsernameById(dto.getUserId())));
		
		return list;
	}
	
	// 게시글 저장
	public void save(BoardSaveRequestDto requestDto) {
		boardDao.save(requestDto.toEntity());
	}
}
