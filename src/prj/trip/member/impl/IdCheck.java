package prj.trip.tboard.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prj.trip.member.dao.MemberDao;
import prj.trip.member.vo.MemberVo;
import prj.trip.tboard.service.Action;

public class IdCheck implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String memid = request.getParameter("id");
		
		MemberVo vo = new MemberVo();
		MemberDao dao = new MemberDao();
		
		vo.setMem_id(memid);
		
		dao.IdCheck(vo.getMem_id());
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter(); 
		
		if(dao.IdCheck(vo.getMem_id())==0)
		writer.println("<script>alert('ID 사용 불가능!'); location.href='"+"Login.jsp"+"';</script>"); 
		else
			writer.println("<script>alert('ID 사용가능! '); location.href='"+"Login.jsp"+"';</script>"); 
				
		writer.close();
		
	}

}
