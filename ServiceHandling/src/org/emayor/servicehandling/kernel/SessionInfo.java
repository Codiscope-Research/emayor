/*
 * Created on Jun 2, 2005
 */
package org.emayor.servicehandling.kernel;

import java.io.Serializable;

/**
 * @author tku
 */
public class SessionInfo implements Serializable {
    
    private String sessionId;

    /**
     *  
     */
    public SessionInfo() {
    }
    
    public SessionInfo(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * @return Returns the sessionId.
     */
    public String getSessionId() {
        return sessionId;
    }
    /**
     * @param sessionId The sessionId to set.
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}