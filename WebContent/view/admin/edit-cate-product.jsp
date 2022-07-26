<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">

        <div class="row mt-3">
          <div class="col-lg-8">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Sửa chuyên mục</div>
                <hr>
          	
	                <form action="${pageContext.request.contextPath}/admin/cate/product/edit" method="post">
	                  <div class="form-group">
	                    <input type="hidden" class="form-control" readonly id="input-1" placeholder="ID" name="id" value="${cate.categoryId}">
	                  </div>
	                  <div class="form-group">
	                    <label for="input-1">Tên chuyên mục</label>
	                    <input type="text" class="form-control" id="input-1" placeholder="Tên chuyên mục" name="name" value="${cate.name}">
	                  </div>
		              <div class="form-group">
		                  <label for="input-2">Chuyên mục cha</label>
		                  <div>
		                     <select class="form-control valid" id="input-6" name="parentId" required aria-invalid="false">
		                        <option value="0">${cate.parent.name}</option>
								<c:forEach items="${all}" var="item">
									<option value="${item.categoryId}">${item.name}</option>
								</c:forEach>
		                    </select>
		                  </div>
		               </div>
	                   <div class="form-footer">
	                      <button class="btn btn-danger"><a href="${pageContext.request.contextPath}/admin/cate/product/list">Hủy</a></button>
                         
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