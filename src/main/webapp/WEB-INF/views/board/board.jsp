<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div class="list-wrap">
	<div class="list-board">
		<div class="list-head">
			<span class="wr-num">번호</span>
			<span class="wr-subject">제목</span>
			<span class="wr-name">이름</span>
			<span class="wr-date">날짜</span>
			<span class="wr-hit">조회</span>
		</div>
		<ul class="list-body">
			<c:forEach items="${ boards }" var="board">
				<li class="list-item">
					<div class="wr-num">${ board.id }</div>
					<div class="wr-subject">${ board.title }</div>
					<div class="wr-name">${ board.username }</div>
					<div class="wr-date">
					<fmt:parseDate value="${ board.modifiedDate }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDate"/>
					<fmt:formatDate value="${ parsedDate }" pattern="MM.dd"/>
					</div>
					<div class="wr-hit">${ board.count }</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	<a href="/devi/board/write">글쓰기</a>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>