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
<!-- Header Bottom Start Here -->
 <div class="header-bottom  header-sticky">
     <div class="container">
         <div class="row align-items-center">
              <div class="col-xl-3 col-lg-4 col-md-6 vertical-menu d-none d-lg-block">
                 <span class="categorie-title"><fmt:message key = "shop_by_categories"/></span>
             </div>                       
             <div class="col-xl-9 col-lg-8 col-md-12 ">
                 <nav class="d-none d-lg-block">
                     <ul class="header-bottom-list d-flex">
                         <li class="active"><a href="/home"><fmt:message key = "home"/></a></li>
                         <li><a href="/shop"><fmt:message key = "shop"/></a></li>
                         <li><a href="/blog"><fmt:message key = "blog"/></a></li>
                         <li><a href="/about"><fmt:message key = "about_us"/></a></li>
                         <li><a href="/contact"><fmt:message key = "contact_us"/></a></li>
                     </ul>
                 </nav>
                 <div class="mobile-menu d-block d-lg-none">
                     <nav>
                         <ul>
                             <li><a href="index.html">home</a>
                                 <!-- Home Version Dropdown Start -->
                                 <ul>
                                     <li><a href="index.html">Home Version 1</a></li>
                                     <li><a href="index-2.html">Home Version 2</a></li>
                                     <li><a href="index-3.html">Home Version 3</a></li>
                                     <li><a href="index-4.html">Home Version 4</a></li>
                                 </ul>
                                 <!-- Home Version Dropdown End -->
                             </li>
                             <li><a href="shop.html">shop</a>
                                 <!-- Mobile Menu Dropdown Start -->
                                 <ul>
                                     <li><a href="product.html">product details</a></li>
                                     <li><a href="compare.html">compare</a></li>
                                     <li><a href="cart.html">cart</a></li>
                                     <li><a href="checkout.html">checkout</a></li>
                                     <li><a href="wishlist.html">wishlist</a></li>
                                 </ul>
                                 <!-- Mobile Menu Dropdown End -->
                             </li>
                             <li><a href="blog.html">Blog</a>
                                 <!-- Mobile Menu Dropdown Start -->
                                 <ul>
                                     <li><a href="single-blog.html">blog details</a></li>
                                 </ul>
                                 <!-- Mobile Menu Dropdown End -->
                             </li>
                             <li><a href="#">pages</a>
                                 <!-- Mobile Menu Dropdown Start -->
                                 <ul>
                                     <li><a href="register.html">register</a></li>
                                     <li><a href="login.html">sign in</a></li>
                                     <li><a href="forgot-password.html">forgot password</a></li>
                                     <li><a href="404.html">404</a></li>
                                 </ul>
                                 <!-- Mobile Menu Dropdown End -->
                             </li>
                             <li><a href="about.html">about us</a></li>
                             <li><a href="contact.html">contact us</a></li>
                         </ul>
                     </nav>
                 </div>
             </div>
         </div>
         <!-- Row End -->
     </div>
     <!-- Container End -->
 </div>
 <!-- Header Bottom End Here -->
 </fmt:bundle>
