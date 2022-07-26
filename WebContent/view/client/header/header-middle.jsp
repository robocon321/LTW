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

<fmt:bundle basename="${lang}">
<!-- Header Middle Start Here -->
<div class="header-middle ptb-15">
    <div class="container">
        <div class="row align-items-center no-gutters">
            <div class="col-lg-3 col-md-12">
                <div class="logo mb-all-30">
                    <a href="index.html"><img src="${url}/img/logo/logo.png" alt="logo-image"></a>
                </div>
            </div>
            <!-- Categorie Search Box Start Here -->
            <div class="col-lg-5 col-md-8 ml-auto mr-auto col-10">
                <div class="categorie-search-box">
                    <form action="#">
                        <input type="text" name="search" placeholder='<fmt:message key = "im_shopping_for"/>...'>
                        <button><i class="lnr lnr-magnifier"></i></button>
                    </form>
                </div>
            </div>
            <!-- Categorie Search Box End Here -->
            <!-- Cart Box Start Here -->
            <div class="col-lg-4 col-md-12">
                <div class="cart-box mt-all-30">
                    <ul class="d-flex justify-content-lg-end justify-content-center align-items-center">
                        <li><a href="/cart/list"><i class="lnr lnr-cart"></i><span class="my-cart"><span class="total-pro">0</span><span><fmt:message key = "cart"/></span></span></a></li>
                        <li><a href="/wishlist/list"><i class="lnr lnr-heart"></i><span class="my-cart"><span><fmt:message key = "wish"/></span><span class="wishlist"> (0)</span></span></a></li>
                    </ul>
                </div>
            </div>
            <!-- Cart Box End Here -->
        </div>
        <!-- Row End -->
    </div>
    <!-- Container End -->
</div>
<!-- Header Middle End Here -->
</fmt:bundle>