<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="/includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">업데이트용 껍데기</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">업데이트용 껍데기</div>
			<!-- /.panel-heading -->
			<div class="panel-body">

				<form action='/board/update' method='post' id="modiForm" role="form">
					
				<%@include file="./boardinput.jsp"%>
			

					<button data-oper="modify" class="btn btn-default" type="submit">Modify
						수정</button>
					<button data-oper="remove" class="btn btn-danger" type="submit">Remove
					</button>
					<button data-oper="list" class="btn btn-info" type="submit">목록
					</button>
				</form>

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
	$(document).ready(function() {

		var formObj = $("form");

		$('button').on("click", function(e) {

			e.preventDefault();

			var oper = $(this).data("oper");

			console.log(oper);
			if (oper === 'remove') {
				formObj.attr("action", "/board/delete")
			} else if (oper === 'list') {
				formObj.attr("action","/board/list").attr("method","get");
				formObj.empty();
			}
			formObj.submit();
		});
	});
</script>


