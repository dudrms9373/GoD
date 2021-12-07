package prj.trip.FBoard.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prj.trip.FBoard.Vo.FreeBoardVo;
import prj.trip.FBoard.controller.Action;
import prj.trip.FBoard.dao.FreeBoardDao;

public class FBoardClick implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fbnum = request.getParameter("fbnum");
		System.out.println(fbnum);
		FreeBoardDao dao  =new FreeBoardDao();
		
		
		FreeBoardVo fvo = dao.getFBoard(fbnum);
		dao.CntUpdate(fbnum);
		request.setAttribute("fvo", fvo);
		String title = fvo.getTitle();
		String cont  = fvo.getCont();
		String nick  = fvo.getNick();
		String like  = fvo.getLikecnt();
		
		
		
		request.setAttribute("fbnum", fbnum);
		request.setAttribute("like", like);
		request.setAttribute("nick", nick);
		request.setAttribute("title", title);
		request.setAttribute("cont", cont);
		
		
		
		String path="/view/fboard/FBoardContent.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
