<!doctype html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/view/client" var="url"></c:url>
<c:choose>
    <c:when test="${param.lang=='vi'}">
		<c:set scope="session" var="lang" value="vi_VN" />
 	</c:when>
    <c:otherwise>
		<c:set scope="session" var="lang" value="en_US" />
    </c:otherwise>
</c:choose>

<fmt:bundle basename="${lang}"> 
<jsp:include page = "${url}/header/head.jsp" />

<body>
    <!--[if lte IE 9]>
        <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
    <![endif]-->

    <!-- Main Wrapper Start Here -->
    <script>
    	var vat =  0;
    	var subtotal = 0;
    	var total = 0;
    </script>
    <div class="wrapper">
        <header>
			<jsp:include page = "${url}/header/header-top.jsp" flush = "true" />
			<jsp:include page = "${url}/header/header-middle.jsp" flush = "true" />
			<jsp:include page = "${url}/header/hkeader-bottom.jsp" flush = "true" />
			<jsp:include page = "${url}/header/mobile-vertical.jsp" flush = "true" />
        </header>
        <!-- Main Header Area End Here -->
        <!-- Categorie Menu & Slider Area Start Here -->
        <div class="main-page-banner home-3">
            <div class="container">
                <div class="row">
                    <!-- Vertical Menu Start Here -->
					<jsp:include page = "${url}/menu/sidebar.jsp" flush = "true" />
                    <!-- Vertical Menu End Here -->
                </div>
                <!-- Row End -->
            </div>
            <!-- Container End -->           
        </div>
        <!-- Categorie Menu & Slider Area End Here -->
        <!-- Breadcrumb Start -->
        <div class="breadcrumb-area mt-30">
            <div class="container">
                <div class="breadcrumb">
                    <ul class="d-flex align-items-center">
                        <li><a href="/home"><fmt:message key = "home"/></a></li>
                        <li class="active"><a href="/cart/list"><fmt:message key = "cart"/></a></li>
                    </ul>
                </div>
            </div>
            <!-- Container End -->
        </div>
        <!-- Breadcrumb End -->
        <!-- Cart Main Area Start -->
        <div class="cart-main-area ptb-100 ptb-sm-60">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <!-- Form Start -->
                        <form action="/cart/edit" method="POST">
                            <!-- Table Content Start -->
                            <div class="table-content table-responsive mb-45">
                                <table>
                                    <thead>
                                        <tr>
                                            <th class="product-thumbnail"><fmt:message key = "image"/></th>
                                            <th class="product-name"><fmt:message key = "product"/></th>
                                            <th class="product-price"><fmt:message key = "price"/></th>
                                            <th class="product-quantity"><fmt:message key = "quantity"/></th>
                                            <th class="product-subtotal"><fmt:message key = "total"/></th>
                                            <th class="product-remove"><fmt:message key = "remove"/></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${products}" var="item" varStatus="loop">
                                    <script>
                                    	subtotal += ${item.promotionPrice*cartInfo[loop.index].quantity};
                                    	vat += ${item.includeVat ? item.promotionPrice*cartInfo[loop.index].quantity*10/100 : 0};                                	
                                    </script>
                                        <tr>
                                            <td class="product-thumbnail">
                                                <a href="/product?id=${item.productId}"><img src="${item.imageMain}" alt="cart-image" /></a>
                                            </td>
                                            
                                            <td class="product-name"><a href="/product?id=${item.productId}">${item.name}</a></td>
                                            <input type="hidden" name="id" value="${item.productId}" />
                                            <td class="product-price"><span class="amount">đ <fmt:formatNumber value="${item.promotionPrice}" maxFractionDigits = "3" type="number"/></span></td>
                                            <td class="product-quantity"><input type="number" name="quantity" value="${cartInfo[loop.index].quantity}" /></td>
                                            <td class="product-subtotal">đ <fmt:formatNumber value="${cartInfo[loop.index].quantity*item.promotionPrice}" maxFractionDigits = "3" type="number"/></td>
                                            <td class="product-remove"> <a href="javascript:void(0)" onclick="removeItemCart(this)"><i class="fa fa-times" aria-hidden="true"></i></a></td>
                                        </tr>                                    
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <script>
                                	total = subtotal + vat;
                                </script>
                            </div>
                            <!-- Table Content Start -->
                            <div class="row">
                               <!-- Cart Button Start -->
                                <div class="col-md-8 col-sm-12">
                                    <div class="buttons-cart">
                                        <input type="submit" value="Update Cart" />
                                        <a href="/checkout"><fmt:message key = "continue_shopping"/></a>
                                    </div>
                                </div>
                                <!-- Cart Button Start -->
                                <!-- Cart Totals Start -->
                                <div class="col-md-4 col-sm-12">
                                    <div class="cart_totals float-md-right text-md-right">
                                        <h2><fmt:message key = "total"/></h2>
                                        <br />
                                        <table class="float-md-right">
                                            <tbody>
                                                <tr class="cart-subtotal">
                                                    <th><fmt:message key = "cart_subtotal"/>: </th>
                                                    <td><span class="amount">$215.00</span></td>                                                    
                                                </tr>
                                                <tr class="cart-vat">
                                                    <th><fmt:message key = "vat"/>: </th>
                                                    <td><span class="amount">$215.00</span></td>                                                    
                                                </tr>
                                                <tr class="order-total">
                                                    <th><fmt:message key = "order_total"/>:</th>
                                                    <td>
                                                        <strong><span class="amount">$215.00</span></strong>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                        <div class="wc-proceed-to-checkout">
                                            <a href="/checkout"><fmt:message key = "proceed_to_checkout"/></a>
                                        </div>
                                    </div>
                                </div>
                                <!-- Cart Totals End -->
                            </div>
                            <!-- Row End -->
                        </form>
                        <!-- Form End -->
                    </div>
                </div>
                 <!-- Row End -->
            </div>
        </div>
        
		<jsp:include page="${url}/footer/support-area.jsp" />
        <!-- Footer Area Start Here -->
		<jsp:include page="${url}/footer/main-footer.jsp" />
        <!-- Quick View Content Start -->
		<jsp:include page="${url}/footer/quick-view.jsp" />
    </div>
	<jsp:include page="${url}/footer/footer.jsp" />
       <script>
		$(".cart-subtotal .amount").text(new Intl.NumberFormat('us-US').format(subtotal)+" VNĐ");
		$(".cart-vat .amount").text(new Intl.NumberFormat('us-US').format(vat)+" VNĐ");
		$(".order-total .amount").text(new Intl.NumberFormat('us-US').format(total)+" VNĐ");
       </script>
</body>
</fmt:bundle>
</html>