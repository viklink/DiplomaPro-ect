<%@ attribute name="coll" type="java.util.Collection" required="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="order-table">

	<table>
		<c:forEach items="${tours}" var="tour">
			<tr>
				<td>${tour.name}</td>
				<td>${tour.price}</td>
				<td>${tour.description}</td>
				<c:if test="${loggedInUser.role == 'guest' }">
				<td><input type="text" name="date" placeholder="YYYY-MM-DD" /></td>
				<td><input type="text" name="personNum" placeholder="Number of persons" /></td>
					<form action="saveOrder"  method="POST">
				<td><button type="submit" name="save" value="${tour.id}">save</button></td>
				</form>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</div>
