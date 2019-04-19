<%@tag description="Default Main Layout Tag" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@attribute name="title" required="true" %>
<%@attribute name="style"%>
<%@attribute name="style2"%>
<%@attribute name="script"%>


<!DOCTYPE html>
<html lang="en">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>
        <c:if test="${not empty title}">
            ${title}
        </c:if>
    </title>

    <link rel="stylesheet" href="<c:url value="/assets/style/JSPStyle/baseStyle.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/style/JSPStyle/indexStyle.css"/>">
    <link rel="stylesheet" href= ${style}>
    <link rel="stylesheet" href= ${style2}>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

    <link href="https://fonts.googleapis.com/css?family=Rubik|Vollkorn" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css?family=Francois+One" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">


    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

    <script src="${script}"></script>
</head>

<body>
    <jsp:include page="/WEB-INF/templates/navbar.jsp"/>
    <jsp:doBody/>
    <jsp:include page="/WEB-INF/templates/footer.jsp"/>
</body>
</html>