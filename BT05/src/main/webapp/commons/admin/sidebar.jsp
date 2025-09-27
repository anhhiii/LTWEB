<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<nav class="sidebar d-flex flex-column">
	<h4 class="mb-4">Dashboard</h4>

	<div class="text-center mb-4 user-info">
		<c:choose>
			<c:when test="${not empty sessionScope.account.avatar}">
				<img
					src="${pageContext.request.contextPath}/uploads/${sessionScope.account.avatar}"
					class="rounded-circle mb-2" width="100" height="100" alt="Avatar" />
			</c:when>
			<c:otherwise>
				<i class="bi bi-person-circle fs-1 mb-2"></i>
			</c:otherwise>
		</c:choose>
		<p class="mb-0 fw-bold">${sessionScope.account.fullName}</p>
		<small>${sessionScope.account.userName}</small>
	</div>


	<ul class="nav nav-pills flex-column mb-auto">
		<li class="nav-item mb-2"><a
			href="<c:url value='#' />" class="nav-link"> <i
				class="bi bi-people-fill"></i> Accounts
		</a></li>
		<li class="nav-item mb-2"><a
			href="<c:url value='/admin/category' />" class="nav-link"> <i
				class="bi bi-tags-fill"></i> Categories
		</a></li>
		<li class="nav-item mb-2"><a
			href="<c:url value='#' />" class="nav-link">
				<i class="bi bi-box-seam"></i> Products
		</a></li>
		<li class="nav-item mb-2"><a
			href="<c:url value='/admin/profile' />" class="nav-link"> <i
				class="bi bi-person-lines-fill"></i> Profile
		</a></li>
		<li class="nav-item mt-3"><a href="<c:url value='/logout' />"
			class="nav-link bg-danger"> <i class="bi bi-box-arrow-right"></i>
				Logout
		</a></li>
	</ul>
</nav>