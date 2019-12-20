<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Dylan's Chat App - Log In</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<div class="limiter">
    <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
        <div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41">
					Dylan - Sign Up
				</span>
            <form class="login100-form validate-form p-b-33 p-t-5" method="post" action="Controller?action=LogIn">
                <c:if test="${errors.size()>0 }">
                    <div class="alert-danger">
                        <ul>
                            <c:forEach var="error" items="${errors }">
                                <li>${error }</li>
                            </c:forEach>
                        </ul>
                    </div>
                </c:if>
                <div class="wrap-input100 validate-input" data-validate = "Enter username">
                    <input class="input100" type="text" name="firstname" placeholder="First Name" value="${fn:escapeXml(prevFirstName)}">
                    <span class="focus-input100" data-placeholder="&#xe82a;"></span>
                </div>
                <div class="wrap-input100 validate-input" data-validate = "Enter username">
                    <input class="input100" type="text" name="lastname" placeholder="Last Name" value="${fn:escapeXml(prevLastName)}">
                    <span class="focus-input100" data-placeholder="&#xe82a;"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate = "Enter username">
                    <input class="input100" type="text" name="email" placeholder="E-Mail" value="${fn:escapeXml(prevEmail)}">
                    <span class="focus-input100" data-placeholder="&#xe82a;"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate = "Enter gender">
                    <select name="gender" class="input100" >
                        <option value="">Gender</option>
                        <c:choose>
                            <c:when test="${prevGender == 'Male'}">
                                <option value="Male" selected>Male</option>
                                <option value="Female">Female</option>
                            </c:when>
                            <c:when test="${prevGender == 'Female'}">
                                <option value="Male">Male</option>
                                <option value="Female" selected>Female</option>
                            </c:when>
                            <c:otherwise>
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                            </c:otherwise>
                        </c:choose>

                    </select>
                    <span class="focus-input100" data-placeholder="&#xe82a;"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate = "Enter age">
                    <input class="input100" type="text" name="age" placeholder="Age" value="${fn:escapeXml(prevAge)}">
                    <span class="focus-input100" data-placeholder="&#xe82a;"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="Enter password">
                    <input class="input100" type="password" name="password" placeholder="Password">
                    <span class="focus-input100" data-placeholder="&#xe80f;"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="Enter password">
                    <input class="input100" type="password" name="password2" placeholder="Confirm Password">
                    <span class="focus-input100" data-placeholder="&#xe80f;"></span>
                </div>

                <div class="container-login100-form-btn m-t-32">
                    <button class="login100-form-btn" type="submit" formaction="Controller?action=SignUp">
                        Sign Up
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
<script src="js/main.js"></script>

</body>
</html>
