/*
 * Generated by XDoclet - Do not edit!
 */
package org.emayor.servicehandling.interfaces;

/**
 * Local home interface for Kernel.
 */
public interface KernelLocalHome
   extends javax.ejb.EJBLocalHome
{
   public static final String COMP_NAME="java:comp/env/ejb/KernelLocal";
   public static final String JNDI_NAME="KernelLocal";

   public org.emayor.servicehandling.interfaces.KernelLocal create()
      throws javax.ejb.CreateException;

}
