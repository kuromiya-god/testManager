<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Ques" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テスト管理ツール</title>
<style>
/* タブのスタイル */
nav {
  background-color: #f1f1f1;
  border: 1px solid #ccc;
  border-radius: 5px;
  margin-right: 10px;
  padding: 10px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

/* ボタンのスタイル */
nav a {
  background-color: #ddd;
  color: #333;
  padding: 10px;
  margin: 5px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  font-size: 18px;
}

/* アクティブなボタンのスタイル */
nav a.active {
  background-color: #555;
  color: #fff;
}

/* タブのコンテンツのスタイル */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

/* アクティブなタブのコンテンツのスタイル */
.tabcontent.active {
  display: block;
}

nav a.logout {
  font-size: 12px; /* ログアウトリンクのテキストのフォントサイズを14pxに設定 */
  padding: 5px; /* ログアウトリンクを囲む要素のパディングを5pxに設定 */
}

nav a.active2 {
  text-align: left;
  font-size: 18px; /* ログアウトリンクのテキストのフォントサイズを14pxに設定 */
  padding: 1px; /* ログアウトリンクを囲む要素のパディングを5pxに設定 */
  align-items: flex-start;
}

</style>
</head>
<body>
	<h1>テスト管理ツール</h1>
	<p><font size="2" face="ＭＳ Ｐ明朝" color="#808080">こんにちは<% String name = (String)session.getAttribute("userId");%><%=name %>さん</font></p>
	<div style="display:flex;">
		<nav>
			<a href="/testManager/GoQuizWorkbook" class="tablinks active" onclick="openTab(event, 'tab1')">試験</a>
			<a href="/testManager/GoMakeWorkbook" class="tablinks active" onclick="openTab(event, 'tab2')">問題作成</a>
			<a href="/testManager/GoEditWorkbook" class="tablinks active" onclick="openTab(event, 'tab3')">問題編集</a>
			<a href="/testManager/GoResult" class="tablinks active" onclick="openTab(event, 'tab4')">成績</a>
			<a href="/testManager/LogOut" class="tablinks logout" onclick="openTab(event, 'tab5')">ログアウト</a>
		</nav>
		<div style="flex:3;">
			<div id="tab1" class="tabcontent active">
	<form method="post" action="/testManager/QuesEdit">
	
	<% ArrayList<Ques> questions = new ArrayList<Ques>(); %>
	<% questions = (ArrayList<Ques>) request.getAttribute("question"); %>
	</form>
	<!--削除してよいかの確認画面をはさんで論理削除する  -->
	<!--誤作動を防ぐため、削除ページに直接飛ぶリンクは作らない  -->
	<p style="color: red; font-size: 24px;">削除モード</p>
	<form method="post" action="/testManager/QuesDeleteExecute">
<%
		for (Ques ques : questions) {
	%>	
		<label for="question">問題文:</label><br>
		<textarea name="question" id="question" cols="50" rows="3" maxlength="250" required><%= ques.getQuestion() %></textarea><br>
		<label for="option1">選択肢1:</label>
		<input type="text" name="option1" maxlength="50" id="option1" value=<%= ques.getOption1() %> required><br>
		<label for="option2">選択肢2:</label>
		<input type="text" name="option2" maxlength="50" id="option2" value=<%= ques.getOption2() %> required><br>
		<label for="option3">選択肢3:</label>
		<input type="text" name="option3" maxlength="50" id="option3" value=<%= ques.getOption3() %> required><br>
		<label for="option4">選択肢4:</label>
		<input type="text" name="option4" maxlength="50" id="option4" value=<%= ques.getOption4() %> required><br>
		<label for="answer">正解:</label>
		<input type="number" id="inputNumber"name="answer" min="1" max="4" value="<%= ques.getAnswer() %>"required><br>
		<label for="explanation">解説:</label>
		<textarea name="explanation" id="explanation" cols="50" rows="3" maxlength="250" required><%= ques.getExplanation() %></textarea><br>
		<p style="color: red; font-size: 18px;">この問題を本当に削除しても良いですか？</p>
		<input type="submit" value="削除">
		<input type="hidden" name="id" value="<%= ques.getId() %>">
		<%
		}
	%>
	</form>
	</div>
	</div>
	</div>
</body>
</html>