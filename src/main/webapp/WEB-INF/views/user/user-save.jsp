<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<h1>회원 가입</h1>
<div>
	<form action="/devi/user" method="post">
		<div class="form-group">
			아이디 : <input type="text" id="username" name="username" value="${ userDto.username }"/> ${ valid_username }
		</div>
		<div class="form-group">
			비밀번호 : <input type="password" id="password" name="password" value="${ userDto.password }"/> ${ valid_password }
		</div>
		<div class="form-group">
			이메일 : <input type="email" id="email" name="email" value="${ userDto.email }"/> ${ valid_email }
		</div>
		<a href="/devi">취소</a>
		<button type="submit" id="btn-save" >확인</button> 
	</form>
</div>

<script src="resources/script/user/user.js"></script>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>