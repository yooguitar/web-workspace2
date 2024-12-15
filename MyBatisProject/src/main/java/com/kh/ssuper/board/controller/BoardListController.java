package com.kh.ssuper.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.ssuper.board.model.service.BoardServiceImpl;
import com.kh.ssuper.board.model.vo.Board;
import com.kh.ssuper.common.PageInfo;
import com.kh.ssuper.common.Pagination;

@WebServlet("/list.board")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// ----- 페이징 처리 ------
		int listCount = new BoardServiceImpl().selectListCount();
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageLimit = 8;
		int boardLimit = 8;
		// System.out.println(listCount);
	
//		int maxPage = (int)Math.ceil((double)listCount / boardLimit);
//		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
//		int endPage = startPage + pageLimit - 1;
//		if(endPage > maxPage) { endPage = maxPage; }
// 	    중복 코드가 발생하므로 common 폴더에 페이징용 탬플릿을 만들어서 쓰겠다 => Pagination
		
		PageInfo pi = Pagination.getPageInfo(
				listCount, currentPage, pageLimit, boardLimit);
	
		List<Board> list = new BoardServiceImpl().selectList(pi);
	
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
	
		request.getRequestDispatcher("/WEB-INF/views/board/board_list.jsp")
				.forward(request, response);
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
