<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.ResultDTO" %>
<%@ page import="model.Workbook" %>
<%    // ArrayListの宣言
    ArrayList<ArrayList<String>> rl = new ArrayList<>();
	ArrayList<ArrayList<String>> rq = new ArrayList<>();
	ArrayList<Float> rp = new ArrayList<>();
	ArrayList<String> rt = new ArrayList<>();
	ArrayList<Integer> rtime = new ArrayList<>();
	ArrayList<String> ru = new ArrayList<>();
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
		<div style="flex: 3;">
			<div id="tab1" class="tabcontent active">
				<%
		// Servletからresultリストを取得する
		rl = (ArrayList<ArrayList<String>>) session.getAttribute("rl");
		rq = (ArrayList<ArrayList<String>>) session.getAttribute("rq");
		rp = (ArrayList<Float>)session.getAttribute("rp");
		rt = (ArrayList<String>) session.getAttribute("rt");
		rtime = (ArrayList<Integer>)session.getAttribute("rtime");
		ru = (ArrayList<String>) session.getAttribute("ru");
		
	%>

<%-- <%
		for (ResultDTO r : rd) {
	%>
	
	<div>
		<p><%= r.getTitle() %>： <%= r.getWorkbookTime() %>回目</p><br>
		<p>正解率： <%= r.getResultpercentage() %>%</p>
		
			<% for (ArrayList<ResultDTO> d : r){%>
			  <% i%>問目：<% d.get %>
		<% i++;} %> --%>
<%
		for(int i = 0;i<rl.size();i++){
%>			<p><%= rt.get(i) %>： <%= rtime.get(i) %>回目<br>
			回答者：<%= ru.get(i) %><br>
			正解率：<%= rp.get(i) %></p>
<%			for(int o = 0;o<rl.get(i).size();o++){%>
				<p><%=(o+1)%>問目 <%=rl.get(i).get(o) %>：
				<%= rq.get(i).get(o) %></p>
<% 		}
		}
%>
	</div>
	

	</div>
	</div>

</body>
</html>