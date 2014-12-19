


function addSessionType() {
	$(document).ready(function() {  
	   $('#sessionTypeDialog').dialog('option', 'title', 'Add Session Type');
	   $('#sessionTypeDialog').dialog('open');
	});
}

function editSessionType(id) {

	$.get("get/" + id, function(result) {

              $("#sessionTypeDialog").html(result);

              $(document).ready(function() {

              $('#sessionTypeDialog').dialog("option", "title", 'Edit Session Type');
       		$('#sessionTypeDialog').dialog('open');
              });
//              initializeDatePicker();
       });
	
}

function resetDialog(form) {

       form.find("input").val("");
}

$(document).ready(function() {

    $('#sessionTypeDialog').dialog({

           autoOpen : false,
           position : 'center',
           modal : true,
           resizable : false,
           width : 440,
           buttons : {
                  "Save" : function() {
                        $('#sessionTypeForm').submit();
                  },
                  "Cancel" : function() {
                        $(this).dialog('close');
                  }
           },
           close : function() {

                  resetDialog($('#sessionTypeForm'));
                  $(this).dialog('close');
           }
    });

});