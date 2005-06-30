/*
 * Generated by XDoclet - Do not edit!
 */
package org.emayor.servicehandling.interfaces;

/**
 * Local home interface for ServiceInfoEntity.
 */
public interface ServiceInfoEntityLocalHome
   extends javax.ejb.EJBLocalHome
{
   public static final String COMP_NAME="java:comp/env/ejb/ServiceInfoEntityLocal";
   public static final String JNDI_NAME="ServiceInfoEntityLocal";

   public org.emayor.servicehandling.interfaces.ServiceInfoEntityLocal create(java.lang.String serviceId)
      throws javax.ejb.CreateException;

   public java.util.Collection findAll()
      throws javax.ejb.FinderException;

   public java.util.Collection findAllActiveServicesInfo()
      throws javax.ejb.FinderException;

   public java.util.Collection findByVersion(java.lang.String version)
      throws javax.ejb.FinderException;

   public org.emayor.servicehandling.interfaces.ServiceInfoEntityLocal findByPrimaryKey(java.lang.String pk)
      throws javax.ejb.FinderException;

}
