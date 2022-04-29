<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>

<div>
	<form>
		<input type="text" id="username" />
		<input type="text" id="password"/>
	</form>
	<button type="button" id="btn-login">login</button>
</div>

<a href="/devi/user">회원가입</a>
<%@ include file="layout/footer.jsp" %>