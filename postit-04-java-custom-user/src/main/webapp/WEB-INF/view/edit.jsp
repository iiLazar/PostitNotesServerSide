<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
<script defer
		src="${pageContext.request.contextPath}/resources/js/script.js"></script>
<title>Post-its</title>
</head>


<body>

<h1>Post-its</h1>
<div class="cont" id="left">
    <fieldset>
        <legend>Post-it</legend>
        Enter note content
        	<form:form action="saveNote" modelAttribute="note"
			method="POST">
				<form:hidden path="id" />
				<form:textarea path="content" id="text" style="background-color: #ffffcc;"/>
				<input type="submit" id="createBtn" value="Click to save changes" />
			</form:form>
    </fieldset>
    
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" class="logBtn" />
	</form:form>
</div>
    
<div class="cont" id="right">
    <div id="notes">
		<core:forEach var="currentNote" items="${notes}">
			<div class="note">
    			<button class="edit" onclick="window.location.href='edit?noteId=${currentNote.id}'; return false;"
    					title="Edit this note">edit</button>
    			<button class="delete" onclick=
    			"if (confirm('Are you sure you want to DELETE this note?')) {window.location.href='delete?noteId=${currentNote.id}';} else {return false;}"
    					title="Delete this note">×</button>
    			<span id="tudu">${currentNote.content}</span>
    		</div>
		</core:forEach>
    
    </div>
</div>
    
<div class="cont" id="contDel">
    <button id="delBtn" onclick="modalDel()">Click to delete all notes</button>
</div>
<div class="modal" id="modal">
    <div class="modalCont">
        <span class="close" style="display: none">&times;</span>
        <p class="modalTxt">Are you sure you want to delete ALL notes?</p>
        <div class="yesNo">
            <button id="yes" onclick="deleteAll()">Yes, delete all notes</button>
            <button id="no" onclick="hideElement('modal')">No, no, no, no, no...!</button>
        </div>
    </div>
</div>


</body>
</html>