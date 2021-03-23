package com.spring.test.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test.domain.WriteDAO;
import com.spring.test.domain.WriteDTO;

// Service 단.
// 		JSP MVC2 의 Command의 역할가 비슷.
//		- Transaction 을 담당합니다. 

// JSP: Controller -> Command -> DAO

// Spring : 
//		@Controller -> @Service -> DAO -> JdbcTemplate  


@Service
public class BoardService {

	WriteDAO dao;
		
	// MyBatis
	private SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	} // ppt p29 
	
	
	// 테스트 출력용
	public BoardService() {
		super();
		System.out.println("BoardService() 생성");
	}
	
	// list
	public List<WriteDTO> list(){ 
		dao = sqlSession.getMapper(WriteDAO.class);
		return dao.select();
	}

	// write
	public int write(WriteDTO dto) {
		dao = sqlSession.getMapper(WriteDAO.class);
		int result = dao.insert(dto);
		System.out.println("생성된 uid는 "+ dto.getUid()+"\n");		
		return result;
	}	
		
	// view 
	public List<WriteDTO> viewByUid(int uid){
		// ★ 나중에 조회수 하라 하시면 여기에 넣자. 
		// 잊지말자. 조회수. 부들부들. 조회수.
		dao = sqlSession.getMapper(WriteDAO.class);
		return dao.selectByUid(uid);
	}	
	

	public List<WriteDTO> selectByUid(int uid){
		dao = sqlSession.getMapper(WriteDAO.class);
		return dao.selectByUid(uid);  // 1개짜리 list
	}	
		
	// update
	public int update(WriteDTO dto) {
		dao = sqlSession.getMapper(WriteDAO.class);
		return dao.update(dto);
//		
	}	
	
	// delete
	public int deleteByUid(int uid) {
		dao = sqlSession.getMapper(WriteDAO.class);
		return dao.deleteByUid(uid);
	}
	
	
}


