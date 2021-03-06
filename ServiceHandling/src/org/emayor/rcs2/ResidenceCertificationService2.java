/*
 * $ Created on Jun 1, 2005 by tku $
 */
package org.emayor.rcs2;

import org.apache.log4j.Logger;
import org.emayor.servicehandling.kernel.AbstracteMayorService;
import org.emayor.servicehandling.kernel.IeMayorService;
import org.emayor.servicehandling.kernel.eMayorServiceException;

/**
 * @author <a href="mailto:Tomasz.Kusber@fokus.fraunhofer.de"> <font
 *         size="-1">Tomasz Kusber </font> </a> <font size="-1"> FHI FOKUS (C)
 *         </font>
 */
public class ResidenceCertificationService2 extends AbstracteMayorService {
	private final static Logger log = Logger
			.getLogger(ResidenceCertificationService2.class);

	public static final String DEF_XML_FILE = "SampleResidenceCertificationRequestDocument.xml";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.emayor.servicehandling.kernel.IeMayorService#startService(java.lang.String,
	 *      java.lang.String)
	 */
	public void startService(String uid, String ssid)
			throws eMayorServiceException {
		log.debug("-> start processing ...");
		this.startIt(IeMayorService.FORWARD_NO, uid, ssid, this
				.getXMLDocumentFromResource(DEF_XML_FILE), "<empty/>");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.emayor.servicehandling.kernel.IeMayorService#startService(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public void startService(String uid, String ssid, String requestDocument)
			throws eMayorServiceException {
		log.debug("-> start processing ...");
		this.startIt(IeMayorService.FORWARD_NO, uid, ssid, this
				.getXMLDocumentFromResource(DEF_XML_FILE), "<empty/>");
		log.debug("-> ... processing DONE!");
	}

}