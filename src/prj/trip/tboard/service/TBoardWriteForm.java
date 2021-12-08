package prj.trip.tboard.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TBoardWriteForm implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String      loginId = (String) session.getAttribute("LoginId");
		request.setAttribute("nickname", loginId);
		
		String path="/view/tboard/tbwrite.jsp";
		request.getRequestDispatcher(path).forward(request, response);

	}

}
