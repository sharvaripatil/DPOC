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

</head>

<body class="md-skin">
<div id="wrapper">
  <nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
      <ul class="nav metismenu" id="side-menu">
        <li class="nav-header">
          <div class="dropdown profile-element"> <span> <img alt="image" class="img-circle" src="img/profile_small.jpg" /> </span> <a data-toggle="dropdown" class="dropdown-toggle" href="#"> <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">Azam Rizvi</strong> </span> <span class="text-muted text-xs block">Admin <b class="caret"></b></span> </span> </a>
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
		      <li class="active"> <a href="algorithm_process.html"><i class="fa fa-th-large"></i> <span class="nav-label">Algorithm Process</span></a> </li>
     
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
							
                            <table class="table table-bordered table-hover">
                                <thead>
                                <tr>
									
                                    <th>Delivery Date</th>
                                    <th>Total Order</th>
                                 
									<th>Truck Number</th>
                                    <th>Truck Capacity</th>
									   <th>Plant</th>
                                    <th>Total Kilometers</th>
									
                                   
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>21/05/18</td>
                                    <td><button class="btn btn-success btn-circle" data-toggle="modal" data-target="#configurealgo" type="button">2
                            </button></td>
									 <td>MH02 AF1006</td>
									 <td>2Ton</td>
                                    <td>Dalmia Cement East Limited - Bakaro	JHARKHAND
</td>
									
                                    <td>500</td>
									
                                </tr>
                                <tr>
                                     <td>22/05/18</td>
                                   <td><button class="btn btn-success btn-circle" data-toggle="modal" data-target="#configurealgo1" type="button">3
                            </button></td>
									 <td>MH02 AF1006</td>
									 <td>2Ton</td>
                                    <td>Adhunik Cement Ltd	MEGHALAYA
</td>
									
                                    <td>960</td>
									
								                                </tr>
                                <tr>
                                    <td>23/05/18</td>
                                   <td><button class="btn btn-success btn-circle" data-toggle="modal" data-target="#configurealgo2" type="button">2
                            </button></td>
									<td>MH02 AF1006</td>
									 <td>2Ton</td>
                                    <td>Dalmia Cement (Bharat) Ltd- Kadapa	ANDHRA PRADESH
</td>
									 
                                    <td>840</td>
									
                                </tr>
                                </tbody>
                            </table>
                           <a href="algorithm_process.html" class="btn btn-success pull-right" type="button">Back
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
                                          
                                        
                                            <h4 class="modal-title">Configure IntellShip Alogrithm</h4>
                                         
                                        </div>
                                        <div class="modal-body" style="overflow-x: auto;">
                                             <table class="table table-bordered">
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
                                <tbody>
                                <tr>
                                    <td>8106908338</td>
                                    <td>4104017597</td>
									<td>7006020</td>
									<td>ASHOK TRADERS</td>
                                    <td>ASHOK TRADERS</td>
									<td>FBCCLPP50DT</td>
									<td>12</td>
                                    <td>BOK TO CHATTARPUR,DALTONGANJ-JDA001</td>
									<td>PALAMU</td>
									<td>5300</td>
                                    <td>D00078</td>
									<td></td>
									<td>01</td>
								
                                    <td>21-07-2018</td>
									<td>ZDLF</td>
									<td>5300</td>
                                    <td>J15</td>
									<td>7006020</td>
									<td>84.1860046</td>
                                    <td>24.3643158</td>
									
											
                                  
                                </tr>
                                <tr>
                                   <td>8106903755</td>
                                    <td>4104010880</td>
									<td>7012184</td>
									<td>BIKASH TRADERS</td>
                                    <td>BIKASH TRADERS</td>
									<td>PCCPP50T</td>
									<td>9</td>
                                    <td>BOK TO GODDA-JD1002</td>
									<td>GODDA</td>
									<td>5300</td>
                                    <td>D00029</td>
									<td></td>
									<td>01</td>
                                    <td>21-07-2018</td>
										<td>ZDLF</td>
									<td>5300</td>
									<td>J07</td>
                                    <td>7012184</td>
									<td>87.213518</td>
									<td>24.825522</td>
                                 
                                </tr>
                            
                                </tbody>
                            </table>
                                                 
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-white btn-rounded" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary btn-rounded">Save changes</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
 <div class="modal" id="configurealgo1" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog modal-lg">
                                <div class="modal-content animated bounceInRight">
                                        <div class="modal-header">
                                          
                                        
                                            <h4 class="modal-title">Configure IntellShip Alogrithm</h4>
                                         
                                        </div>
                                        <div class="modal-body" style="overflow-x: auto;">
                                             <table class="table table-bordered">
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
                                <tbody>
                                <tr>
                                    <td>8106897962</td>
                                    <td>4104010770</td>
									<td>7012184</td>
									<td>JAI MAA SANTOSHI AGENCY</td>
                                    <td>JAI MAA SANTOSHI AGENCY</td>
									<td>FBCCLPP50DT</td>
									<td>15</td>
                                    <td>BOK TO BOKARO STEEL PLANT</td>
									<td>BOKARO</td>
									<td>5300</td>
                                    <td>D00430</td>
									<td></td>
									<td>01</td>
								
                                    <td>20-07-2018</td>
									<td>ZDLF</td>
									<td>5300</td>
                                    <td>J01</td>
									<td>7009688</td>
									<td>86.1292944</td>
                                    <td>23.6429361</td>
									
											
                                  
                                </tr>
                                <tr>
                                   <td>8106912784</td>
                                    <td>4104013006</td>
									<td>7009688</td>
									<td>BIKASH TRADERS</td>
                                    <td>BIKASH TRADERS</td>
									<td>PCCPP50T</td>
									<td>9</td>
                                    <td>BOK TO GODDA-JD1002</td>
									<td>GODDA</td>
									<td>5300</td>
                                    <td>D00029</td>
									<td></td>
									<td>01</td>
                                    <td>21-07-2018</td>
										<td>ZDLF</td>
									<td>5300</td>
									<td>J07</td>
                                    <td>7012184</td>
									<td>87.213518</td>
									<td>24.825522</td>
                                 
                                </tr>
                                <tr>
                                    <td>8106901731</td>
                                    <td>4104013334</td>
									<td>7024895</td>
									<td>NAVIN CEMENT STORE</td>
                                    <td>NAVIN CEMENT STORE</td>
									<td>FBCCLPP50DT</td>
									<td>10</td>
                                    <td>BOK TO HARIHARGANJ,DALTONGANJ-JDA001</td>
									<td>PALAMU</td>
									<td>5300</td>
                                    <td>D00079</td>
									<td></td>
									<td>01</td>
                                    <td>20-07-2018</td>
									<td>ZDLF</td>
									<td>5300</td>
                                    <td>J15</td>
									<td>7024895</td>
									<td>84.2845</td>
                                    <td>24.5246</td>
                                </tr>
                                </tbody>
                            </table>
                                                 
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-white btn-rounded" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary btn-rounded">Save changes</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
	 <div class="modal" id="configurealgo2" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog modal-lg">
                                <div class="modal-content animated bounceInRight">
                                        <div class="modal-header">
                                          
                                        
                                            <h4 class="modal-title">Configure IntellShip Alogrithm</h4>
                                         
                                        </div>
                                        <div class="modal-body" style="overflow-x: auto;">
                                             <table class="table table-bordered">
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
                                <tbody>
                                <tr>
                                    <td>8106908338</td>
                                    <td>4104017597</td>
									<td>7006020</td>
									<td>ASHOK TRADERS</td>
                                    <td>ASHOK TRADERS</td>
									<td>FBCCLPP50DT</td>
									<td>12</td>
                                    <td>BOK TO CHATTARPUR,DALTONGANJ-JDA001</td>
									<td>PALAMU</td>
									<td>5300</td>
                                    <td>D00078</td>
									<td></td>
									<td>01</td>
								
                                    <td>21-07-2018</td>
									<td>ZDLF</td>
									<td>5300</td>
                                    <td>J15</td>
									<td>7006020</td>
									<td>84.1860046</td>
                                    <td>24.3643158</td>
									
											
                                  
                                </tr>
                                <tr>
                                   <td>8106903755</td>
                                    <td>4104010880</td>
									<td>7012184</td>
									<td>BIKASH TRADERS</td>
                                    <td>BIKASH TRADERS</td>
									<td>PCCPP50T</td>
									<td>9</td>
                                    <td>BOK TO GODDA-JD1002</td>
									<td>GODDA</td>
									<td>5300</td>
                                    <td>D00029</td>
									<td></td>
									<td>01</td>
                                    <td>21-07-2018</td>
										<td>ZDLF</td>
									<td>5300</td>
									<td>J07</td>
                                    <td>7012184</td>
									<td>87.213518</td>
									<td>24.825522</td>
                                 
                                </tr>
                               
                                </tbody>
                            </table>
                                                 
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-white btn-rounded" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary btn-rounded">Save changes</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
    <!-- Mainly scripts -->
    <script src="resources/js/jquery-2.1.1.js"></script>
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
