/*
 * Generated by XDoclet - Do not edit!
 */
package org.emayor.servicehandling.interfaces;

/**
 * Local interface for AccessSession.
 */
public interface AccessSessionLocal
   extends javax.ejb.EJBLocalObject
{
   /**
    * Business Method
    */
   public boolean authenticateUser( java.security.cert.X509Certificate[] certificates ) throws org.emayor.servicehandling.kernel.AccessSessionException;

   /**
    * Business Method
    */
   public org.emayor.servicehandling.interfaces.ServiceSessionLocal[] getAllServiceSessions(  ) throws org.emayor.servicehandling.kernel.AccessSessionException;

   /**
    * Business Method
    */
   public org.emayor.servicehandling.interfaces.ServiceSessionLocal getServiceSession( java.lang.String ssid ) throws org.emayor.servicehandling.kernel.AccessSessionException;

   /**
    * Business Method
    */
   public java.lang.String startServiceSession( java.lang.String serviceId,boolean isForwarded,java.lang.String xmlDoc,java.lang.String docSig ) throws org.emayor.servicehandling.kernel.AccessSessionException;

   /**
    * Business Method
    */
   public java.lang.String startServiceSession( java.lang.String serviceId,java.lang.String requestDocument ) throws org.emayor.servicehandling.kernel.AccessSessionException;

   /**
    * Business Method
    */
   public boolean stopServiceSession( java.lang.String ssid ) throws org.emayor.servicehandling.kernel.AccessSessionException;

   /**
    * Business Method
    */
   public boolean stopAllServiceSessions(  ) throws org.emayor.servicehandling.kernel.AccessSessionException;

   /**
    * Business Method
    */
   public org.emayor.servicehandling.kernel.ServiceInfo[] listAvailableServices(  ) throws org.emayor.servicehandling.kernel.AccessSessionException;

   /**
    * Business Method
    */
   public boolean stop(  ) throws org.emayor.servicehandling.kernel.AccessSessionException;

   /**
    * Business Method
    */
   public org.eMayor.PolicyEnforcement.C_UserProfile getUserProfile(  ) throws org.emayor.servicehandling.kernel.AccessSessionException;

   /**
    * Business Method
    */
   public java.lang.String getSessionId(  ) throws org.emayor.servicehandling.kernel.SessionException;

   /**
    * Business Method
    */
   public java.lang.String getUserId(  ) throws org.emayor.servicehandling.kernel.AccessSessionException;

   /**
    * Business Method
    */
   public void setUserId( java.lang.String userId ) throws org.emayor.servicehandling.kernel.AccessSessionException;

   /**
    * Business Method
    */
   public java.util.Date getStartDate(  ) throws org.emayor.servicehandling.kernel.SessionException;

}
