<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Repository for user - Mediator WS</title>
</head>
<body>

    <section class="registerform cf">
        <form name="repository" action="<c:url value="/repositories" />" method="post" accept-charset="utf-8">
	        <ul>
	            <li>
                    <label for="repository.type">Type</label>
                    <select>
                        <option value="jdbc">JDBC</option>
                        <option value="rest">RESTful</option>
                    </select>
                </li>
                <li>
                    <label for="repository.url">Connection (or URL)</label>
                    <input size="65" type="text" name="repository.url" placeholder="jdbc:mysql://localhost/test" required>
                </li>
                <li>
                    <label for="repository.mapGetType">Mapping for GetType</label>
                    <textarea rows="3" cols="65" name="repository.mapGetType"></textarea>
                </li>
                <li>
                    <label for="repository.mapGetPropertyValue">Mapping for GetPropertyValue</label>
                    <textarea rows="3" cols="65" name="repository.mapGetPropertyValue"></textarea>
                </li>
                <li>
                    <label for="repository.mapGetRelated">Mapping for GetRelated</label>
                    <textarea rows="3" cols="65" name="repository.mapGetRelated"></textarea>
                </li>
                <li>
                    <label for="repository.mapGetElement">Mapping for GetElement</label>
                    <textarea rows="3" cols="65" name="repository.mapGetElement"></textarea>
                </li>
                <li>
                    <label for="repository.mapBuildElement">Mapping for BuildElement</label>
                    <textarea rows="3" cols="65" name="repository.mapBuildElement"></textarea>
                </li>
			    <li><input type="submit" value="Register"></li>
		     </ul>
        </form>
    </section>

    <section class="repositorylist">
	<c:forEach varStatus="repositoryStatus" var="repository" items="${repositories}">
	   <table>
	       <caption>Repository with connection: ${repository.url}</caption>
            <thead>
                <tr><th scope="col">Mapping for</th><th scope="col">Value</th></tr>
            </thead>
            <tbody>
                <tr><td>Type</td><td>${repository.type}</td></tr>
                <tr><td>GetType</td><td>${repository.mapGetType}</td></tr>
                <tr><td>GetPropertyValue</td><td>${repository.mapGetPropertyValue}</td></tr>
                <tr><td>GetRelated</td><td>${repository.mapGetRelated}</td></tr>
                <tr><td>GetElement</td><td>${repository.mapGetElement}</td></tr>
                <tr><td colspan="2">
                    <form name="delrep" action="<c:url value="/repositories/${repository.id}" />" method="post" accept-charset="utf-8">
                        <button class="link" name="_method" value="DELETE">Remove</button>
                    </form>
                </td></tr>
            </tbody>
        </table>
	</c:forEach>
    </section>
    
</body>
</html>