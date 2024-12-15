package com.kh.ssuper2.member.model.service;

import java.sql.Connection;

import com.kh.ssuper2.common.JDBCTemplate;
import com.kh.ssuper2.member.model.dao.MemberDao;
import com.kh.ssuper2.member.model.vo.Member;

public class MemberService {

	static {
		JDBCTemplate.registDriver();
	}
	
	public Member login(Member member) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Member m = new MemberDao().login(conn, member);
		
		JDBCTemplate.close(conn);
		
		return m;
		
	}
	
	
	
	public void join(Member member) {
		
		Connection conn = JDBCTemplate.getConnection();	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
