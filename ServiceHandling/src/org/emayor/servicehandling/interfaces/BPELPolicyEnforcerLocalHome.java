/*
 * Generated by XDoclet - Do not edit!
 */
package org.emayor.servicehandling.interfaces;

/**
 * Local home interface for BPELPolicyEnforcer.
 */
public interface BPELPolicyEnforcerLocalHome
   extends javax.ejb.EJBLocalHome
{
   public static final String COMP_NAME="java:comp/env/ejb/BPELPolicyEnforcerLocal";
   public static final String JNDI_NAME="BPELPolicyEnforcerLocal";

   public org.emayor.servicehandling.interfaces.BPELPolicyEnforcerLocal create()
      throws javax.ejb.CreateException;

}