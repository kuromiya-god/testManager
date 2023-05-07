package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuesListSetDAO;
import dao.QuestionsetDAO;
import model.Ques;
import model.Workbook;
import model.WorkbookTimes;

/**
 * Servlet implementation class WorkbookStart
 */
@WebServlet("/WorkbookStart")
public class WorkbookStart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// jspから問題IDを取得
				request.setCharacterEncoding("UTF-8");
				ArrayList<Integer>  questionId = new ArrayList<Integer>() ;
				String workbook_ids = request.getParameter("Workbook_id");
				System.out.println(workbook_ids);
				HttpSession session = request.getSession();
				String userid = (String)session.getAttribute("userId");
				int wi= Integer.parseInt(workbook_ids);
				//workbookのquestionidリストをだす
				QuestionsetDAO qd = new QuestionsetDAO();
				questionId = qd.findByWorkbook(wi);
				QuesListSetDAO qs = new QuesListSetDAO();
				Workbook wb = qs.findByWorkbook(wi);
				
				//randomとlimitを取り出す
				boolean random = wb.isRandom();
				System.out.println("ランダム"+random);
				int limit = wb.getLimit();
				System.out.println("リミット"+limit);
				
				if(random) {
					Collections.shuffle(questionId);
					Collections.shuffle(questionId);
				}
				System.out.println("シャッフル後"+questionId);
				
				if(limit!=0&&limit<questionId.size()) {
					questionId.subList(limit, questionId.size()).clear();
				}
				System.out.println("シャッフル後"+questionId);
					
				
				System.out.println(wi);
				
				
				
				
				//問題idをArrayListへセット
				/*for (int i = 0; i < questionId.size(); i++) {
					questionId.add(Integer.parseInt(questionId[i]));
				}*/
				
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
				
				Workbook wbi = new Workbook(userid,wi);
				
				WorkbookTimes workbookTimes = new WorkbookTimes();
				
				int workbookTime = workbookTimes.workbookTimes(wbi);
				
				
				// JSPに渡すために、問題をリクエストスコープに保存
				session.setAttribute("question", question);
				session.setAttribute("quesCount", quesCount);
				session.setAttribute("answerList", answerList);
				session.setAttribute("question1", question1);
				session.setAttribute("option11", option11);
				session.setAttribute("option21", option21);
				session.setAttribute("option31", option31);
				session.setAttribute("option41", option41);
				session.setAttribute("explanation1", explanation1);
				request.setAttribute("workbookTime", workbookTime);
				session.setAttribute("wb", wb);
				session.setAttribute("questionid", questionId);
				

		        // JSPへフォワード
		    	request.getRequestDispatcher("/WEB-INF/jsp/workbookStart.jsp").forward(request, response);
		    }
	}


