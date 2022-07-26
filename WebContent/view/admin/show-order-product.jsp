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
	        </div>          
 		    <form class="form-inline my-2 my-lg-0">
		      <input class="form-control mr-sm-2 bg-white text-dark" type="text" name="search">
		      <button class="btn btn-info my-2 my-sm-0" type="submit">Search</button>
		    </form>  
	        <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Chi tiết đơn hàng</h5>
                <div class="table-responsive">
                  <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">Mã sản phẩm</th>
                        <th scope="col">Số lượng</th>
                        <th scope="col">Ngày giao</th>
                        <th scope="col">Giá</th>
                      </tr>
                    </thead>
                    <tbody>
	                  <c:forEach items="${products}" var="item" varStatus="loop">
	                      <tr>
							<td>${item.productId}</td>
							<td>${item.quantity}</td>
							<td>${item.shipDate}</td>
							<td>${cost[loop.index]} VNĐ</td>
	                     </tr>
	                  </c:forEach>
	                      <tr>
							<td></td>
							<td></td>
							<td><h5>Tổng giá trị đơn hàng: </h5></td>
							<td><h5>${pay} VNĐ</h5></td>
	                     </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
          <c:url value="${pageContext.request.contextPath}/admin/order/detail/list?" var="myURL">
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