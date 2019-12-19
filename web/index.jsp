<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Dylan's Chat App - Log In</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>

	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">

	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41">
					Dylan - Log In
				</span>
				<form class="login100-form validate-form p-b-33 p-t-5" method="post" action="Controller?action=LogIn">
					<c:if test="${errors.size()>0 }">
						<div class="danger">
							<ul>
								<c:forEach var="error" items="${errors }">
									<li>${error }</li>
								</c:forEach>
							</ul>
						</div>
					</c:if>
					<div class="wrap-input100">
						<input class="input100" type="text" name="email" placeholder="E-Mail">
						<span class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>

					<div class="wrap-input100">
						<input class="input100" type="password" name="password" placeholder="Password">
						<span class="focus-input100" data-placeholder="&#xe80f;"></span>
					</div>

					<div class="container-login100-form-btn m-t-32">
						<button class="login100-form-btn">
							Login
						</button>
					</div>
					<div class="container-login100-form-btn m-t-32">
						<button class="login100-form-btn" type="submit" formaction="Controller?action=SignUpPage">
							Sign Up
						</button>
					</div>
					<div class="container-login100-form-btn m-t-32">
						<button class="login100-form-btn" type="submit" formaction="Controller?action=BlogPage">
							Blog Page
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>