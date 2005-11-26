<%@ page language="Java" contentType="text/html; charset=UTF-8"%>
<%@page import="test.ssl.*" %>
<%@ taglib uri="/WEB-INF/sslext.tld" prefix="sslext"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<sslext:pageScheme secure="true" />

<!-- äöü -->

<html>
<head>
</head>

<body>
<font size="+4"><center><%=request.getRequestURI()%></center></font>
<br>
<jsp:include page="subtop.html"/>
<br>
We are on the truetag page. The non-secure (non-SSL) action "truetag" forwards to this page.  This is a secure (SSL) page.
<br>
<br>
Request attribute is :
<bean:write name="nullString" />
<br>
<br>
Go to the <sslext:link action="/false" module="">main module's false action</sslext:link>
<br>
Go to the <sslext:link action="/true" module="">main module's true action</sslext:link>
<br>
Go to the <sslext:link action="/any" module="">main module's any action</sslext:link>
<br>
<br>

Try the <sslext:link page="/false.do" >false</sslext:link> page.
<br>
Try the <sslext:link page="/true.do" >true</sslext:link> page.
<br>
Try the <sslext:link page="/any.do" >any</sslext:link> page.
<br>
Try the <sslext:link page="/falsetag.do" >falsetag</sslext:link> page.
<br>
Try the <sslext:link page="/anytag.do" >anytag</sslext:link> page.
<br>
<br>
Go to <sslext:link page="/formAction.do">form</sslext:link> test page.
</body>
</html>