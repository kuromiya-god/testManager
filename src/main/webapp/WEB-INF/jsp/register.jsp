<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--既にuser_idが登録されていた場合ここに飛ばして、別のuser_idを入力してもらう  -->
<title>Insert title here</title>
</head>
<body>
<h1>TestManager</h1>
<div id="message">${message}</div>
<form action="/testManager/RegisterCheck" method="post">
<p>＜新規登録ページ＞</p>
ユーザー ID：<input type="text" maxlength="10" name="userId" id="userId" required>(10文字以内)<br>
パスワード：<input type="password" maxlength="20" name="pass" id="pass" required>(20文字以内)<br>
メールアドレス：<input type="email" id="email" name="email" required><br>
職業：<input type="text" name="job" required><br>
年齢：<input type="number" id="age" name="age" min="0" max="150" step="1" required><br>
<input type="submit" value="登録"><br>
<a href="/testManager/login.jsp">ログインページ</a>
</form>

</body>
</html>