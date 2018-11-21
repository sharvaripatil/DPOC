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

    <title></title>

    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="resources/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="resources/css/animate.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">
	 <link href="resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">

</head>

<body class="md-skin">
<div id="wrapper">
 <!-- <div id="navbar"></div> -->
  <%@include file="navbar.jsp" %>

        <div id="page-wrapper" class="gray-bg">
     <div class="top-content">
  <div class="inner-bg">
    <div class="container">
      <div class="row">
        <div class="col-sm-8 col-sm-offset-2 text">
          <h1 style="background:rgba(34, 34, 34, 0.9); padding:15px;width:48%;margin:0px auto;color:#FFC107"><strong>Upload File</strong></h1>
        </div>
      </div>
      <div class="row">
       
        <div class="col-md-4 col-md-offset-4 text">
        
          <div class="form-bottom">
              <form:form action="uploadTrucksInfo" name="fileUpload" enctype="multipart/form-data" modelAttribute="fileUpload">
             <div class="form-group">
             <c:choose>
             	<c:when test="${ftpMessage == 'success'}">
             	<h4 style="color: green;">File has been save successfully</h4> 
             	</c:when>
             	<c:when test="${ftpMessage == 'failure'}">
             	  <h4 style="color: red;">File is not saved ,Please check once!</h4>
             	</c:when>
             	<c:when test="${invalidFile == ''}">
             		<h4 style="color: red;">Please Upload File</h4>
             	</c:when>
             	<c:when test="${invalidAsiNum == ''}">
             		<h4 style="color: red;">Please Enter Details in Login Page</h4>
             	</c:when>
             	<c:when test="${misMatchCoumns == 'misMatchCoumns'}">
             	   <h4 style="color: red;">Please Enter Correct Supplier File Format As Columns Are Mismatch</h4>
				 </c:when>
             </c:choose>
    <input type="file" name="file" id="file" class="file">
    <div class="input-group col-xs-12">
      <input type="text" class="form-control input-lg" disabled placeholder="Upload File">
      <span class="input-group-btn">
        <button class="browse btn btn-primary input-lg" type="button"><i class="glyphicon glyphicon-search"></i> Browse</button>
      </span>
       
     <%--  <input type="file" name="file" id="file-1" class="inputfile inputfile-1" data-multiple-caption="{count} files selected" multiple ismap="ismap"/>
      <span class="input-group-btn">
      <form:button value="submit" class="browse btn btn-primary input-lg">Submit</form:button> --%>
       <!--  <button class="browse btn btn-primary input-lg" type="button"><i class="glyphicon glyphicon-search"></i> Browse</button> -->
    
      </span>
    </div>
  </div>
              <div class="submitbtn">
              <form:button val="submit" class="btn1 btn-primary btn-lg pull-right" onclick="return validateForm()">Submit</form:button>
               <a href="#" class="btn btn-lg btn-default pull-left">Back</a>
              </div>
              <br>
             </form:form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
             <!-- <div id="footer"></div> -->
      <%@include file="footer.html" %>

        </div>
        </div>


    
    <!-- Mainly scripts -->
   <!-- <script src="https://code.jquery.com/jquery-3.3.1.min.js"
			  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
			  crossorigin="anonymous"></script> -->
		<script>
		
$(document).ready(function(){
    $("#navbar").load("navbar.jsp");
	 $("#header").load("header.html");
	 $("#footer").load("footer.html");
});
	</script>
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

    <script>
        $(document).ready(function(){
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>

</body>

</html>
