<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">
        <!--End Row-->


        <div class="row">
          <div class="col-lg-8">
            <button class="add-catalog"><a href="${pageContext.request.contextPath}/admin/new/add">Thêm tin tức</a></button>
          </div>
		    <form class="form-inline my-2 my-lg-0">
		      <input class="form-control mr-sm-2 bg-white text-dark" type="text" name="search">
		      <button class="btn btn-info my-2 my-sm-0" type="submit">Search</button>
		    </form>
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Danh sách tin tức</h5>
                <div class="table-responsive">
                  <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">Tiêu đề</th>
                        <th scope="col">Ảnh đại diện</th>
                        <th scope="col">Lượt xem</th>
                        <th scope="col">Hành động</th>
                      </tr>
                    </thead>
                    <tbody>
                  <c:forEach items="${news}" var="item">
					  <tr>
					  	<td>${item.title}</td>
                        <td><img src="${item.newImage}" style="width: 110px;height: 67px; object-fit: cover;border: 1px solid #fff;"  alt="Not found"></td>
					  	<td>${item.viewCount}</td>
						<td>	
                          <button class="btn btn-danger"><a href="${pageContext.request.contextPath}/admin/new/delete?id=${item.newId}">Xóa</a></button>                         
                          <button class="btn btn-success"><a href="${pageContext.request.contextPath}/admin/new/edit?id=${item.newId}">Sửa</a></button>
                        </td>
                     </tr>
                    </c:forEach>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
          <c:url value="${pageContext.request.contextPath}/admin/new/list?" var="myURL">
			<c:if test="${search != ''}">
				<c:param name="search" value="${search}"/>		
			</c:if>
          </c:url>
		<div class="col-lg-12">
			<nav aria-label="Page navigation example">
			  <ul class="pagination justify-content-center">
			    <li class="page-item ${pages[0] == index ? "disabled" : ""}">
			      <a class="page-link" href="${myURL}page=${pages[0]}" tabindex="-1" aria-disabled="true">Previous</a>
			    </li>
				<c:forEach items="${pages}" var="item">
				    <li class="page-item ${item == index ? "active" : ""}"><a class="page-link" href="${myURL}page=${item}">${item}</a></li>					
				</c:forEach>
			    <li class="page-item ${pages[fn:length(pages)-1] == index ? "disabled" : ""}">
			      <a class="page-link" href="${myURL}page=${pages[fn:length(pages)-1]}">Next</a>
			    </li>
			  </ul>
			</nav>
          </div>      
        </div>
      </div>
    </div>
 
    <jsp:include page = "./footer/footer.jsp" flush = "true" />