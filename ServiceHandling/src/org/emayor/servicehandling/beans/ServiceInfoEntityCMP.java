/*
 * Generated by XDoclet - Do not edit!
 */
package org.emayor.servicehandling.beans;

/**
 * CMP layer for ServiceInfoEntity.
 */
public abstract class ServiceInfoEntityCMP
   extends org.emayor.servicehandling.beans.ServiceInfoEntityEJB
   implements javax.ejb.EntityBean
{

   public void ejbLoad() throws javax.ejb.EJBException, java.rmi.RemoteException
   {
      super.ejbLoad();
   }

   public void ejbStore() throws javax.ejb.EJBException, java.rmi.RemoteException
   {
         super.ejbStore();
   }

   public void ejbActivate() throws javax.ejb.EJBException, java.rmi.RemoteException
   {
      super.ejbActivate();
   }

   public void ejbPassivate() throws javax.ejb.EJBException, java.rmi.RemoteException
   {
      super.ejbPassivate();

   }

   public void setEntityContext(javax.ejb.EntityContext ctx) throws javax.ejb.EJBException, java.rmi.RemoteException
   {
      super.setEntityContext(ctx);
   }

   public void unsetEntityContext() throws javax.ejb.EJBException, java.rmi.RemoteException
   {
      super.unsetEntityContext();
   }

   public void ejbRemove() throws javax.ejb.EJBException, java.rmi.RemoteException, javax.ejb.RemoveException
   {
      super.ejbRemove();

   }

   public abstract java.lang.String getServiceId() ;

   public abstract void setServiceId( java.lang.String serviceId ) ;

   public abstract java.lang.String getServiceVersion() ;

   public abstract void setServiceVersion( java.lang.String serviceVersion ) ;

   public abstract java.lang.String getServiceName() ;

   public abstract void setServiceName( java.lang.String serviceName ) ;

   public abstract java.lang.String getServiceClassName() ;

   public abstract void setServiceClassName( java.lang.String serviceClassName ) ;

   public abstract java.lang.String getServiceFactoryClassName() ;

   public abstract void setServiceFactoryClassName( java.lang.String serviceFactoryClassName ) ;

   public abstract java.lang.String getServiceDescription() ;

   public abstract void setServiceDescription( java.lang.String serviceDescription ) ;

   public abstract java.lang.String getServiceEndpoint() ;

   public abstract void setServiceEndpoint( java.lang.String serviceEndpoint ) ;

   public abstract java.lang.Boolean getActive() ;

   public abstract void setActive( java.lang.Boolean active ) ;

   public abstract java.lang.Integer getInstances() ;

   public abstract void setInstances( java.lang.Integer instances ) ;

   public abstract byte[] getServiceClass() ;

   public abstract void setServiceClass( byte[] serviceClass ) ;

   public abstract byte[] getServiceFactoryClass() ;

   public abstract void setServiceFactoryClass( byte[] serviceFactoryClass ) ;

}
