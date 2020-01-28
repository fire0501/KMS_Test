<%@page import="www.intumit.service.BillboardService"%>
<%@page import="www.intumit.entity.Billboard"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport"content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
		<meta charset="UTF-8">
		<title>編輯公佈事項</title>
		<!-- Bootstrap CSS -->
		<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
			integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
			crossorigin="anonymous">
		<!-- Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
			crossorigin="anonymous"></script>
		<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
			integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
			crossorigin="anonymous"></script>
		<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
			integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
			crossorigin="anonymous"></script>
		<!-- include summernote css/js -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.css">
		<script	src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.js"></script>	
		<script>
			$(document).ready(init);
			function init() {
				 $("#summernote").summernote();
			}
		</script>	
	</head>
	<%
	String billboardId = request.getParameter("billboardId");
	BillboardService service = new BillboardService();
	Billboard b = service.selectBillboardByID(billboardId);
	%>
	<body>	
		<form style="width: 70%" action="updata.do" method="post">
			<h5 style="background-color: gray;">
				<b>編輯公佈事項</b>
			</h5>
			<input name="id" type="text" style="display: none;" value="<%= b.getId() %>">
			<div class="form-group row">
				<label class="col-2 col-form-label">標題：</label>
				<div class="col">
					<input name="title" type="text" class="form-control form-control-sm" 
					 value="<%= b.getTitle() %>">				
				</div>
			</div>	
			<div class="form-group row">
				<label class="col-2 col-form-label">發佈日期：</label>
				<div class="col">
					<input name="dataStart" type="date" class="form-control form-control-sm"
					value="<%= b.getDateStart() %>">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-2 col-form-label">截止日期：</label>
				<div class="col">
					<input name="dataEnd" type="date" class="form-control form-control-sm"
					value="<%= b.getDateEnd() %>">
				</div>
			</div>	
			<div class="form-group row">		
				<label class="col-2 col-form-label">公佈者：</label>
				<div class="col">
					<input name='name' type='text' class="form-control form-control-sm" 
					value="<%= b.getName() %>" readonly>			
				</div>
			</div>	
			<div class="form-group row">
				<label class="col-2 col-form-label">公佈內容：</label>
				<div class="col">
					<textarea name="content" id="summernote" ><%= b.getContent() %></textarea>
				</div>
			</div>
			<input type="submit" class="btn btn-primary" value="修改"  name="submit">
		</form>
	</body>
</html>