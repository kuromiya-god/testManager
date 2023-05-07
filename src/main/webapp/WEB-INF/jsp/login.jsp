<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--user_idかパスワードに誤りがあった場合、ここに飛ばす  -->
<title>ログイン画面</title>
</head>
<body>
<h1>TestManager</h1>
<div id="logmessage">${logmessage}</div>
<form action="/testManager/LoginServlet" method="post">
ユーザー ID：<input type="text" name="userId"><br>
パスワード：<input type="password" name="pass"><br>
<input type="submit" value="ログイン"><br>
<a href="/testManager/register.jsp">新規登録ページ</a>
</form>
</body>
</html>