<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda"%>

<html>
<head>
<title>CinemaGO movies</title>

<link rel="stylesheet" href='<c:url value="/resources/css/normalize.min.css"/>'>
<link rel="stylesheet" href='<c:url value="/resources/css/main.css"/>'>
<link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.min.css"/>">

<style type="text/css">
  th {
       text-align: left
  }
  
</style>
</head>

<body>
   <div style="margin: 0 auto; text-align:center;">
   
         <div style="width:100%; background-color: lightcoral; display: inline-block;">
         <h2 style="padding: 50 0;color: seashell;text-shadow: 1px 1px 8px rgba(0, 0, 0, 0.8);font-size: 3em;font-weight: lighter;">
         	Movies Today
         </h2>
         <div style="display:inline-block; padding-bottom:50px; width:90%;">
               <c:forEach items="${movieSessionsToday}" var="movieSession" varStatus="loopCounter">
               
               <div style="float: left; width:300px; height:480px; max-height:500px; padding:10px; background-color:linen; text-align:center; margin:10px; -webkit-box-shadow: 0px 0px 9px 0px rgba(50, 50, 50, 0.92);"> 
               		<div style="width:100%; float:left; border-bottom: solid 1px burlywood;"><h3 style="margin:0;">
               			<span style="float:left; text-align:left; width:100%;">
               				<span><c:out value="${movieSession.startTime.toLocalTime().toString()}" /></span>
               				<span style="font-weight: lighter; font-size: 0.8em;"> on </span> 
               				<span style="font-weight: lighter; font-size: 0.8em;"><c:out value="${movieSession.cinema.cinemaName}" /></span>
               				<span style="float:right; font-weight: normal; font-size: 0.8em;"><c:out value="${movieSession.movie.duration}" /> min.</span>
               			</span> 	
               		</h3></div>
               		<div style="width:100%; padding-top:15px;"><h2 style="text-shadow: 1px 1px 5px rgba(0, 0, 0, 0.5);">
               			<c:out value="${movieSession.movie.movieTitle}" />
               		</h2></div>
               		<img style="max-height:300px;" src='<c:out value="${movieSession.movie.imgUrl}" />'/>
               		<p style="font-size:0.7em;"><c:out value="${movieSession.movie.description}" /></p>
               		
               		<div style="width:100%; border-top: solid 1px burlywood; padding-top: 5px;">
               			<span style="padding-right:10px;"><c:out value="${movieSession.sessionType.sessionPrice}" /> &#8364</span>
               			<button>Buy</button>
               		</div>
               </div>
               
               </c:forEach>
               <div class="clearfix"></div>
			</div>
			
		</div>
		
		<div style="width:100%; background-color: lightsteelblue; display: inline-block;">
		<h2 style="padding: 50 0;color: seashell;text-shadow: 1px 1px 8px rgba(0, 0, 0, 0.8);font-size: 3em;font-weight: lighter;">
			Movies Tomorrow
		</h2>
		<div style="display:inline-block; padding-bottom:50px; width:90%;">
               <c:forEach items="${movieSessionsTomorrow}" var="movieSession" varStatus="loopCounter">
              
               <div style="float: left; width:300px; height:480px; max-height:500px; padding:10px; background-color:linen; text-align:center; margin:10px; -webkit-box-shadow: 0px 0px 9px 0px rgba(50, 50, 50, 0.92);"> 
               		<div style="width:100%; float:left; border-bottom: solid 1px burlywood;"><h3 style="margin:0;">
               			<span style="float:left;  text-align:left; width:100%;">
               				<span><c:out value="${movieSession.startTime.toLocalTime().toString()}" /></span>
               				<span style="font-weight: lighter; font-size: 0.8em;"> on </span> 
               				<span style="font-weight: lighter; font-size: 0.8em;"><c:out value="${movieSession.cinema.cinemaName}" /></span>
               				<span style="float:right; font-weight: normal; font-size: 0.8em;"><c:out value="${movieSession.movie.duration}" /> min.</span>
               			</span> 	
               		</h3></div>
               		<div style="width:100%; padding-top:15px;"><h2 style="text-shadow: 1px 1px 5px rgba(0, 0, 0, 0.5);">
               			<c:out value="${movieSession.movie.movieTitle}" />
               		</h2></div>
               		<img style="max-height:300px;" src='<c:out value="${movieSession.movie.imgUrl}" />'/>
               		<p style="font-size:0.7em;"><c:out value="${movieSession.movie.description}" /></p>
               		
               		<div style="width:100%; border-top: solid 1px burlywood; padding-top: 5px;">
               			<span style="padding-right:10px;"><c:out value="${movieSession.sessionType.sessionPrice}" /> &#8364  </span>
               			<button>Buy</button>
               		</div>
               </div>
               
                </c:forEach>
			</div>
		</div>
		
		<div class="clearfix"></div>
		<div style="width:100%; background-color: lightsalmon; display: inline-block;">
		<h2 style="padding: 50 0;color: seashell;text-shadow: 1px 1px 8px rgba(0, 0, 0, 0.8);font-size: 3em;font-weight: lighter;">
			Rest of the Movie Sessions
		</h2>
		<div style="display:inline-block; padding-bottom:50px; width:90%;">
               <c:forEach items="${movieSessions}" var="movieSession" varStatus="loopCounter">
	               <div style="float: left; width:300px; height:480px; max-height:500px; padding:10px; background-color:linen; text-align:center; margin:10px; -webkit-box-shadow: 0px 0px 9px 0px rgba(50, 50, 50, 0.92);"> 
	               		<div style="width:100%; float:left; border-bottom: solid 1px burlywood;"><h3 style="margin:0;">
	               			<span style="float:left;  text-align:left; width:100%;">
	               				<span style="font-weight: lighter; font-size: 0.8em;"><c:out value="${movieSession.startTime.toLocalDate().toString()}" /></span>
	               				<span><c:out value="${movieSession.startTime.toLocalTime().toString()}" /></span>
	               				<span style="font-weight: lighter; font-size: 0.8em;"> on </span> 
	               				<span style="font-weight: lighter; font-size: 0.8em;"><c:out value="${movieSession.cinema.cinemaName}" /></span>
	               				<span style="float:right; font-weight: normal; font-size: 0.8em;"><c:out value="${movieSession.movie.duration}" /> min.</span>
	               			</span> 	
	               		</h3></div>
	               		<div style="width:100%; padding-top:15px;"><h2 style="text-shadow: 1px 1px 5px rgba(0, 0, 0, 0.5);">
	               			<c:out value="${movieSession.movie.movieTitle}" />
	               		</h2></div>
	               		<img style="max-height:300px;" src='<c:out value="${movieSession.movie.imgUrl}" />'/>
	               		<p style="font-size:0.7em;"><c:out value="${movieSession.movie.description}" /></p>
	               		
	               		<div style="width:100%; border-top: solid 1px burlywood; padding-top: 5px;">
	               			<span style="padding-right:10px;"><c:out value="${movieSession.sessionType.sessionPrice}" /> &#8364  </span>
	               			<button>Buy</button>
	               		</div>
	               </div>
                </c:forEach>
            </div>
		</div>
     </div>

     <!--  It is advised to put the <script> tags at the end of the document body so that they don't block rendering of the page -->
     
    <script type="text/javascript" src='<c:url value="/resources/js/lib/jquery-1.11.0.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/lib/modernizr-2.6.2-respond-1.1.0.min.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/lib/jquery-ui.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/movieSession.js"/>'></script>
    

</body>
</html>