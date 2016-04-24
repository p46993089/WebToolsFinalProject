<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Online Order Processing Web Portal</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  
   <script > /* activate scrollspy menu */
$('body').scrollspy({
  target: '#navbar-collapsible',
  offset: 52
});


$('a[href*=#]:not([href=#])').click(function() {
    if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
      var target = $(this.hash);
      target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
      if (target.length) {
        $('html,body').animate({
          scrollTop: target.offset().top - 50
        }, 800);
        
        if (this.hash=="#section1") {
            $('.scroll-up').hide();
        }
        else {
            $('.scroll-up').show();
        }
        
        
        // activte animations in this section
        target.find('.animate').delay(1200).addClass("animated");
        setTimeout(function(){
            target.find('.animated').removeClass("animated");
        },2000);
        
        return false;
      }
    }
});
</script>



<style>

@import url(https://fonts.googleapis.com/css?family=Questrial);

html,body {
	height:100%;
    background:center no-repeat fixed url('http://www.webdesignstash.com/api/bg');
    background-size: cover;
    color:#444;
    font-family: 'Questrial', sans-serif;
}

@media (min-width:768px) {
    h1 {
        font-size:68px;
    }
}

a {
    color:#999;
}

a:hover {
    color:#111;
}

.btn,.well,.panel {
    border-radius:0;
}

.btn-blue {
    background-color:#5491bd;
    border-color:#5491bd;
    color:#fff;
}

.text-danger, a.text-danger {
    color:#5491bd;
}

.btn-huge {
    padding:17px 22px;
    font-size:22px;
}

.icon-bar {
	background-color:#fff;
}

.navbar-trans {
	background-color:#2b2b2b;
    color:#cdcdcd;
    border-width:0;
}

.navbar-trans .navbar-brand, .navbar-trans >.container-fluid .navbar-brand {
    padding: 14px;
    color:#5491bd;
}

.navbar-trans li>a:focus,.navbar-trans li.active {
	background-color:#5491bd;
	color:#333;
}

.navbar-trans li>a:hover {
	background-color:#5491bd;
	color:#fff;
	opacity:0.5;
}

.navbar-trans a{
    color:#cdcdcd;
    letter-spacing:1px;
}

.navbar-trans .form-control:focus {
	border-color: #eee;
	outline: 0;
	-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,0.075),0 0 8px rgba(100,100,100,0.6);
	box-shadow: inset 0 1px 1px rgba(0,0,0,0.075),0 0 8px rgba(100,100,100,0.6);
}

.scroll-down {
  position: absolute;
  left: 50%;
  bottom: 40px;
  border: 2px solid #fff;
  border-radius: 50%;
  height: 50px;
  width: 50px;
  margin-left: -15px;
  display: block;
  padding: 7px;
  text-align: center;
  z-index:-1
}

.scroll-up {
  position: fixed;
  display: none;
  z-index: 999;
  bottom: 1.75em;
  right: 2em;
}

.scroll-up a {
  background-color: rgba(135, 135, 135, 0.5);
  display: block;
  width: 35px;
  height: 35px;
  text-align: center;
  color: #fff;
  font-size: 15px;
  line-height: 30px;
}

section {
	padding-top:70px;  
    padding-bottom:50px;
    min-height:100%;
    min-height:calc(100% - 0);
    -webkit-transform-style: preserve-3d;
    -moz-transform-style: preserve-3d;
    transform-style: preserve-3d;
}

@media (min-width:768px) {
    .v-center {
        display:table;
        height:90%;
        width:100%;
        vertical-align:middle;
    }
}
  
#section1, #section3 {
	background-color: rgba(0,0,0,0.7);
	color:#fff;
}
  
#section4 {
	background-color: #f6f6f6;
	color:#444;
}
  
footer {
	background-color:#2b2b2b;
    color:#ddd;
    min-height:100px;
    padding-top:20px;
    padding-bottom:40px;
}

footer .nav>li>a {
    padding: 3px;
    color: #5491bd;
}

footer .nav>li>a:hover {
    background-color:transparent;
	color:#fff;
}

</style>
<body>
	<nav class="navbar navbar-trans navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapsible">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#section1">Neu Portal</a>
        </div>
        <div class="navbar-collapse collapse" id="navbar-collapsible">
            <ul class="nav navbar-nav navbar-left">
                <li><a href="login.htm">Login</a></li>
                <li><a href="#section3">About Us</a></li>
                <li><a href="#section4">Contact</a></li>
               
                <li>&nbsp;</li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" data-toggle="modal" data-target="#myModal"><i class="fa fa-heart-o fa-lg"></i></a></li>
            </ul>
        </div>
    </div>
</nav>

<section class="container-fluid" id="section1">
    <div class="v-center">
        <h1 class="text-center">Welcome To</h1>
        <h2 class="text-center lato animate slideInDown">Northeastern Order Tracking Portal</h2>
        <p class="text-center">
            <br>
            
    <a href="#section2">
        <div class="scroll-down bounceInDown animated">
            <span>
                <i class="fa fa-angle-down fa-2x"></i>
            </span>
        </div>
    </a>
    </div>
</section>





<section class="container-fluid" id="section3">
    <h1 class="text-center">Track your orders </h1>
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <br>
            <div class="row">
                <div class="col-xs-4 col-xs-offset-1">Some brand-tacular designs even have home page content that is taller that 12,000 pixels. That's a lotta content.</div>
                <div class="col-xs-2"></div>
                <div class="col-xs-4 text-right">Anyhoo, this is just some random blurb of text, and Bootply.com is a playground and code editor for Bootstrap.</div>
            </div>
            <br>
           
        </div>
    </div>
</section>

<section id="section4">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1 class="text-center">Make Contact</h1>
                <hr>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-9">
                <div class="row form-group">
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name" required="">
                    </div>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="middleName" name="firstName" placeholder="Middle Name" required="">
                    </div>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name" required="">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-6">
                        <input type="email" class="form-control" name="email" placeholder="Email" required="">
                    </div>
                    <div class="col-sm-5">
                        <input type="email" class="form-control" name="phone" placeholder="Phone" required="">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-11">
                        <input type="homepage" class="form-control" placeholder="Website URL" required="">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col-sm-11">
                        <button class="btn btn-default btn-lg pull-right">Contact Us</button>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="well well-sm pull-right">
                    <address>
                          <strong>Some LLC</strong><br>
                          795 Folsom Ave, Suite 600<br>
                          Newport, RI 94107<br>
                          P: (123) 456-7890
                    </address>
                    <address>
                      <strong>Email Us</strong><br>
                      <a href="mailto:#">first.last@example.com</a>
                    </address>
                </div>
            </div>
        </div>
    </div>
</section>


<footer id="footer">
    <div class="container">
        <div class="row">
            <div class="col-xs-6 col-sm-6 col-md-3 column">
                <h4>Information</h4>
                <ul class="nav">
                    <li><a href="about-us.html">Products</a></li>
                    <li><a href="about-us.html">Services</a></li>
                    <li><a href="about-us.html">Benefits</a></li>
                    <li><a href="elements.html">Developers</a></li>
                </ul>
            </div>
            <div class="col-xs-6 col-md-3 column">
                <h4>Follow Us</h4>
                <ul class="nav">
                    <li><a href="#">Twitter</a></li>
                    <li><a href="#">Facebook</a></li>
                    <li><a href="#">Google+</a></li>
                    <li><a href="#">Pinterest</a></li>
                </ul>
            </div>
            <div class="col-xs-6 col-md-3 column">
                <h4>Contact Us</h4>
                <ul class="nav">
                    <li><a href="#">Email</a></li>
                    <li><a href="#">Headquarters</a></li>
                    <li><a href="#">Management</a></li>
                    <li><a href="#">Support</a></li>
                </ul>
            </div>
            <div class="col-xs-6 col-md-3 column">
                <h4>Customer Service</h4>
                <ul class="nav">
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Delivery Information</a></li>
                    <li><a href="#">Privacy Policy</a></li>
                    <li><a href="#">Terms &amp; Conditions</a></li>
                </ul>
            </div>
        </div>
        <!--/row-->
        <p class="text-right">©2015</p>
    </div>
</footer>

<div class="scroll-up">
    <a href="#"><i class="fa fa-angle-up"></i></a>
</div>

<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h2 class="text-center"><img src="//placehold.it/110" class="img-circle"><br>Login</h2>
            </div>
            <div class="modal-body row">
                <h6 class="text-center">COMPLETE THESE FIELDS TO SIGN UP</h6>
                <form class="col-md-10 col-md-offset-1 col-xs-12 col-xs-offset-0">
                    <div class="form-group">
                        <input type="text" class="form-control input-lg" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control input-lg" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <button class="btn btn-danger btn-lg btn-block">Sign In</button>
                        <span class="pull-right"><a href="#">Register</a></span><span><a href="#">Need help?</a></span>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <h6 class="text-center"><a href="">Privacy is important to us. Click here to read why.</a></h6>
            </div>
        </div>
    </div>
</div>
</body>
</html>





  