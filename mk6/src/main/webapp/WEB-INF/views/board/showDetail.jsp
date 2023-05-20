<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="/includes/header.jsp"%>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">정보 상세 화면</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">샘플 객체 상세</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="form-group">
					<label>이게 등록날짜임  </label>
					 <input class="form-control" name="regDate"
						value="${single.regDate}">
				</div>


				<%@include file="./boardinput.jsp"%>
				
				<form id='operForm' action="/board/update" method="get">
					<input type="hidden" id="id" name="id" value="${single.id}">
				</form>
				
				<button data-oper="modify" class="btn btn-default"
					onclick="location.href='/board/updateBoard?id=${single.id}'">정보
					수정</button>
				<button data-oper="list" class="btn btn-info"
					onclick="location.href='/board/list'">목록</button>

			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->


<%@include file="/includes/footer.jsp"%>

<script type="text/javascript">

	//우리가 정해준 singleController에 대한 url매핑 주소들을 확인을 꼭 해주고 -> id 나 모델의 ㅂ값들으 ㅎ확인해줘야됨  
	$(document).ready(function() {
		
		var operForm =$("#operForm");
		$("button[data-oper='modify']").on("click",function(e){
			operForm.attr("action","/board/update").submit();
		});
		$("button[data-oper='list']").on("click",function(e){
			operForm.find("#id").remove();
			operForm.attr("action","board/list").submit();
		});		
	}
</script>

