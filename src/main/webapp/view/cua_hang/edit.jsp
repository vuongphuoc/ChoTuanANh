<%--
  Created by IntelliJ IDEA.
  User: vuong
  Date: 4/8/2023
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Cửa Hàng</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <form action="/TEMPLATE_FINAL_war_exploded/cua-hang/update?ma=${ch.ma}" method="POST">
        <div class="container">
            <div class="card-group">
                <div class="card-body">
                    <h1>Cập nhật Cửa Hàng</h1>
                    <div class="col-md-12">
                          <label>Mã</label>
                        <input type="text" name="ma" class="form-control" value="${ch.ma}" disabled>
                    </div>
                    <div class="col-md-12">
                        <label>Tên</label>
                        <input type="text" name="ten" class="form-control"value="${ch.ten}">
                    </div>
                    <div class="col-md-12">
                        <label>Địa chỉ</label>
                        <input type="text" name="diaChi" class="form-control"value="${ch.diaChi}">
                    </div>
                    <div class="col-md-12">
                        <label>Thành phố</label>
                        <select name="thanhPho" class="form-control" value="${ch.thanhPho}">
                            <option value="hn">hà Nội</option>
                            <option value="hcm">Hồ Chí Minh</option>
                        </select>
                    </div>
                    <div class="col-md-12">
                        <label>Quốc Gia</label>
                        <select name="quocGia" class="form-control" value="${ch.quocGia}">
                            <option value="vn">Việt Nam</option>
                            <option value="js">Nhật Bản</option>
                        </select>
                    </div>
                </div>
                <div class="col-md-12">
                    <button class="form-control" >Cập nhật Cửa Hàng</button>
                </div>
            </div>
        </div>
    </form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>