<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--ここがメインページのつもり、このページと新規登録ページだけをwebapp直下に置く  -->
<title>ログイン画面</title>
</head>
<body>
<h1>TestManager</h1>
<form action="/testManager/LoginServlet" method="post">
ユーザー ID：<input type="text" name="userId" required><br>
パスワード：<input type="password" name="pass" required><br>
<input type="submit" value="ログイン"><br>
<a href="/testManager/register.jsp">新規登録ページ</a>
</form>
</body>
</html>