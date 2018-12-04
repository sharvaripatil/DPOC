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
<title>Dashboard</title>
<!-- <link href="css/bootstrap.min.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
 -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="resources/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="resources/css/animate.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">
	<!--  <link href="resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet"> -->


<style>
#map {
	width: 100%;
	height: 430px;
	margin-left: auto;
	margin-right: auto;
}
}
</style>
</head>

<body class="md-skin">
<div id="wrapper">
  <div id="navbar"></div>
  <div id="page-wrapper" class="gray-bg">
    <div id="header"></div>
    <div class="wrapper wrapper-content"> 
<div class="col-lg-12">
			<div class="ibox-title">
				 <h5> Title will be here....</h5> <!-- for navbar sub menu <span class="fa fa-chevron-right"></span> -->
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
       <div id="footer"></div>
    <div id="right-sidebar">
      <div class="sidebar-container">
        <ul class="nav nav-tabs navs-3">
          <li class="active"><a data-toggle="tab" href="#tab-1"> Notes </a></li>
          <li><a data-toggle="tab" href="#tab-2"> Projects </a></li>
          <li class=""><a data-toggle="tab" href="#tab-3"> <i class="fa fa-gear"></i> </a></li>
        </ul>
        <div class="tab-content">
          <div id="tab-1" class="tab-pane active">
            <div class="sidebar-title">
              <h3> <i class="fa fa-comments-o"></i> Latest Notes</h3>
              <small><i class="fa fa-tim"></i> You have 10 new message.</small> </div>
            <div>
              <div class="sidebar-message"> <a href="#">
                <div class="pull-left text-center"> <img alt="image" class="img-circle message-avatar" src="img/a1.jpg">
                  <div class="m-t-xs"> <i class="fa fa-star text-warning"></i> <i class="fa fa-star text-warning"></i> </div>
                </div>
                <div class="media-body"> There are many variations of passages of Lorem Ipsum available. <br>
                  <small class="text-muted">Today 4:21 pm</small> </div>
                </a> </div>
              <div class="sidebar-message"> <a href="#">
                <div class="pull-left text-center"> <img alt="image" class="img-circle message-avatar" src="img/a2.jpg"> </div>
                <div class="media-body"> The point of using Lorem Ipsum is that it has a more-or-less normal. <br>
                  <small class="text-muted">Yesterday 2:45 pm</small> </div>
                </a> </div>
              <div class="sidebar-message"> <a href="#">
                <div class="pull-left text-center"> <img alt="image" class="img-circle message-avatar" src="img/a3.jpg">
                  <div class="m-t-xs"> <i class="fa fa-star text-warning"></i> <i class="fa fa-star text-warning"></i> <i class="fa fa-star text-warning"></i> </div>
                </div>
                <div class="media-body"> Mevolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like). <br>
                  <small class="text-muted">Yesterday 1:10 pm</small> </div>
                </a> </div>
              <div class="sidebar-message"> <a href="#">
                <div class="pull-left text-center"> <img alt="image" class="img-circle message-avatar" src="img/a4.jpg"> </div>
                <div class="media-body"> Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the <br>
                  <small class="text-muted">Monday 8:37 pm</small> </div>
                </a> </div>
              <div class="sidebar-message"> <a href="#">
                <div class="pull-left text-center"> <img alt="image" class="img-circle message-avatar" src="img/a8.jpg"> </div>
                <div class="media-body"> All the Lorem Ipsum generators on the Internet tend to repeat. <br>
                  <small class="text-muted">Today 4:21 pm</small> </div>
                </a> </div>
              <div class="sidebar-message"> <a href="#">
                <div class="pull-left text-center"> <img alt="image" class="img-circle message-avatar" src="img/a7.jpg"> </div>
                <div class="media-body"> Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32. <br>
                  <small class="text-muted">Yesterday 2:45 pm</small> </div>
                </a> </div>
              <div class="sidebar-message"> <a href="#">
                <div class="pull-left text-center"> <img alt="image" class="img-circle message-avatar" src="img/a3.jpg">
                  <div class="m-t-xs"> <i class="fa fa-star text-warning"></i> <i class="fa fa-star text-warning"></i> <i class="fa fa-star text-warning"></i> </div>
                </div>
                <div class="media-body"> The standard chunk of Lorem Ipsum used since the 1500s is reproduced below. <br>
                  <small class="text-muted">Yesterday 1:10 pm</small> </div>
                </a> </div>
              <div class="sidebar-message"> <a href="#">
                <div class="pull-left text-center"> <img alt="image" class="img-circle message-avatar" src="img/a4.jpg"> </div>
                <div class="media-body"> Uncover many web sites still in their infancy. Various versions have. <br>
                  <small class="text-muted">Monday 8:37 pm</small> </div>
                </a> </div>
            </div>
          </div>
          <div id="tab-2" class="tab-pane">
            <div class="sidebar-title">
              <h3> <i class="fa fa-cube"></i> Latest projects</h3>
              <small><i class="fa fa-tim"></i> You have 14 projects. 10 not completed.</small> </div>
            <ul class="sidebar-list">
              <li> <a href="#">
                <div class="small pull-right m-t-xs">9 hours ago</div>
                <h4>Business valuation</h4>
                It is a long established fact that a reader will be distracted.
                <div class="small">Completion with: 22%</div>
                <div class="progress progress-mini">
                  <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                </div>
                <div class="small text-muted m-t-xs">Project end: 4:00 pm - 12.06.2014</div>
                </a> </li>
              <li> <a href="#">
                <div class="small pull-right m-t-xs">9 hours ago</div>
                <h4>Contract with Company </h4>
                Many desktop publishing packages and web page editors.
                <div class="small">Completion with: 48%</div>
                <div class="progress progress-mini">
                  <div style="width: 48%;" class="progress-bar"></div>
                </div>
                </a> </li>
              <li> <a href="#">
                <div class="small pull-right m-t-xs">9 hours ago</div>
                <h4>Meeting</h4>
                By the readable content of a page when looking at its layout.
                <div class="small">Completion with: 14%</div>
                <div class="progress progress-mini">
                  <div style="width: 14%;" class="progress-bar progress-bar-info"></div>
                </div>
                </a> </li>
              <li> <a href="#"> <span class="label label-primary pull-right">NEW</span>
                <h4>The generated</h4>
                <!--<div class="small pull-right m-t-xs">9 hours ago</div>--> 
                There are many variations of passages of Lorem Ipsum available.
                <div class="small">Completion with: 22%</div>
                <div class="small text-muted m-t-xs">Project end: 4:00 pm - 12.06.2014</div>
                </a> </li>
              <li> <a href="#">
                <div class="small pull-right m-t-xs">9 hours ago</div>
                <h4>Business valuation</h4>
                It is a long established fact that a reader will be distracted.
                <div class="small">Completion with: 22%</div>
                <div class="progress progress-mini">
                  <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                </div>
                <div class="small text-muted m-t-xs">Project end: 4:00 pm - 12.06.2014</div>
                </a> </li>
              <li> <a href="#">
                <div class="small pull-right m-t-xs">9 hours ago</div>
                <h4>Contract with Company </h4>
                Many desktop publishing packages and web page editors.
                <div class="small">Completion with: 48%</div>
                <div class="progress progress-mini">
                  <div style="width: 48%;" class="progress-bar"></div>
                </div>
                </a> </li>
              <li> <a href="#">
                <div class="small pull-right m-t-xs">9 hours ago</div>
                <h4>Meeting</h4>
                By the readable content of a page when looking at its layout.
                <div class="small">Completion with: 14%</div>
                <div class="progress progress-mini">
                  <div style="width: 14%;" class="progress-bar progress-bar-info"></div>
                </div>
                </a> </li>
              <li> <a href="#"> <span class="label label-primary pull-right">NEW</span>
                <h4>The generated</h4>
                <!--<div class="small pull-right m-t-xs">9 hours ago</div>--> 
                There are many variations of passages of Lorem Ipsum available.
                <div class="small">Completion with: 22%</div>
                <div class="small text-muted m-t-xs">Project end: 4:00 pm - 12.06.2014</div>
                </a> </li>
            </ul>
          </div>
          <div id="tab-3" class="tab-pane">
            <div class="sidebar-title">
              <h3><i class="fa fa-gears"></i> Settings</h3>
              <small><i class="fa fa-tim"></i> You have 14 projects. 10 not completed.</small> </div>
            <div class="setings-item"> <span> Show notifications </span>
              <div class="switch">
                <div class="onoffswitch">
                  <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example">
                  <label class="onoffswitch-label" for="example"> <span class="onoffswitch-inner"></span> <span class="onoffswitch-switch"></span> </label>
                </div>
              </div>
            </div>
            <div class="setings-item"> <span> Disable Chat </span>
              <div class="switch">
                <div class="onoffswitch">
                  <input type="checkbox" name="collapsemenu" checked class="onoffswitch-checkbox" id="example2">
                  <label class="onoffswitch-label" for="example2"> <span class="onoffswitch-inner"></span> <span class="onoffswitch-switch"></span> </label>
                </div>
              </div>
            </div>
            <div class="setings-item"> <span> Enable history </span>
              <div class="switch">
                <div class="onoffswitch">
                  <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example3">
                  <label class="onoffswitch-label" for="example3"> <span class="onoffswitch-inner"></span> <span class="onoffswitch-switch"></span> </label>
                </div>
              </div>
            </div>
            <div class="setings-item"> <span> Show charts </span>
              <div class="switch">
                <div class="onoffswitch">
                  <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example4">
                  <label class="onoffswitch-label" for="example4"> <span class="onoffswitch-inner"></span> <span class="onoffswitch-switch"></span> </label>
                </div>
              </div>
            </div>
            <div class="setings-item"> <span> Offline users </span>
              <div class="switch">
                <div class="onoffswitch">
                  <input type="checkbox" checked name="collapsemenu" class="onoffswitch-checkbox" id="example5">
                  <label class="onoffswitch-label" for="example5"> <span class="onoffswitch-inner"></span> <span class="onoffswitch-switch"></span> </label>
                </div>
              </div>
            </div>
            <div class="setings-item"> <span> Global search </span>
              <div class="switch">
                <div class="onoffswitch">
                  <input type="checkbox" checked name="collapsemenu" class="onoffswitch-checkbox" id="example6">
                  <label class="onoffswitch-label" for="example6"> <span class="onoffswitch-inner"></span> <span class="onoffswitch-switch"></span> </label>
                </div>
              </div>
            </div>
            <div class="setings-item"> <span> Update everyday </span>
              <div class="switch">
                <div class="onoffswitch">
                  <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example7">
                  <label class="onoffswitch-label" for="example7"> <span class="onoffswitch-inner"></span> <span class="onoffswitch-switch"></span> </label>
                </div>
              </div>
            </div>
            <div class="sidebar-content">
              <h4>Settings</h4>
              <div class="small"> I belive that. Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                And typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.
                Over the years, sometimes by accident, sometimes on purpose (injected humour and the like). </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- Mainly scripts --> 
<script
			  src="https://code.jquery.com/jquery-3.3.1.min.js"
			  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
			  crossorigin="anonymous"></script>
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
			   
<!-- <script type="text/javascript">

$(document).ready(function(){
    $("#navbar").load("navbar.html");
	 $("#header").load("header.html");
	 $("#footer").load("footer.html");
});
//		  $.ajax({
//      url: "navbar.html",
//      dataType: "html",
//      success: function(data) {
//          $("#navbar").html(data);
//      }
//});

</script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script> 
<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script> 

Flot 
<script src="js/plugins/flot/jquery.flot.js"></script> 
<script src="js/plugins/flot/jquery.flot.tooltip.min.js"></script> 
<script src="js/plugins/flot/jquery.flot.spline.js"></script> 
<script src="js/plugins/flot/jquery.flot.resize.js"></script> 
<script src="js/plugins/flot/jquery.flot.pie.js"></script> 
<script src="js/plugins/flot/jquery.flot.symbol.js"></script> 
<script src="js/plugins/flot/jquery.flot.time.js"></script> 

Peity 
<script src="js/plugins/peity/jquery.peity.min.js"></script> 
<script src="js/demo/peity-demo.js"></script> 

Custom and plugin javascript 
<script src="js/inspinia.js"></script> 
<script src="js/plugins/pace/pace.min.js"></script> 

jQuery UI 
<script src="js/plugins/jquery-ui/jquery-ui.min.js"></script> 

Jvectormap 
<script src="js/plugins/jvectormap/jquery-jvectormap-2.0.2.min.js"></script> 
<script src="js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script> 

EayPIE 
<script src="js/plugins/easypiechart/jquery.easypiechart.js"></script> 

Sparkline 
<script src="js/plugins/sparkline/jquery.sparkline.min.js"></script> 

Sparkline demo data  
<script src="js/demo/sparkline-demo.js"></script> 
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&amp;libraries=geometry"></script> 
 --><script>
        $(document).ready(function() {
            $('.chart').easyPieChart({
                barColor: '#f8ac59',
//                scaleColor: false,
                scaleLength: 5,
                lineWidth: 4,
                size: 80
            });

            $('.chart2').easyPieChart({
                barColor: '#1c84c6',
//                scaleColor: false,
                scaleLength: 5,
                lineWidth: 4,
                size: 80
            });

            var data2 = [
                [gd(2012, 1, 1), 7], [gd(2012, 1, 2), 6], [gd(2012, 1, 3), 4], [gd(2012, 1, 4), 8],
                [gd(2012, 1, 5), 9], [gd(2012, 1, 6), 7], [gd(2012, 1, 7), 5], [gd(2012, 1, 8), 4],
                [gd(2012, 1, 9), 7], [gd(2012, 1, 10), 8], [gd(2012, 1, 11), 9], [gd(2012, 1, 12), 6],
                [gd(2012, 1, 13), 4], [gd(2012, 1, 14), 5], [gd(2012, 1, 15), 11], [gd(2012, 1, 16), 8],
                [gd(2012, 1, 17), 8], [gd(2012, 1, 18), 11], [gd(2012, 1, 19), 11], [gd(2012, 1, 20), 6],
                [gd(2012, 1, 21), 6], [gd(2012, 1, 22), 8], [gd(2012, 1, 23), 11], [gd(2012, 1, 24), 13],
                [gd(2012, 1, 25), 7], [gd(2012, 1, 26), 9], [gd(2012, 1, 27), 9], [gd(2012, 1, 28), 8],
                [gd(2012, 1, 29), 5], [gd(2012, 1, 30), 8], [gd(2012, 1, 31), 25]
            ];

            var data3 = [
                [gd(2012, 1, 1), 800], [gd(2012, 1, 2), 500], [gd(2012, 1, 3), 600], [gd(2012, 1, 4), 700],
                [gd(2012, 1, 5), 500], [gd(2012, 1, 6), 456], [gd(2012, 1, 7), 800], [gd(2012, 1, 8), 589],
                [gd(2012, 1, 9), 467], [gd(2012, 1, 10), 876], [gd(2012, 1, 11), 689], [gd(2012, 1, 12), 700],
                [gd(2012, 1, 13), 500], [gd(2012, 1, 14), 600], [gd(2012, 1, 15), 700], [gd(2012, 1, 16), 786],
                [gd(2012, 1, 17), 345], [gd(2012, 1, 18), 888], [gd(2012, 1, 19), 888], [gd(2012, 1, 20), 888],
                [gd(2012, 1, 21), 987], [gd(2012, 1, 22), 444], [gd(2012, 1, 23), 999], [gd(2012, 1, 24), 567],
                [gd(2012, 1, 25), 786], [gd(2012, 1, 26), 666], [gd(2012, 1, 27), 888], [gd(2012, 1, 28), 900],
                [gd(2012, 1, 29), 178], [gd(2012, 1, 30), 555], [gd(2012, 1, 31), 993]
            ];


            var dataset = [
                {
                    label: "Open Orders",
                    data: data3,
                    color: "#1ab394",
                    bars: {
                        show: true,
                        align: "center",
                        barWidth: 24 * 60 * 60 * 600,
                        lineWidth:0
                    }

                }, {
                    label: "Delivered Orders",
                    data: data2,
                    yaxis: 2,
                    color: "#1C84C6",
                    lines: {
                        lineWidth:1,
                            show: true,
                            fill: true,
                        fillColor: {
                            colors: [{
                                opacity: 0.2
                            }, {
                                opacity: 0.4
                            }]
                        }
                    },
                    splines: {
                        show: false,
                        tension: 0.6,
                        lineWidth: 1,
                        fill: 0.1
                    },
                }
            ];


            var options = {
                xaxis: {
                    mode: "time",
                    tickSize: [3, "day"],
                    tickLength: 0,
                    axisLabel: "Date",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Arial',
                    axisLabelPadding: 10,
                    color: "#d5d5d5"
                },
                yaxes: [{
                    position: "left",
                    max: 1070,
                    color: "#d5d5d5",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Arial',
                    axisLabelPadding: 3
                }, {
                    position: "right",
                    clolor: "#d5d5d5",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: ' Arial',
                    axisLabelPadding: 67
                }
                ],
                legend: {
                    noColumns: 1,
                    labelBoxBorderColor: "#000000",
                    position: "nw"
                },
                grid: {
                    hoverable: false,
                    borderWidth: 0
                }
            };

            function gd(year, month, day) {
                return new Date(year, month - 1, day).getTime();
            }

            var previousPoint = null, previousLabel = null;

            $.plot($("#flot-dashboard-chart"), dataset, options);

            var mapData = {
                "US": 298,
                "SA": 200,
                "DE": 220,
                "FR": 540,
                "CN": 120,
                "AU": 760,
                "BR": 550,
                "IN": 200,
                "GB": 120,
            };

            $('#world-map').vectorMap({
                map: 'world_mill_en',
                backgroundColor: "transparent",
                regionStyle: {
                    initial: {
                        fill: '#e4e4e4',
                        "fill-opacity": 0.9,
                        stroke: 'none',
                        "stroke-width": 0,
                        "stroke-opacity": 0
                    }
                },

                series: {
                    regions: [{
                        values: mapData,
                        scale: ["#1ab394", "#22d6b1"],
                        normalizeFunction: 'polynomial'
                    }]
                },
            });
        });
    </script> 
<script>
       function initialize() {
  var mapOptions = {
    zoom: 4,
    center: new google.maps.LatLng(20.5937, 78.9629),
    scrollwheel: false,
    zoomControl: true,
    disableDefaultUI: true,
    zoomControlOptions: {
      style: google.maps.ZoomControlStyle.DEFAULT
    }
  };

  var map = new google.maps.Map(document.getElementById('map'), mapOptions);
  map.mapTypeControl = false;
  var image = {
    // url: 'img/marker.png',
    anchor: new google.maps.Point(0, 58)
  };

  var markers = [{
    lat: 19.0760,
    lng: 72.8777,
    map: map,
    title: 'Mumbai',
    icon: image,
    id: 'hello world',
    content: {
		
           title: 'Mumbai',
      address: 'K.P. Aurum',
			invoice:'456',
      number: 'MH02 EE5012',

     
    }
  }, {
    lat: 21.1702,
    lng: 72.8311,
    map: map,
    title: 'Surat',
    icon: image,
    id: 'hello world',
    content: {
		
           title: 'Surat',
      address: 'A.R.Pvt',
			invoice:'457',
      number: 'MH42 EA9612',
    }
  }, {
    lat: 28.7041,
    lng: 77.1025,
    map: map,
    title: 'Delhi',
    icon: image,
    id: 'hello world',
    content: {
		
           title: 'Delhi',
      address: 'Gandhi Marg',
			invoice:'458',
      number: 'UP78 AB9612',
    }
  }, {
    lat: 26.8467,
    lng: 80.9462,
    map: map,
    title: 'Lucknow',
    icon: image,
    id: 'hello world',
    content: {
		
           title: 'Lucknow',
      address: 'Shalimaar Tower',
			invoice:'459',
      number: 'UP78 AC9612',
    }
   
  }];

  markers.forEach(function(el) {

    var marker = new google.maps.Marker({
      position: new google.maps.LatLng(el.lat, el.lng),
      map: el.map,
      title: el.title,
      icon: el.icon,
      id: el.id

    });

    var template = '';

    
    if (!el.content.mode) {
      template =
        "<div class=\"infowindow\">" +
        "<div class=\"infowindow__header\">" +
      
        "<h3>" + el.content.title + "</h3>" +
        "</div>" +
        "<div class=\"infowindow__body\">" +
        "<div class=\"field\">" +
        "<div class=\"meta\">Address</div>" +
        "<p>" + el.content.address + "</p>" +
        "</div>" +
        "<div class=\"field\">" +
        "<div class=\"meta\">Invoice No.</div>" +
		  "<p>" + el.content.invoice + "</p>" +
		  "<div class=\"field\">" +
        "<div class=\"meta\">Truck No.</div>" +
		  "<p>" + el.content.number + "</p>" +
        "</div>" +
        "</div>" +
        "</div>";
    } else {
      template =
        "<div class=\"infowindow\">" +
        "<div class=\"infowindow__header\">" +
       
        "<h3>" + el.content.title + "</h3>" +
        "</div>" +
        "<div class=\"infowindow__body\">" +
        "<div class=\"field\">" +
        "<div class=\"meta\">Address</div>" +
        "<p>" + el.content.address + "</p>" +
        "</div>" +
        "<div class=\"field field-mode\">" +
        "<div class=\"field-mode__item\">" +
        "<div class=\"meta\">Invoice No.</div>" +
		   "<p>" + el.content.invoice + "</p>" +
      
        "</div>" +
        "<div class=\"field-mode__item\">" +
        "<div class=\"meta\">сб</div>" +
      
        "</div>" +
        "<div class=\"field-mode__item\">" +
        "<div class=\"meta\">нд</div>" +
      
        "</div>"

      +
      "</div>" +
      "<div class=\"field\">" +
      "<div class=\"meta\">Технічна підтримка</div>" +
      "<a href=\"tel:" + el.content.number.replace(/-/g, "").replace(/ /g, "") + "\">" + el.content.number + "</a>" +
        "</div>" +
        "</div>" +
        "</div>";
    }

    var infowindow = new google.maps.InfoWindow({
      content: template
    });
    marker.addListener('click', function() {
      console.log(this.id)
      infowindow.open(map, marker);
    });

  });

}
// Asynchronous Loading

function loadScript() {
  var script = document.createElement('script');
  script.type = 'text/javascript';
  script.src = 'https://maps.googleapis.com/maps/api/js?v=3.exp&' +
    'callback=initialize';
  document.body.appendChild(script);
}
window.onload = loadScript;
    </script>
</body>
</html>
