<!doctype html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/view/client" var="url"></c:url>

<jsp:include page = "${url}/header/head.jsp" />

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
                        <li><a href="index.html">Home</a></li>
                        <li class="active"><a href="about.html">About Us</a></li>
                    </ul>
                </div>
            </div>
            <!-- Container End -->
        </div>
        <!-- Breadcrumb End -->
        <!-- About Us Start Here -->
        <div class="about-us pt-100 pt-sm-60">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="sidebar-img mb-all-30">
                            <img src="${url}/img/blog/10.jpg" alt="single-blog-img">
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="about-desc">
                            <h3 class="mb-10 about-title">About our success story</h3>
                            <p class="mb-20">Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?</p>
                            <p class="mb-20">Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo volup.</p>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eu nisi ac mi malesuada vestibulum. Phasellus tempor nunc eleifend cursus molestie. Mauris lectus arcu, pellentesque at sodales sit amet, condimentum id nunc. Donec ornare mattis suscipit. Praesent fermentum accumsan vulputate.</p>
                            <a href="#" class="return-customer-btn read-more">read more</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Container End -->
        </div>
        <!-- About Us End Here -->
        <!-- About Us Team Start Here -->
        <div class="about-team pt-100 pt-sm-60">
            <div class="container">
               <h3 class="mb-30 about-title">our exclusive team</h3>
                <div class="row text-center">
                    <!-- Single Team Start Here -->
                    <div class="col-lg-3 col-md-6 col-sm-6 col-6">
                        <div class="single-team mb-all-30">
                            <div class="team-img sidebar-img">
                                <img src="${url}/img/team/2.jpg" alt="team-image">
                                <div class="team-link">
                                    <ul>
                                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                        <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="team-info">
                                <h4>Marcos Alonso</h4>
                                <p>web designer</p>
                            </div>
                        </div>
                    </div>
                    <!-- Single Team End Here -->
                     <!-- Single Team Start Here -->
                    <div class="col-lg-3 col-md-6 col-sm-6 col-6">
                        <div class="single-team mb-all-30">
                            <div class="team-img sidebar-img">
                                <img src="${url}/img/team/1.jpg" alt="team-image">
                                <div class="team-link">
                                    <ul>
                                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                        <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="team-info">
                                <h4>Luis Aragones</h4>
                                <p>web developer</p>
                            </div>
                        </div>
                    </div>
                    <!-- Single Team End Here -->
                     <!-- Single Team Start Here -->
                    <div class="col-lg-3 col-md-6 col-sm-6 col-6">
                        <div class="single-team mb-xxs-30">
                            <div class="team-img sidebar-img">
                                <img src="${url}/img/team/3.jpg" alt="team-image">
                                <div class="team-link">
                                    <ul>
                                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                        <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="team-info">
                                <h4>Maria Alessis</h4>
                                <p>class master</p>
                            </div>
                        </div>
                    </div>
                    <!-- Single Team End Here -->
                     <!-- Single Team Start Here -->
                    <div class="col-lg-3 col-md-6 col-sm-6 col-6">
                        <div class="single-team">
                            <div class="team-img sidebar-img">
                                <img src="${url}/img/team/4.jpg" alt="team-image">
                                <div class="team-link">
                                    <ul>
                                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                        <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="team-info">
                                <h4>John Doe</h4>
                                <p>php developer</p>
                            </div>
                        </div>
                    </div>
                    <!-- Single Team End Here -->
                </div>
            </div>
            <!-- Container End -->
        </div>
        <!-- About Us Team End Here -->
        <!-- About Us Skills Start Here -->
        <div class="about-skill ptb-100 ptb-sm-60">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                       <h3 class="about-title mb-20">Our skills</h3>
                        <div class="skill-progress mb-all-40">
                            <div class="progress">
                                <div class="skill-title">Strategy 79%</div>
                                <div class="progress-bar wow fadeInLeft" data-wow-delay="0.2s" role="progressbar" style="width: 79%; visibility: visible; animation-delay: 0.2s; animation-name: fadeInLeft;">
                                </div>
                            </div>
                            <div class="progress">
                                <div class="skill-title">Marketing 96%</div>
                                <div class="progress-bar wow fadeInLeft" data-wow-delay="0.3s" role="progressbar" style="width: 96%; visibility: visible; animation-delay: 0.3s; animation-name: fadeInLeft;">
                                </div>
                            </div>
                            <div class="progress">
                                <div class="skill-title">Wordpress Theme 65%</div>
                                <div class="progress-bar wow fadeInLeft" data-wow-delay="0.4s" role="progressbar" style="width: 65%; visibility: visible; animation-delay: 0.4s; animation-name: fadeInLeft;">
                                </div>
                            </div>
                            <div class="progress">
                                <div class="skill-title">Shopify Theme 75%</div>
                                <div class="progress-bar wow fadeInLeft" data-wow-delay="0.5s" role="progressbar" style="width: 75%; visibility: visible; animation-delay: 0.5s; animation-name: fadeInLeft;">
                                </div>
                            </div>
                            <div class="progress">
                                <div class="skill-title">UI/UX Design 92%</div>
                                <div class="progress-bar wow fadeInLeft" data-wow-delay="0.6s" role="progressbar" style="width: 89%; visibility: visible; animation-delay: 0.6s; animation-name: fadeInLeft;">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="ht-single-about">
                            <h3 class="about-title mb-20">our works</h3>
                            <div class="ht-about-work">
                                <span>1</span>
                                <div class="ht-work-text">
                                    <h5><a href="#">LOREM IPSUM DOLOR SIT AMET</a></h5>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eu nisi ac mi</p>
                                </div>
                            </div>
                            <div class="ht-about-work">
                                <span>2</span>
                                <div class="ht-work-text">
                                    <h5><a href="#">DONEC FERMENTUM EROS</a></h5>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eu nisi ac mi</p>
                                </div>
                            </div>
                            <div class="ht-about-work">
                                <span>3</span>
                                <div class="ht-work-text">
                                    <h5><a href="#">LOREM IPSUM DOLOR SIT AMET</a></h5>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eu nisi ac mi</p>
                                </div>
                            </div>
                            <div class="ht-about-work">
                                <span>4</span>
                                <div class="ht-work-text">
                                    <h5><a href="#">Adipiscing IPSUM DOLOR SIT AMET</a></h5>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eu nisi ac mi</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Container End -->
        </div>
		<jsp:include page="${url}/footer/support-area.jsp" />
        <!-- Footer Area Start Here -->
		<jsp:include page="${url}/footer/main-footer.jsp" />
        <!-- Quick View Content Start -->
		<jsp:include page="${url}/footer/quick-view.jsp" />        
		<!-- Quick View Content End -->    
		</div>
	<jsp:include page="${url}/footer/footer.jsp" />
</body>

</html>