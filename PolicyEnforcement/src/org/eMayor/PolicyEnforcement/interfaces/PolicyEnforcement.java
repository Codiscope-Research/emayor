/*
 * Generated by XDoclet - Do not edit!
 */
package org.eMayor.PolicyEnforcement.interfaces;

/**
 * Remote interface for PolicyEnforcement.
 */
public interface PolicyEnforcement
   extends javax.ejb.EJBObject
{
   /**
    * Business method
    */
   public java.lang.String F_getUserProfile( java.security.cert.X509Certificate[] x509_CertChain )
      throws org.eMayor.PolicyEnforcement.E_PolicyEnforcementException, java.rmi.RemoteException;

   /**
    * Business method
    */
   public boolean F_AuthenticateUser( java.lang.String UserProfile )
      throws org.eMayor.PolicyEnforcement.E_PolicyEnforcementException, java.rmi.RemoteException;

   /**
    * Business method
    */
   public boolean F_VerifyXMLSignature( java.lang.String xmlDocument )
      throws org.eMayor.PolicyEnforcement.E_PolicyEnforcementException, java.rmi.RemoteException;

   /**
    * Business method
    */
   public java.lang.String F_TimeStampXMLDocument( java.lang.String xmlDocumentDoc )
      throws org.eMayor.PolicyEnforcement.E_PolicyEnforcementException, java.rmi.RemoteException;

   /**
    * Business method
    */
   public boolean F_VerifyXMLTimeStampedDocument( java.lang.String xmlDocument )
      throws org.eMayor.PolicyEnforcement.E_PolicyEnforcementException, java.rmi.RemoteException;

   /**
    * Business method
    */
   public boolean F_AuthorizeService( java.lang.String UserProfile,java.lang.String ServiceProfile )
      throws org.eMayor.PolicyEnforcement.E_PolicyEnforcementException, java.rmi.RemoteException;

   /**
    * Business method
    */
   public boolean F_AuthorizeServiceStep( java.lang.String UserProfile,java.lang.String ServiceProfile,java.lang.String ServiceStep )
      throws org.eMayor.PolicyEnforcement.E_PolicyEnforcementException, java.rmi.RemoteException;

   /**
    * Business method
    */
   public void F_UpdatePolicies(  )
      throws org.eMayor.PolicyEnforcement.E_PolicyEnforcementException, java.rmi.RemoteException;

}
