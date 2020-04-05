<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/5/2020
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting product</title>
</head>
<body>
<h1>Xóa sản phẩm</h1>
<p>
    <a href="/products">Quay lại giao diện chính</a>
</p>
<form method="post">
    <h3>Người dùng xác định xóa?</h3>
    <fieldset>
        <legend>Thông tin sản phẩm</legend>
        <table>
            <tr>
                <td>Tên: </td>
                <td>${requestScope["product"].getName()}</td>
            </tr>
            <tr>
                <td>Giá: </td>
                <td>${requestScope["product"].getPrice()}</td>
            </tr>
            <tr>
                <td>Tồn kho: </td>
                <td>${requestScope["product"].getStock()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Xóa sản phẩm"></td>
                <td><a href="/products">Quay lại giao diện chính</a></td>
            </tr>
        </table>
    </fieldset>
</body>
</html>
