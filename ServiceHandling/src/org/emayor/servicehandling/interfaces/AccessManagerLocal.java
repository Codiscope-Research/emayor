/*
 * Generated by XDoclet - Do not edit!
 */
package org.emayor.servicehandling.interfaces;

/**
 * Local interface for AccessManager.
 */
public interface AccessManagerLocal
   extends javax.ejb.EJBLocalObject
{
   /**
    * Business Method
    */
   public java.lang.String createAccessSession(  ) throws org.emayor.servicehandling.kernel.AccessException;

   /**
    * Business Method
    */
   public java.lang.String startService( java.lang.String accessSessionId,java.lang.String serviceId ) throws org.emayor.servicehandling.kernel.AccessException;

   /**
    * Business Method
    */
   public java.lang.String startService( java.lang.String accessSessionId,java.lang.String serviceId,java.lang.String requestDocument ) throws org.emayor.servicehandling.kernel.AccessException;

   /**
    * Business Method
    */
   public boolean stopService( java.lang.String accessSessionId,java.lang.String serviceSessionId ) throws org.emayor.servicehandling.kernel.AccessException;

   /**
    * Business Method
    */
   public org.emayor.servicehandling.kernel.ServicesInfo listAvailableServices( java.lang.String accessSessionId ) throws org.emayor.servicehandling.kernel.AccessException;

   /**
    * Business Method
    */
   public org.emayor.servicehandling.kernel.RunningServicesInfo listRunningServices( java.lang.String accessSessionId ) throws org.emayor.servicehandling.kernel.AccessException;

   /**
    * Business Method
    */
   public boolean stopAccessSession( java.lang.String accessSessionId ) throws org.emayor.servicehandling.kernel.AccessException;

   /**
    * Business Method
    */
   public java.lang.String startForwardedService( java.lang.String accessSessionId,java.lang.String serviceId,org.emayor.servicehandling.kernel.ForwardMessage message ) throws org.emayor.servicehandling.kernel.AccessException;

   /**
    * Business Method
    */
   public boolean startAccessSession( java.lang.String asid,java.security.cert.X509Certificate[] certificates ) throws org.emayor.servicehandling.kernel.AccessException;

   /**
    * Business Method
    */
   public org.emayor.servicehandling.kernel.UserProfile getUserProfile( java.lang.String asid ) throws org.emayor.servicehandling.kernel.AccessException;

}
