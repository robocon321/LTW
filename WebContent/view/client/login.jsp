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
                        <li><a href="/register"><fmt:message key = "account"/></a></li>
                        <li class="active"><a href="/contact"><fmt:message key = "contact_us"/></a></li>
                    </ul>
                </div>
            </div>
            <!-- Container End -->
        </div>
        <!-- Breadcrumb End -->
        <!-- LogIn Page Start -->
        <div class="log-in ptb-100 ptb-sm-60">
            <div class="container">
                <div class="row">
                    <!-- New Customer Start -->
                    <div class="col-md-6">
                        <div class="well mb-sm-30">
                            <div class="new-customer">
                                <h3 class="custom-title"><fmt:message key = "new_customer"/></h3>
                                <p class="mtb-10"><strong><fmt:message key = "register"/></strong></p>
                                <p><fmt:message key = "by_creating"/></p>
                                <a class="customer-btn" href="/register"><fmt:message key = "continue"/></a>
                            </div>
                        </div>
                    </div>
                    <!-- New Customer End -->
                    <!-- Returning Customer Start -->
                    <div class="col-md-6">
                        <div class="well">
                            <div class="return-customer">
                                <h3 class="mb-10 custom-title"><fmt:message key = "login"/></h3>
                                <p class="mb-10"><strong><fmt:message key = "im_returning"/></strong></p>
                                <form action="/login" method="post">
                                    <div class="form-group">
                                        <label><fmt:message key = "username"/> <span style="color:red">${error_uname}</span></label>
                                        <input type="text" name="uname" placeholder="" id="input-email" class="form-control" value="${uname_in}">
                                    </div>
                                    <div class="form-group">
                                        <label><fmt:message key = "password"/> <span style="color:red">${error_pwd}</span></label>
                                        <input type=password" name="pwd" placeholder="" id="input-password" class="form-control">
                                    </div>
                                    <p class="lost-password"><a href="/forgot-password"><fmt:message key = "forgot_pwd"/>?</a></p>
                                    <input type="submit" value="<fmt:message key = "login"/>" class="return-customer-btn">
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- Returning Customer End -->
                </div>
                <!-- Row End -->
            </div>
            <!-- Container End -->
        </div>
        <!-- LogIn Page End -->
		<jsp:include page="${url}/footer/support-area.jsp" />
        <!-- Footer Area Start Here -->
		<jsp:include page="${url}/footer/main-footer.jsp" />
        <!-- Quick View Content Start -->
		<jsp:include page="${url}/footer/quick-view.jsp" />        
		<!-- Quick View Content End -->
    </div>
	<jsp:include page="${url}/footer/footer.jsp" />
</body>
</fmt:bundle>
</html>