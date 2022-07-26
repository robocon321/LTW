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
                <div class="card-title">Thêm User</div>
                <hr>
                <form action="${pageContext.request.contextPath}/admin/user/add" method="post">
	                  <div class="form-group">
	                    <label for="input-1">Username</label>
	                    <input type="text" class="form-control" id="input-1" placeholder="Username" name="uname">
	                  </div>
	                  <div class="form-group">
	                    <label for="input-1">Password</label>
	                    <input type="password" class="form-control" id="myinput" placeholder="Mật khẩu" name="pwd">
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
	                    <input type="text" class="form-control" id="input-1" placeholder="Tên" name="fname">
	                  </div>	                  		              
	                  <div class="form-group">
	                    <label for="input-1">Họ </label>
	                    <input type="text" class="form-control" id="input-1" placeholder="Họ" name="lname">
	                  </div>	                  
	                  <div class="form-group">
	                    <label for="input-1">Địa chỉ</label>
	                    <input type="text" class="form-control" id="input-1" placeholder="Địa chỉ" name="addr">
	                  </div>	                  
	                  <div class="form-group">
	                    <label for="input-1">Email</label>
	                    <input type="text" class="form-control" id="input-1" placeholder="Email" name="email">
	                  </div>	                  
	                  <div class="form-group">
	                    <label for="input-1">Số điện thoại</label>
	                    <input type="text" class="form-control" id="input-1" placeholder="Phone" name="phone">
	                  </div>	
	                  <div class="form-group">
	                    <label for="input-1">Ngày tạo</label>
	                    <input type="date" class="form-control" id="input-1" placeholder="Ngày tạo" name="created_date">
	                  </div>		                  
	                  <div class="form-group">
	                    <label for="input-1">Tạo bởi</label>
	                    <input type="text" class="form-control" id="input-1" placeholder="Tạo bởi" name="created_by">
	                  </div>	
                  <div class="form-footer"> 
					  <a class="btn btn-danger" href="${pageContext.request.contextPath}/admin/user/list"><i class="fa fa-times"></i>Hủy</a>
                    <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i> Thêm</button>
                </div>	                  
                </form>
              </div>
            </div>
          </div>
        </div>
        <div class="overlay toggle-menu"></div>
      </div>
    </div>
    <script>
		var date = new Date();
		
		var day = date.getDate();
		var month = date.getMonth() + 1;
		var year = date.getFullYear();
		
		if (month < 10) month = "0" + month;
		if (day < 10) day = "0" + day;
		
		var today = year + "-" + month + "-" + day;
		
		
		document.getElementById('the-date').value = today;
</script>

    <jsp:include page = "./footer/footer.jsp" flush = "true" />