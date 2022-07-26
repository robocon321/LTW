<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:url value="/view/client" var="url"></c:url>
<c:choose>
    <c:when test="${param.lang=='vi'}">
		<c:set scope="session" var="lang" value="vi_VN" />
 	</c:when>
    <c:otherwise>
		<c:set scope="session" var="lang" value="en_US" />
    </c:otherwise>
</c:choose>

<!-- Header Top Start Here -->
<fmt:bundle basename="${lang}">
<div class="header-top-area">
    <div class="container">
        <!-- Header Top Start -->
        <div class="header-top">
            <ul>
                <li><a href="javascript:void(0)"><fmt:message key = "free_shipping_on_order_over"/> $99</a></li>
                <li><a href="/cart/list"><fmt:message key = "shopping_cart"/></a></li>
                <li><a href="/checkout"><fmt:message key = "checkout"/></a></li>
            </ul>
            <ul>                                          
                <li><span><fmt:message key = "language"/></span> <a href="#"><fmt:message key = "english"/><i class="lnr lnr-chevron-down"></i></a>
                    <!-- Dropdown Start -->
                    <ul class="ht-dropdown">
                        <li><a href="?lang=en"><img src="${url}/img/header/1.jpg" alt="language-selector"><fmt:message key = "english"/></a></li>
                        <li><a href="?lang=vi"><img src="${url}/img/vi.png" alt="language-selector"><fmt:message key = "vietnam"/></a></li>
                    </ul>
                    <!-- Dropdown End -->
                </li>
                <li><a href="#"><fmt:message key = "my_account"/><i class="lnr lnr-chevron-down"></i></a>
                    <!-- Dropdown Start -->
                    <ul class="ht-dropdown">
                    <c:choose>
                    	<c:when test="${empty user_id}">
	                        <li><a href="/login"><fmt:message key = "login"/></a></li>
	                        <li><a href="/register"><fmt:message key = "register"/></a></li>                    	
                    	</c:when>
                    	<c:otherwise>
	                        <li><a href="/account"><fmt:message key = "my_account"/></a></li>
	                        <li><a href="/history"><fmt:message key = "order_history"/></a></li>
	                        <li><a href="/transaction"><fmt:message key = "transactions"/></a></li>
	                        <li><a href="/cart/list"><fmt:message key = "cart"/></a></li>
	                        <li><a href="/login"><fmt:message key = "checkout"/></a></li>
	                        <li><a href="/wishlist"><fmt:message key = "wishlist"/></a></li>
	                        <li><a href="/logout"><fmt:message key = "logout"/></a></li>
                    	</c:otherwise>
                    </c:choose>
                    </ul>
                    <!-- Dropdown End -->
                </li> 
            </ul>
        </div>
        <!-- Header Top End -->
    </div>
    <!-- Container End -->
</div>
<!-- Header Top End Here -->
</fmt:bundle>
