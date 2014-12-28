<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="/sessiontypes/save" />

<form:form id="movieSessionsForm" commandName="movieSession" method="post"
     
     action="${actionUrl}" class="pure-form pure-form-aligned">

     <fieldset>
          <legend></legend>

          <div class="pure-control-group">
              <label for="cinema_name">Cinema Name</label>
              <form:input path="cinemaName" placeholder="Cinema Name" />
          </div>
          
		  <div class="pure-control-group">
              <label for="rows_count">Rows Count</label>
              <form:input path="rowsCount" placeholder="Rows Count" />
          </div>
		  
		  <div class="pure-control-group">
              <label for="columns_count">Columns Count</label>
              <form:input path="columnsCount" placeholder="Columns Count" />
          </div>
		  
          <form:input path="id" type="hidden" />
      </fieldset>
</form:form>