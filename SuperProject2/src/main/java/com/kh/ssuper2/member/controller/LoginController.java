package com.kh.ssuper2.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.ssuper2.member.model.service.MemberService;
import com.kh.ssuper2.member.model.vo.Member;

@WebServlet("/login.me")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		// System.out.println(userId);
		// System.out.println(userPwd);
		
		Member member = new Member(); 
		member.setUserId(userId);
		member.setUserPwd(userPwd);
		
		Member loginUser = new MemberService().login(member);
		System.out.println(loginUser);
		
		/*
		 * 콘솔에 null 찍히고 있음
		 * 예상되는 상황
		 * 1. 앞단에서 입력을 못받아오고있다.
		 * 2. JDBC구간에 오타나 빼먹은게 있다.
		 * 
		 * 가능성 낮은 상환
		 * 1. SQL 자체오류
		 * 
		 */
		
		if(loginUser != null) {
			
			HttpSession session = request.getSession();			// Client 측의 session을 가져왔다.
			session.setAttribute("loginUser", loginUser); 		// session에 유저의 정보를 키 밸류 형태로 set 하였다
			
			session.setAttribute("alertMsg", "로그인에 성공했어요~~");	// 화면단에서 alertMsg 키를 호출하면 밸류가 출력될것
			
			response.sendRedirect("/super2");						// 서버측의 응답으로 클라이언트가 url(super2)을 재요청 하게한다
			
		} else {
			request.setAttribute("failMsg", "로그인에 실패했습니다ㅜ");
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/fail_page.jsp");
			
			view.forward(request, response);					// RequestDispatcher 타입 view를 forward 한다.
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
