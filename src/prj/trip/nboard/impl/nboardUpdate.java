package prj.trip.nboard.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prj.trip.nboard.dao.NBoardDao;
import prj.trip.nboard.service.Action;
import prj.trip.nboard.vo.NBoardVo;

public class nboardUpdate implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
	    String nick = (String) session.getAttribute("LoginNick");
		String nboardNick = request.getParameter("mem_nick");
		int nboardNum= Integer.parseInt(request.getParameter("nb_num"));
		
		System.out.println(nboardNum);
		
		NBoardDao dao = new NBoardDao();
		NBoardVo vo = null;
		
		int mem_num = dao.getMem_num(nick); // 로그인 한 사람의 mem_num
		int board_mem_num = dao.getMem_num(nboardNick); // 게시판 작성자의 mem_num
		
		
		// 게시판 작성자 mem_num 과 로그인 한 사람의 mem_num이 같으면
		if(mem_num==(board_mem_num))
		vo = dao.nboardUpdate(nboardNum);
			
		
		
		
		

	}

}
