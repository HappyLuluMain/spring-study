package com.project.devi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.devi.dto.BoardSaveRequestDto;
import com.project.devi.service.BoardService;

@RestController
public class BoardApiController {

	private final BoardService boardService;
	
	@Autowired
	public BoardApiController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping(value="/api/v1/board", method = RequestMethod.POST)
	public ResponseEntity<BoardSaveRequestDto> boardSave(@Valid BoardSaveRequestDto requestDto, Errors errors) {
		
		//유효성 검사 통과 실패시 ExceptionController에서 MethodArgumentNotValidException 처리
		
		boardService.save(requestDto);
		
		return new ResponseEntity<>(requestDto, HttpStatus.OK);
	}
}
