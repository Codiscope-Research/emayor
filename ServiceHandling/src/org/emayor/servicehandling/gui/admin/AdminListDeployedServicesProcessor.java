/*
 * Created on Jun 6, 2005
 */
package org.emayor.servicehandling.gui.admin;

import java.io.IOException;

import javax.ejb.EJBException;
import javax.ejb.RemoveException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.emayor.servicehandling.interfaces.AdminManagerLocal;
import org.emayor.servicehandling.kernel.AdminException;
import org.emayor.servicehandling.kernel.AdminServiceProfileData;
import org.emayor.servicehandling.utils.ServiceLocator;
import org.emayor.servicehandling.utils.ServiceLocatorException;

/**
 * @author tku
 */
public class AdminListDeployedServicesProcessor extends
		AbstractRequestProcessor {
	private final static Logger log = Logger
			.getLogger(AdminListDeployedServicesProcessor.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.emayor.servicehandling.gui.admin.IRequestProcessor#process(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public String process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		log.debug("-> start processing ...");
		String ret = "admin/FatalError.jsp";
		HttpSession session = req.getSession(false);
		if (session == null) {
			log.debug("no valid session !");
		} else {
			try {
				ServiceLocator locator = ServiceLocator.getInstance();
				AdminManagerLocal admin = locator.getAdminManagerLocal();
				AdminServiceProfileData[] data = admin.listDeployedServices();
				if (log.isDebugEnabled())
					log.debug("got " + data.length
							+ " service profiles from kernel");
				session.setAttribute("ADMIN_SERVICE_PROFILE_ARRAY", data);
				ret = "admin/ListOfDeployedServices.jsp";
				admin.remove();
			} catch (ServiceLocatorException ex) {
				log.error("caught ex: " + ex.toString());
				AdminErrorPageData data = new AdminErrorPageData();
				data
						.setPageTitle("Couldn't connect to the admin interface on the platfom.");
				session.setAttribute(AdminErrorPageData.ATT_NAME, data);
				ret = "admin/ErrorPage.jsp";
			} catch (AdminException ex) {
				log.error("caught ex: " + ex.toString());
				AdminErrorPageData data = new AdminErrorPageData();
				data.setPageTitle("Couldn't list the deployed service.");
				session.setAttribute(AdminErrorPageData.ATT_NAME, data);
				ret = "admin/ErrorPage.jsp";
			} catch (EJBException ex) {
				log.error("caught ex: " + ex.toString());
				AdminErrorPageData data = new AdminErrorPageData();
				data.setPageTitle("Internal Error!");
				data.setMessage("This was an fatal internal error!");
				session.setAttribute(AdminErrorPageData.ATT_NAME, data);
				ret = "admin/ErrorPage.jsp";
			} catch (RemoveException ex) {
				log.error("caught ex: " + ex.toString());
				AdminErrorPageData data = new AdminErrorPageData();
				data.setPageTitle("Internal Error!");
				data.setMessage("This was an fatal internal error!");
				session.setAttribute(AdminErrorPageData.ATT_NAME, data);
				ret = "admin/ErrorPage.jsp";
			}
		}
		return ret;
	}

}