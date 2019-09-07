<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="java.util.*"%>
<%@page import ="main.*"%>
<% ArrayList<Glossary_Item> al = (ArrayList<Glossary_Item>)request.getAttribute("rs");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<form action ="gloss" method ="Post">
<% for(Glossary_Item i : al) { %>
<%i.getWord(); %>
<% }%>
</form>
</body>

</html>