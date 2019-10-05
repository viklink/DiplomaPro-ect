$(document).ready(function() {
	$('#update_button').click(function() {
		sendAjaxForm('button', 'ajax_form', event);
	});
})
function sendAjaxForm(button, ajax_form, event) {
	event.preventDefault();
	var formElement = button.parent().parent();
	$.ajax({
		url : 'updateTour',
		method : 'POST',
		data : $(this).serialize(),
		success : function(response) {
			alert('Data sent');
		},
		error : function(response) {
			alert('Error. Data not sent');
		}

	});
}