

function addMovie() {
	$(document).ready(function() {  
	   $('#movieDialog').dialog('option', 'title', 'Add New Movie');
	   $('#movieDialog').dialog('open');
	});
}

function editMovie(id) {

	$.get("get/" + id, function(result) {

              $('#movieDialog').html(result);

              $(document).ready(function() {
            	  $('#movieDialog').dialog('option', 'title', 'Edit Movie');
       			  $('#movieDialog').dialog('open');
              });
//              initializeDatePicker();
       });
	
}

function resetDialog(form) {

       form.find("input").val("");
}

$(document).ready(function() {

    $('#movieDialog').dialog({

           autoOpen : false,
           position : 'center',
           modal : true,
           resizable : false,
           width : 440,
           buttons : {
                  "Save" : function() {
                        $('#movieForm').submit();
                  },
                  "Cancel" : function() {
                        $(this).dialog('close');
                  }
           },
           close : function() {

                  resetDialog($('#movieForm'));
                  $(this).dialog('close');
           }
    });

});