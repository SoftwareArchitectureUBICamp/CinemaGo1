<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="/sessiontypes/save" />

<form:form id="movieForm" commandName="movie" method="post"
     
     action="${actionUrl}" class="pure-form pure-form-aligned">

     <fieldset>
          <legend></legend>
          <div class="pure-control-group">
              <label for="name">Name</label>
              <form:input path="movieTitle" placeholder="Movie Name Type" />
          </div>
          <div class="pure-control-group">
              <label for="price">Duration</label>
              <form:input path="duration" placeholder="Duration" maxlength="10" />
          </div>
          <div class="pure-control-group">
              <label for="price">Description</label>
              <form:input path="description" placeholder="Description" maxlength="100" />
          </div>
          <form:input path="id" type="hidden" />
      </fieldset>
</form:form>