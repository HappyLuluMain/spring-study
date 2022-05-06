<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div class="list-wrap">
	<div class="list-board">
		<div class="list-head">
			<div class="list-row">
				<span class="wr-num list-cell">번호</span>
				<span class="wr-subject list-cell">제목</span>
				<span class="wr-name list-cell">이름</span>
				<span class="wr-date list-cell">날짜</span>
				<span class="wr-hit list-cell">조회</span>
			</div>
		</div>
		<ul class="list-body">
			<c:forEach items="${ pageInfo.boards }" var="board">
				<li class="list-item">
					<div class="wr-num list-cell">${ board.id }</div>
					<div class="wr-subject list-cell">${ board.title }</div>
					<div class="wr-name list-cell">${ board.username }</div>
					<div class="wr-date list-cell">
					<fmt:parseDate value="${ board.modifiedDate }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDate"/>
					<fmt:formatDate value="${ parsedDate }" pattern="MM월dd일"/>
					</div>
					<div class="wr-hit list-cell">${ board.count }</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	<div class="pagination">
		<c:if test="${ pageInfo.startRow ne 1 }">
			<a href="/devi/board?page=${ pageInfo.startRow-1 }"> << </a>
		</c:if>
		<c:forEach var="num" begin="${ pageInfo.startRow }" end="${ pageInfo.endRow }">
			<c:choose>
				<c:when test="${ pageInfo.pageIndex ne num }">
					<a href="/devi/board?page=${ num }">${ num }</a>
				</c:when>
				<c:otherwise>
					${ pageInfo.pageIndex }
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${ not pageInfo.isLastRow }">
			<a href="/devi/board?page=${ pageInfo.endRow+1 }"> >> </a>
		</c:if>
	</div>
	<a href="/devi/board/write">글쓰기</a>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>