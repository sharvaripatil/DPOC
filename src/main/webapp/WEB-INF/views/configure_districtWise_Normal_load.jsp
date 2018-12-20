<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html lang="en">

<head>
<!-- <meta charset="utf-8"> -->
<meta  name="viewport" content="width=device-width, initial-scale=1.0">
<title>Normal Load Configuration</title>

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="resources/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="resources/css/animate.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">

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
				 
				
				<div class="ibox-content" style="color:black">
				  <c:choose>
				    <c:when test="${message == 'success'}">
				    <center>
				    <h4 style="color: green;">New District Normal Load Data has been saved successfully</h4>
				    </center>
				    </c:when>
				     <c:when test="${update == 'updateSuccess'}">
				    <center>
				    <h4 style="color: green;"> District Normal Load Data has been updated successfully</h4>
				    </center>
				    </c:when>
				  </c:choose>
                             <form:form id="formId" action="normalLoadConfiguration" class="form-horizontal m-l-md" modelAttribute="normalLoadConfig" method="post">
                            
                                <div class="form-group"><label class="col-lg-2 control-label" >District Name :</label>

                                    <div class="col-lg-3">
                                    <form:input path="districtName"  type="text" placeholder="District Name" onchange="checkDistrictName()" class="form-control"/>
                                    <form:errors path="districtName" class="help-block m-b-none  text-danger"></form:errors>
                                    <label id="districtError"></label>
                                    </div>
                                </div>
                                <div class="form-group"><label class="col-lg-2 control-label">Rated Load :</label>
                                    <div class="col-lg-3">
                                    <form:input path="ratedLoad"  type="text" placeholder="Rated Load" class="form-control"/>
                                    <form:errors path="ratedLoad" class="help-block m-b-none  text-danger"></form:errors>
									</div>
                                </div>
								 <div class="form-group"><label class="col-lg-2 control-label">Normal Load :</label>
                                    <div class="col-lg-3">
                                    <form:input path="normalLoad"  type="text" placeholder="Normal Load" class="form-control"/>
                                    <form:errors path="normalLoad" class="help-block m-b-none  text-danger"></form:errors>
									 </div>
                                </div>
                                <div class="form-group">
                               <%--  <spring:url value="" var=""></spring:url> --%>
                                    <div class="col-lg-offset-2 col-lg-10">
                                        <button class="btn btn-sm btn-primary" name="add" type="submit">Add</button>
                                        <button class="btn btn-sm btn-primary"  style="margin-left: 14%;" name="update" type="submit">Update</button>
<!--                                         <button class="btn btn-sm btn-primary"  style="margin-left: 9%;" name="Reset" type="reset" id="resetId">Reset</button> -->
                                    </div>
                                   
                                </div>
                        </form:form>
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

/* $('#resetId').click(function(){
	alert('reset');
	$('#formId').trigger("reset");
	//$('#formId').reset();
}); */

function checkDistrictName(){
	var districtName = $('#districtName').val();
	$.ajax({
			type : "GET",
			url : "checkDistrictName",
			data : "districtName=" + districtName,
			success : function(response) {
				
				$('#ratedLoad').val(response.ratedLoad);
				$('#normalLoad').val(response.truckOverLoading);
               /* if(response == true){
            	   $('#districtError').text('District name is already avaialble').css('color','red');
               } else {
            	   $('#districtError').text('');
               } */
			},
			error : function(e) {
				 alert('Error: ' + e); 
			}
		});

}

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
