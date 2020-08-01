<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">

<title>Cake shop</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.0/examples/album/">

<!-- Bootstrap core CSS -->
<link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="album.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style>
.box {
	color:deeppink;
	
}
 .bg-pink{ background-color: #FFE9EC;}

.card-blog .card-body {
  position: relative;
}

.card-blog .card-category-box {
  position: absolute;
  text-align: center;
  top: -16px;
  left: 15px;
  right: 15px;
  line-height: 25px;
  overflow: hidden;
}

.card-blog .card-category {
  display: inline-block;
  color: #fff;
  padding: 0 15px 5px;
  overflow: hidden;
  background-color: deeppink;
  border-radius: 4px;
}

.card-blog .card-category .category {
  color: #fff;
  display: inline-block;
  text-transform: uppercase;
  font-size: .7rem;
  letter-spacing: .1px;
  margin-bottom: 0;
}

.card-blog .card-title {
  font-size: 1.3rem;
  margin-top: .6rem;
}

.card-blog .card-description {
  color: #4e4e4e;
}
.btn-pink{
background-color:pink;
}

</style>

</head>

<body>

	<header>
		 <%@ include file="navigation.jsp"%>
	</header>

	<main role="main">

	

			<div class="container text-center box">
				<h1 class="heading">My Cake Shop</h1>
				<p class="text-center">Best cakes in town</p>
			</div>
	

		<div class="album py-5 ">
			<div class="container">

					
					    <div class="row">
					    <c:forEach items="${products}" var="product">
          <div class="col-md-4 mb-2">
            <div class="card card-blog">
              <div class="card-img">
               <img class="card-img-top" src="${product.pictureUrl}">
              </div>
              <div class="card-body bg-pink">
                <div class="card-category-box">
                  <div class="card-category">
                    <h6 class="category">${product.price} €</h6>
                  </div>
                </div>
                <h3 class="card-title">${product.name}</h3>
                <p class="card-description">
                 ${product.description}
                </p>
                
              </div>
              <div class="card-footer">
              	<div class="d-flex justify-content-around align-items-center">
										
										
		

<a class="btn btn-pink" href="/products/${product.id}" role="button">Voir</a>
											<button type="button"
												class="btn btn-secondary">Ajouter au panier</button>
										
									</div>
              </div>
            </div>
          </div>
					
			</c:forEach>		
					
					
					
					
				</div>
			</div>
		</div>



	</main>

	<footer class="text-muted">
		<div class="container">
			<p class="float-right">
				<a href="#">Back to top</a>
			</p>
		</div>
	</footer>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')
	</script>
	<script src="../../assets/js/vendor/popper.min.js"></script>
	<script src="../../dist/js/bootstrap.min.js"></script>
	<script src="../../assets/js/vendor/holder.min.js"></script>
</body>
</html>
