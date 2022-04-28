package com.project.devi.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.devi.model.Board;

@Repository
public class BoardDao {
	
	private static final String NAME_SPACE = "com.project.devi.mappers.BoardMapper";
	
	private final SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public BoardDao(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public Board findById(Long id) {
		
		
		
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".findById", id);
	}
	
}
