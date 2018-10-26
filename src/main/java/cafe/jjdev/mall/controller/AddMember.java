package cafe.jjdev.mall.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cafe.jjdev.mall.service.Member;
import cafe.jjdev.mall.service.MemberDao;

@WebServlet("/addMember")
public class AddMember extends HttpServlet {
	
	MemberDao memberDao;
	// 회원가입 폼
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("AddMember doGet");
		request.getRequestDispatcher("/WEB-INF/jsp/addMember.jsp").forward(request, response);		
	}
    // 회원가입 액션
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMember doPost");
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String level=request.getParameter("level");
		Member member=new Member();
		member.setId(id);
		member.setPw(pw);
		member.setLevel(Integer.parseInt(level));
		memberDao=new MemberDao();
		int row=memberDao.insertMember(member);
		System.out.println("row : "+row);
		if(row==0) {
			System.out.println("회원가입 실패");
		} else {
			System.out.println("회원가입 성공");
		}
		response.sendRedirect(request.getContextPath()+"/login");	
	}

}
