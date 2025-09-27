<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<div class="container mt-5">
    <h2 class="mb-4 text-center">User Profile</h2>
    <div class="col-md-8 mx-auto">
        <!-- Profile Info -->
        <div id="profileView" class="card p-4 mb-3 shadow-sm">
            <c:if test="${not empty user.avatar}">
                <div class="text-center mb-4">
                    <img src="${pageContext.request.contextPath}/uploads/${user.avatar}" 
                         width="300" height="300" class="rounded-circle shadow-sm" alt="Avatar">
                </div>
            </c:if>

            <div class="row text-center">
                <div class="col-md-6 mb-3"><strong>Username:</strong> ${user.userName}</div>
                <div class="col-md-6 mb-3"><strong>Full Name:</strong> ${user.fullName}</div>
                <div class="col-md-6 mb-3"><strong>Email:</strong> ${user.email}</div>
                <div class="col-md-6 mb-3"><strong>Phone:</strong> ${user.phone}</div>
            </div>

            <div class="text-center">
                <button class="btn btn-primary" onclick="showForm()">Edit Profile</button>
            </div>
        </div>

        <!-- Edit Form -->
        <div id="profileForm" class="card p-4 mb-3 shadow-sm" style="display: none;">
            <div class="text-center mb-4">
                <c:if test="${not empty user.avatar}">
                    <img src="${pageContext.request.contextPath}/uploads/${user.avatar}" 
                         width="200" height="200" class="rounded-circle shadow-sm mb-3" alt="Avatar">
                </c:if>
            </div>

            <form action="${pageContext.request.contextPath}/user/profile" method="post" enctype="multipart/form-data">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="username" class="form-label fw-bold">Username</label>
                        <input type="text" class="form-control rounded shadow-sm" id="username" name="username"
                               value="${user.userName}" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="email" class="form-label fw-bold">Email</label>
                        <input type="email" class="form-control rounded shadow-sm" id="email" name="email"
                               value="${user.email}" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="fullname" class="form-label fw-bold">Full Name</label>
                        <input type="text" class="form-control rounded shadow-sm" id="fullname" name="fullname"
                               value="${user.fullName}" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="phone" class="form-label fw-bold">Phone</label>
                        <input type="text" class="form-control rounded shadow-sm" id="phone" name="phone"
                               value="${user.phone}" required>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="avatar" class="form-label fw-bold">Avatar</label>
                    <input type="file" class="form-control rounded shadow-sm" id="avatar" name="avatar" accept="image/*">
                </div>

                <div class="d-flex justify-content-between">
                    <button type="submit" class="btn btn-success fw-bold">Save</button>
                    <button type="button" class="btn btn-secondary fw-bold" onclick="hideForm()">Cancel</button>
                </div>
            </form>
        </div>

    </div>
</div>

<script>
function showForm() {
    document.getElementById("profileView").style.display = "none";
    document.getElementById("profileForm").style.display = "block";
}
function hideForm() {
    document.getElementById("profileForm").style.display = "none";
    document.getElementById("profileView").style.display = "block";
}
</script>