/*
 * $ Created on Feb 9, 2005 by tku $
 */
package org.emayor.servicehandling.kernel;

import java.io.Serializable;
import java.util.Calendar;

/**
 * @author <a href="mailto:Tomasz.Kusber@fokus.fraunhofer.de"> <font
 *         size="-1">Tomasz Kusber </font> </a> <font size="-1"> FHI FOKUS (C)
 *         </font>
 */
public interface ITask extends Serializable {

	/**
	 * 
	 * @return
	 */
	public String getTaskId();

	/**
	 * 
	 * @param taskId
	 */
	public void setTaskId(String taskId);

	/**
	 * 
	 * @return
	 */
	public String getStatus();

	/**
	 * 
	 * @param status
	 */
	public void setStatus(String status);

	/**
	 * 
	 * @return
	 */
	public String getXMLDocument();

	/**
	 * 
	 * @param xmlDocument
	 */
	public void setXMLDocument(String xmlDocument);
	
	public String getDocDigSig();
	
	public void setDocDigSig(String docDigSig);
	
	public String getExtraInfo();
	
	public void setExtraInfo(String extraInfo);
	
	public boolean isSignatureStatus();
	
	public void setSignatureStatus(boolean signatureStatus);
	
	public int getTaskType();
	
	public void setTaskType(int taskType);
	
	public Calendar getDeadline();
	
	public void setDeadline(Calendar deadline);
	
	public Calendar getIncoming();
	
	public void setIncoming(Calendar incoming);
}