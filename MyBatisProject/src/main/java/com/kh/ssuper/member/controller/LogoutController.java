package com.kh.ssuper.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout.me")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 로그인은 뭘까??
		// Session의 Attribute에다가
		// "loginUser"라는 키값으로
		// DB에서 조회한 값들이 필드에 담긴
		// Member객체를 담았다

		// 로그아웃이란??
		// case 1. loginUser 키값만 지우기
		// case 2. session을 만료시킨다.(== 무효화한다) 
		// case 2 => invalidate() => session객체 메소드 
		HttpSession session = request.getSession();
		session.invalidate();
		
		// 응답 데이터 => 웰컴파일 가야됨
		// sendRedirect()
		// System.out.println(request.getContextPath());
		// response.sendRedirect("/super"); 절대경로 ㄴㄴ
		response.sendRedirect(request.getContextPath()); // 상대경로로 지정하는것이 좋다
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
