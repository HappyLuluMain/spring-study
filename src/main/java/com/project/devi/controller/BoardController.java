package com.project.devi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.devi.service.BoardService;
import com.project.devi.service.UserService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/write")
	public String write(Model model) {
		
		// 임의의 유저 id
		model.addAttribute("userId", 1);
		
		return "board/board-write";
	}
	
	// 게시글 여러개 (게시판)
	@RequestMapping({"", "/"})
	public String boards(@RequestParam(value = "page", defaultValue = "1", required = false) Integer pageIndex, Model model) {
		model.addAttribute("pageInfo", boardService.paging(pageIndex));
		
		return "board/board";
	}
	
	// 게시글 하나
	@RequestMapping("/{id}")
	public String board(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("board", boardService.findById(id));
		
		return "board/board-detail";
	}
	
}
