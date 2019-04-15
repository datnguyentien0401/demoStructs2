<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <title>Demo Struct2</title>
    </head>
    <body>
        <div class="container">
            <h1 style="text-align: center">Danh sách truyện</h1>
        <s:a href="addBook.jsp">Thêm truyện</s:a><hr>
            <table class="table table-dark">
                <thead>
                    <tr>
                        <th scope="col">Tên Truyện</th>
                        <th scope="col">Tác giả</th>
                        <th scope="col">Option</th>

                    </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${listBook}">
                    <tr>
                        <th scope="row"><p>${book.tenTruyen}</p></th>
                        <td><p>${book.tacGia}</p></td>
                        <td> 
                            <s:url id="urlUpdate" action="find">
                                <s:param name="ten">${book.tenTruyen}</s:param>
                            </s:url>
                            <s:a href="%{urlUpdate}">Chỉnh sửa</s:a>
                            <s:url id="urlDel" action="delete">
                                <s:param name="ten">${book.tenTruyen}</s:param>
                            </s:url>
                            <s:a href="%{urlDel}">Xóa truyện</s:a>
                            </td>

                        </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
    </body>
</html>
