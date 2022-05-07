<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<h1>회원 가입</h1>
<div id="form-wrap">
	<form id="user-save-form">
		<div class="form-group">
			아이디 <br/><input type="text" id="username" />&emsp;<span id="username-valid"></span>
		</div><br/>
		<div class="form-group">
			비밀번호 <br/><input type="password" id="password"/>&emsp;<span id="password-valid"></span>
		</div><br/>
		<div class="form-group">
			이메일 <br/><input type="email" id="email" />&emsp;<span id="email-valid"></span>
		</div>
	</form>
		<a href="/devi">취소</a>
		<button type="button" id="btn-save" >확인</button>
</div>

<script src="/devi/resources/script/user.js"></script>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>