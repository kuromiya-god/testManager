package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;
import model.RegisterDTO;

/**
 * Servlet implementation class RegisterCheck
 */
@WebServlet("/RegisterCheck")
public class RegisterCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String job = request.getParameter("job");
		String age1 = request.getParameter("age");
		int age = 0;
		try{age = Integer.parseInt(age1);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		RegisterDTO dto = new RegisterDTO(userId,pass,email,job,age);
		
		RegisterDAO registerdao = new RegisterDAO() ;
		int result = registerdao.RegisterCustomer(dto);
		
		if(result==1) {
			request.setAttribute("userId", userId);
			//フォワード
			request.getRequestDispatcher("/WEB-INF/jsp/registerOk.jsp").forward(request, response);
		}else {
			String message = "ご入力いただいたユーザーIDは既に使われています。";
	        request.setAttribute("message", message);
	        request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
		}
	}

}
