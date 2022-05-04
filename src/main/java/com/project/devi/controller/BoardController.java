package com.project.devi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.devi.service.BoardService;

@Controller
public class BoardController {
	
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/post/{id}")
	public String post(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("board", boardService.findById(id));
		
		return "board/post";
	}
	
	// 게시판 첫 페이지
	@RequestMapping("/board")
	public String board(Model model) {
		model.addAttribute("boards", boardService.findAll(1));
		return "board/board";
	}
	
	// 게시판 페이징을 위한 컨트롤러 (@PathVarible required는 스프링 4.3.3 이후부터 지원)
	@RequestMapping("/board/{pageIndex}")
	public String board(@PathVariable("pageIndex") Integer pageIndex, Model model) {
		model.addAttribute("boards", boardService.findAll(pageIndex));
		
		return "board/board";
	}
}
