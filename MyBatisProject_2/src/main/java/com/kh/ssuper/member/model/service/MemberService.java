package com.kh.ssuper.member.model.service;

import com.kh.ssuper.member.model.vo.Member;

public interface MemberService {

	Member login(Member member);
	
	int insertMember(Member member);
	
	
}
