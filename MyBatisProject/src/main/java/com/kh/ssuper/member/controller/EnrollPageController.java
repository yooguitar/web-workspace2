package com.kh.ssuper.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join.me")
public class EnrollPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EnrollPageController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 회원가입 양식 띄워주기
		// 서블릿에서 응답데이터 지정하는 방식이 두가지
		// 1. RequestDispatcher객체 이용하는 방법(forwarding) == 파일 경로를 지정하는 방식
		// 2. sendRedirect(URL 재요청 방식) => 코드의 중복이 발생할때 사용
		RequestDispatcher view =
				request.getRequestDispatcher("/WEB-INF/views/member/enroll_form.jsp");
		view.forward(request, response);
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
