/*
 * Generated by XDoclet - Do not edit!
 */
package de.fraunhofer.dms.xinco.wrapper;

/**
 * Remote interface for XincoWrapper.
 * @xdoclet-generated at ${TODAY}
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface XincoWrapper
   extends javax.ejb.EJBObject
{
   /**
    * Business method
    */
   public boolean uploadFile( java.lang.String user,java.lang.String pass,byte[] content,java.lang.String[] contentOrder )
      throws java.rmi.RemoteException;

}
