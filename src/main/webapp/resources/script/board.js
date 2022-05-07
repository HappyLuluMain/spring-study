var board_main = {
	init: function(){
		var _this = this;
		$('#btn-write').on('click', function(){
			_this.save();
		});
	},
	
	save: function(){
		var data = {
			userId: $('#user_id').val(),
			title: $('#title').val(),
			content: $('#content').val()
		};
		
		$.ajax({
			url: '/devi/api/v1/board',
			type: 'POST',
			dataType: 'json',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(data)
		}).done(function(res){
			alert('글쓰기가 완료 되었습니다');
			window.location.href='/devi/board';
		}).fail(function(error){
			$('#title-valid').text(error.responseJSON.title);
			$('#content-valid').text(error.responseJSON.content);
		});
	}
}

board_main.init();