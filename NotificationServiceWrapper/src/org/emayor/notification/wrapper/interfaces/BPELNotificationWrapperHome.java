/*
 * Generated by XDoclet - Do not edit!
 */
package org.emayor.notification.wrapper.interfaces;

/**
 * Home interface for BPELNotificationWrapper.
 */
public interface BPELNotificationWrapperHome
   extends javax.ejb.EJBHome
{
   public static final String COMP_NAME="java:comp/env/ejb/BPELNotificationWrapper";
   public static final String JNDI_NAME="ejb/BPELNotificationWrapper";

   public org.emayor.notification.wrapper.interfaces.BPELNotificationWrapper create()
      throws javax.ejb.CreateException,java.rmi.RemoteException;

}
