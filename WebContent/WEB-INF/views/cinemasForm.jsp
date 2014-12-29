<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="/admin/cinemas/save" />

<form:form id="cinemaForm" commandName="cinema" method="post" action="${actionUrl}" class="pure-form pure-form-aligned">

     <fieldset>
          <legend></legend>

          <div class="pure-control-group">
              <label for="cinemaName">Cinema Name</label>
              <form:input path="cinemaName" placeholder="Cinema Name" />
          </div>
          
		  <div class="pure-control-group">
              <label for="rows">Rows Count</label>
              <form:input path="rowsCount" placeholder="Rows Count" />
          </div>
		  
		  <div class="pure-control-group">
              <label for="columns">Columns Count</label>
              <form:input path="columnsCount" placeholder="Columns Count" />
          </div>
		  
          <form:input path="id" type="hidden" />
      </fieldset>
</form:form>