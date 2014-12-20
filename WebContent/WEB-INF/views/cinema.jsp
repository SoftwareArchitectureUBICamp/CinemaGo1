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
	
	<h1>Cinemas</h1>
	        <button class="pure-button pure-button-primary" onclick="addSessionType()">
            <i class="fa fa-plus"></i> Add Cinema </button>
            <br><br>
            
	<table class="pure-table pure-table-bordered pure-table-striped">
            <thead>
               <tr>
                  <th width="12%">Cinemas</th>
                  <th width="8%">Seasion</th>
                  <th width="12%">Schedule</th>
                  <th width="8%"></th>
               </tr>
            </thead>
            <tbody>

  	<c:forEach items="${cinemas}" var="cinemas" varStatus="status">
  	
                       <tr>
            <td><input name="cinemas[${status.index}].firstname" value="${cinema1.cinemaname}"/></td>
            <td><input name="cinemas[${status.index}].lastname" value="${cinema1.rowscount}"/></td>
            <td><input name="cinemas[${status.index}].email" value="${cinema1.columnscount}"/></td>
                    <td> <nobr>
              <button onclick="editSessionType(${sessionType.movie});"
                                class="pure-button pure-button-primary">
                             <i class="fa fa-pencil"></i> Edit
                        </button>

                        <a href="delete/${sessionType.movie}" class="pure-button pure-button-primary"
                   onclick="return confirm('Are you sure you want to delete this?');">
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
    <script type="text/javascript" src='<c:url value="/resources/js/sessionType.js"/>'></script>

</body>
</html>
