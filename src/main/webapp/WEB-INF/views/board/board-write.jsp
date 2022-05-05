<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div id="form-wrap">
	<form id="write-form">
		<input type="hidden" id="userId" value="1" />
		<div class="form-group">
			<label for="title">
				제목<br/>
				<input type="text" id="title" />
			</label>
		</div>
		<div class="form-group">
			<label for="content">
				내용<br/>
				<textarea id="content"></textarea>
			</label>
		</div>
	</form>
	<a href="/devi/board">취소</a>
	<button type="button" id="btn-write">확인</button>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>