<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<h1>회원 가입</h1>
<div>
	<form>
		<div class="form-group">
			아이디 : <input type="text" id="username"/>
		</div>
		<div class="form-group">
			비밀번호 : <input type="password" id="password" />
		</div>
		<div class="form-group">
			이메일 : <input type="email" id="email" />
		</div>
	</form>
	<a href="/devi">취소</a>
	<button type="button" id="btn-save" >확인</button> 
</div>

<script src="resources/script/user/user.js"></script>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>