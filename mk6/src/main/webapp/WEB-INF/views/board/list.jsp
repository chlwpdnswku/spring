<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="/includes/header.jsp"%>

<main>
	<div class="container-fluid px-4">
		<h1 class="mt-4">Dashboard</h1>
		<ol class="breadcrumb mb-4">

			<div class="d-flex justify-content-end">
				<button id="registerBtn" type="button" class="btn btn-success">
					새등록</button>
			</div>

		</ol>
		<div class="row">
			<c:forEach items="${boardlist}" var="board">

				<!-- 정상 적인 출력들  -->
				<div class="col-xl-3 col-md-6">
					<div class="card bg-primary text-white mb-4">
						<h5 class="card-title text-center">${board.id}</h5>
						<div class="card-body">${board.content}</div>
						<div
							class="card-footer d-flex align-items-center justify-content-between">
							<a class="small text-white stretched-link"
								href="/board/showDetail?id=${board.id}">View Details</a>
							<div class="small text-white">
								<i class="fas fa-angle-right"></i>
							</div>
						</div>
					</div>
				</div>


				<%-- 		<c:if test="${board.id % 2 == 1}">
					<div class="col-xl-3 col-md-6">
						<div class="card bg-primary text-white mb-4">
							<h5 class="card-title text-center">${board.id}</h5>
							<div class="card-body">${board.content}</div>
							<div
								class="card-footer d-flex align-items-center justify-content-between">
								<a class="small text-white stretched-link" href="/board/showDetail?id=${board.id}">View
									Details</a>
								<div class="small text-white">
									<i class="fas fa-angle-right"></i>
								</div>
							</div>
						</div>
					</div>
				</c:if>
				<c:if test="${board.id % 2 == 0}">
					<div class="col-xl-3 col-md-6">
						<div class="card bg-warning text-white mb-4">
							<h5 class="card-title text-center">${board.id}</h5>
							<div class="card-body">${board.content}</div>
							<div
								class="card-footer d-flex align-items-center justify-content-between">
								<a class="small text-white stretched-link" href="#">View
									Details</a>
								<div class="small text-white">
									<i class="fas fa-angle-right"></i>
								</div>
							</div>
						</div>
					</div>
				</c:if>

				<c:if test="${board.id % 3 == 0}">
					<div class="col-xl-3 col-md-6">
						<div class="card bg-success text-white mb-4">
							<h5 class="card-title text-center">${board.id}</h5>
							<div class="card-body">${board.content}</div>
							<div
								class="card-footer d-flex align-items-center justify-content-between">
								<a class="small text-white stretched-link" href="#">View
									Details</a>
								<div class="small text-white">
									<i class="fas fa-angle-right"></i>
								</div>
							</div>
						</div>
					</div>
				</c:if>

				<c:if test="${board.id % 4 == 0}">
					<div class="col-xl-3 col-md-6">
						<div class="card bg-danger text-white mb-4">
							<h5 class="card-title text-center">${board.id}</h5>
							<div class="card-body">${board.content}</div>
							<div
								class="card-footer d-flex align-items-center justify-content-between">
								<a class="small text-white stretched-link" href="#">View
									Details</a>
								<div class="small text-white">
									<i class="fas fa-angle-right"></i>
								</div>
							</div>
						</div>
					</div>
				</c:if> --%>

			</c:forEach>
		</div>
		<!-- card end  -->

		<!-- pagenation  -->
		<nav aria-label="Page navigation example">
			  <ul class="pagination justify-content-center">
			  	<c:if test="${pageMake.prev}">
			  	 <li class="paginate_button previous">
			      <a href="${pageMake.startPage-1}"class="page-link">Previous</a>
			    </li>
			  	</c:if>
			   <c:forEach var="num" begin="${pageMake.startPage}" end="${pageMake.endPage}">
			   
			   	<li class="paginate_button ${pageMake.criPageInfo.pageNum == num ? 'active': ''}" >
			   	<a class="page-link" href="${num}">${num}</a>
			   	</li>
			   	
			   </c:forEach>
			    <c:if test="${pageMake.next}">
			     <li class="paginate_button next">
			      <a href="${pageMake.endPage+1}" class="page-link">Next</a>
			    </li>
			    </c:if>
			  </ul>
			  
			  <form id="pagingForm" action="/board/list" method="get">
			  	<input type="hidden" name="pageNum" value='${pageMake.criPageInfo.pageNum}'/>
			  	<input type="hidden" name="amount" value='${pageMake.criPageInfo.amount}'/>
			  </form>
			  
		</nav>


		<div class="card mb-4">
			<div class="card-header">
				<i class="fas fa-table me-1"></i> DataTable Example
			</div>
			<div class="card-body">
				<table id="datatablesSimple">
					<thead>
						<tr>
							<th>Name</th>
							<th>Position</th>
							<th>Office</th>
							<th>Age</th>
							<th>Start date</th>
							<th>Salary</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Name</th>
							<th>Position</th>
							<th>Office</th>
							<th>Age</th>
							<th>Start date</th>
							<th>Salary</th>
						</tr>
					</tfoot>
					<tbody>
						<tr>
							<td>Tiger Nixon</td>
							<td>System Architect</td>
							<td>Edinburgh</td>
							<td>61</td>
							<td>2011/04/25</td>
							<td>$320,800</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</main>


<div class="modal" tabindex="-1" id="resultModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="titleModal">Modal title</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body" id="bodyModal">
				<p>Modal body text goes here.</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Save changes</button>
			</div>
		</div>
	</div>
</div>


<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<%@include file="/includes/footer.jsp"%>


<script type="text/javascript">
	$(document).ready(function() {
		
		var result = "${result}";
		
		checkModal(result);
		
		history.replaceState({}, null, null);
		function checkModal(result) {
			if (result === '' || history.state) {
				return;
			}
			if (parseInt(result) > 0) {
				$("#bodyModal").html("게시글" + parseInt(result) + "번이 등록 ");
			}
			$("#resultModal").modal("show");
		};

		$("#registerBtn").on("click", function() {
			self.location = "/board/boardreg";
		});
		
		//페이징 네이션 
		var pagingForm = $("#pagingForm");
		$(".paginate_button a").on("click",function(e){
			e.preventDefault();
			//페이지 name넘버를 페이지 숫자로 바꿔주는 값들 
			pagingForm.find("input[name='pageNum']").val($(this).attr("href"));
			
			pagingForm.submit();
		});
				
		
	});
</script>