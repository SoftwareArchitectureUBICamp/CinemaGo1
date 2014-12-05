<?xml version="1.0" encoding="UTF-8"?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns:c="http://java.sun.com/jsp/jstl/core"
xmlns:fmt="http://java.sun.com/jsp/jstl/fmt"
xmlns="http://www.w3.org/1999/xhtml"
version="2.0">
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>

<![CDATA[<!DOCTYPE html>]]>
<html lang="en">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
        <title>Neopay Init-Antwort</title>
        <link rel="stylesheet" type="text/css" href="http://www.blueprintcss.org/blueprint/src/typography.css"/>
        <link rel="stylesheet" type="text/css" href="http://www.blueprintcss.org/blueprint/src/forms.css"/>
        <link rel="stylesheet" type="text/css" href="http://www.blueprintcss.org/blueprint/src/grid.css"/>
    </head>

    <body>
        <div>${head}</div>
        <div class="container">
			<h1>Hello : ${name}</h1>
			<a href="/next">Kitas</a>
			<a href="/form.html">Kitas</a>
        </div>

    </body>
</html>

</jsp:root>