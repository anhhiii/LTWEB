<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="text-center">
    <h1 class="mb-3 text-primary">Chào mừng đến với TruyenHay</h1>
    <c:choose>
        <c:when test="${not empty sessionScope.account}">
            <p class="lead">Rất vui được gặp bạn, 
                <strong>${sessionScope.account.username}</strong> 🎉</p>
        </c:when>
        <c:otherwise>
            <p class="text-muted">Vui lòng đăng nhập hoặc đăng ký để trải nghiệm đầy đủ tính năng.</p>
        </c:otherwise>
    </c:choose>
</div>
