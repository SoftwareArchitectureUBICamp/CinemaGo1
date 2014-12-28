


function addSessionType() {
	$(document).ready(function() {  
	   $('#movieSessionDialog').dialog('option', 'title', 'Add Movie Session');
	   $('#movieSessionDialog').dialog('open');
	});
}

function editSessionType(id) {

	$.get("get/" + id, function(result) {

              $("#movieSessionDialog").html(result);

              $(document).ready(function() {

              $('#movieSessionDialog').dialog("option", "title", 'Edit Movie Session');
       		$('#movieSessionDialog').dialog('open');
              });
//              initializeDatePicker();
       });
	
}

function resetDialog(form) {

       form.find("input").val("");
}

$(document).ready(function() {

    $('#movieSessionDialog').dialog({

           autoOpen : false,
           position : 'center',
           modal : true,
           resizable : false,
           width : 440,
           buttons : {
                  "Save" : function() {
                        $('#movieSessionForm').submit();
                  },
                  "Cancel" : function() {
                        $(this).dialog('close');
                  }
           },
           close : function() {

                  resetDialog($('#movieSessionForm'));
                  $(this).dialog('close');
           }
    });

});