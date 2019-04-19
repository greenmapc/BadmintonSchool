<#macro header title script="">
    <!DOCTYPE html>
    <html lang="en" xmlns="http://java.sun.com/jsf/facelets">
    <head>
        <meta charset="UTF-8">

        <title> ${title} </title>

        <link rel="stylesheet" href="${context.getContextPath()}/assets/style/style.css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

        <link href="https://fonts.googleapis.com/css?family=Rubik|Vollkorn" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Francois+One" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

        <#if script != "">
            <script src="${context.getContextPath()}/assets/script/${script}.js"></script>
        </#if>
    </head>
    <body>
        <#include "navbar.ftl">
            <#nested>
        <#include "footer.ftl">
    </body>
    </html>
</#macro>