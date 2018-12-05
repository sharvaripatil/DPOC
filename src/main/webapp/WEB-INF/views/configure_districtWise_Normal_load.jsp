<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Normal Load Configuration</title>

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="resources/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="resources/css/animate.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">
	<!--  <link href="resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet"> -->

</head>

<body class="md-skin">
<div id="wrapper">
  <%@include file="navbar.jsp" %>
  <div id="page-wrapper" class="gray-bg">
    <div id="header"></div>
    <div class="wrapper wrapper-content"> 
<div class="col-lg-12">
			<div class="ibox-title">
				 <h5> Normal Load Configuration</h5> 
				<div class="ibox-content">
                            <form class="form-horizontal m-l-md">
                                <div class="form-group"><label class="col-lg-2 control-label">District Name :</label>

                                    <div class="col-lg-3"><input type="text" placeholder="District Name" class="form-control"> <span class="help-block m-b-none  text-danger">Validation content</span>
                                    </div>
                                </div>
                                <div class="form-group"><label class="col-lg-2 control-label">Rated Load :</label>

                                    <div class="col-lg-3"><input type="input" placeholder="Rated Load" class="form-control">
									<span class="help-block m-b-none text-danger">Validation content</span>
									</div>
                                </div>
								 <div class="form-group"><label class="col-lg-2 control-label">Normal Load :</label>

                                    <div class="col-lg-3"><input type="input" placeholder="Normal Load" class="form-control">
									 <span class="help-block m-b-none  text-danger">Validation content</span>
									 </div>
                                </div>
                               
                                <div class="form-group">
                                    <div class="col-lg-offset-2 col-lg-10">
                                        <button class="btn btn-sm btn-primary" type="submit">Submit</button>
                                    </div>
                                </div>
                            </form>
                        </div>

			</div>
        </div>
	  </div>
      <!--  <div id="footer"></div> -->
        <%@include file="footer.html" %>
   
  </div>
</div>
<!-- Mainly scripts -->
	<script>
$(document).ready(function(){
    $("#navbar").load("navbar.jsp");
	 $("#header").load("header.html");
	 $("#footer").load("footer.html");
});
</script>
	<!-- Mainly scripts -->
     <script src="resources/js/jquery-2.1.1_old.js"></script> 
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="resources/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <!-- Peity -->
    <script src="resources/js/plugins/peity/jquery.peity.min.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="resources/js/inspinia.js"></script>
    <script src="resources/js/plugins/pace/pace.min.js"></script>

    <!-- iCheck -->
    <script src="resources/js/plugins/iCheck/icheck.min.js"></script>

    <!-- Peity -->
    <script src="resources/js/demo/peity-demo.js"></script>
			   
</body>
</html>
