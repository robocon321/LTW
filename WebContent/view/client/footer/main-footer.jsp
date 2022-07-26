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
<footer class="off-white-bg2 pt-95 bdr-top pt-sm-55">
    <!-- Footer Top Start -->
    <div class="footer-top">
        <div class="container">
            <!-- Signup Newsletter Start -->
            <div class="row mb-60">
                 <div class="col-xl-7 col-lg-7 ml-auto mr-auto col-md-8">
                    <div class="news-desc text-center mb-30">
                         <h3><fmt:message key = "sign_up_for_newsletters"/></h3>
                         <p><fmt:message key = "be_the"/></p>
                     </div>
                     <div class="newsletter-box">
                         <form action="#">
                              <input class="subscribe" placeholder="<fmt:message key = "your_email_address"/>" name="email" id="subscribe" type="text">
                              <button type="submit" class="submit"><fmt:message key = "subscribe"/></button>
                         </form>
                     </div>
                 </div>
            </div> 
            <!-- Signup-Newsletter End -->                   
            <div class="row">
                <!-- Single Footer Start -->
                <div class="col-lg-2 col-md-4 col-sm-6">
                    <div class="single-footer mb-sm-40">
                        <h3 class="footer-title"><fmt:message key = "information"/></h3>
                        <div class="footer-content">
                            <ul class="footer-list">
                                <li><a href="about.html"><fmt:message key = "about_us"/></a></li>
                                <li><a href="#"><fmt:message key = "delivery_information"/></a></li>
                                <li><a href="#"><fmt:message key = "privacy_policy"/></a></li>
                                <li><a href="contact.html"><fmt:message key = "terms_conditions"/></a></li>
                                <li><a href="login.html">FAQs</a></li>
                                <li><a href="login.html"><fmt:message key = "return_policy"/></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- Single Footer Start -->
                <!-- Single Footer Start -->
                <div class="col-lg-2 col-md-4 col-sm-6">
                    <div class="single-footer mb-sm-40">
                        <h3 class="footer-title"><fmt:message key = "customer_service"/></h3>
                        <div class="footer-content">
                            <ul class="footer-list">
                                <li><a href="contact.html"><fmt:message key = "contact_us"/></a></li>
                                <li><a href="#"><fmt:message key = "returns"/></a></li>
                                <li><a href="#"><fmt:message key = "order_history"/></a></li>
                                <li><a href="wishlist.html"><fmt:message key = "wishlist"/></a></li>
                                <li><a href="#"><fmt:message key = "site_map"/></a></li>
                                <li><a href="#"><fmt:message key = "gift_certificates"/></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- Single Footer Start -->
                <!-- Single Footer Start -->
                <div class="col-lg-2 col-md-4 col-sm-6">
                    <div class="single-footer mb-sm-40">
                        <h3 class="footer-title"><fmt:message key = "extras"/></h3>
                        <div class="footer-content">
                            <ul class="footer-list">
                                <li><a href="#"><fmt:message key = "newsletter"/></a></li>
                                <li><a href="#"><fmt:message key = "brands"/></a></li>
                                <li><a href="#"><fmt:message key = "gift_certificates"/></a></li>
                                <li><a href="#"><fmt:message key = "affiliate"/></a></li>
                                <li><a href="#"><fmt:message key = "specials"/></a></li>
                                <li><a href="#"><fmt:message key = "site_map"/></a></li>      
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- Single Footer Start -->
                <!-- Single Footer Start -->
                <div class="col-lg-2 col-md-4 col-sm-6">
                    <div class="single-footer mb-sm-40">
                        <h3 class="footer-title"><fmt:message key = "my_account"/></h3>
                        <div class="footer-content">
                            <ul class="footer-list">
                                <li><a href="contact.html"><fmt:message key = "contact_us"/></a></li>
                                <li><a href="#"><fmt:message key = "returns"/></a></li>
                                <li><a href="#"><fmt:message key = "my_account"/></a></li>
                                <li><a href="#"><fmt:message key = "order_history"/></a></li>
                                <li><a href="wishlist.html"><fmt:message key = "wishlist"/></a></li>
                                <li><a href="#"><fmt:message key = "newsletter"/></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- Single Footer Start -->
                <!-- Single Footer Start -->
                <div class="col-lg-4 col-md-6 col-sm-6">
                    <div class="single-footer mb-sm-40">
                        <h3 class="footer-title"><fmt:message key = "support"/></h3>
                        <div class="footer-content">
                            <ul class="footer-list address-content">
                                <li><i class="lnr lnr-map-marker"></i> <fmt:message key = "address"/>: KTX khu B, TP Di An, tinh Binh Duong.</li>
                                <li><i class="lnr lnr-envelope"></i><a href="#"> <fmt:message key = "email"/>: robocon321n@gmail.com </a></li>
                                <li>
                                    <i class="lnr lnr-phone-handset"></i> <fmt:message key = "phone"/>: 0354512411
                                </li>
                            </ul>
                            <div class="payment mt-25 bdr-top pt-30">
                                <a href="#"><img class="img" src="${url}/img/payment/1.png" alt="payment-image"></a>
                            </div>                                   
                        </div>
                    </div>
                </div>
                <!-- Single Footer Start -->
            </div>
            <!-- Row End -->
        </div>
        <!-- Container End -->
    </div>
    <!-- Footer Top End -->
    <!-- Footer Middle Start -->
    <div class="footer-middle text-center">
        <div class="container">
            <div class="footer-middle-content pt-20 pb-30">
                    <ul class="social-footer">
                        <li><a href="https://www.facebook.com/"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="https://twitter.com/"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="https://plus.google.com/"><i class="fa fa-google-plus"></i></a></li>
                        <li><a href="https://www.linkedin.com/"><i class="fa fa-linkedin"></i></a></li>
                        <li><a href="#"><img src="${url}/img/icon/social-img1.png" alt="google play"></a></li>
                        <li><a href="#"><img src="${url}/img/icon/social-img2.png" alt="app store"></a></li>
                    </ul>
            </div>
        </div>
        <!-- Container End -->
    </div>
    <!-- Footer Middle End -->
    <!-- Footer Bottom Start -->
    <div class="footer-bottom pb-30">
        <div class="container">

             <div class="copyright-text text-center">                    
                <p>Copyright Â© 2018 <a target="_blank" href="#">Truemart</a> All Rights Reserved.</p>
             </div>
        </div>
        <!-- Container End -->
    </div>
    <!-- Footer Bottom End -->
</footer>
<!-- Footer Area End Here -->
</fmt:bundle>