/*
 * Created on Feb 15, 2005
 */
package org.emayor.servicehandling.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.emayor.servicehandling.interfaces.AccessManagerLocal;
import org.emayor.servicehandling.kernel.AccessException;
import org.emayor.servicehandling.kernel.ServicesInfo;
import org.emayor.servicehandling.utclient.ServiceLocator;
import org.emayor.servicehandling.utils.ServiceLocatorException;

/**
 * @author tku
 */
public class WelcomeProcessor {
	private static Logger log = Logger.getLogger(WelcomeProcessor.class);

	/**
	 *  
	 */
	public WelcomeProcessor() {
		super();
	}

	public void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		log.debug("-> start processing ...");
		HttpSession session = req.getSession();
//		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
//		out.println("<html><head><title>After welcome!</title></head>");
//		out.println("<body>");
		try {
			ServiceLocator serviceLocator = ServiceLocator.getInstance();
			AccessManagerLocal access = serviceLocator.getAccessManager();
			String asid = access.createAccessSession();
			session.setAttribute("ASID", asid);
			if (log.isDebugEnabled())
				log.debug("got following asid=" + asid);
			ServicesInfo servicesInfo = access.listAvailableServices("-1001");
			session.setAttribute("SERVICES_INFO", servicesInfo.getServicesInfo());
//			out.println("current access session id = ");
//			out.println("<br/>");
//			out.println("<h1>");
//			out.println("List of the available services:");
//			out.println("</h1><br/>");
//			out.println("");
//			ServiceInfo[] infoArray = servicesInfo.getServicesInfo();
//			for (int i = 0; i < infoArray.length; i++) {
//				
//			}
		}
		catch(ServiceLocatorException ex) {
			log.error("caught ex: " + ex.toString());
			// TODO hadle exception
		}
		catch(AccessException aex) {
			log.error("caught ex: " + aex.toString());
			// TODO handle ex
		}
		
//		out
//				.println("<a href=\"ServiceHandlingTest?action=welcome1\">test it again</a>");
//		out.println("</body>");
//		out.println("</html>");
//		out.close();
		log.debug("-> ... processing DONE!");
	}

}