var board_main = {
	init: function(){
		var _this = this;
		$('#btn-write').on('click', function(event){
			_this.save(event);
		});
	},
	
	save: function(event){
		event.preventDefault;
		
		var data = new FormData();
		
		var userId = $('#user_id').val();
		var title = $('#title').val();
		var content = $('#content').val();
		
		var inputFile = $('#file')[0].files[0];
		
		data.append("userId", userId);
		data.append("title", title);
		data.append("content", content);
		data.append("file", inputFile);
		
		
		$.ajax({
			url: '/devi/api/v1/board',
			enctype: 'multipart/form-data',
			type: 'POST',
			processData: false,
			contentType: false,
			data: data
		}).done(function(res){
			alert('글쓰기가 완료 되었습니다');
			window.location.href='/devi/board';
		}).fail(function(error){
			console.log(error);
		});
	}
}

board_main.init();