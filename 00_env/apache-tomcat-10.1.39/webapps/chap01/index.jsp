<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>LifeCycle Test</title>
</head>
<body>
<h1>라이프 사이클 테스트
</h1>
<br/>
<a href="xml-lifecycle">XML 설정</a>
<a href="annotation-lifecycle">Annotation 설정</a>

<h2>Service Method의 역할</h2>
<h3>a 태그의 href 속성 값 요청</h3>
<a href="request-service">서비스 메서드 요청</a>
<h3>form 태그의 method 속성을 get으로 설정해서 요청</h3>
<form action="request-service" method="get">
    <input type="submit" value="get 방식 요청">
</form>
<h3>form 태그의 method 속성을 post로 설정해서 요청</h3>
<form action="request-service" method="post">
    <input type="submit" value="post 방식 요청">
</form>
</body>
</html>