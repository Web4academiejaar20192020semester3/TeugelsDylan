<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Dylan's Chat App - Blog</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/blog.js"></script>
</head>
<body onload="openSocket();">
	<div class="limiter">
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41">
					Dylan - Blog Page
				</span>
				<form class="login100-form validate-form p-b-33 p-t-5">
					<div class="wrap-input100 validate-input" style="text-align: center">
						<h2>TOPIC 1</h2>
						<h3>Wie is de beste voetbalploeg in België?</h3>
						<table id="answer-table1" class="blog-tables">
							<tr>
								<th>Topic</th>
								<th>Name</th>
								<th>Rating</th>
								<th>Comment</th>
							</tr>
						</table>
						<hr>
						<h2>TOPIC 2</h2>
						<h3>Hond of kat?</h3>
						<table id="answer-table2" class="blog-tables">
							<tr>
								<th>Topic #</th>
								<th>Name</th>
								<th>Rating</th>
								<th>Comment</th>
							</tr>
						</table>
						<hr>
						<h2>TOPIC 3</h2>
						<h3>Wat zijn je favoriete gerechten?</h3>
						<table id="answer-table3" class="blog-tables">
							<tr>
								<th>Topic #</th>
								<th>Name</th>
								<th>Rating</th>
								<th>Comment</th>
							</tr>
						</table>
						<hr>
						<h2>TOPIC 4</h2>
						<h3>Vanaf wanneer is iemand "oud"</h3>
						<table id="answer-table4" class="blog-tables">
							<tr>
								<th>Topic #</th>
								<th>Name</th>
								<th>Rating</th>
								<th>Comment</th>
							</tr>
						</table>
						<hr>
						<h2>TOPIC 5</h2>
						<h3>Wat is de mooiste plaats op aarde?</h3>
						<table id="answer-table5" class="blog-tables">
							<tr>
								<th>Topic #</th>
								<th>Name</th>
								<th>Rating</th>
								<th>Comment</th>
							</tr>
						</table>
						<hr>
					</div>
					<div class="wrap-input100 validate-input" data-validate="Enter Topic Number">
						<input class="input100" type="number" id="topic" placeholder="Topic Number 1-5" min="1" max="5">
						<span class="focus-input100" data-placeholder="&#xe80f;"></span>
					</div>
					<div class="wrap-input100 validate-input" data-validate = "Enter Name">
						<input class="input100" type="text" id="name" placeholder="Name">
						<span class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>
					<div class="wrap-input100 validate-input" data-validate="Enter Rating">
						<input class="input100" type="number" id="rating" placeholder="Rating 0-10" min="0" max="10">
						<span class="focus-input100" data-placeholder="&#xe80f;"></span>
					</div>
					<div class="wrap-input100 validate-input" data-validate="Enter Comment">
						<input class="input100" type="text" id="comment" placeholder="Comment">
						<span class="focus-input100" data-placeholder="&#xe80f;"></span>
					</div>
					<div class="container-login100-form-btn m-t-32">
						<button class="login100-form-btn" type="button" id="sendCommentButton" onclick="sendComment()">
							Add Comment
						</button>
					</div>
					<div class="container-login100-form-btn m-t-32">
						<button class="login100-form-btn" type="submit" formaction="Controller?">
							Go Back
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
