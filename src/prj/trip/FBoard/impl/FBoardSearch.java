package prj.trip.FBoard.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prj.trip.FBoard.Vo.FreeBoardVo;
import prj.trip.FBoard.Vo.PagingVo;
import prj.trip.FBoard.controller.Action;
import prj.trip.FBoard.dao.FreeBoardDao;

public class FBoardSearch implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String main = request.getParameter("searchCondition");
		String Keyword = request.getParameter("searchKeyword");

		System.out.println(main);
		System.out.println(Keyword);

		int end;
		int start;
		int number;
		String num = request.getParameter("pagenum");
		System.out.println("숫자" + num);

		FreeBoardDao dao = new FreeBoardDao();

		// 페이징
		PagingVo pvo = new PagingVo();
		pvo.setPageSize(4);
		int s = pvo.getPageSize();
		if (num == null) {
			pvo.setPageNo(1);
			end = s * 1;
			start = end - s + 1;

		} else {
			number = Integer.parseInt(num);
			pvo.setPageNo(number);
			System.out.println("숫자 변화값" + number);
			end = s * number;
			start = end - s + 1;

		}

		if (main.equals("Title")) {
			System.out.println("제목!@!!@!@!@!@!@@!");
			pvo.setTotalCount(dao.getFBtitleSearchCount(Keyword));
			request.setAttribute("pvo", pvo);
			List<FreeBoardVo> fbvo = dao.getFBoardtitleSearch(end, start, Keyword);
			request.setAttribute("fbvo", fbvo);

			String path = "/view/fboard/FreeBoard.jsp";
			request.getRequestDispatcher(path).forward(request, response);

		} else {
			System.out.println("닉네임!@!!@!@!@!@!@@!");
			pvo.setTotalCount(dao.getFBNickSearchCount(Keyword));
			request.setAttribute("pvo", pvo);
			List<FreeBoardVo> fbvo = dao.getFBoardNickSearch(end, start, Keyword);
			request.setAttribute("fbvo", fbvo);
			
			
			String path = "/view/fboard/FreeBoard.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}


	}
}
