/*
 * Generated by XDoclet - Do not edit!
 */
package org.emayor.notification.manager;

import org.emayor.notification.interfaces.INotificationManager;

/**
 * Remote interface for NotificationManager.
 * @see org.emayor.notification.interfaces.INotificationManager
 */
public interface NotificationManager
   extends javax.ejb.EJBObject, INotificationManager
{
   /**
    * Business method
    * @throws NotificationException
    * @see INotificationManager#createNotificationProducer(Properties)    */
   public java.lang.Integer createNotificationProducer( java.util.Properties config )
      throws org.emayor.notification.exception.NotificationException, java.rmi.RemoteException;

   /**
    * Business method
    * @throws NotificationException
    * @see INotificationManager#createNotificationProducer(Properties, Date)    */
   public java.lang.Integer createNotificationProducer( java.util.Properties config,java.util.Date expire )
      throws org.emayor.notification.exception.NotificationException, java.rmi.RemoteException;

   /**
    * Business method
    * @throws NotificationException
    * @see org.emayor.notification.interfaces.INotificationManager#deleteNotificationProducer(java.lang.Integer)    */
   public boolean deleteNotificationProducer( java.lang.Integer key )
      throws org.emayor.notification.exception.NotificationException, java.rmi.RemoteException;

   /**
    * Business method
    * @see org.emayor.notification.interfaces.INotificationManager#getNotificationProducer(java.lang.Integer)    */
   public org.emayor.notification.interfaces.INotificationProducer getNotificationProducer( java.lang.Integer key )
      throws java.rmi.RemoteException;

}
