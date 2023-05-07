package servlet;
//jspから問題のidを受け取り、問題一式をquiz.jspに渡すservlet
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuesListSetDAO;
import dao.QuestionsetDAO;
import model.Ques;

/**
 * Servlet implementation class QuizServlet
 */
@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/WEB-INF/jsp/quesMake2.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // jspから問題IDを取得
		request.setCharacterEncoding("UTF-8");
		String[]  ids = request.getParameterValues("ids[]");
		
		ArrayList<Integer>  questionId = new ArrayList<Integer>() ;
		//チェックボックスなのでnullが来たら元のページへ戻す
		if(ids==null){
		    QuesListSetDAO l = new QuesListSetDAO();
		    ArrayList<Ques> quesList = l.findByQuesList();
		    HttpSession session = request.getSession();
		    session.setAttribute("quesList",quesList);
		    request.getRequestDispatcher("/WEB-INF/jsp/quizChoice.jsp").forward(request, response);
		    
		} 
		
		//問題idをArrayListへセット
		for (int i = 0; i < ids.length; i++) {
			questionId.add(Integer.parseInt(ids[i]));
		}
		
		//問題の数を変数にセット
		int quesCount = 0;
		quesCount = questionId.size();

		for(Integer s:questionId) {
			System.out.println("quesidのnull" +s);
		}

		// 問題を取得
		QuestionsetDAO dao = new QuestionsetDAO();
		ArrayList<Ques> question = dao.findByQuestion(questionId);
		
		//ArrayListを準備
		ArrayList<Integer> answerList = new ArrayList<>();
		ArrayList<String> question1 = new ArrayList<>();
		ArrayList<String> option11 = new ArrayList<>();
		ArrayList<String> option21 = new ArrayList<>();
		ArrayList<String> option31 = new ArrayList<>();
		ArrayList<String> option41 = new ArrayList<>();
		ArrayList<Integer> answer1 = new ArrayList<>();
		ArrayList<String> explanation1 = new ArrayList<>();
		
		 //questionから問題一式を取り出してArrayListに格納、Scoringで使う
		for (Ques ques : question) {
            question1.add(ques.getQuestion());
            option11.add(ques.getOption1());
            option21.add(ques.getOption2());
            option31.add(ques.getOption3());
            option41.add(ques.getOption4());
            answer1.add(ques.getAnswer());
            explanation1.add(ques.getExplanation());
            
        }
		//questionからanswerを取り出してArrayListに格納
		for (Ques ques : question) {
           
            answerList.add(ques.getAnswer());
       
            
        }
	
		
		// JSPに渡すために、問題をリクエストスコープに保存
		HttpSession session = request.getSession();
		session.setAttribute("question", question);
		session.setAttribute("quesCount", quesCount);
		session.setAttribute("answerList", answerList);
		session.setAttribute("question1", question1);
		session.setAttribute("option11", option11);
		session.setAttribute("option21", option21);
		session.setAttribute("option31", option31);
		session.setAttribute("option41", option41);
		session.setAttribute("explanation1", explanation1);
		
		

        // JSPへフォワード
    	request.getRequestDispatcher("/WEB-INF/jsp/quiz.jsp").forward(request, response);
    }
}