package com.kh.ssuper.member.model.service;

import java.sql.Connection;

import com.kh.ssuper.common.JDBCTemplate;
import com.kh.ssuper.member.model.dao.MemberDao;
import com.kh.ssuper.member.model.vo.Member;

public class MemberServiceImpl implements MemberService {

	static {
		JDBCTemplate.registDriver();
	}
	
	@Override
	public Member login(Member member) {
		
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().login(conn, member);
		
		JDBCTemplate.close(conn);
		
		return m;
	}

	@Override
	public int insertMember(Member member) {
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
