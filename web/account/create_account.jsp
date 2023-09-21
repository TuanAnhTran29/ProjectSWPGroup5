<%-- 
    Document   : create_account
    Created on : Sep 21, 2023, 12:47:42 AM
    Author     : tuana
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <!-- Basic -->
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <!-- Site Metas -->
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">

        <title>
            Giftos
        </title>

        <!-- slider stylesheet -->
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />

        <!-- bootstrap core css -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

        <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet" />
        <!-- responsive style -->
        <link href="css/responsive.css" rel="stylesheet" />
    </head>

    <body>
        <div class="hero_area">
            <!-- header section strats -->
            <header class="header_section">
                <nav class="navbar navbar-expand-lg custom_nav-container ">
                    <a class="navbar-brand" href="index.html">
                        <span>
                            Long
                        </span>
                    </a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class=""></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav  ">
                            <li class="nav-item active">
                                <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="shop.html">
                                    Shop
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="why.html">
                                    Why Us
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="testimonial.html">
                                    Testimonial
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="contact.html">Contact Us</a>
                            </li>
                        </ul>
                        <div class="user_option">
                            <a href="./login.html">
                                <i class="fa fa-user" aria-hidden="true"></i>
                                <span>
                                    Login
                                </span>
                            </a>
                            <a href="">
                                <i class="fa fa-shopping-bag" aria-hidden="true"></i>
                            </a>
                            <form class="form-inline ">
                                <button class="btn nav_search-btn" type="submit">
                                    <i class="fa fa-search" aria-hidden="true"></i>
                                </button>
                            </form>
                        </div>
                    </div>
                </nav>
            </header>
            <!-- end header section -->
        </div>

        <div class="login-page">
            <div class="register-form">
                <c:if test="${requestScope['message']!= null}">
                    <span class="message" style="color: red">${requestScope['message']}</span>
                </c:if>
                <form action="AccountController?action=createAccount" method="Post">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputEmail4">First name</label>
                            <input type="text" class="form-control" id="inputEmail4" placeholder="First name" name="fname" value="<c:out value="${fname}"/>" required="">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputPassword4">Last name</label>
                            <input type="text" class="form-control" id="inputPassword4" placeholder="Last name" name="lname" value="<c:out value="${lname}"/>" required="">
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-12">
                            <label for="inputCity">Phone</label>
                            <input type="text" class="form-control" placeholder="Phone number" name="phone" required="">
                        </div>
                        <div class="form-group col-md-12">
                            <label for="inputCity">Username</label>
                            <input type="text" class="form-control" placeholder="Username" name="username" value="<c:out value="${username}"/>" required="">
                        </div>

                        <div class="form-group col-md-12">
                            <label for="inputZip">Password</label>
                            <input type="password" class="form-control" placeholder="Password" name="password">
                        </div>

                        <div class="form-group col-md-12">
                            <label for="inputZip">Confirm password</label>
                            <input type="password" class="form-control" name="cpassword" placeholder="Re-password">
                        </div>
                    </div>

                    <button type="submit" class="btn btn-primary">Sign up</button>
                    <p class="message">Already registered? <a href="AccountController?action=loginPage">Sign In</a></p>
                </form>
                <!-- <form class="register-form">
                  <input type="text" placeholder="first name"/>
                  <input type="text" placeholder="last name"/>
                  <input type="text" placeholder="email address"/>
                  <input type="text" placeholder="username"/>
                  <input type="password" placeholder="password"/>
                  <input type="password" placeholder="confirm password"/>
                  <button>create</button>
                  <p class="message">Already registered? <a href="login.html">Sign In</a></p>
                </form> -->

            </div>
        </div>


        <!-- footer section -->
        <footer class=" footer_section">
            <div class="container">
                <p>
                    &copy; <span id="displayYear"></span> All Rights Reserved By
                    <a href="https://html.design/">Free Html Templates</a>
                </p>
            </div>
        </footer>
        <!-- footer section -->

    </section>

    <!-- end info section -->


    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
    </script>
    <script src="js/custom.js"></script>

</body>

</html>
