<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/list.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/WdatePicker.js"></script>

</head>
<script type="text/javascript">
	var orderByMethod = '${movieVO.orderByMethod=="asc"?"desc":"asc"}'

	function myOrder(orderByColumn) {

		location.href = "/selects?orderByColumn=" + orderByColumn
				+ "&orderByMethod=" + orderByMethod

	}
	function updatestatus(id,status) {
		$.post("updatestatus",{id:id,status:status},function(data){
			if(data>0){
				alert("操作成功");
				location.reload();
			}
		},"json")
	}
	
</script>
<body>
	<form action="selects" method="post">
		影片名称:<input type="text" name = "name" value="${movievo.name}">
		导演:<input type="text" name = "direct" value="${movievo.direct}">
		电影年代:<input type="text" name = "year" value="${movievo.year }">
		上映时间:<input type="text" name = "timeStart" value="${movievo.timeStart }"> -- <input type="text" name = "timeEnd" value="${movievo.timeEnd }">
		价格:<input type="text" name = "priceStart" value="${movievo.priceStart }"> -- <input type="text" name = "priceEnd" value="${movievo.priceEnd}">
		电影时长:<input type="text" name = "durationStart" value="${movievo.durationStart}"> -- <input type="text" name = "durationEnd" value="${movievo.durationEnd}">
		<input type="submit" value="查询"> 
	</form>
	<table>
		<tr>
			<td>序号</td>
			<td>影片名</td>
			<td>导演</td>
			<td><a href="javascript:myOrder('price')">价格</a></td>
			<td><a href="javascript:myOrder('time')">上映时间</a></td>
			<td><a href="javascript:myOrder('duration')">时长</a></td>
			<td>类型</td>
			<td><a href="javascript:myOrder('year')">年代</a></td>
			<td>区域</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${info}" var="l" varStatus="i">
			<tr>
				<td>${i.index+1}</td>
				<td>${l.name}</td>
				<td>${l.direct }</td>
				<td>${l.price }</td>
				<td>${l.time }</td>
				<td>${l.duration }</td>
				<td>${l.type }</td>
				<td>${l.year }</td>
				<td>${l.area }</td>
				<td>${l.status==-1?"已经下架":l.status==0?"即将上架":"正在热映" }</td>
				<td>
					<c:if test="${l.status==-1}">
						<input type="button" value="上架"  onclick="updatestatus(${l.id},1)">
					</c:if>
					<c:if test="${l.status!=-1}">
						<input type="button" value="下架"  onclick="updatestatus(${l.id},-1)">
					</c:if>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="10">${page }</td>
		</tr>
	</table>
</body>
</html>