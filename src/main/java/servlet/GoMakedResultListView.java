package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ResultFind;

/**
 * Servlet implementation class GoMakedResultListView
 */
@WebServlet("/GoMakedResultListView")
public class GoMakedResultListView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title =request.getParameter("title");
		System.out.println(title);
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userId");
		if(userid==null) {
			response.sendRedirect("/testManager/login.jsp");
			return;
		}
		
		ResultFind ra = new ResultFind();
		ArrayList<ArrayList<String>> rl = ra.ResultFindResultListMaked(userid,title);
		ArrayList<ArrayList<String>> rq = ra.ResultFindQuesListMaked(userid,title);
		ArrayList<Float> rp = ra.ResultFindPercentageMaked(userid,title);
		ArrayList<String>rt = ra.ResultFindTitleMaked(userid,title);
		ArrayList<Integer> rtime = ra.ResultFindTimeMaked(userid,title);
		ArrayList<String> ru = ra.ResultFindUser(userid,title);
		
		session.setAttribute("rl",rl);
		session.setAttribute("rq",rq);
		session.setAttribute("rp",rp);
		session.setAttribute("rt",rt);
		session.setAttribute("rtime",rtime);
		session.setAttribute("ru",ru);
		
		request.getRequestDispatcher("/WEB-INF/jsp/makedResultListView.jsp").forward(request, response);
		
	}

}
