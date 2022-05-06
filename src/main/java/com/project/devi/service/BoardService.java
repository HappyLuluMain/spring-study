package com.project.devi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	private static final int PAGINATION_SIZE = 10;
	private static final int PAGE_SIZE = 5;
	
	@Autowired
	public BoardService(BoardDao boardDao, UserDao userDao) {
		this.boardDao = boardDao;
		this.userDao = userDao;
	}
	
	// 게시글 하나 가져오기
	public Board findById(Long id) {
		
		return boardDao.findById(id);
	}
	
	// 게시글 저장
	public void save(BoardSaveRequestDto requestDto) {
		boardDao.save(requestDto.toEntity());
	}
	
	// 페이징 처리 메소드
	public Map<String, Object> paging(int reqPageIndex){
		
		int pageIndex = reqPageIndex;

		int startNum = (pageIndex - 1) * PAGE_SIZE;
		
		// 마지막 페이지 번호 구하기
		long total = boardDao.totalCountOfBoard();
		int lastRow = 1;
		if(total != 0) {
			lastRow = Long.valueOf((total % PAGE_SIZE == 0 ? total / PAGE_SIZE : (total / PAGE_SIZE) + 1)).intValue();
		}
		
		// 게시글 여러개 가져오기
		// Board 객체를 가져와서 BoardResponseDto에 매핑, Board 객체에는 username이 없기때문에 username 설정을 위해 forEach 사용
		List<BoardResponseDto> boards = boardDao.findAll(startNum, PAGE_SIZE).stream()
				.map(BoardResponseDto::new)
				.collect(Collectors.toList());
		boards.forEach(dto -> dto.setUsername(userDao.findUsernameById(dto.getUserId())));
		
		// pagination 시작 번호와 마지막 번호 구하기
		int startRow = (pageIndex % PAGINATION_SIZE == 0 ? 
				(((pageIndex / PAGINATION_SIZE) -1 ) * PAGINATION_SIZE) + 1 : ((pageIndex / PAGINATION_SIZE) * PAGINATION_SIZE) + 1);
		
		int endRow = startRow + PAGINATION_SIZE - 1;
		boolean isLastRow = false;
		if(endRow >= lastRow) {
			endRow = lastRow;
			isLastRow = true;
		}
		
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		pageInfo.put("pageIndex", pageIndex);
		pageInfo.put("startRow", startRow);
		pageInfo.put("endRow", endRow);
		pageInfo.put("isLastRow", isLastRow);
		pageInfo.put("boards", boards);
		
		return pageInfo;
	}
}
