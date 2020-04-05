<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/5/2020
  Time: 6:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View customer</title>
</head>
<body>
<h1>Thông tin chi tiết sản phẩm</h1>
<p>
    <a href="/products">Quay lại giao diện chính</a>
</p>
<table>
    <tr>
        <td>Id: </td>
        <td>${requestScope["product"].getId()}</td>
    </tr>
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
        <td>Ảnh: </td>
        <td> <img src="${requestScope["product"].getImage_url()}" alt=""></td>
    </tr>
</table>
</body>
</html>
