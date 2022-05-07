var user_main = {
	init: function(){
		var _this = this;
		
		$('#btn-save').on('click', function(){
			_this.save();
		})
	},
	
	save: function(){
		var data = {
			username: $('#username').val(),
			password: $('#password').val(),
			email: $('#email').val()
		};
		
		$.ajax({
			url: '/devi/api/v1/user',
			type: 'POST',
			contentType: 'application/json; charset=utf-8',
			dataType: 'json',
			data: JSON.stringify(data)
		}).done(function(res){
			console.log(res);
			window.location.href='/devi';
		}).fail(function(error){
			$('#username-valid').text(error.responseJSON.username);
			$('#password-valid').text(error.responseJSON.password);
			$('#email-valid').text(error.responseJSON.email);
			
		});
	}
}

user_main.init();