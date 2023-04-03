<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.min.js" integrity="sha384-heAjqF+bCxXpCWLa6Zhcp4fu20XoNIA98ecBC1YkdXhszjoejr5y9Q77hIrv8R9i" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Participated Events</title>
</head>
<body>
<c:if test="${not empty participatedEvents or not empty expiredEvents}">
<div class="container-fluid">
<table class="table table-hover text-center">
<tr>
<th>Name</th>
<th>Description</th>
<th>Status</th>
</tr>
<c:forEach items="${participatedEvents}" var="e">
 <tr>
 <td>${e.eventName} </td>
 <td>${e.eventDescription}</td>
 <td>upcoming Event</td>
 <td><a href="cancelParticipation/${e.eId}">cancel participation</a></td>
 </tr>
</c:forEach>
<c:forEach items="${expiredEvents}" var="e">
 <tr>
 <td>${e.eventName}</td>
 <td>${e.eventDescription}</td>
 <td style="color:green;">event participated successfully</td>
 </tr>
</c:forEach>
</table>
 </div>
 </c:if>
 <c:if test="${empty participatedEvents and empty expiredEvents}">
 <h4 style="color:red;text-align:center;"><br/>no participated events, participate now<br/></h4>
 </c:if>
</body>
</html>