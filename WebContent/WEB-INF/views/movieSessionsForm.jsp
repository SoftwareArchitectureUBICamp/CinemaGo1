<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="/sessiontypes/save" />

<form:form id="movieSessionsForm" commandName="movieSession" method="post"
     
     action="${actionUrl}" class="pure-form pure-form-aligned">

     <fieldset>
          <legend></legend>

          <div class="pure-control-group">
              <label for="start_time">Start time</label>
              <form:input path="startTime" placeholder="Start time" />
          </div>
		  
		//  fetch
	// name="movie_id")
	// private Movie movie;

	// name="cinema_id")
	// private Cinema cinema;

	// name="session_type_id")
	// private SessionType sessionType;
	
	// @OneToMany(mappedBy="movieSession", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	// private Set<Seat> occupiedSeats = new HashSet<Seat>(0);
		  
          <form:input path="id" type="hidden" />
      </fieldset>
</form:form>