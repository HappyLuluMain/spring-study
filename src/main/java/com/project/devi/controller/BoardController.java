package com.project.devi.controller;

import javax.validation.Valid;

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
	
	@RequestMapping("/board/{id}")
	public String boardDetail(@Valid @PathVariable("id") Long id, Model model) {
		
		model.addAttribute("board", boardService.findById(id));
		
		return "board-detail";
	}
}
