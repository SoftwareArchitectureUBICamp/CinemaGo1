<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>List of Movies</title>

<link rel="stylesheet" href='<c:url value="/resources/css/normalize.min.css"/>'>
<link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.min.css"/>">
<link rel="stylesheet" href='<c:url value="/resources/css/main.css"/>'>

<style type="text/css">
  
  img{
  	vertical-align: middle;
	max-height: 200;
  }

</style>
</head>

<body>
<div style="width: 95%; margin: 0 auto;">

	<div><%@ include file="nav.jsp"%></div>

        <div id="movieDialog" style="display: none;">
        	<%@ include file="moviesForm.jsp"%>
        </div>
	
	<h1>List of Movies</h1>
	        <button class="pure-button pure-button-primary" onclick="addMovie()">
            <i class="fa fa-plus"></i> Add Movie </button>
            <br><br>
            
	<table class="pure-table pure-table-bordered pure-table-striped admintable">
            <thead>
               <tr>
                  <th>Movie Image</th>
                  <th>Movie</th>
                  <th>Duration</th>
                  <th>Description</th>
                  <th></th>
               </tr>
            </thead>
            <tbody>

  	<c:forEach items="${movies}" var="movie" varStatus="status">
  	
                       <tr>

            <td><img src="<c:out value="${movie.imgUrl}" />"/></td>
            <td><c:out value="${movie.movieTitle}" /></td>
            <td><c:out value="${movie.duration}" /></td>
            <td><c:out value="${movie.description}" /></td>
            <td> <nobr>
              <button onclick="editMovie(${movie.id});"
                                class="pure-button pure-button-primary">
                             <i class="fa fa-pencil"></i> Edit
                        </button>

                        <a href="delete/${movie.id}" class="pure-button pure-button-primary"
                   onclick="return confirm('Are you sure you want to delete this movie?');">
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
    <script type="text/javascript" src='<c:url value="/resources/js/movies.js"/>'></script>

</body>
</html>
