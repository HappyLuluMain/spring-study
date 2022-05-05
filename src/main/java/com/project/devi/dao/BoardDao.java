package com.project.devi.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.devi.model.Board;

@Repository
public class BoardDao {
	
	private static final String NAME_SPACE = "com.project.devi.mappers.BoardMapper";
	
	private static final int PAGE_SIZE = 5;
	
	private final SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public BoardDao(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	// 게시글 하나 가져오기
	public Board findById(Long id) {
		
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".findById", id);
	}
	
	// 게시글 PAGE_SIZE 만큼 가져오기(게시판)
	public List<Board> findAll(int pageIndex){
		int startRow = (pageIndex - 1) * PAGE_SIZE;
		
		return sqlSessionTemplate.selectList(NAME_SPACE + ".findAll", startRow);
	}

	// 게시글 저장
	public void save(Board board) {
		sqlSessionTemplate.insert(NAME_SPACE + ".save", board);
	}
}
