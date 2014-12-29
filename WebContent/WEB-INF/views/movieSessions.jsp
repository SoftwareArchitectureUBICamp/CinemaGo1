<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
</style>
</head>

<body>
   <div style="width: 95%; margin: 0 auto;">
   
   	<div><%@ include file="nav.jsp"%></div>
   
        <div id="movieSessionDialog" style="display: none;">
        	<%@ include file="movieSessionsForm.jsp"%>
        </div>

        <h1>List Of Movie Sessions</h1>

        <button class="pure-button pure-button-primary" onclick="addSessionType()">
            <i class="fa fa-plus"></i> Add New Session
         </button>
         <br>
         <p class="error">${error}</p>
         <table class="pure-table pure-table-bordered pure-table-striped admintable">
            <thead>
               <tr>
                  <!-- <th width="4%">Nr.</th> -->
                  <th width="20%">Movie</th>
                  <th width="12%">Cinema</th>
                  <th width="8%">Date</th>
                  <th width="10%">Session Time</th>
                  <th width="8%">Duration</th>
                  <th width="10%">End Time</th>                  
                  <th width="12%">Session Type</th>
                  <th width="12%">Price</th>
                  <th></th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${movieSessions}" var="movieSession" varStatus="loopCounter">
               <tr>
                   <!-- <td><c:out value="${loopCounter.count}" /></td> -->
                   <td><c:out value="${movieSession.movie.movieTitle}" /></td>
                   <td><c:out value="${movieSession.cinema.cinemaName}" /></td>
                   <td><c:out value="${movieSession.startTime.toLocalDate()}" /></td>
                   <td><c:out value="${movieSession.startTime.toLocalTime()}" /></td>
                   <td><c:out value="${movieSession.movie.duration}" /></td>
                   <td><c:out value="${movieSession.getEndTime().toLocalTime()}" /></td>
                   <td><c:out value="${movieSession.sessionType.sessionName}" /></td>
                   <td><c:out value="${movieSession.sessionType.sessionPrice}" /></td>
                   <td>
                     <nobr>
                        <button onclick="editSessionType(${movieSession.id});"
                                class="pure-button pure-button-primary">
                             <i class="fa fa-pencil"></i> Edit
                        </button>

                        <a href="delete/${movieSession.id}" class="pure-button pure-button-primary"
                   onclick="return confirm('Are you sure you want to delete this session type?');">
                             <i class="fa fa-times"></i>Delete
                        </a>
                      </nobr>
                   </td>
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