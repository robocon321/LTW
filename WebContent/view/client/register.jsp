<!doctype html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/view/client" var="url"></c:url>

<jsp:include page = "${url}/header/head.jsp" />
<c:choose>
    <c:when test="${param.lang=='vi'}">
		<c:set scope="session" var="lang" value="vi_VN" />
 	</c:when>
    <c:otherwise>
		<c:set scope="session" var="lang" value="en_US" />
    </c:otherwise>
</c:choose>

<fmt:bundle basename="${lang}"> 

<body>
    <!--[if lte IE 9]>
        <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
    <![endif]-->

    <!-- Main Wrapper Start Here -->
    <div class="wrapper">
        <header>
			<jsp:include page = "${url}/header/header-top.jsp" flush = "true" />
			<jsp:include page = "${url}/header/header-middle.jsp" flush = "true" />
			<jsp:include page = "${url}/header/header-bottom.jsp" flush = "true" />
			<jsp:include page = "${url}/header/mobile-vertical.jsp" flush = "true" />
        </header>
        <!-- Main Header Area End Here -->
        <!-- Categorie Menu & Slider Area Start Here -->
        <div class="main-page-banner home-3">
            <div class="container">
                <div class="row">
                    <!-- Vertical Menu Start Here -->
                    <div class="col-xl-3 col-lg-4 d-none d-lg-block">
                        <div class="vertical-menu mb-all-30">
                            <nav>
                                <ul class="vertical-menu-list">
                                    <li class=""><a href="shop.html"><span><img src="${url}/img/vertical-menu/1.png" alt="menu-icon"></span>Automotive & Motorcycle<i class="fa fa-angle-right" aria-hidden="true"></i></a>

                                        <ul class="ht-dropdown mega-child">
                                            <li><a href="shop.html">Office chair <i class="fa fa-angle-right"></i></a>
                                                 <!-- category submenu end-->
                                                <ul class="ht-dropdown mega-child">
                                                    <li><a href="shop.html">Bibendum Cursus</a></li>
                                                    <li><a href="shop.html">Dignissim Turpis</a></li>
                                                    <li><a href="shop.html">Dining room</a></li>
                                                    <li><a href="shop.html">Dining room</a></li>
                                                </ul>
                                                <!-- category submenu end-->
                                            </li>
                                            <li><a href="shop.html">Purus Lacus <i class="fa fa-angle-right"></i></a>
                                                 <!-- category submenu end-->
                                                <ul class="ht-dropdown mega-child">
                                                    <li><a href="shop.html">Magna Pellentesq</a></li>
                                                    <li><a href="shop.html">Molestie Tortor</a></li>
                                                    <li><a href="shop.html">Vehicula Element</a></li>
                                                    <li><a href="shop.html">Sagittis Blandit</a></li>
                                                </ul>
                                                <!-- category submenu end-->
                                            </li>                                            
                                            <li><a href="shop.html">Sagittis Eget</a></li>
                                            <li><a href="shop.html">Sagittis Eget</a></li>
                                        </ul>
                                        <!-- category submenu end-->
                                    </li>
                                    <li><a href="shop.html"><span><img src="${url}/img/vertical-menu/3.png" alt="menu-icon"></span>Sports & Outdoors<i class="fa fa-angle-right" aria-hidden="true"></i></a>
                                        <!-- Vertical Mega-Menu Start -->
                                        <ul class="ht-dropdown megamenu first-megamenu">
                                            <!-- Single Column Start -->
                                            <li class="single-megamenu">
                                                <ul>
                                                    <li class="menu-tile">Cameras</li>
                                                    <li><a href="shop.html">Cords and Cables</a></li>
                                                    <li><a href="shop.html">gps accessories</a></li>
                                                    <li><a href="shop.html">Microphones</a></li>
                                                    <li><a href="shop.html">Wireless Transmitters</a></li>
                                                </ul>
                                                <ul>
                                                    <li class="menu-tile">GamePad</li>
                                                    <li><a href="shop.html">real game hd</a></li>
                                                    <li><a href="shop.html">fighting game</a></li>
                                                    <li><a href="shop.html">racing pad</a></li>
                                                    <li><a href="shop.html">puzzle pad</a></li>
                                                </ul>
                                            </li>
                                            <!-- Single Column End -->
                                            <!-- Single Column Start -->
                                            <li class="single-megamenu">
                                                <ul>
                                                    <li class="menu-tile">Digital Cameras</li>
                                                    <li><a href="shop.html">Camera one</a></li>
                                                    <li><a href="shop.html">Camera two</a></li>
                                                    <li><a href="shop.html">Camera three</a></li>
                                                    <li><a href="shop.html">Camera four</a></li>
                                                </ul>
                                                <ul>
                                                    <li class="menu-tile">Virtual Reality</li>
                                                    <li><a href="shop.html">Reality one</a></li>
                                                    <li><a href="shop.html">Reality two</a></li>
                                                    <li><a href="shop.html">Reality three</a></li>
                                                    <li><a href="shop.html">Reality four</a></li>
                                                </ul>
                                            </li>
                                            <!-- Single Column End -->
                                            <!-- Single Megamenu Image Start -->
                                            <li class="megamenu-img">
                                                <a href="shop.html"><img src="${url}/img/vertical-menu/sub-img1.jpg" alt="menu-image"></a>
                                                <a href="shop.html"><img src="${url}/img/vertical-menu/sub-img2.jpg" alt="menu-image"></a>
                                                <a href="shop.html"><img src="${url}/img/vertical-menu/sub-img3.jpg" alt="menu-image"></a>
                                            </li>
                                            <!-- Single Megamenu Image End -->
                                        </ul>
                                        <!-- Vertical Mega-Menu End -->
                                    </li>
                                    <li><a href="shop.html"><span><img src="${url}/img/vertical-menu/6.png" alt="menu-icon"></span>Fashion<i class="fa fa-angle-right" aria-hidden="true"></i></a>
                                        <!-- Vertical Mega-Menu Start -->
                                        <ul class="ht-dropdown megamenu megamenu-two">
                                            <!-- Single Column Start -->
                                            <li class="single-megamenu">
                                                <ul>
                                                    <li class="menu-tile">Menâs Fashion</li>
                                                    <li><a href="shop.html">Blazers</a></li>
                                                    <li><a href="shop.html">Boots</a></li>
                                                    <li><a href="shop.html">pants</a></li>
                                                    <li><a href="shop.html">Tops & Tees</a></li>
                                                </ul>
                                            </li>
                                            <!-- Single Column End -->
                                            <!-- Single Column Start -->
                                            <li class="single-megamenu">
                                                <ul>
                                                    <li class="menu-tile">Womenâs Fashion</li>
                                                    <li><a href="shop.html">Bags</a></li>
                                                    <li><a href="shop.html">Bottoms</a></li>
                                                    <li><a href="shop.html">Shirts</a></li>
                                                    <li><a href="shop.html">Tailored</a></li>
                                                </ul>
                                            </li>
                                            <!-- Single Column End -->
                                        </ul>
                                        <!-- Vertical Mega-Menu End -->
                                    </li>
                                    <li><a href="shop.html"><span><img src="${url}/img/vertical-menu/7.png" alt="menu-icon"></span>Home & Kitchen<i class="fa fa-angle-right" aria-hidden="true"></i></a>
                                        <!-- Vertical Mega-Menu Start -->
                                        <ul class="ht-dropdown megamenu megamenu-two">
                                            <!-- Single Column Start -->
                                            <li class="single-megamenu">
                                                <ul>
                                                    <li class="menu-tile">Large Appliances</li>
                                                    <li><a href="shop.html">Armchairs</a></li>
                                                    <li><a href="shop.html">Bunk Bed</a></li>
                                                    <li><a href="shop.html">Mattress</a></li>
                                                    <li><a href="shop.html">Sideboard</a></li>
                                                </ul>
                                            </li>
                                            <!-- Single Column End -->
                                            <!-- Single Column Start -->
                                            <li class="single-megamenu">
                                                <ul>
                                                    <li class="menu-tile">Small Appliances</li>
                                                    <li><a href="shop.html">Bootees Bags</a></li>
                                                    <li><a href="shop.html">Jackets</a></li>
                                                    <li><a href="shop.html">Shelf</a></li>
                                                    <li><a href="shop.html">Shoes</a></li>
                                                </ul>
                                            </li>
                                            <!-- Single Column End -->
                                        </ul>
                                        <!-- Vertical Mega-Menu End --> 
                                    </li>
                                    <li><a href="shop.html"><span><img src="${url}/img/vertical-menu/4.png" alt="menu-icon"></span>Phones & Tablets<i class="fa fa-angle-right" aria-hidden="true"></i>
                                    </a>
                                        <!-- Vertical Mega-Menu Start -->
                                        <ul class="ht-dropdown megamenu megamenu-two">
                                            <!-- Single Column Start -->
                                            <li class="single-megamenu">
                                                <ul>
                                                    <li class="menu-tile">Tablet</li>
                                                    <li><a href="shop.html">tablet one</a></li>
                                                    <li><a href="shop.html">tablet two</a></li>
                                                    <li><a href="shop.html">tablet three</a></li>
                                                    <li><a href="shop.html">tablet four</a></li>
                                                </ul>
                                            </li>
                                            <!-- Single Column End -->
                                            <!-- Single Column Start -->
                                            <li class="single-megamenu">
                                                <ul>
                                                    <li class="menu-tile">Smartphone</li>
                                                    <li><a href="shop.html">phone one</a></li>
                                                    <li><a href="shop.html">phone two</a></li>
                                                    <li><a href="shop.html">phone three</a></li>
                                                    <li><a href="shop.html">phone four</a></li>
                                                </ul>
                                            </li>
                                            <!-- Single Column End -->
                                        </ul>
                                        <!-- Vertical Mega-Menu End -->
                                    </li>
                                    <li><a href="shop.html"><span><img src="${url}/img/vertical-menu/6.png" alt="menu-icon"></span>TV & Video<i class="fa fa-angle-right" aria-hidden="true"></i></a>
                                        <!-- Vertical Mega-Menu Start -->
                                        <ul class="ht-dropdown megamenu megamenu-two">
                                            <!-- Single Column Start -->
                                            <li class="single-megamenu">
                                                <ul>
                                                    <li class="menu-tile">Gaming Desktops</li>
                                                    <li><a href="shop.html">Alpha Desktop</a></li>
                                                    <li><a href="shop.html">rober Desktop</a></li>
                                                    <li><a href="shop.html">Ultra Desktop </a></li>
                                                    <li><a href="shop.html">beta desktop</a></li>
                                                </ul>
                                            </li>
                                            <!-- Single Column End -->
                                            <!-- Single Column Start -->
                                            <li class="single-megamenu">
                                                <ul>
                                                    <li class="menu-tile">Womenâs Fashion</li>
                                                    <li><a href="shop.html">3D-Capable</a></li>
                                                    <li><a href="shop.html">Clearance</a></li>
                                                    <li><a href="shop.html">Free Shipping Eligible</a></li>
                                                    <li><a href="shop.html">On Sale</a></li>
                                                </ul>
                                            </li>
                                            <!-- Single Column End -->
                                        </ul>
                                        <!-- Vertical Mega-Menu End -->
                                    </li>
                                     <li><a href="shop.html"><span><img src="${url}/img/vertical-menu/5.png" alt="menu-icon"></span>Beauty</a>
                                    </li>
                                    <li><a href="shop.html"><span><img src="${url}/img/vertical-menu/8.png" alt="menu-icon"></span>Fruits & Veggies</a></li>
                                    <li><a href="shop.html"><span><img src="${url}/img/vertical-menu/9.png" alt="menu-icon"></span>Computer & Laptop</a></li>
                                    <li><a href="shop.html"><span><img src="${url}/img/vertical-menu/10.png" alt="menu-icon"></span>Meat & Seafood</a></li>
                                    <!-- More Categoies Start -->
                                    <li id="cate-toggle" class="category-menu v-cat-menu">
                                        <ul>
                                            <li class="has-sub"><a href="#">More Categories</a>
                                                <ul class="category-sub">
                                                    <li><a href="shop.html"><span><img src="${url}/img/vertical-menu/11.png" alt="menu-icon"></span>Accessories</a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>
                                    <!-- More Categoies End -->
                                </ul>
                            </nav>
                        </div>
                    </div>
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
                        <li class="active"><a href="/register"><fmt:message key = "register"/></a></li>
                    </ul>
                </div>
            </div>
            <!-- Container End -->
        </div>
        <!-- Breadcrumb End -->
       <!-- Register Account Start -->
        <div class="register-account ptb-100 ptb-sm-60">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="register-title">
                            <h3 class="mb-10"><fmt:message key = "register_account"/></h3>
                            <p class="mb-10"><fmt:message key = "if_you_already"/></p>
                        </div>
                    </div>
                </div>
                <!-- Row End -->
                <div class="row">
                    <div class="col-sm-12">
                        <form class="form-register" action="/register" method="POST">
                            <fieldset>
                                <legend><fmt:message key = "your_personal_details"/> <p style="color:red">${error}</p></legend>
                                
                                <div class="form-group d-md-flex align-items-md-center">
                                    <label class="control-label col-md-2" for="username"><span class="require">*</span><fmt:message key = "username"/></label>
                                    <div class="col-md-10">
                                        <input type="text" class="form-control" id="username" placeholder="<fmt:message key = "username"/>" name="uname" required>
                                    </div>
                                </div>
                                
                                <div class="form-group d-md-flex align-items-md-center">
                                    <label class="control-label col-md-2" for="f-name"><span class="require">*</span><fmt:message key = "first_name"/></label>
                                    <div class="col-md-10">
                                        <input type="text" class="form-control" id="f-name" placeholder="<fmt:message key = "first_name"/>" name="fname" required>
                                    </div>
                                </div>
                                <div class="form-group d-md-flex align-items-md-center">
                                    <label class="control-label col-md-2" for="l-name"><span class="require">*</span><fmt:message key = "last_name"/></label>
                                    <div class="col-md-10">
                                        <input type="text" class="form-control" id="l-name" placeholder="<fmt:message key = "last_name"/>" name="lname" required>
                                    </div>
                                </div>
                                <div class="form-group d-md-flex align-items-md-center">
                                    <label class="control-label col-md-2" for="email"><span class="require">*</span><fmt:message key = "email"/></label>
                                    <div class="col-md-10">
                                        <input type="email" class="form-control" id="email" placeholder="<fmt:message key = "email"/>" name="email" required>
                                    </div>
                                </div>
                                <div class="form-group d-md-flex align-items-md-center">
                                    <label class="control-label col-md-2" for="number"><span class="require">*</span><fmt:message key = "telephone"/></label>
                                    <div class="col-md-10">
                                        <input type="text" class="form-control" id="number" placeholder="<fmt:message key = "telephone"/>" name="phone" required>
                                    </div>
                                </div>
                            </fieldset>
                            <fieldset>
                                <legend><fmt:message key = "your_password"/></legend>
                                <div class="form-group d-md-flex align-items-md-center">
                                    <label class="control-label col-md-2" for="pwd"><span class="require">*</span><fmt:message key = "password"/>:</label>
                                    <div class="col-md-10">
                                        <input type="password" class="form-control" id="pwd" placeholder="Password" name="pwd" required>
                                    </div>
                                </div>
                                <div class="form-group d-md-flex align-items-md-center">
                                    <label class="control-label col-md-2" for="pwd-confirm"><span class="require">*</span><fmt:message key = "confirm_password"/></label>
                                    <div class="col-md-10">
                                        <input type="password" class="form-control" id="pwd-confirm" placeholder="Confirm password" name="re-pwd" required>
                                    </div>
                                </div>
                            </fieldset>
                            <div class="terms">
                                <div class="float-md-right">
                                    <span><fmt:message key = "i_have_agree"/><a href="/view/client/terms-conditions.jsp" class="agree"><b><fmt:message key = "privacy_policy"/></b></a></span>
                                    <input type="checkbox" name="agree" value="1"> &nbsp;
                                    <input type="submit" value="Continue" class="return-customer-btn">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- Row End -->
            </div>
            <!-- Container End -->
        </div>
		<jsp:include page="${url}/footer/support-area.jsp" />
        <!-- Footer Area Start Here -->
		<jsp:include page="${url}/footer/main-footer.jsp" />
        <!-- Quick View Content Start -->
		<jsp:include page="${url}/footer/quick-view.jsp" />
    </div>
	<jsp:include page="${url}/footer/footer.jsp" />
</body>
</fmt:bundle>
</html>