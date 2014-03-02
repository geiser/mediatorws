<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Repository ${repository.url}</title>
</head>
<body>
	<table>
		<caption>Repository with connection: ${repository.url}</caption>
		<thead>
			<tr>
				<th scope="col">Mapping for</th>
				<th scope="col">Value</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Type</td>
				<td>${repository.type}</td>
			</tr>
			<tr>
				<td>GetType</td>
				<td>${repository.mapGetType}</td>
			</tr>
			<tr>
				<td>GetPropertyValue</td>
				<td>${repository.mapGetPropertyValue}</td>
			</tr>
			<tr>
				<td>GetRelated</td>
				<td>${repository.mapGetRelated}</td>
			</tr>
			<tr>
				<td>GetElement</td>
				<td>${repository.mapGetElement}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>