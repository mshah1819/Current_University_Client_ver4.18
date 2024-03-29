<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.university.bean.UniversityInfoBean"
	import="com.university.bean.RegistrationBean"%>
<!DOCTYPE html>
<html>
<head>
<!--<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<meta name="viewport" http-equiv="Content-Type"
	content=" width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/dashboard.css" rel="stylesheet">
<link rel="shortcut icon" type="image/x-icon"
	href="http://www.hdwallpaperbackground.com/uploads/allimg/130331/Tsinghua%20University%20photos%20hd%20wallpapers%2010_960x600.jpg" />
<link href="css/jquery-ui.css" rel="stylesheet">
<title>University Detail - Disha</title>
<link rel="stylesheet" href="css/jquery-ui.css" type="text/css" />
<script src="lib/jquery-1.10.2.js"></script>
<script type="text/javascript" src="lib/jquery-ui.js"></script>
<script type="text/javascript" src="lib/jquery.ui.autocomplete.js" /></script>
<script type="text/javascript" src="lib/jquery.ui.core.js"></script>
<script type="text/javascript" src="lib/jquery.ui.position.js"></script>
<script type="text/javascript" src="lib/jquery.ui.widget.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script>
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
</head>
<style type="text/css">
	.ui-autocomplete
	{
		z-index: 1000;
	}
</style>
<%
	RegistrationBean rb 				= (RegistrationBean) session.getAttribute("userName");
	UniversityInfoBean universityDetail = (UniversityInfoBean) session.getAttribute("universityDetail");
	String[] univInfoNameList 			= (String[]) request.getAttribute("univInfoNameList");
	String[] univStateList 	  			= (String[]) request.getAttribute("univStateList");
	String[] univBranchList   			= (String[]) request.getAttribute("univBranchList");
%>
<script type="text/javascript"> 
 $(function() 
		    {
		    var univName = new Array();
		    <% for(int i = 0;i<univInfoNameList.length;i++){%> univName[<%=i%>] = "<%=univInfoNameList[i]%>"; <%}%>
		    console.log(univName[2]);
		    $("#univ_name").autocomplete({source: univName});
		    }
		  );
 
 $(function() 
		    {
		    var branchName = new Array();
		    <% for(int i = 0;i<univBranchList.length;i++){%> branchName[<%=i%>] = "<%=univBranchList[i]%>"; <%}%>
		    console.log(branchName[2]);
		    $("#branch_name").autocomplete({source: branchName});
		    }
		  );
 
 $(function() 
		    {
		    var stateName = new Array();
		    <% for(int i = 0;i<univStateList.length;i++){%> stateName[<%=i%>] = "<%=univStateList[i]%>"; <%}%>
		    console.log(stateName[2]);
		    $("#state_name").autocomplete({source: stateName});
		    }
		  );
</script>

  <script type="text/javascript">
  function initialize() {
	var Lat = <%=universityDetail.getLatitude()%> ;
	var Lng = <%=universityDetail.getLongitude()%> ;
	console.log(Lat);
	console.log(Lng);
	var latlng = new google.maps.LatLng(Lat, Lng);
    var mapOptions = {
      zoom: 4,
      center:latlng,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    var map = new google.maps.Map(document.getElementById("map_canvas"),mapOptions);
    var marker = new google.maps.Marker({position: center, map: map, title:"University"});
  }
  google.maps.event.addDomListener(window, 'load', initialize);
</script> 


<body onload="initialize()">
	<!-- Header Code -->
							<!-- <div id="map-canvas" style="width:300px; height:300px;"></div> -->
	
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<a class="navbar-brand" href="index.jsp">DISHA</a>

			<!--Code to collapse the header bar on mobile browser-->
			<button class="navbar-toggle" data-toggle="collapse"
				data-target=".navHeaderCollapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<div class="col-sm-3 col-md-3"></div>
			<div class="collapse navbar-collapse navHeaderCollapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="home">Home <span
							class="glyphicon glyphicon-home"> </span></a></li>
					<li><a href="logout.jsp">Logout <span
							class="glyphicon glyphicon-off"> </span></a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- Header Ends Here -->

	<!-- Main page image box -->

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">

				<div class="list-group">
					<a href="#" class="list-group-item active">Welcome <%=rb.getFirstName()%></a>
					<a href="#" class="list-group-item"><span
						class="glyphicon glyphicon-user"> Profile</span></a>
				</div>
				
				<div class="list-group">
					<a href="#" class="list-group-item active">Dashboard</a> <a
						href="#" class="list-group-item">Get Suggestions</a> <a href="#"
						class="list-group-item">Compare University</a> <a href="#"
						class="list-group-item">Compare Your Profile</a>

				</div>
				
				<div class="list-group">
					<a href="#" class="list-group-item active">Search University</a>

					<form action="getDetailFromType" method="GET">
						<div class="input-group">
							<div class="ui-widget" align="right">
								<input id="univ_name" type="text" class="form-control"
									placeholder="By Name" name="univ_name"
									style="padding: 3px 6px;">
							</div>
							<div class="input-group-btn">
								<button class="btn btn-default" type="submit">
									<i class="glyphicon glyphicon-search"></i>
								</button>
							</div>
						</div>
					</form>

					<form action="getDetailFromType" method="GET">
						<div class="input-group">
							<div class="ui-widget" align="right">
								<input id="branch_name" type="text" class="form-control"
									placeholder="By Branch" name="branch_name"
									style="padding: 3px 6px;">
							</div>
							<div class="input-group-btn">
								<button class="btn btn-default" type="submit">
									<i class="glyphicon glyphicon-search"></i>
								</button>
							</div>
						</div>
					</form>

					<form action="getDetailFromType" method="GET">
						<div class="input-group">
							<div class="ui-widget" align="right">
								<input id="state_name" type="text" class="form-control"
									placeholder="By State" name="state_name"
									style="padding: 3px 6px;">
							</div>
							<div class="input-group-btn">
								<button class="btn btn-default" type="submit">
									<i class="glyphicon glyphicon-search"></i>
								</button>
							</div>
						</div>
					</form>
				</div>

				<div class="list-group">
					<a href="#" class="list-group-item active">Service</a>
					 <a href="#" class="list-group-item">Forum</a>
				</div>

			</div>

	 		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
 				<h4 class="page-header"><%=universityDetail.getInstnm()%></h4>

				<ul class="nav nav-tabs" id="myTab">
					<li class="active"><a href="#basicdetail" data-toggle="tab"><i
							class="fa fa-envelope-o"></i>Basic Details</a></li>
					<li><a href="#financialdetail" data-toggle="tab"><i
							class="fa fa-reply-all"></i>Financial Details</a></li>
					<li><a href="#enrollementdetail" data-toggle="tab"><i
							class="fa fa-file-text-o"></i>Enrollement Details</a></li>
					<li><a href="#photosdetail" data-toggle="tab"><i
							class="fa fa-clock-o"></i>Photos</a></li>
					<li><a href="#videosdetail" data-toggle="tab"><i
							class="fa fa-clock-o"></i>Videos</a></li>
					<li><a href="#mapdetail" data-toggle="tab"><i
							class="fa fa-clock-o"></i>Map</a></li>
				</ul>

				<div class="tab-content">
					<div class="tab-pane active" id="basicdetail">
						<table class="table table-striped">
							<thead>
								<tr>
									<th colspan="3">University Basic Details</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><b>Alias</b></td>
									<td>:</td>
									<td><%=universityDetail.getIalias()%></td>
								</tr>
								<tr>
									<td><b>Address</b></td>
									<td>:</td>
									<td><%=universityDetail.getAddr()%></td>
								</tr>
								<tr>
									<td><b>Zip</b></td>
									<td>:</td>
									<td><%=universityDetail.getZip()%></td>
								</tr>
								<tr>
									<td><b>City, State</b></td>
									<td>:</td>
									<td><%=universityDetail.getCity()%>, <%=universityDetail.getStabbr()%></td>
								</tr>

								<tr>
									<td><b>Website</b></td>
									<td>:</td>
									<td><a href="<%=universityDetail.getWebaddr()%>" target="_blank"><%=universityDetail.getWebaddr()%></a></td>

								</tr>

								<tr>
									<td><b>Admin</b></td>
									<td>:</td>
									<td><a href="<%=universityDetail.getAdminurl()%>" target="_blank"><%=universityDetail.getAdminurl()%></a></td>
								</tr>

								<tr>
									<td><b>Financial Aid</b></td>
									<td>:</td>
									<td><a href="<%=universityDetail.getFaidurl()%>" target="_blank"><%=universityDetail.getFaidurl()%></a></td>
								</tr>

								<tr>
									<td><b>Application</b></td>
									<td>:</td>
									<td><a href="<%=universityDetail.getApplurl()%>" target="_blank"><%=universityDetail.getApplurl()%></a></td>
								</tr>
							</tbody>
						</table>
					</div>

					<div class="tab-pane" id="financialdetail">
						<table class="table table-striped">
							<thead>
								<tr>
									<th colspan="3">University Financial Details</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><b>EIN</b></td>
									<td>:</td>
									<td><%=universityDetail.getEin()%></td>
								</tr>
							</tbody>
						</table>
					</div>

					<div class="tab-pane" id="enrollementdetail">
						<table class="table table-striped">
							<thead>
								<tr>
									<th colspan="3">University Enrollement Details</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><b>Graduate Offer</b></td>
									<td>:</td>
									<td><%=universityDetail.getGroffer()%></td>
								</tr>
								<tr>
									<td><b>Undergraduate Offer</b></td>
									<td>:</td>
									<td><%=universityDetail.getHdegofr1()%></td>
								</tr>
								<tr>
									<td><b>Hospitals</b></td>
									<td>:</td>
									<td><%=universityDetail.getHospital()%></td>
								</tr>
								<tr>
									<td><b>Medicals</b></td>
									<td>:</td>
									<td><%=universityDetail.getMedical()%></td>
								</tr>
								<tr>
									<td><b>Institution Size</b></td>
									<td>:</td>
									<td><%=universityDetail.getInstsize()%></td>
								</tr>
							</tbody>
						</table>
					</div>

					<div class="tab-pane" id="photosdetail">
						<div id="transition-timer-carousel"
							class="carousel slide transition-timer-carousel"
							data-ride="carousel">
							<!-- Indicators -->
							<ol class="carousel-indicators">
								<li data-target="#transition-timer-carousel" data-slide-to="0"
									class="active"></li>
								<li data-target="#transition-timer-carousel" data-slide-to="1"></li>
								<li data-target="#transition-timer-carousel" data-slide-to="2"></li>
							</ol>

							<!-- Wrapper for slides -->
							<div class="carousel-inner">
								<div class="item active">
									<img src="http://placehold.it/1200x400" />
									<div class="carousel-caption">
										<h1 class="carousel-caption-header">Slide 1</h1>

									</div>
								</div>

								<div class="item">
									<img src="http://placehold.it/1200x400/AAAAAA/888888" />
									<div class="carousel-caption">
										<h1 class="carousel-caption-header">Slide 2</h1>
									</div>
								</div>

								<div class="item">
									<img src="http://placehold.it/1200x400/888888/555555" />
									<div class="carousel-caption">
										<h1 class="carousel-caption-header">Slide 3</h1>
									</div>
								</div>
							</div>

							<!-- Controls -->
							<a class="left carousel-control"
								href="#transition-timer-carousel" data-slide="prev"> <span
								class="glyphicon glyphicon-chevron-left"></span>
							</a> <a class="right carousel-control"
								href="#transition-timer-carousel" data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right"></span>
							</a>

							<!-- Timer "progress bar" -->
							<hr class="transition-timer-carousel-progress-bar animate" />
						</div>
					</div>

					<div class="tab-pane" id="videosdetail" style="text-align: center;">
						<object width="425" height="350">
							<param name="movie"
								value="https://www.youtube.com/watch?v=tRX0ulDYf8c" />
							<embed src="http://www.youtube.com/v/tIBxavsiHzM"
								type="application/x-shockwave-flash" width="425" height="350" />
						</object>
					</div>

					<div class="tab-pane" id="mapdetail" style="width:900px; height:500px;">
						<div id="map_canvas" style="width:900px; height:500px;"></div>
					</div>

				</div>
			</div>
		</div> 
	</div>	 							
<%-- 							<tr>
								<td><%=universityDetail.getFips()%></td>
								<td><%=universityDetail.getObereg()%></td>
								<td><%=universityDetail.getChfnm()%></td>
								<td><%=universityDetail.getChftitle()%></td>
								<td><%=universityDetail.getGentele()%></td>
							</tr>


							<tr>
								<td><%=universityDetail.getNpricurl()%></td>
								<td><%=universityDetail.getIclevel()%></td>
								<td><%=universityDetail.getControl()%></td>
								<td><%=universityDetail.getHloffer()%></td>
								<td><%=universityDetail.getUgoffer()%></td>
							</tr>
							<tr>
Graduate Offer								<td><%=universityDetail.getGroffer()%></td>
Undergraduate Offer								<td><%=universityDetail.getHdegofr1()%></td>
								<td><%=universityDetail.getDeggrant()%></td>
Hospitals								<td><%=universityDetail.getHospital()%></td>
Medicals								<td><%=universityDetail.getMedical()%></td>
							</tr>
							<tr>
								<td><%=universityDetail.getOpenpubl()%></td>
								<td><%=universityDetail.getAct()%></td>

								<td><%=universityDetail.getInstcat()%></td>
Institution Size								<td><%=universityDetail.getInstsize()%></td>
							</tr>
							<tr>	
								<td><%=universityDetail.getF1SYSNAM()%></td>
								<td><%=universityDetail.getFaxtele()%></td>
								<td><%=universityDetail.getCountycd()%></td>
								<td><%=universityDetail.getCountynm()%></td>
								<td><div id="map_container"></div></td>							
							</tr>
						</tbody>
					</table>
 				</div>
  --%>
		<!-- Footer Code -->
		<div class="navbar navbar-default navbar-fixed-bottom">
			<div class="container">
				<p class="navbar-text pull-left">All Rights Reserved @
					Team-Manan</p>
				<a href="http://www.linkedin.com/in/mshah18"
					class="navbar-btn btn-primary btn pull-right">Follow on
					LinkedIn</a>
			</div>
		</div>
		<!-- Footer Ends Here -->

		<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script> -->
		<script src="lib/bootstrap.min.js"></script>
</body>
</html>

