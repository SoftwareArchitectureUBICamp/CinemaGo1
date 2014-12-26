<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Movies</title>

<link rel="stylesheet" href='<c:url value="/resources/css/normalize.min.css"/>'>
<link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.min.css"/>">
<link rel="stylesheet" href='<c:url value="/resources/css/main.css"/>'>

<style type="text/css">
  th {
       text-align: left
  }

</style>
</head>

<body>
<div style="width: 95%; margin: 0 auto;">

	<div><%@ include file="nav.jsp"%></div>
	
	<h1>Movies</h1>
	        <button class="pure-button pure-button-primary" onclick="addSessionType()">
            <i class="fa fa-plus"></i> Add Movie </button>
            <br><br>
            
	<table class="pure-table pure-table-bordered pure-table-striped">
            <thead>
               <tr>
                  <th width="12%">Movie</th>
                  <th width="8%">Duration</th>
                  <th width="12%">Description</th>
                  <th width="8%"></th>
               </tr>
            </thead>
            <tbody>

  	<c:forEach items="${movies}" var="movie" varStatus="status">
  	
                       <tr>
            <td><input name="movies[${status.index}].firstname" value="${movies.movieTitle}"/></td>
            <td><input name="movies[${status.index}].lastname" value="${movies.duration}"/></td>
            <td><input name="movies[${status.index}].email" value="${movies.description}"/></td>
                    <td> <nobr>
              <button onclick="editMovie(${movies.id});"
                                class="pure-button pure-button-primary">
                             <i class="fa fa-pencil"></i> Edit
                        </button>

                        <a href="delete/${movies.id}" class="pure-button pure-button-primary"
                   onclick="return confirm('Are you sure you want to delete this movie?');">
                             <i class="fa fa-times"></i>Delete
                        </a>
                      </nobr>
        </tr>
   	</c:forEach>
	</table>

     <!--  It is advised to put the <script> tags at the end of the document body so that they don't block rendering of the page -->
     
    <script type="text/javascript" src='<c:url value="/resources/js/lib/jquery-1.11.0.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/lib/modernizr-2.6.2-respond-1.1.0.min.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/lib/jquery-ui.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/movies.js"/>'></script>

</body>
</html>
