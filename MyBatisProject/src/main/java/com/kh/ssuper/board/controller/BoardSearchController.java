package com.kh.ssuper.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.ssuper.board.model.service.BoardService;
import com.kh.ssuper.board.model.service.BoardServiceImpl;
import com.kh.ssuper.board.model.vo.Board;
import com.kh.ssuper.common.PageInfo;
import com.kh.ssuper.common.Pagination;

@WebServlet("/search.board")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSearchController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 사용자가 선택한 옵션과 사용자가 입력한 키워드를 가지고
		// 페이징처리가 끝난 검색결과를 들고 갈 것
	
		String condition = request.getParameter("condition");
		// "writer", "title", "content"
		String keyword = request.getParameter("keyword");
		// 사용자가 입력한 값
		
		// DTO(date transfer object) : 포장상자?
		// DTO가 아니라면 차안은 MAP정도
	
		Map<String, String> map = new HashMap();
		map.put("condition", condition);
		map.put("keyword", keyword);
		
		BoardService boardService = new BoardServiceImpl();
		
		int count = boardService.searchedCount(map);
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		// <input type="hidden" name="currentPage" value="1" />
		int pageLimit = 10;
		int boardLimit = 3;
		
		
		PageInfo pi = Pagination.getPageInfo(count, currentPage, pageLimit, boardLimit);
		
		List<Board> list = boardService.selectSearchList(pi, map);
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		request.setAttribute("keyword", keyword); // 사용자가 입력한 값 같이 넘긴다. 인풋박스가 날아가지 않음
		request.setAttribute("condition", condition);
		
		
		System.out.println("잘나옴?2");
		System.out.println(keyword);
		System.out.println(condition);
		
		
		request.getRequestDispatcher("/WEB-INF/views/board/board_list.jsp")
				.forward(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
