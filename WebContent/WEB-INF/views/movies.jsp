<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Movie: ${movie}</p>
  	<table>
  	<c:forEach items="${movies}" var="movie" varStatus="status">
        <tr>
            <td align="center">${status.count}</td>
            <td><input name="movies[${status.index}].firstname" value="${movie.movieTitle}"/></td>
            <td><input name="movies[${status.index}].lastname" value="${movie.duration}"/></td>
            <td><input name="movies[${status.index}].email" value="${movie.description}"/></td>
        </tr>
   	</c:forEach>
	</table>

</body>
</html>