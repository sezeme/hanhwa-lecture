<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>cookie & session</title>
</head>
<body>
<h1>Cookie Handling</h1>
<form action="cookie" method="post">
    <table>
        <tr>
            <td>firstName : </td>
            <td><input type="text" name="firstName"></td>
        </tr>
        <tr>
            <td>lastName : </td>
            <td><input type="text" name="lastName"></td>
        </tr>
        <tr>
            <td colspan="2"><button>전송</button></td>
        </tr>
    </table>
</form>
<h1>Session Handling</h1>
<form action="session" method="post">
    <table>
        <tr>
            <td>firstName : </td>
            <td><input type="text" name="firstName"></td>
        </tr>
        <tr>
            <td>lastName : </td>
            <td><input type="text" name="lastName"></td>
        </tr>
        <tr>
            <td colspan="2"><button>전송</button></td>
        </tr>
    </table>
</form>

<h3>세션 데이터 지우기</h3>
<a href="session-delete">세션 데이터 제거</a>
</body>
</html>