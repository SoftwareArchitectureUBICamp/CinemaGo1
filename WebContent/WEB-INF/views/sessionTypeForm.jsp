<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="/sessiontypes/save" />

<form:form id="sessionTypeForm" commandName="sessionType" method="post"
     
     action="${actionUrl}" class="pure-form pure-form-aligned">

     <fieldset>
          <legend></legend>

          <div class="pure-control-group">
              <label for="name">Name</label>
              <form:input path="sessionName" placeholder="Session Name Type" />
          </div>
		  
          <div class="pure-control-group">
              <label for="price">Price</label>
              <form:input path="sessionPrice" placeholder="Price" maxlength="10" />
          </div>
          
          <form:input path="id" type="hidden" />
      </fieldset>
</form:form>