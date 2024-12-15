package com.kh.ssuper.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.ssuper.member.model.vo.Member;

public class MemberDao {

	
	public int insertMember(SqlSession sqlSession, Member member) {
		/*
		 * int result = 0;
		 * PreparedStatement pstmt = null;
		 * ...
		 * ....
		 * return result; 
		 */
		
		/*
		 * SqlSession이 제공하는 메소드를 통해 SQL문을 찾아서 실행하고 결과를 받아볼 수 있음
		 * 
		 * sqlSession.sql문 종류에 맞는 메소드("매퍼파일의namespace속성값.해당SQL문의고유한ID값");
		 */
		
		//int result = sqlSession.insert("memberMapper.insertMember", member);
		//return result;
		
		return sqlSession.insert("memberMapper.insertMember", member);
		
	}
	
	public Member login(SqlSession sqlSession, Member member) {
		
		// Member loginMember = sqlSession.selectOne("memberMapper.login", member);
		// return loginMember;
		
		// selectOne() : 조회결과가 존재하지 않는다면 null을 반환
		return sqlSession.selectOne("memberMapper.login", member);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
