package com.spring.test.domain;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface WriteDAO {
	
	// 전체 SELECT
	public abstract List<WriteDTO> select(); 
	
	// 새글 작성 <-- DTO
	public abstract int insert(WriteDTO dto);
	
	// 특정 uid 글 내용 읽기, 
	//public abstract List<WriteDTO> readByUid(int uid);
	public abstract List<WriteDTO> selectByUid(Integer uid);
	
	// 특정 uid 글 수정 (제목, 내용)
	public abstract int update(WriteDTO dto);		

	// 특정 uid 글 삭제하기
	public abstract int deleteByUid(Integer uid);	
	
	WriteDTO searchBySubject(String name); // 메소드 이름:searchBySubject
} // end DAO









