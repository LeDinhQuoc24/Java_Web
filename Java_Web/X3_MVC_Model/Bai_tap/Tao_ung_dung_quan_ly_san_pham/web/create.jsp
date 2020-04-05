<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/5/2020
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new product</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<h1>Create new customer</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/products">Quay lại giao diện chính</a>
</p>
<form method="post">
    <fieldset>
        <legend>Thông tin sản phẩm</legend>
        <table>
            <tr>
                <td>Id: </td>
                <td><input type="text" name="id" id="id"></td>
            </tr>
            <tr>
                <td>Tên: </td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Giá: </td>
                <td><input type="text" name="price" id="price"></td>
            </tr>
            <tr>
                <td>Tồn kho: </td>
                <td><input type="text" name="stock" id="stock"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Thêm sản phẩm mới"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
