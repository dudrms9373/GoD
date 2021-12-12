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
		//관리자 권한 확인
		int uLevel = getMemLevel(loginId);
		request.setAttribute("uLevel",uLevel);
		//관리자여부를  확인하지 못하게 하기 위해 구분할만한 표시는 주지않는다.
		request.setAttribute("nickname", loginId);
		
		String path="/view/tboard/tbwrite.jsp";
		request.getRequestDispatcher(path).forward(request, response);

	}

}
