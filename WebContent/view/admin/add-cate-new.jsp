<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">

        <div class="row mt-3">
          <div class="col-lg-8">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Thêm chuyên mục</div>
                <hr>
                <form action="${pageContext.request.contextPath}/admin/cate/new/add" method="post">
                
                  <div class="form-group">
                    <label for="input-1">Tên chuyên mục</label>
                    <input type="text" class="form-control" id="input-1" placeholder="Tên chuyên mục" name="name">
                  </div>
	               <div class="form-group">
	                  <label for="input-2">Chuyên mục cha</label>
	                  <div>
	                    <select class="form-control valid" id="input-6" name="parentId" required aria-invalid="false">
	                        <option value="0">NULL</option>
	                        <c:forEach items="${cate}" var="item">
	                        	<option value="${item.newCategoryId}">${item.name}</option>
	                        </c:forEach>
	                    </select>
	                  </div>
	                </div>
                 <div class="form-footer">
	                <button class="btn btn-danger"><a href="${pageContext.request.contextPath}/admin/cate/new/list">Hủy</a></button>
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