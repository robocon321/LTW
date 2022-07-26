if(cart == undefined){
	$(".total-pro").text(0);	
}else{
	$(".total-pro").text(cart.length);
}

if(wishlist == undefined){
	$(".wishlist").text("("+0+")");	
}else{
	$(".wishlist").text("("+wishlist.length+")");
}

$(".vertical-menu-list").empty();
category.forEach((item,index)=>{
	if(item.parentId == 0){
		$(".vertical-menu-list").append("<li id='category-"+item.categoryId+"'><a href='shop.html'>"+item.name+"</a></li>");
	}else{
		if($("#category-"+item.parentId).has("ul").length == 0){
			$("#category-"+item.parentId).append("<ul class='ht-dropdown mega-child'></ul>");					
			$("#category-"+item.parentId +" a").append("<i class='fa fa-angle-right' aria-hidden='true'></i>");
		}
		$("#category-"+item.parentId+" ul").append("<li id='category-"+item.categoryId+"'><a href='shop.html'>"+item.name+"</a></li>");					
	}
})

function addToCart(productId, quantity){
	console.log(productId, quantity);
	if(userId == undefined){
		alert("Bạn cần phải đăng nhập");
		return ;
	}else{
		$.ajax({
			url: '/cart/insert',
			type: 'post',
			data: 'user_id='+userId+'&product_id='+productId+"&quantity="+quantity});

		var o = cart.find((item)=> item.productId == productId);
		
		if(o == undefined){
			cart.push({userId: userId, productId: productId, quantity: quantity});
		}else{
			o.quantity += quantity;
		}
		
		$(".total-pro").text(cart.length);
	}
}

function addToWishList(productId){
	if(userId == undefined){
		alert("Bạn cần phải đăng nhập");
		return ;
	}else{
		$.ajax({
			url: '/wishlist/insert',
			type: 'post',
			data: 'user_id='+userId+'&product_id='+productId});
	
		var o = wishlist.find((item)=> item.productId == productId);
		
		if(o == undefined){
			wishlist.push({userId: userId, productId: productId});
		}
		
		$(".wishlist").text("list ("+wishlist.length+")");
		
	}
}

function removeItemCart(data){
	$(data).closest("tr").remove();
}

function removeItemWishlist(data){
	$(data).closest("tr").remove();
}
