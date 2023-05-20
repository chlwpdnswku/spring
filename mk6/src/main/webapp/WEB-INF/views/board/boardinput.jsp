<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="form-group">
	<lable>식별자 </lable>
	<input class="form-control" name="id" readOnly="readonly"
		value="${single.id}">
</div>


<div class="form-group">
	<label>제목들 </label> <input class="form-control" name="title"
		value="${single.title}">
</div>

<div class="form-group">
	<label>글 내용 </label> <input type="text" class="form-control"
		name="content" value="${single.content}">
</div>

<!-- 문제가 이거임 날짜 때문에 뭣도안됨지금  -->
<div class="form-group">
	<label>날짜정보는 자동으로 업데이트되니까이건 한국으로 바꾸자 </label> 
	<input type="text" class="form-control" name="dateProp" 
		value="${single.dateProp}">
</div>