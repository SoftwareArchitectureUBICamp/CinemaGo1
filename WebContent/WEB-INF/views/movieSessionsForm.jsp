<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="/moviesessions/save" />

<form:form id="movieSessionForm" commandName="movieSession" method="post"
     
     action="${actionUrl}" class="pure-form pure-form-aligned">

     <fieldset>
          <legend></legend>

          <div class="pure-control-group">
              <label for="startTime">Start Time</label>
              <form:input path="startTime" placeholder="Movie Start Time" />
          </div>
          <div class="pure-control-group">
              <label for="movie">Movie Title</label>
			  	<form:select path="movie.movieTitle">
        			<form:options id="movie" items="${movies}" itemValue="id" itemLabel="movieTitle"></form:options> 
    			</form:select>
          </div>          
          <div class="pure-control-group">
              <label for="cinema">Cinema Name</label>
			  	<form:select path="cinema.cinemaName">
         			<form:options items="${cinemas}" itemValue="id" itemLabel="cinemaName"></form:options>
    			</form:select>
          </div>          
          <div class="pure-control-group">
              <label for="sessionType">Session Type</label>
			  	<form:select path="sessionType.sessionName">
         			<form:options items="${sessionTypes}" itemValue="id" itemLabel="sessionName"></form:options>
    			</form:select>
          </div>          

          
          <form:input path="id" type="hidden" />
      </fieldset>
</form:form>