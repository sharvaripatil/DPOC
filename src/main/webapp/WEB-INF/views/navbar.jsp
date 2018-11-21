 <nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
      <ul class="nav metismenu" id="side-menu">
        <li class="nav-header">
          <div class="dropdown profile-element"> <span> <img alt="image"  src="resources/img/logo.png" /> </span> <a data-toggle="dropdown" class="dropdown-toggle" href="#"> <span class="clear"><!--  <span class="block m-t-xs"> <strong class="font-bold">Azam Rizvi</strong> </span> <span class="text-muted text-xs block">Admin <b class="caret"></b></span> </span> --> </a>
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
        <!-- <li class="active"> <a href="index.html"><i class="fa fa-th-large"></i> <span class="nav-label">Dashboards</span></a> </li> -->
		      <li> <a href="<c:url value='/algorithmProcess' />"><i class="fa fa-th-large"></i> <span class="nav-label">Algorithm Process</span></a> </li>
		  
		    <li> <a href="#"><i class="fa fa-th-large"></i> <span class="nav-label">Transport Info</span><span class="fa arrow"></span></a> 
		  <ul class="nav nav-second-level collapse">
		  <li><a href="<c:url value='uploadTrucksInfo' />">Upload Trucks Information</a></li>
            <li><a href="<c:url value='getAllTrucksInformation' />">All Available Trucks</a></li>
            <li><a href="#">Clubbed Order Loaded Trucks</a></li>
            
          </ul>
		  </li>
       
      </ul>
    </div>
  </nav>