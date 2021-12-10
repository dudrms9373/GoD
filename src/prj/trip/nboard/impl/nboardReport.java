package prj.trip.nboard.impl;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prj.trip.nboard.service.Action;

public class nboardReport implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String path="/view/common/report.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
		

	}

}
