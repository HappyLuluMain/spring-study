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
			alert('회원 가입 완료 ' + res);
			window.location.href='/devi';
		}).fail(function(error){
			alert(JSON.stringify(error));
		})
	}
}

user_main.init();