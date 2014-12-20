<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<link rel="stylesheet" href='<c:url value="/resources/css/normalize.min.css"/>'>
<link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.min.css"/>">
<link rel="stylesheet" href='<c:url value="/resources/css/main.css"/>'>

<style type="text/css">
  th {
       text-align: left
  }

</style>

<div style="width: 95%; margin: 0 auto;">

	<h1><a href="/">CinemaGo</a></h1>
            <br>
            
	<table class="pure-table pure-table-bordered pure-table-striped">
            <thead>
               <tr>
                  <th width="8%"><a href="/cinema/">Cinemas</a></th>
                  <th width="8%"><a href="/movies/">Movies</a></th>
                  <th width="8%"><a href="/sessiontypes/">Session Types</a></th>
                  <th width="8%"><a href="/1/">ect.</a></th>
                  <th width="8%"></th>
               </tr>
            </thead>
            <tbody>

	</table>

     <!--  It is advised to put the <script> tags at the end of the document body so that they don't block rendering of the page -->
     
    <script type="text/javascript" src='<c:url value="/resources/js/lib/jquery-1.11.0.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/lib/modernizr-2.6.2-respond-1.1.0.min.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/lib/jquery-ui.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/sessionType.js"/>'></script>