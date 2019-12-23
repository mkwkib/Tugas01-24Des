<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<!DOCTYPE html>
<html>
<head>
    <title>Index Login dan Register</title>
    <link href="static/css/style.css" rel='stylesheet' type='text/css' />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Cool Login Form Tab Form,Login Forms,Sign up Forms,Registration Forms,News letter Forms,Elements"./>
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <script src="static/js/jquery.min.js"></script>
    <script src="static/js/easyResponsiveTabs.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#horizontalTab').easyResponsiveTabs({
                type: 'default', //Types: default, vertical, accordion
                width: 'auto', //auto or any width like 600px
                fit: true   // 100% fit in a container
            });
        });
    </script>
    <link href='//fonts.googleapis.com/css?family=Quicksand:400,300,700' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="wrap">
    <h1> Index Login dan Register </h1>
    <div class="main-content">
        <div class="sap_tabs">

            <div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">

                <ul>
                    <li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><span>Login</span></li>
                    <li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><span>create account</span></li>

                </ul>
                <!---->

                <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
                    <div class="register">
                        <form action="/login" method="post">
                            <input placeholder="Username" class="mail" type="text" required="" id="username" name="username">
                            <input placeholder="Password" class="lock" type="password" required="" id="password" name="password">
                            <span style="color: red"><c:out value="${error}"/></span>
                            <input type="submit" value="Login"/>
                        </form>
                        <p>Forgot Your ID or Password?<a href="#"> Click here</a></p>
                    </div>
                </div>

                <div class="tab-2 resp-tab-content" aria-labelledby="tab_item-1">
                    <div class="register">
                        <form action="/saveRegis" method="post">
                            <input placeholder="Username" type="text" required="" id="userName" name="userName">
                            <input placeholder="Full Name" type="text" required="" id="fullName" name="fullName">
                            <input placeholder="Password" type="password" required="" id="password" name="password">
                            <div class="sign-up">
                                <input type="submit" value="Register"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--start-copyright-->
    <div class="copy-right">
        <div class="wrap">
            <p>&copy; 2019 Index Form</p>
        </div>
    </div>
    <!--//end-copyright-->
</div>
</body>
</html>