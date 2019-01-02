<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title></title>

<link href="resources/css/plugins/chosen/chosen.css" rel="stylesheet">
<link href="resources/css/plugins/select2/select2.min.css"
	rel="stylesheet">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/font-awesome/css/font-awesome.css"
	rel="stylesheet">
<link href="resources/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="resources/css/animate.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">

<link href="resources/css/dataTables/truck_history_bootstrap.min.css" rel="stylesheet">
<link href="resources/css/dataTables/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="resources/css/dataTables/fixedHeader.bootstrap.min.css" rel="stylesheet">
<link href="resources/css/dataTables/responsive.bootstrap.min.css" rel="stylesheet">
 
 
 
 
 <!-- <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.datatables.net/fixedheader/3.1.5/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.bootstrap.min.css" rel="stylesheet">
  -->





 
 <link
	href="resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css"
	rel="stylesheet">
	<style>
	.text-large {
  font-size: 100%;
}
	</style>
<body class="md-skin">
	<div id="wrapper">
		<!--  <div id="navbar"></div> -->
		<%@include file="navbar.jsp"%>
		<div id="page-wrapper" class="gray-bg">
			<div id="header"></div>
			<div class="row wrapper border-bottom white-bg page-heading">
				<div class="col-lg-10">
					<h2>History</h2>
					<ol class="breadcrumb">
						<li><a href="index.html">Home</a></li>
						<li><a>History</a></li>

					</ol>
				</div>
				<div class="col-lg-2"></div>
			</div>
			<div class="wrapper wrapper-content animated fadeInRight">

				<div class="row">
					<div class="col-lg-12">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5>DistrictWise Normal Load Configure View</h5>
								<!-- <div class="ibox-tools">
									<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
									</a> <a class="dropdown-toggle" data-toggle="dropdown" href="#">
										<i class="fa fa-wrench"></i>
									</a>
									<ul class="dropdown-menu dropdown-user">
										<li><a href="#">Config option 1</a></li>
										<li><a href="#">Config option 2</a></li>
									</ul>
									<a class="close-link"> <i class="fa fa-times"></i>
									</a>
								</div> -->
							</div>
							<div class="ibox-content">
								<form:form action="searchByVehicleNoDistrictName">
									<div calss="row">
										<!-- <div class="col-lg-4">
											<div class="form-group">

												<label class="font-normal ">Select for search</label>
												<div class="input-group text-large">
													<select id="selected" name="selected" class="chosen-select" style="width:200px;">
														<option value="Select">Select</option>
														<option value="Vehicle No">Vehicle No</option>
														<option value="District Name">District Name</option>
													</select>
												</div>
											</div>
										</div>
 -->
										<!-- <div class="col-lg-3">
											<br />
											<div class="form-group">

												<input type="text" class="form-control" id="textId" name="value" value=""
													placeholder="Search By" />
												

											</div>
 

										</div>
										<div class="col-lg-1"><br/>
										<button class="btn btn-sm btn-primary"  type="submit">Search</button>
										</div>

 -->
										<c:choose>
											<c:when test="${showMessage == 'format'}">
												<h4 style="color: red;">select proper format file to
													upload</h4>
											</c:when>
										</c:choose>
										<button type="button"  class="btn btn-info btn-sm pull-right" data-toggle="modal" data-target="#myModal">Add</button>
										<div class="clearfix"></div>
										<table id="dataTable" class="table table-striped table-bordered nowrap">
											<thead>
												<tr>
													<th>District Name</th>
													<th>Rated Load</th>
													<th>Normal Load(%)</th>
													<th>Normal Load(Tonns)</th>
													<!--                                      <th>Last_Transaction_Of_Normal_Load</th>
 -->
												</tr>
											</thead>
											<tbody id="searchData">
												<c:choose>
												
													<c:when test="${not empty configureViewData}">
														<c:forEach items="${configureViewData}" var="viewData"
															varStatus="status">
															<tr>
																<td>${viewData.districtName}</td>
																<td>${viewData.ratedLoad}</td>
																<td>${viewData.truckOverLoading}</td>
																<td>${viewData.truckOverLoadingtonns}</td>
																
																<%-- 												<td>${historyData.lastTransactionOfNormalLoad}</td>
 --%>
															</tr>
														</c:forEach>
													</c:when>
													<c:when test="${empty configureViewData}">
														<tr>
															<td colspan='5'><center>
																	<p style="color: red; font-size: 15px;">Data is
																		not present</p>
																</center></td>
														</tr>
													
													</c:when>
												</c:choose>
											</tbody>

										</table>

									</div>
								</form:form>
							</div>
						</div>

					</div>

				</div>
				<!--  <div id="footer"></div> -->
				<%@include file="footer.html"%>
			</div>
		</div>




		<div id="myModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content animated bounceInRight">
					<div class="modal-header">


						<h4 class="modal-title"> Normal Load Configuration</h4>

					</div>
					<div class="modal-body">
					<form id="formId" class="form-horizontal m-l-md" action="normalLoadConfiguration1" method="post">
                            
                                <div class="form-group"><label class="col-lg-3 control-label">District Name :</label>

                                    <div class="col-lg-5">
                                    <input id="districtName" name="districtName" placeholder="District Name" type="text" class="form-control" onchange="checkDistrictName()" >
                                    
                                    <label id="districtError"></label>
                                    </div>
                                </div>
                                <div class="form-group"><label class="col-lg-3 control-label">Rated Load :</label>
                                    <div class="col-lg-5">
                                    <input id="txt1" name="ratedLoad" placeholder="Rated Load" type="text" class="form-control">
                                    
									</div>
                                </div>
								 <div class="form-group"><label class="col-lg-3 control-label">Normal Load (%) :</label>
                                    <div class="col-lg-5">
                                    <input id="txt2" name="normalLoadInPer" placeholder="Normal Load in percentage" type="text" class="form-control" >
                                    
									 </div>
                                </div>
                                	 <div class="form-group"><label class="col-lg-3 control-label">Normal Load (Tonns):</label>
                                    <div class="col-lg-5">
                                    <input id="rate" name="normalLoadInTonns" placeholder="Normal Load in tonns" type="text" class="form-control">
                                    
									 </div>
                                </div>
                                 <div class="form-group"><label class="col-lg-3 control-label"></label>
                                    <div class="col-lg-5">
                                    <button class="btn btn-sm btn-primary" name="add" type="submit">Add</button>
                                        <button class="btn btn-sm btn-primary pull-right" name="update" type="submit">Update</button>
                                    
									 </div>
                                </div>
                         
                        </form>
                   

					</div>
					<!-- <div class="modal-footer">
						<button type="button" class="btn btn-white btn-rounded"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary btn-rounded">Save
							changes</button>
					</div> -->
				</div>
			</div>
		</div>
		
	<!-- 	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/fixedheader/3.1.5/js/dataTables.fixedHeader.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.3/js/dataTables.responsive.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.3/js/responsive.bootstrap.min.js"></script> -->
<script src="resources/js/jquery-2.1.1_old.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/jquery.form-validator.min.js"></script>

<!-- Data Tables   -->
<script src="resources/js/dataTables/truck_history_jquery-3.3.1.js"></script>
<script src="resources/js/dataTables/jquery.dataTables.min.js"></script>
   <script src="resources/js/dataTables/dataTables.bootstrap.min.js"></script>
   <script src="resources/js/dataTables/dataTables.fixedHeader.min.js"></script>
   <script src="resources/js/dataTables/dataTables.responsive.min.js"></script>
   <script src="resources/js/dataTables/responsive.bootstrap.min.js"></script> 


<script>
		$(document).ready(function() {
		    var table = $('#dataTable').DataTable( {
		        responsive: true
		    } );
		 
		    new $.fn.dataTable.FixedHeader( table );
		} );
</script>


		<!-- Mainly scripts -->
		<!-- <script src="https://code.jquery.com/jquery-3.3.1.min.js"
			integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
			crossorigin="anonymous"></script>
		 -->
		
		
		
		
		<script>
		
$(document).ready(function(){
    $("#navbar").load("navbar.html");
	 $("#header").load("header.html");
	 $("#footer").load("footer.html");
});

   	</script>

		
		<!-- <script src="resources/js/jquery-2.1.1_old.js"></script> -->
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

		<!-- Custom and plugin javascript -->
		<script src="resources/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

		<!-- Chosen -->
		<script src="resources/js/plugins/chosen/chosen.jquery.js"></script>
		<!-- <!-- Chosen -->
		<script src="js/plugins/chosen/chosen.jquery.js"></script>
		-->
		<!-- JSKnob -->
		<script src="resources/js/plugins/jsKnob/jquery.knob.js"></script>

		<!-- Input Mask-->
		<script src="resources/js/plugins/jasny/jasny-bootstrap.min.js"></script>

		<!-- Data picker -->
		<script src="resources/js/plugins/datapicker/bootstrap-datepicker.js"></script>

		<!-- NouSlider -->
		<script src="resources/js/plugins/nouslider/jquery.nouislider.min.js"></script>

		<!-- Switchery -->
		<script src="resources/js/plugins/switchery/switchery.js"></script>

		<!-- IonRangeSlider -->
		<script
			src="resources/js/plugins/ionRangeSlider/ion.rangeSlider.min.js"></script>

		<!-- iCheck -->
		<script src="resources/js/plugins/iCheck/icheck.min.js"></script>

		<!-- MENU -->
		<script src="resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>

		<!-- Color picker -->
		<script
			src="resources/js/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>

		<!-- Clock picker -->
		<script src="resources/js/plugins/clockpicker/clockpicker.js"></script>

		<!-- Image cropper -->
		<script src="resources/js/plugins/cropper/cropper.min.js"></script>

		<!-- Date range use moment.js same as full calendar plugin -->
		<script src="resources/js/plugins/fullcalendar/moment.min.js"></script>

		<!-- Date range picker -->
		<script src="resources/js/plugins/daterangepicker/daterangepicker.js"></script>

		<!-- Select2 -->
		<script src="resources/js/plugins/select2/select2.full.min.js"></script>

		<!-- TouchSpin -->
		<script
			src="resources/js/plugins/touchspin/jquery.bootstrap-touchspin.min.js"></script>
			
			<script type="text/javascript">
		
		$(document).ready(function(){
		    $("#navbar").load("navbar.jsp");
			 $("#header").load("header.html");
			 $("#footer").load("footer.html");
			   $("#txt1,#txt2").change(function () { // input on change
			        var result = parseFloat(parseInt($("#txt1").val(), 10) * parseInt($("#txt2").val(), 10) / 100 );
			        $('#rate').val(result || ''); //shows value in "#rate"
			    })
		});
		
		
		
		$(function () {    
		    $("#formId").validate({
		    	
		        rules: {
		        	txt2: {
		                required: true,
		                minlength: 100
		            },
		            action: "required"
		        },
		        messages: {
		        	txt2: {
		                required: "Please enter some data",
		                minlength: "Your data must be at least 8 characters"
		            },
		            action: "Please provide some data"
		        }
		    });
		});
		
		</script>	   
			

		</body>

</html>
