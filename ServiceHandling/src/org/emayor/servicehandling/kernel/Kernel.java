/*
 * $ Created on Feb 9, 2005 by tku $
 */
package org.emayor.servicehandling.kernel;

import org.apache.log4j.Logger;
import org.emayor.policyenforcer.C_UserProfile;
import org.emayor.servicehandling.interfaces.AccessSessionLocal;
import org.emayor.servicehandling.interfaces.ServiceSessionLocal;

/**
 * @author <a href="mailto:Tomasz.Kusber@fokus.fraunhofer.de"> <font
 *         size="-1">Tomasz Kusber </font> </a> <font size="-1"> FHI FOKUS (C)
 *         </font>
 */
public class Kernel implements IKernel {
	private static Logger log = Logger.getLogger(Kernel.class);
	
	private static Kernel _self = null;
	
	private Kernel() {}
	
	public static final Kernel getInstance() {
		if (_self == null)
			_self = new Kernel();
		return _self;
	}

	/* (non-Javadoc)
	 * @see org.emayor.servicehandling.kernel.IKernel#createAccessSession()
	 */
	public synchronized String createAccessSession() throws KernelException {
		// TODO Auto-generated method stub
		log.debug("-> start processing ...");
		String ret = null;
		log.debug("-> ... processing DONE!");
		return ret;
	}

	/* (non-Javadoc)
	 * @see org.emayor.servicehandling.kernel.IKernel#getAccessSession(java.lang.String)
	 */
	public synchronized AccessSessionLocal getAccessSession(String asid) throws KernelException {
		// TODO Auto-generated method stub
		log.debug("-> start processing ...");
		AccessSessionLocal ret = null;
		log.debug("-> ... processing DONE!");
		return ret;
	}

	/* (non-Javadoc)
	 * @see org.emayor.servicehandling.kernel.IKernel#deleteAccessSession(java.lang.String)
	 */
	public synchronized boolean deleteAccessSession(String asid) throws KernelException {
		// TODO Auto-generated method stub
		log.debug("-> start processing ...");
		boolean ret = false;
		log.debug("-> ... processing DONE!");
		return ret;
	}

	/* (non-Javadoc)
	 * @see org.emayor.servicehandling.kernel.IKernel#createServiceSession(java.lang.String, java.lang.String)
	 */
	public synchronized ServiceSessionLocal createServiceSession(String asid, String serviceName) throws KernelException {
		// TODO Auto-generated method stub
		log.debug("-> start processing ...");
		ServiceSessionLocal ret = null;
		log.debug("-> ... processing DONE!");
		return ret;
	}

	/* (non-Javadoc)
	 * @see org.emayor.servicehandling.kernel.IKernel#getServiceSession(java.lang.String)
	 */
	public synchronized ServiceSessionLocal getServiceSession(String ssid) throws KernelException {
		// TODO Auto-generated method stub
		log.debug("-> start processing ...");
		ServiceSessionLocal ret = null;
		log.debug("-> ... processing DONE!");
		return ret;
	}

	/* (non-Javadoc)
	 * @see org.emayor.servicehandling.kernel.IKernel#deleteServiceSession(java.lang.String)
	 */
	public synchronized boolean deleteServiceSession(String ssid) throws KernelException {
		// TODO Auto-generated method stub
		log.debug("-> start processing ...");
		boolean ret = false;
		log.debug("-> ... processing DONE!");
		return ret;
	}

	/* (non-Javadoc)
	 * @see org.emayor.servicehandling.kernel.IKernel#listAvailableServices(org.emayor.policyenforcer.C_UserProfile)
	 */
	public synchronized ServiceInfo[] listAvailableServices(C_UserProfile userProfile) throws KernelException {
		// TODO Auto-generated method stub
		log.debug("-> start processing ...");
		ServiceInfo[] ret = new ServiceInfo[0];
		log.debug("-> ... processing DONE!");
		return ret;
	}

	/* (non-Javadoc)
	 * @see org.emayor.servicehandling.kernel.IKernel#listAllAvailableServices()
	 */
	public synchronized ServiceInfo[] listAllAvailableServices() throws KernelException {
		// TODO Auto-generated method stub
		log.debug("-> start processing ...");
		ServiceInfo[] ret = new ServiceInfo[0];
		log.debug("-> ... processing DONE!");
		return ret;
	}

}