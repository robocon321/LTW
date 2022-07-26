<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:url value="/view/client" var="url"></c:url><head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Home || Truemart Responsive Html5 Ecommerce Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Favicons -->
    <link rel="shortcut icon" href="${url}/img/favicon.ico">
    <!-- Fontawesome css -->
    <link rel="stylesheet" href="${url}/css/font-awesome.min.css">
    <!-- Ionicons css -->
    <link rel="stylesheet" href="${url}/css/ionicons.min.css">
    <!-- linearicons css -->
    <link rel="stylesheet" href="${url}/css/linearicons.css">
    <!-- Nice select css -->
    <link rel="stylesheet" href="${url}/css/nice-select.css">
    <!-- Jquery fancybox css -->
    <link rel="stylesheet" href="${url}/css/jquery.fancybox.css">
    <!-- Jquery ui price slider css -->
    <link rel="stylesheet" href="${url}/css/jquery-ui.min.css">
    <!-- Meanmenu css -->
    <link rel="stylesheet" href="${url}/css/meanmenu.min.css">
    <!-- Nivo slider css -->
    <link rel="stylesheet" href="${url}/css/nivo-slider.css">
    <!-- Owl carousel css -->
    <link rel="stylesheet" href="${url}/css/owl.carousel.min.css">
    <!-- Bootstrap css -->
    <link rel="stylesheet" href="${url}/css/bootstrap.min.css">
    <!-- Custom css -->
    <link rel="stylesheet" href="${url}/css/default.css">
    <!-- Main css -->
    <link rel="stylesheet" href="${url}/style.css">
    <!-- Responsive css -->
    <link rel="stylesheet" href="${url}/css/responsive.css">

    <!-- Modernizer js -->
    <script src="${url}/js/vendor/modernizr-3.5.0.min.js"></script>

	<script>
		var category = ${category};	
	</script>
	<c:choose>
		<c:when test="${empty cart}">
			<script>
				var cart = undefined;
			</script>
		</c:when>
		<c:otherwise>
			<script>
				var cart = ${cart};
			</script>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${empty user_id}">
			<script>
				var userId = undefined;
			</script>
		</c:when>
		<c:otherwise>
			<script>
				var userId = ${user_id};
			</script>
		</c:otherwise>
	</c:choose>    
	<c:choose>
		<c:when test="${empty wishlist}">
			<script>
				var wishlist = undefined;
			</script>
		</c:when>
		<c:otherwise>
			<script>
				var wishlist = ${wishlist};
			</script>
		</c:otherwise>
	</c:choose>    
</head>
