<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Cinemas</title>

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

    <div id="cinemaDialog" style="display: none;">
      	<%@ include file="cinemasForm.jsp"%>
    </div>
	
	<h1>List of Cinemas</h1>
	
	        <button class="pure-button pure-button-primary" onclick="addCinema()">
            <i class="fa fa-plus"></i> Add Cinema </button>
            <br><br>
            
	<table class="pure-table pure-table-bordered pure-table-striped admintable">
            <thead>
               <tr>
                  <th width="12%">Cinema name</th>
                  <th width="8%">Row count</th>
                  <th width="12%">Column count</th>
                  <th width="8%"></th>
               </tr>
            </thead>
            <tbody>

<c:forEach items="${cinemas}" var="cinema" varStatus="status">
  	
	<tr>

    	<td><c:out value="${cinema.cinemaName}" /></td>
        <td><c:out value="${cinema.rowsCount}" /></td>
        <td><c:out value="${cinema.columnsCount}" /></td>

        <td> 
        	<nobr>
            <button onclick="editCinema(${cinema.id});" class="pure-button pure-button-primary">
            	<i class="fa fa-pencil"></i>Edit
            </button>

            <a href="delete/${cinema.id}" class="pure-button pure-button-primary" onclick="return confirm('Are you sure you want to delete this?');">
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
    <script type="text/javascript" src='<c:url value="/resources/js/cinemas.js"/>'></script>

</body>
</html>