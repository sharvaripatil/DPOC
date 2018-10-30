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
 <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAF27UXmyKEQpNmybxxaViJpYWo-yFzkxk"></script> 
 <!-- <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAyYtYpllFDH6MlGZzgw4wOZqVPe6vlGwU&callback=initMap"> </script> -->
<style type="text/css">
#map {
  height: 500px;
  width: 500px;
  margin: 0px;
  padding: 0px
}
 
</style>

</head>

<body class="md-skin">
<div id="wrapper">
  <nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
      <ul class="nav metismenu" id="side-menu">
        <li class="nav-header">
          <div class="dropdown profile-element"> <span> <img alt="image"  src="resources/img/logo.png" /> </span> <a data-toggle="dropdown" class="dropdown-toggle" href="#"> <span class="clear"> <!-- <span class="block m-t-xs"> <strong class="font-bold">Azam Rizvi</strong> </span> <span class="text-muted text-xs block">Admin <b class="caret"></b></span> </span> --> </a>
            <ul class="dropdown-menu animated fadeInRight m-t-xs">
              <li><a href="profile.html">Profile</a></li>
              <li><a href="contacts.html">Contacts</a></li>
              <li><a href="mailbox.html">Mailbox</a></li>
              <li class="divider"></li>
              <li><a href="login.html">Logout</a></li>
            </ul>
          </div>
          <div class="logo-element"> </div>
        </li>
        <li> <a href="index.html"><i class="fa fa-th-large"></i> <span class="nav-label">Dashboards</span></a> </li>
		      <li class="active"> <a href="<c:url value='/algorithmProcess' />"><i class="fa fa-th-large"></i> <span class="nav-label">Algorithm Process</span></a> </li>
     
      </ul>
    </div>
  </nav>

        <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
        <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
            <form role="search" class="navbar-form-custom" action="search_results.html">
                <div class="form-group">
                    <input type="text" placeholder="Search for something..." class="form-control" name="top-search" id="top-search">
                </div>
            </form>
        </div>
            <ul class="nav navbar-top-links navbar-right">
            
                <li class="dropdown">
                    <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope"></i>  <span class="label label-warning">16</span>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <div class="dropdown-messages-box">
                                <a href="profile.html" class="pull-left">
                                    <img alt="image" class="img-circle" src="img/a7.jpg">
                                </a>
                                <div class="media-body">
                                    <small class="pull-right">46h ago</small>
                                    <strong>Mike Loreipsum</strong> started following <strong>Monica Smith</strong>. <br>
                                    <small class="text-muted">3 days ago at 7:58 pm - 10.06.2014</small>
                                </div>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="dropdown-messages-box">
                                <a href="profile.html" class="pull-left">
                                    <img alt="image" class="img-circle" src="img/a4.jpg">
                                </a>
                                <div class="media-body ">
                                    <small class="pull-right text-navy">5h ago</small>
                                    <strong>Chris Johnatan Overtunk</strong> started following <strong>Monica Smith</strong>. <br>
                                    <small class="text-muted">Yesterday 1:21 pm - 11.06.2014</small>
                                </div>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="dropdown-messages-box">
                                <a href="profile.html" class="pull-left">
                                    <img alt="image" class="img-circle" src="img/profile.jpg">
                                </a>
                                <div class="media-body ">
                                    <small class="pull-right">23h ago</small>
                                    <strong>Monica Smith</strong> love <strong>Kim Smith</strong>. <br>
                                    <small class="text-muted">2 days ago at 2:30 am - 11.06.2014</small>
                                </div>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="text-center link-block">
                                <a href="mailbox.html">
                                    <i class="fa fa-envelope"></i> <strong>Read All Messages</strong>
                                </a>
                            </div>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell"></i>  <span class="label label-primary">8</span>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="mailbox.html">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> You have 16 messages
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="profile.html">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="grid_options.html">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="text-center link-block">
                                <a href="notifications.html">
                                    <strong>See All Alerts</strong>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                            </div>
                        </li>
                    </ul>
                </li>


                <li>
                    <a href="login.html">
                        <i class="fa fa-sign-out"></i> Log out
                    </a>
                </li>
            </ul>

        </nav>
        </div>
            <div class="row wrapper border-bottom white-bg page-heading">
                <div class="col-lg-10">
                    <h2>Intelliship</h2>
                    <ol class="breadcrumb">
                        <li>
                            <a href="index.html">Home</a>
                        </li>
                        <li>
                            <a>Intelliship</a>
                        </li>
                      
                    </ol>
                </div>
                <div class="col-lg-2">

                </div>
            </div>
        <div class="wrapper wrapper-content animated fadeInRight">
      
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>Intelliship</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="#">Config option 1</a>
                                    </li>
                                    <li><a href="#">Config option 2</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
							
                            <table class="table table-bordered">
                                <thead>
                                <tr>

											<th>Truck No.</th>
											<th>District Name</th>
											<th>Load Type</th>
											<th>Material Type</th>
											<th>Total Order</th>
											<th>Total Order Quantity</th>
											<th>Truck Capacity</th>
											<th>Pending Quantity</th>
											<th>Plant</th>
											<th>Total Kilometers</th>
											<th>Shipping Estimation Time</th>
											<th>Shipping Status</th>
											<th>Map</th>

										</tr>
                                </thead>
                                <tbody>
										<c:forEach items="${shippingGroupList}"
											var="shippingGroupDetails" varStatus="status">
											<tr>
												<td>${shippingGroupDetails.truckNo}</td>
												<td>${shippingGroupDetails.districtName}</td>
												<td>${shippingGroupDetails.loadType}</td>
												<td>${shippingGroupDetails.materialType}</td>
												<td><button class="btn btn-success btn-circle" type="button" 
														onclick="getOrderDetailsByMaterial('${shippingGroupDetails.truckNo}')">${shippingGroupDetails.totalOrders}
													</button></td> 
												<td>${shippingGroupDetails.totalOrderQuantity}</td>
												<td>${shippingGroupDetails.truckCapacity}</td>
												<td>${shippingGroupDetails.pendingQuantity}</td>
												<td>${shippingGroupDetails.plant}</td>
												<td>${shippingGroupDetails.totalKilometers}</td>
												<td>${shippingGroupDetails.estimationTime}</td>
												<td>${shippingGroupDetails.shippingStatus}</td>
												<td>   <a class="btn btn-primary btn-rounded" onclick="getMap('${shippingGroupDetails.truckNo}')" >View Map</a></td>
												
											</tr>
										</c:forEach>
									</tbody>

                            </table>
                           <a href="<c:url value='/algorithmProcess' />" class="btn btn-success pull-right" type="button">Back
                            </a>
                        </div>
						
                    </div>
					 
                </div>
        
            </div>
       
        </div>
        <div class="footer">
            <div class="pull-right">
                10GB of <strong>250GB</strong> Free.
            </div>
             <div> <strong>Copyright</strong> A4Technology Solution Pvt. Ltd &copy; 2017-2018 </div>
        </div>

        </div>
        </div>

  <div class="modal" id="configurealgo" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog modal-lg">
                                <div class="modal-content animated bounceInRight">
                                        <div class="modal-header">
                                          
                                        
                                            <h4 class="modal-title">Shipping Order Details</h4>
                                         
                                        </div>
                                        <div class="modal-body" style="overflow-x: auto;">
                                             <table class="table table-bordered" id="data">
                                <thead>
                                <tr>
									<th>Delivery</th>
                                    <th>Reference Document</th>
                                    <th>Sold to Party</th>
									 <th>Name of sold to Party</th>
                                    <th>Name of the ship tp party</th>
                                    <th>Material</th>
									 <th>Actual delivery Qty</th>
                                    <th>Route Description</th>
                                    <th>District Name</th>
                                    <th>Plant</th>
                                    <th>Route</th>
									 <th>Forwarding Agent Name</th>
                                    <th>Distribution Channel</th>
                                    <th>Deliv.Date(From/To)</th>
									 <th>Delivery Type</th>
                                    <th>Shipping Point/Receiving Pt</th>
                                    <th>District Code</th>
									 <th>Ship to Party</th>
                                    <th>Shio to Long</th>
                                    <th>Ship to Latt</th>
								 </tr>
                                </thead>
                                <tbody id="orderData">
																				
									</tbody>
                            </table>
                                                 
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-white btn-rounded" data-dismiss="modal">Close</button>
                                            <!-- <button type="button" class="btn btn-primary btn-rounded">Save changes</button> -->
                                        </div>
                                    </div>
                                </div>
                            </div>
      <div class="modal" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content animated bounceInRight">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title"><i class="fa fa-truck"></i> Shipping Detail</h4>
      </div>
      <div class="modal-body">
      <div id="map" style="border: 2px solid #3872ac;"></div>
      <div id="directions_panel"></div>
      
       <!--  <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d241317.11609997266!2d72.74109837487424!3d19.082197838387007!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3be7c6306644edc1%3A0x5da4ed8f8d648c69!2sMumbai%2C+Maharashtra!5e0!3m2!1sen!2sin!4v1534840526127" width="100%" height="450" frameborder="0" style="border:0" allowfullscreen></iframe> -->
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-white" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

	<div class="modal" id="truck_quantity" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content animated bounceInRight">
      <div class="modal-header">
        <h4 class="modal-title">Truck Quantity</h4>
      </div>
      <div class="modal-body" style="overflow-x: auto;">
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>Order No.</th>
              <th>Order Quantity</th>
              <th>Truck No.</th>
              <th>Truck Capacity</th>
			  <th>Truck Order Quatitiy</th>
              
            </tr>
          </thead>
          <tbody id="orderGroup">
            
          </tbody>
        </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-white btn-rounded" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
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

    <script>
        $(document).ready(function(){
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
        
       /*  $(document).ready(function() {
            $("#myModal").modal();
          }); */
        
        function getOrderDetailsByDate(date){
        	$.ajax({
				type : "GET",
				url : "getShippingOrderByDate",
				data : "orderDate=" + date,
				success : function(response) {
					$("#orderData").empty();
					$.each(response, function(i, value) {
						 $("#orderData").append("<tr><td>" + value.delivery + "</td><td>" + value.deference_document + "</td><td>" + value.sold_to_party + 
								"</td><td>" + value.name_of_sold_to_party + "</td><td>"  + value.name_of_the_ship_to_party + "</td><td>" + 
								 value.material + "</td><td>" + value.actual_delivery_qty + "</td><td>" + 
								  value.route_description + "</td><td>" + value.district_name + "</td><td>"  
								 + value.plant + "</td><td>"+ value.route + "</td><td>" + 
								 value.forwarding_agent_name + "</td><td>" + value.distribution_channel + "</td><td>" + value.deliv_date + "</td><td>" +
								 value.delivery_type + "</td><td>" +value.shipping_Point + "</td><td>" +value.district_code + "</td><td>" +
 value.ship_to_party + "</td><td>"+ value.ship_to_long + "</td><td>" + value.ship_to_latt +"</td></tr>"); 
					});

				},
				error : function(e) {
					 alert('Error: ' + e); 
				}
			});

        	$("#configurealgo").modal(); 
        	
        }
          function getOrderDetailsByMaterial(truckNo){
        	  $.ajax({
  				type : "GET",
  				url : "getGroupOrderByTruck",
  				data : "truckNo=" + truckNo,
  				success : function(response) {
  					$("#orderData").empty();
  					$.each(response, function(i, value) {
  						 $("#orderData").append("<tr><td>" + value.delivery + "</td><td>" + value.deference_document + "</td><td>" + value.sold_to_party + 
  								"</td><td>" + value.name_of_sold_to_party + "</td><td>"  + value.name_of_the_ship_to_party + "</td><td>" + 
  								 value.material + "</td><td>" + value.actual_delivery_qty + "</td><td>" + 
  								  value.route_description + "</td><td>" + value.district_name + "</td><td>"  
  								 + value.plant + "</td><td>"+ value.route + "</td><td>" + 
  								 value.forwarding_agent_name + "</td><td>" + value.distribution_channel + "</td><td>" + value.deliv_date + "</td><td>" +
  								 value.delivery_type + "</td><td>" +value.shipping_Point + "</td><td>" +value.district_code + "</td><td>" +
   value.ship_to_party + "</td><td>"+ value.ship_to_long + "</td><td>" + value.ship_to_latt +"</td></tr>"); 
  					});

  				},
  				error : function(e) {
  					 alert('Error: ' + e); 
  				}
  			});

          	$("#configurealgo").modal(); 
  
          }
          function getGroupOrder(date){
          	$.ajax({
  				type : "GET",
  				url : "getGroupOrderByDate",
  				data : "orderDate=" + date,
  				success : function(response) {
  					$("#orderGroup").empty();
  					$.each(response, function(i, value) {
  						 $("#orderGroup").append("<tr><td>" + value.delivaryNo + "</td><td>" + value.originalOrderQty + "</td><td>" + value.truckNo + 
 								"</td><td>" + value.truckCapacity + "</td><td>"  + value.truckOrderQty +"</td></tr>");  
  					});

  				},
  				error : function(e) {
  					 alert('Error: ' + e); 
  				}
  			});

          	$("#truck_quantity").modal(); 
          	
          }
          var trucksData;
          function getMap(truckNo){
        	  
        	  $.ajax({
    				type : "GET",
    				url : "getLatiAndLongValues",
    				data : "truckNo=" + truckNo,
    				success : function(response) {
    					var json = JSON.stringify(response);
    					trucksData = json;
    					showmap();
    				},
    				error : function(e) {
    					 alert('Error: ' + e); 
    				}
    			});
          }

          /* var MapPoints = '[{"address":{"lat":"23.7012517","lng":"86.0591489"},"title":"Dalmia Cement,JHARKHAND"},{"address":{"lat":"24.5246","lng":"84.2845"},"title":"NAVIN CEMENT STORE"},{"address":{"lat":"24.2493788","lng":"83.9261005"},"title":"SAKSHI TRADERS"}]'; */

          var MY_MAPTYPE_ID = 'custom_style';
          var directionsDisplay;
          var directionsService = new google.maps.DirectionsService();
          var map;
          function showmap() {
        	  var pointA = new google.maps.LatLng(23.7012517, 86.0591489);
            if (jQuery('#map').length > 0) {
            	map = new google.maps.Map(document.getElementById('map'), {
            		 zoom: 15,
            		center: pointA,
            		mapTypeId: google.maps.MapTypeId.ROADMAP,
                    scrollwheel: false 
                  });
            	
            	directionsDisplay = new google.maps.DirectionsRenderer({
            		map: map,
                    suppressMarkers: true
                  });
               var locations = jQuery.parseJSON(trucksData);
             /*  var locations =  trucksData; */
              
              directionsDisplay.setMap(map);

              var infowindow = new google.maps.InfoWindow();
              var shippingCoordinates = [];
              var bounds = new google.maps.LatLngBounds();

              for (i = 0; i < locations.length; i++) {
                marker = new google.maps.Marker({
                  position: new google.maps.LatLng(locations[i].latitude, locations[i].longitude),
                  map: map
                });
                shippingCoordinates.push(marker.getPosition());
                bounds.extend(marker.position);

                google.maps.event.addListener(marker, 'click', (function(marker, i) {
                  return function() {
                    infowindow.setContent(locations[i].placeName);
                    infowindow.open(map, marker);
                  }
                })(marker, i));
              }

              map.fitBounds(bounds);

              // directions service configuration
              var start = shippingCoordinates[0];
              var end = shippingCoordinates[shippingCoordinates.length - 1];
              var waypts = [];
              for (i = 0; i < locations.length; i++) {    
            	     waypts.push({
            	        location: new google.maps.LatLng(locations[i].latitude, locations[i].longitude),
            	        stopover: true
            	     });
            	}
              calcRoute(start, end, waypts);
/* 
            	directionsService.route({
            	  origin: new google.maps.LatLng(locations[0].latitude, locations[0].longitude),
            	  destination: new google.maps.LatLng(locations[locations.length - 1].latitude, locations[locations.length - 1].longitude),
            	  waypoints: waypts,
            	  optimizeWaypoints: true,
            	  travelMode: 'DRIVING'
            	}, function(response, status) {
            	  if (status === 'OK') {
            	    directionsDisplay.setDirections(response);
            	    var route = response.routes[0];
            	  } else {
            	    window.alert('Directions request failed due to ' + status);
            	  }
            	}); */
              /* for (var i = 1; i < shippingCoordinates.length - 1; i++) {
                waypts.push({
                  location: shippingCoordinates[i],
                  stopover: true
                });
              }
              calcRoute(start, end, waypts); */
            }
            $("#myModal").modal();
          }

          function calcRoute(start, end, waypts) { 
            var request = {
              origin: start,
              destination: end,
              waypoints: waypts,
              optimizeWaypoints: true,
              travelMode: google.maps.TravelMode.DRIVING
            };
            directionsService.route(request, function(response, status) {
              if (status == google.maps.DirectionsStatus.OK) {
                directionsDisplay.setDirections(response);
                var route = response.routes[0];
                var summaryPanel = document.getElementById('directions_panel');
                summaryPanel.innerHTML = '';
                // For each route, display summary information.
                /* for (var i = 0; i < route.legs.length; i++) {
                  var routeSegment = i + 1;
                  summaryPanel.innerHTML += '<b>Route Segment: ' + routeSegment + '</b><br>';
                  summaryPanel.innerHTML += route.legs[i].start_address + ' to ';
                  summaryPanel.innerHTML += route.legs[i].end_address + '<br>';
                  summaryPanel.innerHTML += route.legs[i].distance.text + '<br><br>';
                } */
              } else {
          	    window.alert('Directions request failed due to ' + status);
        	  }
            });
          }
          google.maps.event.addDomListener(window, 'load', initialize);
           

          
         </script>

</body>

</html>
