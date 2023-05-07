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
 * Servlet implementation class ResultView
 */
@WebServlet("/ResultView")
public class ResultView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("userId");
		
		if(userid==null) {
			response.sendRedirect("/testManager/login.jsp");
			return;
		}
		
		
		ResultFind ra = new ResultFind();
		ArrayList<ArrayList<String>> rl = ra.ResultFindResultList(userid);
		ArrayList<ArrayList<String>> rq = ra.ResultFindQuesList(userid);
		ArrayList<Float> rp = ra.ResultFindPercentage(userid);
		ArrayList<String>rt = ra.ResultFindTitle(userid);
		ArrayList<Integer> rtime = ra.ResultFindTime(userid);
		
		
		
		session.setAttribute("rl",rl);
		session.setAttribute("rq",rq);
		session.setAttribute("rp",rp);
		session.setAttribute("rt",rt);
		session.setAttribute("rtime",rtime);
		
		request.getRequestDispatcher("/WEB-INF/jsp/resultView.jsp").forward(request, response);
	}

}
