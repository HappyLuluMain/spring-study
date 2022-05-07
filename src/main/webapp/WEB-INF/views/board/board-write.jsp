<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div id="form-wrap">
	<form id="board-write-form">
		<input type="hidden" id="user_id" value="${ userId }" />
		<div class="form-group">
			<label for="title">
				제목<br/>
				<input type="text" id="title" />
			</label>
			<span id="title-valid"></span>
		</div>
		<div class="form-group">
			<label for="content">
				내용<br/>
				<textarea id="content"></textarea>
			</label>
			<span id="content-valid"></span>
		</div>
	</form>
	<a href="/devi/board">취소</a>
	<button type="button" id="btn-write">확인</button>
</div>

<script src="/devi/resources/script/board.js"></script>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>