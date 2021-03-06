<%@ page language="Java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/sslext.tld" prefix="sslext"%>
<sslext:pageScheme secure="false" />


<%@ taglib uri="/WEB-INF/emayor-bean.tld" prefix="emayorbean" %>
<%--  The class TextResourceKeys only holds [static] class attributes, no instance attributes.
      so automatic instantiation here doesn't hurt.  --%>
<jsp:useBean id="TextResourceKeys" class="org.emayor.webtier.shared.TextResourceKeys" />	


<%-- This page has no form access --%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<title>eMayor error page</title>
</head>


<%--  Note: This JSP fills in 5 different partitions (0..4) which
            are created from the template.htm file.
            See the instructions in this template.htm file.
            The processing logic in the sources is located in
            org.emayor.webtier.shared.HTMLTemplate and
            org.emayor.webtier.shared.ExtendedActionForm  äöü --%>	



<bean:write name="errorPageForm" property="partition0" filter="false"/>


                <tr>
                  <td colspan="4" rowspan="1">&nbsp;</td>
                </tr>


<bean:write name="errorPageForm" property="partition1" filter="false"/>



<%--  ..................... JSP LOGIC START .....................  --%>	
<%-- Index page link: Use the global action forward: --%>
<tr><td>&nbsp;<html:link forward="municipalityList">
    Index
</html:link>&nbsp;</td>
<td style="width: 50%;">Error Page</td>
<%--  ..................... JSP LOGIC END .....................  --%>	
                  <td style="width: 40%;"></td>
                  <td
 style="text-align: center; background-color: rgb(240, 240, 220);">
 &nbsp;<a href="help/help.htm">Help</a>&nbsp;</td>
                </tr>


<bean:write name="errorPageForm" property="partition2" filter="false"/>


<tr>
<td style="background-color: rgb(255, 206, 192); margin-left: 36px; margin-right: 36px;">
<%--  ..................... JSP LOGIC START .....................  --%>	
<%-- Show the repository entries --%>
<br>
&nbsp;
<br>
An error has occured.
<p>
<bean:write name="errorPageForm" property="errorDescription"  filter="false"/>
<br>
&nbsp;
<p>
<%--  ..................... JSP LOGIC END .....................  --%>
            </td>
          </tr>


<bean:write name="errorPageForm" property="partition3" filter="false"/>


<emayorbean:writeLanguage name="errorPageForm" resourceElementKey="<%=TextResourceKeys.AbouteMayor%>"/>


<bean:write name="errorPageForm" property="partition4" filter="false"/>


</html>
