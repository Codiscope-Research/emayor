<%-- Caution: **ALL** must be on ONE line here. NO CR's, NO spaces. --%><%@ page language="Java" contentType="text/html; charset=UTF-8"%><%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%><%@ taglib uri="/WEB-INF/sslext.tld" prefix="sslext"%><sslext:pageScheme secure="true" /><%@ taglib uri="/WEB-INF/emayor-bean.tld" prefix="emayorbean" %><%-- Send the eMayorForm:  äöü --%><bean:write name="formTestForm" property="emayorform" filter="false"/>