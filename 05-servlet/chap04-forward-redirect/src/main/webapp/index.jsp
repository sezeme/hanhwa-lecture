<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>forward & redirect</title>
</head>
<body>
<h1>forward</h1>
<form action="forward" method="post">
    <table>
        <tr>
            <td>아이디 :</td>
            <td><input type="text" name="userId"></td>
        </tr>
        <tr>
            <td>비밀번호 :</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="로그인"></td>
        </tr>
    </table>
    <h1>redirect</h1>
    <ul>
        <li><a href="othersite">네이버로 이동</a></li>
        <li><a href="otherservlet">다른 서블릿으로 재요청</a></li>
    </ul>
</form>
</body>
</html>