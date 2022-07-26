<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />
  <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix = "c" %>
    <div class="content-wrapper">
      <div class="container-fluid">
        <div class="row mt-3">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Sửa tin tức</div>
                <hr>
                <form enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/admin/new/edit">
               
                  <div class="form-group">
                    <label for="input-1">Tiêu đề</label>
                    <input type="text" class="form-control" id="input-1" placeholder="Tiêu đề" name="title" value="${item.title}">
                    <input type="hidden" class="form-control" id="input-11" name="id" value="${item.newId}">
                  </div>
                  
                  <div class="form-group">
                    <label for="input-2">Mô tả</label>
					<textarea id="input-2" class="form-control" rows="4" cols="50" name="description">${item.description}</textarea>                 
 				  </div>
                  
                  <div class="form-group">
                    <label for="input-3">Hình ảnh</label>
                    <input type="file" class="form-control" id="input-3" placeholder="Hình ảnh" name="new_image" value="${item.newImage}">
 				  </div>
                  
                  <div class="form-group">
                    <label for="input-7">Chi tiết</label>
					<textarea class="form-control ckeditor" id="input-7" rows="4" cols="50" name="detail">${item.detail}</textarea>                 
 				  </div>
                  
                  <div class="form-group">
                    <label for="input-16">Lượt xem</label>
                    <input type="number" class="form-control" id="input-16" placeholder="Lượt xem" name="view_count" value="${item.viewCount}">
 				  </div>
                  
                  <div class="form-group">
                    <label for="input-12">Ngày tạo</label>
                    <input type="date" class="form-control" id="input-12" placeholder="Ngày thêm vào" name="created_date" value="${item.createdDate}">
 				  </div>
                  
                  <div class="form-group">
                    <label for="input-13">Người tạo</label>
                    <input type="text" class="form-control" id="input-13" placeholder="Được tạo bởi" name="created_by" value="${item.createdBy}">
 				  </div>

                  <div class="form-group">
                    <label for="input-15">Chọn danh mục</label>
	                    <select class="form-control valid chosen-select" data-placeholder="Chọn danh mục"  multiple id="input-6" name="category" required aria-invalid="false">
	                        <c:forEach items="${category}" var="item">
	                        	<option value="${item.newCategoryId}">${item.name}</option>
	                        </c:forEach>
	                    </select>
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
	$(".chosen-select").chosen({
		  no_results_text: "Oops, nothing found!"
	})
</script>
<script type="text/javascript">
	var intCate = <%=request.getAttribute("intCate")%>;
	console.log(intCate);
</script>
