package prj.trip.FBoard.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prj.trip.FBoard.Vo.FreeBoardVo;
import prj.trip.FBoard.Vo.PagingVo;
import prj.trip.FBoard.dao.FreeBoardDao;
import prj.trip.FBoard.service.Action;





public class FreeBoard implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int end;
		int start;
		int number;
		
		String num = request.getParameter("pagenum");
		System.out.println("숫자"+num);
		
		FreeBoardDao dao = new FreeBoardDao();
		
		//페이징
		PagingVo pvo = new PagingVo();
		pvo.setPageSize(4);
		int s = pvo.getPageSize();
		if(num == null) {
			pvo.setPageNo(1);
			end = s * 1;
			start = end - s +1;
			
		}else {
			number = Integer.parseInt(num);
			pvo.setPageNo(number);
			System.out.println("숫자 변화값"+number);
			end = s * number;
			start = end - s +1;
			
		}
		pvo.setTotalCount(dao.getCount());
		//pvo.setStartPageNo(0*s+1);
		//pvo.setEndPageNo(2*);
		request.setAttribute("pvo", pvo);
		
		//게시판 목록
		System.out.println(start); //게시물 시작번호
		System.out.println(end); //게시물 끝번호
		System.out.println(pvo.getPageSize()); //한페이지에 보이는 게시물 갯수
		List<FreeBoardVo> fbvo =   dao.getFreeBoardList(end , start);
		request.setAttribute("fbvo", fbvo);
		
		String   path         =   "/view/fboard/FreeBoard.jsp";  
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
