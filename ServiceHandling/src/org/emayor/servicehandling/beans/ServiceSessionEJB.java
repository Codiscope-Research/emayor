/*
 * Created on Feb 14, 2005
 */
package org.emayor.servicehandling.beans;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import org.apache.log4j.Logger;
import org.emayor.servicehandling.interfaces.KernelLocal;
import org.emayor.servicehandling.interfaces.ServiceSessionBeanEntityLocal;
import org.emayor.servicehandling.interfaces.ServiceSessionBeanEntityLocalHome;
import org.emayor.servicehandling.interfaces.SimpleIdGeneratorLocal;
import org.emayor.servicehandling.kernel.IServiceSession;
import org.emayor.servicehandling.kernel.IeMayorService;
import org.emayor.servicehandling.kernel.KernelException;
import org.emayor.servicehandling.kernel.ServiceSessionException;
import org.emayor.servicehandling.kernel.SessionException;
import org.emayor.servicehandling.kernel.eMayorServiceException;
import org.emayor.servicehandling.utils.ServiceLocator;
import org.emayor.servicehandling.utils.ServiceLocatorException;

/**
 * @ejb.bean name="ServiceSession" display-name="ServiceSessionEJB"
 *           description="Description for ServiceSession"
 *           jndi-name="ejb/emayor/sh/ServiceSession" type="Stateful"
 *           view-type="local"
 */
public class ServiceSessionEJB implements SessionBean, IServiceSession {
	private static Logger log = Logger.getLogger(ServiceSessionEJB.class);

	private ServiceSessionBeanEntityLocal serviceSessionData;

	//private String asid;

	//private String ssid;

	//private String serviceId;

	private SessionContext ctx;

	private IeMayorService eMayorService;

	//private Date startDate;

	/**
	 *  
	 */
	public ServiceSessionEJB() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
	 */
	public void setSessionContext(SessionContext ctx) throws EJBException,
			RemoteException {
		log.debug("-> start processing ...");
		this.ctx = ctx;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ejb.SessionBean#ejbRemove()
	 */
	public void ejbRemove() throws EJBException, RemoteException {
		log.debug("-> start processing ...");
		try {
			this.serviceSessionData.remove();
		} catch (RemoveException ex) {
			log.error("caught ex: " + ex.toString());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ejb.SessionBean#ejbActivate()
	 */
	public void ejbActivate() throws EJBException, RemoteException {
		log.debug("-> start processing ...");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ejb.SessionBean#ejbPassivate()
	 */
	public void ejbPassivate() throws EJBException, RemoteException {
		log.debug("-> start processing ...");
	}

	/**
	 * Business Method
	 * 
	 * @ejb.interface-method view-type = "local"
	 *  
	 */
	public String getAccessSessionId() throws ServiceSessionException {
		log.debug("getting asid ...");
		return this.serviceSessionData.getAsid();
	}

	/**
	 * Business Method
	 * 
	 * @ejb.interface-method view-type = "local"
	 *  
	 */
	public void setAccessSessionId(String asid) throws ServiceSessionException {
		if (log.isDebugEnabled())
			log.debug("setting asid to " + asid);
		this.serviceSessionData.setAsid(asid);
	}

	/**
	 * Business Method
	 * 
	 * @ejb.interface-method view-type = "local"
	 *  
	 */
	public String getServiceId() throws ServiceSessionException {
		log.debug("getting service name");
		return this.serviceSessionData.getServiceId();
	}

	/**
	 * Business Method
	 * 
	 * @ejb.interface-method view-type = "local"
	 *  
	 */
	public void setServiceId(String serviceId) throws ServiceSessionException {
		log.debug("getting service id");
		this.serviceSessionData.setServiceId(serviceId);
	}

	/**
	 * Business Method
	 * 
	 * @ejb.interface-method view-type = "local"
	 *  
	 */
	public void stopService(String reason) throws ServiceSessionException {
		log.debug("-> start processing ...");
		throw new ServiceSessionException("NOT IMPLEMENTED !!!");
	}

	/**
	 * Business Method
	 * 
	 * @ejb.interface-method view-type = "local"
	 *  
	 */
	public String getSessionId() throws SessionException {
		log.debug("-> start processing ...");
		return this.serviceSessionData.getSsid();
	}

	/**
	 * Default create method
	 * 
	 * @throws CreateException
	 * @ejb.create-method
	 */
	public void ejbCreate(String asid) throws CreateException {
		log.debug("-> start processing ...");
		if (asid == null || asid.length() == 0)
			throw new CreateException("the given asid has to be a valid value!");
		try {
			ServiceLocator serviceLocator = ServiceLocator.getInstance();
			SimpleIdGeneratorLocal simpleIdGeneratorLocal = serviceLocator
					.getSimpleIdGeneratorLocal();
			String ssid = simpleIdGeneratorLocal.generateId();
			simpleIdGeneratorLocal.remove();
			if (log.isDebugEnabled())
				log.debug("generated following ssid : " + ssid);
			ServiceSessionBeanEntityLocalHome home = serviceLocator
					.getServiceSessionBeanEntityLocalHome();
			this.serviceSessionData = home.create(ssid);
			this.serviceSessionData.setAsid(asid);
			Calendar cal = Calendar.getInstance();
			this.serviceSessionData.setStartDate(cal.getTime());
		} catch (ServiceLocatorException ex) {
			log.error("caught ex: " + ex.toString());
			throw new CreateException(
					"Couldn't get the local interface of the service session entity bean!");
		} catch (RemoveException ex) {
			log.error("caught ex: " + ex.toString());
			throw new CreateException(
					"Couldn't remove the instance of the SimpleIdGeneratorLocal!");
		}
		log.debug("-> ... processing DONE!");
	}

	/**
	 * Default create method
	 * 
	 * @throws CreateException
	 * @ejb.create-method
	 */
	public void ejbCreate(String ssid, String asid) throws CreateException {
		log.debug("-> start processing ...");
		log.debug("the ejbCreate method with two input parameters");
		if (asid == null || asid.length() == 0)
			throw new CreateException("the given asid has to be a valid value!");
		try {
			ServiceLocator serviceLocator = ServiceLocator.getInstance();
			if (log.isDebugEnabled())
				log.debug("search using following ssid : " + ssid);
			ServiceSessionBeanEntityLocalHome home = serviceLocator
					.getServiceSessionBeanEntityLocalHome();
			this.serviceSessionData = home.findByPrimaryKey(ssid);
			if (log.isDebugEnabled()) {
				if (this.serviceSessionData != null) {
					log.debug("got the properly service session bean instance!");
					log.debug("ssid from db: " + this.serviceSessionData.getSsid());
				}
			}
		} catch (ServiceLocatorException ex) {
			log.error("caught ex: " + ex.toString());
			throw new CreateException(
					"Couldn't get the local interface of the service session entity bean!");
		} catch (FinderException ex) {
			log.error("caught ex: " + ex.toString());
			throw new CreateException(
					"Couldn't find a record with service session data specified by ssid = "
							+ ssid);
		}
		log.debug("-> ... processing DONE!");
	}

	/**
	 * Business Method
	 * 
	 * @ejb.interface-method view-type = "local"
	 *  
	 */
	public IeMayorService geteMayorService() throws ServiceSessionException {
		log.debug("-> start processing ...");
		return this.eMayorService;
	}

	/**
	 * Business Method
	 * 
	 * @ejb.interface-method view-type = "local"
	 *  
	 */
	public void seteMayorService(IeMayorService emayorService)
			throws ServiceSessionException {
		log.debug("-> start processing ...");
		this.eMayorService = emayorService;
		log.debug("-> ... processing DONE!");
	}

	/**
	 * Business Method
	 * 
	 * @ejb.interface-method view-type = "local"
	 *  
	 */
	public void startService(String userId, boolean isForwarded, String xmlDoc,
			String docSig) throws ServiceSessionException {
		log.debug("-> start processing ...");
		try {
			log.debug("starting the service :-)");
			if (isForwarded)
				this.eMayorService.forward(userId, this.serviceSessionData
						.getSsid(), xmlDoc, docSig);
			else {
				this.eMayorService.startService(userId, this.serviceSessionData
						.getSsid());
			}
		} catch (eMayorServiceException emsex) {
			log.error("caught ex: " + emsex.toString());
			throw new ServiceSessionException("Couldn't start the service :-(");
		}
		log.debug("-> ... processing DONE!");
	}

	/**
	 * Business Method
	 * 
	 * @ejb.interface-method view-type = "local"
	 *  
	 */
	public void startServiceRequestCompleted(String userId,
			boolean isForwarded, String xmlDoc, String docSig)
			throws ServiceSessionException {
		log.debug("-> start processing ...");
		try {
			log.debug("starting the service :-)");
			if (isForwarded)
				this.eMayorService.forward(userId, this.serviceSessionData
						.getSsid(), xmlDoc, docSig);
			else {
				this.eMayorService.startService(userId, this.serviceSessionData
						.getSsid(), xmlDoc);
			}
		} catch (eMayorServiceException emsex) {
			log.error("caught ex: " + emsex.toString());
			throw new ServiceSessionException("Couldn't start the service :-(");
		}
		log.debug("-> ... processing DONE!");
	}

	/**
	 * Business Method
	 * 
	 * @ejb.interface-method view-type = "local"
	 *  
	 */
	public void endService() throws ServiceSessionException {
		log.debug("-> start processing ...");
		try {
			ServiceLocator locator = ServiceLocator.getInstance();
			KernelLocal kernel = locator.getKernelLocal();
			kernel.deleteServiceSession(this.serviceSessionData.getAsid(),
					this.serviceSessionData.getSsid());
			kernel.remove();
		} catch (ServiceLocatorException slex) {
			log.error("cannot get an instance of the service locator");
			throw new ServiceSessionException(
					"cannot get an instance of the service locator");
		} catch (KernelException kex) {
			log.error("cannot delete successful service session: ssid="
					+ serviceSessionData.getSsid());
			throw new ServiceSessionException(
					"cannot delete successful service session");
		} catch (RemoveException rex) {
			log.error("cannot remove the instance of the kernel ejb");
			throw new ServiceSessionException(
					"cannot remove the instance of the kernel ejb");
		}
		log.debug("-> ... processing DONE!");
	}

	/**
	 * Business Method
	 * 
	 * @ejb.interface-method view-type = "local"
	 *  
	 */
	public Date getStartDate() throws SessionException {
		log.debug("-> start processing ...");
		return this.serviceSessionData.getStartDate();
	}

	/**
	 * Business Method
	 * 
	 * @ejb.interface-method view-type = "local"
	 *  
	 */
	public String getCreatorId() throws ServiceSessionException {
		log.debug("-> start processing ...");
		return this.serviceSessionData.getUserId();
	}

	/**
	 * Business Method
	 * 
	 * @ejb.interface-method view-type = "local"
	 *  
	 */
	public void setCreatorId(String creatorId) throws ServiceSessionException {
		log.debug("-> start processing ...");
		this.serviceSessionData.setUserId(creatorId);
	}
}