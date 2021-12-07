package prj.trip.FBoard.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prj.trip.FBoard.controller.Action;

public class FBLikeCnt implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("LoginId") == null) {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter writer = response.getWriter(); 
			writer.println("<script>alert('로그인이 필요합니다.'); history.back(); </script>"); 
			writer.close();
		}else {
			
		}
	}

}
