/*
 * $ Created on Mar 15, 2005 by tku $
 */
package org.emayor.servicehandling.test;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.apache.xpath.XPathAPI;
import org.emayor.servicehandling.kernel.Task;
import org.emayor.servicehandling.utclient.CVDocumentTypes;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * @author <a href="mailto:Tomasz.Kusber@fokus.fraunhofer.de"> <font
 *         size="-1">Tomasz Kusber </font> </a> <font size="-1"> FHI FOKUS (C)
 *         </font>
 */
public class CVDisplayTaskProcessor extends AbstractProcessor {
    private static final Logger log = Logger
            .getLogger(CVDisplayTaskProcessor.class);

    /*
     * (non-Javadoc)
     * 
     * @see org.emayor.servicehandling.test.IProcessor#process(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public String process(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        log.debug("-> start processing ...");
        String ret = "Error.jsp";
        try {
            HttpSession session = req.getSession(false);
            String taskId = req.getParameter("taskId");
            String taskIndex = req.getParameter("taskIndex");
            Task[] tasks = (Task[]) session.getAttribute("MY_TASKS");
            int index = Integer.parseInt(taskIndex);
            Task task = tasks[index];
            if (task.getTaskId().equals(taskId)) {
                log.debug("the task id is OK");
                String xmldoc = task.getXMLDocument();
                if (log.isDebugEnabled())
                    log.debug("got xml: \n" + xmldoc);
                DocumentBuilderFactory factory = DocumentBuilderFactory
                        .newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                StringReader reader = new StringReader(xmldoc);
                InputSource inputSource = new InputSource(reader);
                Document root = builder.parse(inputSource);
                if (root != null)
                    log.debug("root: " + root.toString());

                if (task.getTaskType() == CVDocumentTypes.CV_RESIDENCE_CERTIFICATE_REQUEST) {
                    log
                            .debug("this is a residance certification request document");
                    String reqForename = XPathAPI
                            .selectSingleNode(
                                    root,
                                    "/ResidenceCertificationRequestDocument/RequesterDetails/CitizenName/CitizenNameForename/text()")
                            .getNodeValue();
                    String reqSurname = XPathAPI
                            .selectSingleNode(
                                    root,
                                    "/ResidenceCertificationRequestDocument/RequesterDetails/CitizenName/CitizenNameSurname/text()")
                            .getNodeValue();
                    String reqEmail = XPathAPI
                            .selectSingleNode(
                                    root,
                                    "/ResidenceCertificationRequestDocument/RequesterDetails/ContactDetails/Email/EmailAddress/text()")
                            .getNodeValue();

                    session.setAttribute("CURR_TASK", task);
                    session.setAttribute("REQ_FORENAME", reqForename);
                    session.setAttribute("REQ_SURNAME", reqSurname);
                    session.setAttribute("REQ_EMAIL", reqEmail);
                    ret = "CVDisplayRCRequest.jsp";
                } else if (task.getTaskType() == CVDocumentTypes.CV_RESIDENCE_DOCUMENT) {
                    log.debug("this is a residance certification document");
                    /*String forename = XPathAPI
                            .selectSingleNode(
                                    root,
                                    "/ResidenceCertificationDocument/CertifiedConcernedPersons/CitizenDetails/CitizenName/CitizenNameForename/text()")
                            .getNodeValue();
                    String surname = XPathAPI
                            .selectSingleNode(
                                    root,
                                    "/ResidenceCertificationDocument/CertifiedConcernedPersons/CitizenDetails/ContactDetails/Email/EmailAddress/text()")
                            .getNodeValue();
                    String email = XPathAPI
                            .selectSingleNode(
                                    root,
                                    "/ResidenceCertificationDocument/CertifiedConcernedPersons/CitizenDetails/CitizenName/CitizenNameSurname/text()")
                            .getNodeValue();
                    session.setAttribute("FORENAME", forename);
                    session.setAttribute("SURNAME", surname);
                    session.setAttribute("EMAIL", email);*/

                    
                    //TransformerFactory tFactory = TransformerFactory.newInstance();
                    //Transformer transformer = tFactory.newTransformer();
                    //transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                    //transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
                    //transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
                    //transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    //transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                    
                    // create output writer
                    //StringWriter writer = new StringWriter();

                    // do transform
                    //transformer.transform(new StreamSource(xmldoc), new StreamResult(writer));
                    
                    //String xmldocAsHTML = writer.toString();
                    
      		      DOMImplementation impl = builder.getDOMImplementation();
					Document doc = builder.parse(new InputSource(
							new StringReader(xmldoc)));

					// Serialize the document
					OutputFormat format = new OutputFormat(doc);
					format.setLineWidth(65);
					format.setIndenting(true);
					format.setIndent(2);
					StringWriter writer = new StringWriter();
					XMLSerializer serializer = new XMLSerializer(writer, format);
					serializer.serialize(doc);

					String xmldocAsHTML = writer.toString();

					xmldocAsHTML = xmldocAsHTML.replaceAll("<", "&lt;");
					xmldocAsHTML = xmldocAsHTML.replaceAll(">", "&gt;");
					//xmldocAsHTML =
					// xmldocAsHTML.replaceAll("&lt;/","<br>&lt;/");
					//xmldocAsHTML =
					// xmldocAsHTML.replaceAll("&gt;","&gt;<br>");
					xmldocAsHTML = xmldocAsHTML.replaceAll("\"", "&quot;");

					session.setAttribute("CURR_TASK", task);
					session.setAttribute("RCD", xmldocAsHTML);
                    ret = "CVDisplayRCDocument.jsp";
                } else if (task.getTaskType() == CVDocumentTypes.CV_USER_REGISTRATION_REQUEST) {
                    log.debug("this is a user registration request");
                    String forename = XPathAPI
                            .selectSingleNode(
                                    root,
									"/UserProfile/CitizenDetails/CitizenName/CitizenNameForename/text()")
                            .getNodeValue();
                    String surname = XPathAPI
                            .selectSingleNode(
                                    root,
									"/UserProfile/CitizenDetails/CitizenName/CitizenNameSurname/text()")
                            .getNodeValue();
                    String email = XPathAPI
                            .selectSingleNode(
                                    root,
                                    "/UserProfile/CitizenDetails/ContactDetails/Email/EmailAddress/text()")
                            .getNodeValue();
                    String title = XPathAPI
                    .selectSingleNode(
                            root,
                            "/UserProfile/CitizenDetails/CitizenName/CitizenNameTitle/text()")
                    .getNodeValue();
                    String sex = XPathAPI
                    .selectSingleNode(
                            root,
                            "/UserProfile/CitizenDetails/CitizenSex/text()")
                    .getNodeValue();
                    String lang = XPathAPI
                    .selectSingleNode(
                            root,
                            "/UserProfile/CitizenDetails/PreferredLanguages/text()")
                    .getNodeValue();
                    
                    session.setAttribute("CURR_TASK", task);
                    session.setAttribute("REQ_FORENAME", forename);
                    session.setAttribute("REQ_SURNAME", surname);
                    session.setAttribute("REQ_EMAIL", email);
                    session.setAttribute("REQ_TITLE", title);
                    session.setAttribute("REQ_LANG", lang);
                    session.setAttribute("REQ_SEX", sex);
                    
                    ret = "CVDisplayURRequest.jsp";
                } else if (task.getTaskType() == CVDocumentTypes.CV_NEGATIVE_RESIDENCE_CERTIFICATE_DOCUMENT) {
                  
                	log.debug("this is a NEGATIVE residance certification document");
                    
					session.setAttribute("CURR_TASK", task);
					
                    ret = "CVDisplayRCNegativeDocument.jsp";                    
                } else {
                    log.debug("unknown document type");
                    session.setAttribute("ERR_MSG", "Unknown document type");
                    ret = "Error.jsp";
                }
            } else {
                log.debug("the task id was wrong !!!!!");
                session.setAttribute("ERR_MSG", "The task id is not valid!");
                ret = "Error.jsp";
            }
        } catch (ParserConfigurationException pcex) {
            log.error("caught ex: " + pcex.toString());
        } catch (SAXException saxex) {
            log.error("caught ex: " + saxex.toString());
        } catch (TransformerException tex) {
            log.error("caught ex: " + tex.toString());
        }
        log.debug("-> ... processing DONE!");
        return ret;
    }
}