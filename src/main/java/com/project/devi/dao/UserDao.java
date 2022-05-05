package com.project.devi.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.devi.model.User;

@Repository
public class UserDao {

	private static final String NAME_SPACE = "com.project.devi.mappers.UserMapper";
	
	private final SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public UserDao(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	// 아이디와 비밀번호로 유저 검색
	public User findByUsernameAndPassword(String username, String password) {
		
		Map<String, String> param = new HashMap<String, String>();
		
		param.put("username", username);
		param.put("password", password);
		
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".findByUsernameAndPassword", param);
	}
	
	// 유저 생성
	public void save(User user) {
		sqlSessionTemplate.insert(NAME_SPACE + ".save", user);
	}
	
	// 유저 이름 가져오기
	public String findUsernameById(Integer id) {
		return sqlSessionTemplate.selectOne(NAME_SPACE + ".findUsernameById", id);
	}
}
