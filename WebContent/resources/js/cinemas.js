

function addCinema() {
	$(document).ready(function() {  
	   $('#cinemaDialog').dialog('option', 'title', 'Add New Cinema');
	   $('#cinemaDialog').dialog('open');
	});
}

function editCinema(id) {

	$.get("get/" + id, function(result) {

              $('#cinemaDialog').html(result);

              $(document).ready(function() {
            	  $('#cinemaDialog').dialog('option', 'title', 'Edit Cinema');
       			  $('#cinemaDialog').dialog('open');
              });
//              initializeDatePicker();
       });
	
}

function resetDialog(form) {

       form.find("input").val("");
}

$(document).ready(function() {

    $('#cinemaDialog').dialog({

           autoOpen : false,
           position : 'center',
           modal : true,
           resizable : false,
           width : 440,
           buttons : {
                  "Save" : function() {
                        $('#cinemaForm').submit();
                  },
                  "Cancel" : function() {
                        $(this).dialog('close');
                  }
           },
           close : function() {

                  resetDialog($('#cinemaForm'));
                  $(this).dialog('close');
           }
    });

});