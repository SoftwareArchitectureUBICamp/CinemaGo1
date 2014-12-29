<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda"%>

<html>
<head>
<title>List Of Session types</title>

<link rel="stylesheet" href='<c:url value="/resources/css/normalize.min.css"/>'>
<link rel="stylesheet" href='<c:url value="/resources/css/main.css"/>'>
<link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.min.css"/>">

<style type="text/css">
  th {
       text-align: left
  }
  
  img {
  	max-height:300px;
  }

</style>
</head>

<body>
   <div style="width: 95%; margin: 0 auto;">
   
        <h1>List Of Current Movie Sessions</h1>

         <br>
         <h3>Movies Today</h3>
         
         <div>
         	
         </div>
         
         <table class="pure-table pure-table-bordered pure-table-striped">
            <tbody>
               <c:forEach items="${movieSessionsToday}" var="movieSession" varStatus="loopCounter">
               <tr>
                   <td><img src='<c:out value="${movieSession.movie.imgUrl}" />'/></td>
                   <td><c:out value="${movieSession.startTime.toLocalDate().toString()}" /></td>
                   <td><c:out value="${movieSession.startTime.toLocalTime().toString()}" /></td>
                   <td><c:out value="${movieSession.movie.movieTitle}" /></td>
                   <td><c:out value="${movieSession.cinema.cinemaName}" /></td>
                   <td><c:out value="${movieSession.sessionType.sessionName}" /></td>
                   <td><c:out value="${movieSession.sessionType.sessionPrice}" /></td>
 
                </tr>
                </c:forEach>
            </tbody>
         </table>
		
		<h3>Movies Tomorrow</h3>
        <table class="pure-table pure-table-bordered pure-table-striped">
            <tbody>
               <c:forEach items="${movieSessionsTomorrow}" var="movieSession" varStatus="loopCounter">
               <tr>
                   <td><img src='<c:out value="${movieSession.movie.imgUrl}" />'/></td>
                   <td><c:out value="${movieSession.startTime.toLocalDate().toString()}" /></td>
                   <td><c:out value="${movieSession.startTime.toLocalTime().toString()}" /></td>
                   <td><c:out value="${movieSession.movie.movieTitle}" /></td>
                   <td><c:out value="${movieSession.cinema.cinemaName}" /></td>
                   <td><c:out value="${movieSession.sessionType.sessionName}" /></td>
                   <td><c:out value="${movieSession.sessionType.sessionPrice}" /></td>
 
                </tr>
                </c:forEach>
            </tbody>
         </table>

		<h3>Rest Movie Sessions</h3>
        <table class="pure-table pure-table-bordered pure-table-striped">
            <tbody>
               <c:forEach items="${movieSessions}" var="movieSession" varStatus="loopCounter">
               <tr>
                   <td><img src='<c:out value="${movieSession.movie.imgUrl}" />'/></td>
                   <td><c:out value="${movieSession.startTime.toLocalDate().toString()}" /></td>
                   <td><c:out value="${movieSession.startTime.toLocalTime().toString()}" /></td>
                   <td><c:out value="${movieSession.movie.movieTitle}" /></td>
                   <td><c:out value="${movieSession.cinema.cinemaName}" /></td>
                   <td><c:out value="${movieSession.sessionType.sessionName}" /></td>
                   <td><c:out value="${movieSession.sessionType.sessionPrice}" /></td>
 
                </tr>
                </c:forEach>
            </tbody>
         </table>
     </div>

     <!--  It is advised to put the <script> tags at the end of the document body so that they don't block rendering of the page -->
     
    <script type="text/javascript" src='<c:url value="/resources/js/lib/jquery-1.11.0.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/lib/modernizr-2.6.2-respond-1.1.0.min.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/lib/jquery-ui.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/movieSession.js"/>'></script>
    

</body>
</html>