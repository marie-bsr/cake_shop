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
.card{
margin:auto;}
 .bg-pink{ background-color: #FFE9EC;}
</style>

</head>

<body>

	<header>
		 <%@ include file="navigation.jsp"%>
	</header>

		<div class="album py-5 ">
			<div class="container">

				<div class="row">
<div class="card  " style="width: 80%;">
  <div class="card-header">
<img class="card-img-top" src="${product.pictureUrl}">
  </div>
  <div class="card-body text-center bg-pink">
    <h5 class="card-title"> ${product.name}</h5>
    <p class="card-text"> ${product.description}</p>
     <p> Prix: ${product.price} €</p>
      <p> Quantité en stock: ${stock.quantity}</p>
                </p>
    <a href="#" class="btn btn-primary">Ajouter au panier</a>
  </div>
 
</div>
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
