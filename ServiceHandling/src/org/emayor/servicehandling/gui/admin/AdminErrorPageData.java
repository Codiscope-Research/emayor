/*
 * Created on Jun 6, 2005
 */
package org.emayor.servicehandling.gui.admin;

import java.io.Serializable;

/**
 * @author tku
 */
public class AdminErrorPageData implements Serializable {
    public static final String ATT_NAME = "ADMIN_ERROR_PAGE_DATA";
    
    private String pageTitle;
    
    private String message;
    

	/**
	 * @return Returns the message.
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message The message to set.
	 */
	public void setMessage(String message) {
		this.message = message;
	}
    /**
     * @return Returns the pageTitle.
     */
    public String getPageTitle() {
        return pageTitle;
    }
    /**
     * @param pageTitle The pageTitle to set.
     */
    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }
}
