<%@page import="www.intumit.entity.Billboard"%>
<%@page import="java.util.List"%>
<%@page import="www.intumit.service.BillboardService"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
		<meta charset="UTF-8">
		<title>瀏覽公佈事項</title>
		<!-- Bootstrap CSS -->
		<link rel="stylesheet"
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
			integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
			crossorigin="anonymous">		
	</head>	
	<script>
	function getBillboard(billboardId){	
		location.href = "<%=request.getContextPath()%>/updata.jsp?billboardId=" + billboardId;
	}
	</script>
	<%
	BillboardService service = new BillboardService();
	List<Billboard> list = service.selectAllBillboard();
	%>
	<body>
		<table class="table table-hover table-sm">
			<tr>
				<th style="width: 50%">標題</th>
				<th style="width: 15%">發佈日期</th>
				<th style="width: 15%">截止日期</th>
				<th style="width: 10%;text-align: center">修改</th>
				<th style="width: 10%;text-align: center">刪除</th>
			</tr>
			<tbody>
			<% if(list != null && list.size() > 0) { %>
					<% 
					for(int i = 0; i < list.size(); i++) {
					Billboard b = list.get(i);	 
					%>
				<tr>
					<td><%= b.getTitle() %></td>	
					<td><%= b.getDateStart() %></td>
					<td><%= b.getDateEnd() %></td>
					<td style="text-align: center">	
						<button type="button" onclick="getBillboard(<%= b.getId() %>)" class="btn btn-primary btn-sm">修改</button>
					</td>
					<td style="text-align: center">							
						<form action="delete.do" method="post">
							<input name="id" style="display: none;" type="text" value="<%= b.getId() %>">
							<input type="submit" class="btn btn-danger btn-sm" value="刪除">
						</form>			
					</td>
				</tr>
					<% } %>
			<% }else{ %>
				<h6 style="color: red;">無資料</h6>
			<% } %>					
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5" style="text-align:center;">
						<a href="<%=request.getContextPath()%>/add.jsp" class="btn btn-secondary btn-sm">新增</a>				
					</td>
				</tr>
			</tfoot>
		</table>

		<!-- Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.4.1.min.js"
			integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
			integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
			integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
			crossorigin="anonymous"></script>
	</body>
</html>