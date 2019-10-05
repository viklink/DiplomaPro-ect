<%@ attribute name="coll" type="java.util.Collection" required="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<div class="tour-table">
	<c:if test="${myTours != null}">
		<table>
			<c:forEach items="${myTours}" var="tour">
				<tr>
					<td>${tour.name}</td>
					<td><fmt:formatNumber value="${tour.price}" type="currency"
							currencyCode="USD" /></td>
					<td>${tour.description}</td>
					
				</tr>
			</c:forEach>
		</table>
		</c:if>
	</div>
	
	