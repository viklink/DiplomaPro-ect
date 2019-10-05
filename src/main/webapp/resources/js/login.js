$(document).ready(function() {
	$('#password').on('input', function() {
		if($('#password').html.length <3) {
			console.log('test');
			$('.password_validation_block').show();
			$('.password_validation_block').text("TEST");
		} else {
			$('.password_validation_block').hide();
		}
	})
})