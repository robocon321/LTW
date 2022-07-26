<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />

    <div class="content-wrapper">
      <div class="container-fluid">

        <div class="row mt-3">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Sửa User</div>
                <hr>
                <form action="${pageContext.request.contextPath}/admin/user/edit" method="post">
                  <div class="form-group">
                    <label for="input-1">ID</label>
                    <input type="text" class="form-control" id="input-1" readonly="readonly" placeholder="ID" value="${acc.userId}" name="userId">
                  </div>
	                  <div class="form-group">
	                    <label for="input-1">Username</label>
	                    <input type="text" class="form-control" id="input-1" placeholder="Username" name="uname" value="${acc.username}">
	                  </div>
	                  <div class="form-group">
	                    <label for="input-1">Password</label>
	                    <input type="password" class="form-control" id="myinput" placeholder="Mật khẩu" name="pwd" value="${acc.password}">
        <input type="checkbox" onclick="myFunction1()">Hiển thị mật khẩu
                    <script>function myFunction1() {
                    	  var x = document.getElementById("myinput");
                    	  if (x.type === "password") {
                    	    x.type = "text";
                    	  } else {
                    	    x.type = "password";
                    	  }
                    	}</script> 
	                  </div>
	                  <div class="form-group">
	                    <label for="input-1">Tên </label>
	                    <input type="text" class="form-control" id="input-1" placeholder="Tên" name="fname" value="${acc.firstName}">
	                  </div>	                  		              
	                  <div class="form-group">
	                    <label for="input-1">Họ </label>
	                    <input type="text" class="form-control" id="input-1" placeholder="Họ" name="lname" value="${acc.lastName}">
	                  </div>	                  
	                  <div class="form-group">
	                    <label for="input-1">Địa chỉ</label>
	                    <input type="text" class="form-control" id="input-1" placeholder="Địa chỉ" name="addr" value="${acc.address}">
	                  </div>	                  
	                  <div class="form-group">
	                    <label for="input-1">Email</label>
	                    <input type="text" class="form-control" id="input-1" placeholder="Email" name="email" value="${acc.email}">
	                  </div>	                  
	                  <div class="form-group">
	                    <label for="input-1">Số điện thoại</label>
	                    <input type="text" class="form-control" id="input-1" placeholder="Phone" name="phone" value="${acc.phone}">
	                  </div>	
	                  <div class="form-group">
	                    <label for="input-1">Ngày tạo</label>
	                    <input type="date" class="form-control" id="input-1" placeholder="Ngày tạo" name="created_date" value="${acc.createdDate}">
	                  </div>		                  
	                  <div class="form-group">
	                    <label for="input-1">Tạo bởi</label>
	                    <input type="text" class="form-control" id="input-1" placeholder="Tạo bởi" name="created_by" value="${acc.createdBy}">
	                  </div>	
                  <div class="form-group">
                    <button class="btn btn-danger"><a href="${pageContext.request.contextPath}/admin/user/list">Hủy</a></button>
                     <button type="submit" class="btn btn-success">Cập nhật</button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <div class="overlay toggle-menu"></div>
      </div>
    </div>

    <jsp:include page = "./footer/footer.jsp" flush = "true" />