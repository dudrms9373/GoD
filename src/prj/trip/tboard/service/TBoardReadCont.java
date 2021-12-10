package prj.trip.tboard.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prj.trip.comment.vo.CommentVo;
import prj.trip.tboard.dao.TBoardDao;
import prj.trip.tboard.vo.TBoardVo;

public class TBoardReadCont implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String    loginId   = (String) session.getAttribute("LoginId");
		String    sboardNum = request.getParameter("boardNum");
		int       boardNum  = Integer.parseInt(sboardNum);
		System.out.println(sboardNum);
		// 게시물 불러오기
		TBoardDao dao       =  new TBoardDao();
		TBoardVo  tboardVo  = dao.getTBoard(boardNum);
		
		int currentPage = 1; //시작 페이지 설정
		int dpp         = 10; // 장당 보여줄 페이지 설정(10장씩)
		int totalData = dao.getCmtCount(boardNum);
		request.setAttribute("totalData", totalData);
		request.setAttribute("dpp", dpp);
		// 댓글 가져오기
		List<CommentVo> cmtList = dao.getCmtList(boardNum, currentPage, dpp-10);
		System.out.println("댓글 길이:"+cmtList.size());
		for (CommentVo commentVo : cmtList) {
			System.out.println(commentVo);
		}
		// request 에 담기
		request.setAttribute("tboardVo", tboardVo);
		request.setAttribute("cmtList", cmtList);
		
		String path = "/view/tboard/tcont.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
		
		
		
		
	}

}
