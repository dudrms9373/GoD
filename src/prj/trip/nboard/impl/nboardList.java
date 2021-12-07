package prj.trip.nboard.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prj.trip.nboard.dao.NBoardDao;
import prj.trip.nboard.service.Action;
import prj.trip.nboard.vo.NBoardVo;

public class nboardList implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		NBoardDao dao = new NBoardDao();
		
		List<NBoardVo> nboardList = dao.getnBoardList();

		request.setAttribute("nboardList", nboardList);


		String path = "/view/nboard/noticeBoard.jsp";

		request.getRequestDispatcher(path).forward(request, response);

	}

}
