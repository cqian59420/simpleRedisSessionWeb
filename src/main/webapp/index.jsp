<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: cq
  Date: 2017/1/24
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试登录</title>
    <link type="text/css" href="style/customer.css">
</head>
<body style="text-align: center">


<span style="color: red"><%
    if (request.getAttribute("errorMap") != null) {
%>
    <%=((Map) request.getAttribute("errorMap")).get("loginResult")%>
    <%
        }

    %></span>


<form action="/srsw/login" method="post" class="loginForm">
    <table>
        <thead>
        <th>
            登录
        </th>
        </thead>

        <tbody>
        <tr>
            <td>UserNmae</td>
            <td><input type="text" name="userNmae" placeholder="请输入用户名"></td>
        </tr>

        <tr>
            <td>Password</td>
            <td>
                <input type="password" name="password" placeholder="请输入password">
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <button type="submit">提交</button>
            </td>
        </tr>

        </tbody>
    </table>
</form>


</body>
</html>
