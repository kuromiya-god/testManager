<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Ques" %>
<%@ page import="model.Workbook" %>
<%    // ArrayListの宣言
    ArrayList<Ques> questions = new ArrayList<Ques>();
	Workbook workbook = null;
%>
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
			<%
		// Servletから問題リストを取得する
		questions = (ArrayList<Ques>) session.getAttribute("quesList");
		workbook = (Workbook)session.getAttribute("workbookContent");
		// 問題リストをループして、各問題を表示する
		//チェックボックスで問題集に格納するのを選ぶ
	%>
	<p>問題集編集モード</p>
	<form method="post" action="/testManager/WorkbookChange">
		<label for="title">問題集題名:</label>
		<input type="text" name="title" maxlength="50" id="title" Value=<%= workbook.getTitle()%> required><br>
		<label for="genre">ジャンル:</label>
		<input type="text" name="genre" maxlength="50" id="genre" Value=<%= workbook.getGenre()%> required><br>
		<label for="author_name">作成者名:</label>
		<input type="text" name="author_name" maxlength="50" id="author_name" Value=<%= workbook.getAuthor_name()%> required>（公開される作成者名です）<br>	
		<label for="random">ランダム：</label>
		<input type="checkbox" name="random" Value="true">（チェックを入れると出題順がランダムになります）<br>
		<label for="random">ステルス：</label>
		<input type="checkbox" name="stealth" Value="true">（チェックを入れると全文一致しないと検索で表示されなくなります）<br>
		<label for="answer">問題数制限:</label>
		<input type="number" id="inputNumber" name="answer" min="1" max="50">(問題数の制限ができます。問題数を超えた制限は無効です)<br>
		
		<p>問題集に入れる問題を[改めてすべて]選択してください。</p>
		<div id="errormessage">${errormessage}</div>
<%
		for (Ques ques : questions) {
	%>
	<div>
		<p><input type="checkbox" name="ids[]" value=<%=ques.getId()%>>
		
		問題文: <%= ques.getQuestion() %></p>		
	</div>
	<%
		}
	%>
	
	<input type="submit" value="問題集編集"><br>
</form>
	</div>
	</div>
	</div>
</body>
</html>