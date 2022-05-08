package com.project.devi.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.devi.dto.BoardSaveRequestDto;
import com.project.devi.service.BoardService;
import com.project.devi.validator.BoardSaveValidator;

@RestController
public class BoardApiController {

	private final BoardService boardService;
	
	private final BoardSaveValidator boardSaveValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(boardSaveValidator);
	}
	
	@Autowired
	public BoardApiController(BoardService boardService, BoardSaveValidator boardSaveValidator) {
		this.boardService = boardService;
		this.boardSaveValidator = boardSaveValidator;
	}
	
	@RequestMapping(value="/api/v1/board", method = RequestMethod.POST)
	public ResponseEntity<BoardSaveRequestDto> boardSave(@Valid BoardSaveRequestDto requestDto) {
		
		//유효성 검사 통과 실패시 ExceptionController에서 MethodArgumentNotValidException 처리
		
		boardService.save(requestDto);
		
		return new ResponseEntity<>(requestDto, HttpStatus.OK);
	}
}
