<%@ attribute name="coll" type="java.util.Collection" required="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="tour-table">

	<table>
		<c:forEach items="${coll}" var="tour">
			<tr>
			<td>${tour.id}</td>
				<td>${tour.name}</td>
				<td>${tour.description}</td>
				<c:if test="${loggedInUser.roleId == 2 }">
					<td>
						<form action="updateTour" method="POST">
						<p><input type="text" name="id" placeholder="Tour id"/>
							<input type="text" name="name" placeholder="Tour name"/>
			                <input type="text" name="price" placeholder="Tour price"/>
			                <input type="text" name="description" placeholder="Tour description"/>
			                <input type="submit" value="Send" /></p>
						</form>
					</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</div>
