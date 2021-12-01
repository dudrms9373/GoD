package TBoard.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TBoard.service.Action;
import memebr.dao.MemberDao;
import memebr.vo.MemberVo;

public class InsertUser implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("id");
		String upw = request.getParameter("pw");
		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		
		String year = request.getParameter("birth");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		String birth = year+"년 " + month+"월 " + day+"일";
		
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		
		String tel = tel1+"-" + tel2+"-" + tel3;
		
		String gender = request.getParameter("gender");
		
		MemberVo vo = new MemberVo(uid, upw, uname, uemail, birth, tel, gender);
		MemberDao dao = new MemberDao();
		dao.InsertUser(vo);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter(); 
		writer.println("<script>alert('회원가입 완료!!'); location.href='"+"Login.jsp"+"';</script>"); 
		writer.close();
	}

}