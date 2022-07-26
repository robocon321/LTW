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
<div class="support-area bdr-top">
    <div class="container">
        <div class="d-flex flex-wrap text-center">
            <div class="single-support">
                <div class="support-icon">
                    <i class="lnr lnr-gift"></i>
                </div>
                <div class="support-desc">
                    <h6><fmt:message key = "great_value"/></h6>
                    <span>Nunc id ante quis tellus faucibus dictum in eget.</span>
                </div>
            </div>
            <div class="single-support">
                <div class="support-icon">
                    <i class="lnr lnr-rocket" ></i>
                </div>
                <div class="support-desc">
                    <h6><fmt:message key = "worldwide_delivery"/></h6>
                    <span>Quisque posuere enim augue, in rhoncus diam dictum non</span>
                </div>
            </div>
            <div class="single-support">
                <div class="support-icon">
                   <i class="lnr lnr-lock"></i>
                </div>
                <div class="support-desc">
                    <h6><fmt:message key = "safe_payment"/></h6>
                    <span>Duis suscipit elit sem, sed mattis tellus accumsan.</span>
                </div>
            </div>
            <div class="single-support">
                <div class="support-icon">
                   <i class="lnr lnr-enter-down"></i>
                </div>
                <div class="support-desc">
                    <h6><fmt:message key = "shop_confidence"/></h6>
                    <span>Faucibus dictum suscipit eget metus. Duis  elit sem, sed.</span>
                </div>
            </div>
            <div class="single-support">
                <div class="support-icon">
                   <i class="lnr lnr-users"></i>
                </div>
                <div class="support-desc">
                    <h6><fmt:message key = "24/7_help_center"/></h6>
                    <span>Quisque posuere enim augue, in rhoncus diam dictum non.</span>
                </div>
            </div>
        </div>
    </div>
    <!-- Container End -->
</div>
<!-- Support Area End Here -->
</fmt:bundle>