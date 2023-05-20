<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="/includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">글 쓰 기</h1>
	</div>
</div>
<div class="card mb-4">
	<div class="card-header">글 작성</div>

	<div class="card-body">
		<form role="form" action="/board/register" method="post">
		
			<div class="row">
				<div class="col-lg-9">
					<lagel>제목</lagel>
					<input class="form-control" name='title' type="text" />
				</div>
				<div class="col-lg-3">
					<lagel>작성자</lagel>
					<input class="form-control" name='author' type="text" />
				</div>
			</div>

			<div class="form-group">
				<lable> 날짜 정 보 </lable>
				<input type="text" class="form-control" name="dateProp"
					value="${single.dateProp}">
			</div>

			<div class="form-group">
				<textarea class="form-control" rows="10" name="content"
					placeholder="내용을 입력해주세요" required></textarea>
			</div>

			<button type="submit" class="btn btn-secondary mb-3">제출하기</button>

			<button type="reset" class="btn btn-default mb-3">리셋</button>
		</form>

	</div>
</div>

<%@include file="/includes/footer.jsp"%>
