<%@ page language="Java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/sslext.tld" prefix="sslext"%>
<sslext:pageScheme secure="true" />

<%@ taglib uri="/WEB-INF/emayor-bean.tld" prefix="emayorbean" %>
<%--  The class TextResourceKeys only holds [static] class attributes, no instance attributes.
      so automatic instantiation here doesn't hurt.  --%>
<jsp:useBean id="TextResourceKeys" class="org.emayor.eMayorWebTier.Utilities.TextResourceKeys" />	


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
	<title>eMayorRequestAcknowledgement</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>


<%--  Note: This JSP fills in 5 different partitions (0..4) which
            are created from the template.htm file.
            See the instructions in this template.htm file.
            The processing logic in the sources is located in
            org.emayor.webtier.shared.HTMLTemplate and
            org.emayor.webtier.shared.ExtendedActionForm  äöü --%>	


<bean:write name="serviceForm" property="partition0" filter="false"/>



<%--  ..................... JSP LOGIC START .....................  --%>	
<%--  The following are table rows associated with the available languages --%>
<%--  Placeholder row, so next row is at the bottom: --%>
<%--  colspan = number of available languages:       --%>
                <tr>
                  <td colspan="<bean:write name="serviceForm" property="numberOfLanguages" />" rowspan="1">&nbsp;</td>
                </tr>
                <tr>

<logic:equal name="serviceForm" property="language" value="ger">
<td style="text-align: center; background-color: rgb(201, 60, 56);">&nbsp;<span
 style="color: rgb(255, 255, 255);"><emayorbean:writeLanguage name="serviceForm" resourceElementKey="<%=TextResourceKeys.ShortCutGerman%>" /></span>&nbsp;</td>
</logic:equal>
<logic:notEqual name="serviceForm" property="language" value="ger">
                  <td style="text-align: center;">&nbsp;
                      <sslext:link action="service.do?language=ger&do=executeService" 
					               name="serviceForm" 
					               property="serviceParametersWithoutLanguage" ><emayorbean:writeLanguage name="serviceForm" resourceElementKey="<%=TextResourceKeys.ShortCutGerman%>"/></sslext:link>&nbsp;</td>
</logic:notEqual>

<logic:equal name="serviceForm" property="language" value="en">
<td style="text-align: center; background-color: rgb(201, 60, 56);">&nbsp;<span
 style="color: rgb(255, 255, 255);"><emayorbean:writeLanguage name="serviceForm" resourceElementKey="<%=TextResourceKeys.ShortCutEnglish%>" /></span>&nbsp;</td>
</logic:equal>
<logic:notEqual name="serviceForm" property="language" value="en">
                  <td style="text-align: center;">&nbsp;
                      <sslext:link action="service.do?language=en&do=executeService" 
					               name="serviceForm" 
					               property="serviceParametersWithoutLanguage" ><emayorbean:writeLanguage name="serviceForm" resourceElementKey="<%=TextResourceKeys.ShortCutEnglish%>"/></sslext:link>&nbsp;</td>
</logic:notEqual>

<logic:equal name="serviceForm" property="language" value="it">
<td style="text-align: center; background-color: rgb(201, 60, 56);">&nbsp;<span
 style="color: rgb(255, 255, 255);"><emayorbean:writeLanguage name="serviceForm" resourceElementKey="<%=TextResourceKeys.ShortCutItalian%>" /></span>&nbsp;</td>
</logic:equal>
<logic:notEqual name="serviceForm" property="language" value="it">
                  <td style="text-align: center;">&nbsp;
                      <sslext:link action="service.do?language=it&do=executeService" 
					               name="serviceForm" 
					               property="serviceParametersWithoutLanguage" ><emayorbean:writeLanguage name="serviceForm" resourceElementKey="<%=TextResourceKeys.ShortCutItalian%>"/></sslext:link>&nbsp;</td>
</logic:notEqual>

<logic:equal name="serviceForm" property="language" value="sp">
<td style="text-align: center; background-color: rgb(201, 60, 56);">&nbsp;<span
 style="color: rgb(255, 255, 255);"><emayorbean:writeLanguage name="serviceForm" resourceElementKey="<%=TextResourceKeys.ShortCutSpanish%>" /></span>&nbsp;</td>
</logic:equal>
<logic:notEqual name="serviceForm" property="language" value="sp">
                  <td style="text-align: center;">&nbsp;
                      <sslext:link action="service.do?language=sp&do=executeService" 
					               name="serviceForm" 
					               property="serviceParametersWithoutLanguage" ><emayorbean:writeLanguage name="serviceForm" resourceElementKey="<%=TextResourceKeys.ShortCutSpanish%>"/></sslext:link>&nbsp;</td>
</logic:notEqual>
</tr>
<%--  ..................... JSP LOGIC END .....................  --%>	



<bean:write name="serviceForm" property="partition1" filter="false"/>



<%--  ..................... JSP LOGIC START .....................  --%>	
<%-- Index page link: Use the global action forward: --%>
<tr><td>&nbsp;<html:link forward="municipalityList">
    Index
</html:link>&nbsp;</td>
<%-- name of municipality as link: --%>
<td>&nbsp;<html:link action="municipality.do?do=showIndex" 
                     paramName="serviceForm" 
                     paramProperty="municipalityNameKey" 
                     paramId="<%=TextResourceKeys.MunicipalityNameKeyTag%>">
   <bean:write name="serviceForm" property="nameOfMunicipality" />
</html:link>&nbsp;</td>
<td style="width: 50%;">&nbsp;<bean:write name="serviceForm" property="nameOfService" />&nbsp;</td>                
<%--  ..................... JSP LOGIC END .....................  --%>	
                  <td style="width: 40%;"></td>
                  <td style="text-align: center; background-color: rgb(240, 240, 220);">
 &nbsp;<html:link action="help.do?"
                  paramName="serviceForm" 
                  paramProperty="helpTopicKey"
                  paramId="helpTopicKey">
       <emayorbean:writeLanguage name="serviceForm" resourceElementKey="<%=TextResourceKeys.Help%>"/></html:link>&nbsp;</td>
</tr>


<bean:write name="serviceForm" property="partition2" filter="false"/>


<tr>
<td>
<%--  ..................... JSP LOGIC START .....................  --%>	
<%-- start with an iterate over the services --%>
<p>
<emayorbean:writeLanguage name="serviceForm" resourceElementKey="<%=TextResourceKeys.ServiceAcknowledgementInformation1%>"/>
<br>
<emayorbean:writeLanguage name="serviceForm" resourceElementKey="<%=TextResourceKeys.ServiceAcknowledgementInformation2%>"/>

    <p>
      <html:link action="municipality.do?do=logout" 
                 paramName="serviceForm" 
                 paramProperty="municipalityNameKey" 
                 paramId="municipalityNameKey"><emayorbean:writeLanguage name="serviceForm" resourceElementKey="<%=TextResourceKeys.Logout%>" /></html:link>
    </p>
      <html:link action="municipality.do?do=showIndex" 
                 paramName="serviceForm" 
                 paramProperty="municipalityNameKey" 
                 paramId="municipalityNameKey"><bean:write name="serviceForm" property="nameOfMunicipality" /></html:link>
    </p>

<%--  ..................... JSP LOGIC END .....................  --%>	
</td>
</tr>


<bean:write name="serviceForm" property="partition3" filter="false"/>


<emayorbean:writeLanguage name="serviceForm" resourceElementKey="<%=TextResourceKeys.AbouteMayor%>"/>


<bean:write name="serviceForm" property="partition4" filter="false"/>


</html>
