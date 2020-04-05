<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/5/2020
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<p>
    <a href="/products?action=create">Thêm mới sản phẩm</a>
</p>

<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Tên</th>
        <th scope="col">Giá</th>
        <th scope="col">Tồn kho</th>
        <th scope="col">Ảnh</th>
        <th scope="col">Sửa/Xóa</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <th scope="col"><a href="/products?action=view&id=${product.getId()}">${product.getId()}</a></th>
            <th scope="col">${product.getName()}</th>
            <th scope="col">${product.getPrice()}</th>
            <th scope="col">${product.getStock()}</th>
            <th scope="col"><img src="${product.getImage_url()}" alt=""></th>
            <th scope="col"><a href="/products?action=edit&id=${product.getId()}">Chỉnh sửa</a></th>
            <th scope="col"><a href="/products?action=delete&id=${product.getId()}">Xóa</a></th>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>