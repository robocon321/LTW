<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">
        <div class="row mt-3">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Thêm sản phẩm</div>
                <hr>
                <form enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/admin/product/add">
               
                  <div class="form-group">
                    <label for="input-1">Tên sản phẩm</label>
                    <input type="text" class="form-control" id="input-1" placeholder="Tên sản phẩm" name="name">
                  </div>
                  
                  <div class="form-group">
                    <label for="input-2">Mô tả</label>
					<textarea id="input-2" class="form-control" rows="4" cols="50" name="description"></textarea>                 
 				  </div>
                  
                  <div class="form-group">
                    <label for="input-3">Hình ảnh</label>
                    <input type="file" class="form-control" id="input-3" placeholder="Hình ảnh" name="image_main">
 				  </div>
                  
                  <div class="form-group">
                    <label for="input-4">Giá thực(Chưa giảm giá)</label>
                    <input type="number" class="form-control" id="input-4" placeholder="Giá thực" name="price">
 				  </div>

                  <div class="form-group">
                    <label for="input-5">Giá quảng cáo(Đã giảm giá)</label>
                    <input type="number" class="form-control" id="input-5" placeholder="Giá quảng cáo" name="promotions_price">
 				  </div>

                  <div class="form-group">
                    <label for="input-16">Số lượng</label>
                    <input type="number" class="form-control" id="input-16" placeholder="Số lượng" name="quantity">
 				  </div>
                  
                  <div class="form-group">
                    <label for="input-6">Thuế VAT</label>
					<input type="radio" class="ml-5" name="vat" value="true">Đã bao gồm thuế</input>
					<input type="radio" class="ml-5" name="vat" value="false" checked/>Chưa bao gồm thuế</input>
 				  </div>
                  
                  <div class="form-group">
                    <label for="input-7">Chi tiết</label>
					<textarea class="form-control ckeditor" id="input-7" rows="4" cols="50" name="detail"></textarea>                 
 				  </div>
                  
                  <div class="form-group">
                    <label for="input-8">Lượt xem</label>
                    <input type="number" class="form-control" id="input-8" placeholder="Lượt xem" name="view_count">
 				  </div>
                                    
                  <div class="form-group">
                    <label for="input-10">Thương hiệu</label>
                    <input type="text" class="form-control" id="input-10" placeholder="Thương hiệu" name="brand">
 				  </div>

                  <div class="form-group">
                    <label for="input-17">Danh mục</label>
                    <input type="text" class="form-control" id="input-17" placeholder="Danh mục" name="category_id">
 				  </div>
                  
                  <div class="form-group">
                    <label for="input-11">Ngày ra mắt</label>
                    <input type="date" class="form-control" id="input-11" placeholder="Ngày ra mắt" name="launch_date">
 				  </div>
                  
                  <div class="form-group">
                    <label for="input-12">Ngày thêm vào</label>
                    <input type="date" class="form-control" id="input-12" placeholder="Ngày thêm vào" name="created_date">
 				  </div>
                  
                  <div class="form-group">
                    <label for="input-13">Người tạo</label>
                    <input type="text" class="form-control" id="input-13" placeholder="Được tạo bởi" name="created_by">
 				  </div>
                  
                  <div class="form-group">
                    <label for="input-14">Thêm hình ảnh</label>
                    <input type="file" accept="image/*" multiple class="form-control" id="input-14" name="images">
 				  </div>

                  <div class="form-group" id="attribute">
                    <label for="input-15">Thêm thuộc tính</label>
					<button type="button" class="btn btn-primary" id="add">Mới</button>
 				  </div>

               <div class="form-footer">
                    <button class="btn btn-danger"><i class="fa fa-times"></i><a href="${pageContext.request.contextPath}/admin/product/list">Hủy</a></button>
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
<jsp:include page = "./footer/footer.jsp" flush = "true" />
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
<script type="text/javascript">
	var editor = CKEDITOR.replace(".editor");
	CKFinder.setupCKEditor(editor, "/view/admin/assets/plugins/ckfinder/");
</script>
<script type="text/javascript">
	  $("#add").click(function(e) {
	    e.preventDefault();
	    $("#attribute").append("<div class=\"form-group m-4\"><input type=\"text\" class=\"form-control m-2\" placeholder=\"Tên thuộc tính\" name=\"name_attribute\"><input type=\"text\" class=\"form-control m-2\" placeholder=\"Giá trị thuộc tính\" name=\"value_attribute\"><button type=\"button\" class=\"remove btn btn-secondary m-2\">Xóa</button></div>");
	  });
	  $(document).on("click",".remove",function(e){
		e.preventDefault();
		$(this).closest("div").remove(); 
	  });
</script>
