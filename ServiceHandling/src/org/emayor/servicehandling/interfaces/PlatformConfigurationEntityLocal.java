/*
 * Generated by XDoclet - Do not edit!
 */
package org.emayor.servicehandling.interfaces;

/**
 * Local interface for PlatformConfigurationEntity.
 */
public interface PlatformConfigurationEntityLocal
   extends javax.ejb.EJBLocalObject
{
   /**
    * Getter for CMP Field PropertyValue
    */
   public java.lang.String getConfigID(  ) ;

   /**
    * Setter for CMP Field PropertyValue
    */
   public void setConfigID( java.lang.String value ) ;

   /**
    * the unique id of the platform instance e.g. Aachen,Bozen
    */
   public java.lang.String getEMayorPlatformInstanceID(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setEMayorPlatformInstanceID( java.lang.String value ) ;

   /**
    * arbitrary fulle name of the municipality - informative character
    */
   public java.lang.String getEMayorMunicipalityName(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setEMayorMunicipalityName( java.lang.String value ) ;

   /**
    * this property indicates whether the internal test services should be loaded (test) or the services contained in the deploy directory
    */
   public java.lang.String getEMayorOperatingMode(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setEMayorOperatingMode( java.lang.String value ) ;

   /**
    * test - the forwarding will be simulated, it means there is no need to start an extra (second) BPEL PM production - a real process will be started in case of forwarding
    */
   public java.lang.String getEMayorOperatingModeForward(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setEMayorOperatingModeForward( java.lang.String value ) ;

   /**
    * deployment directory for the emayor services emayor.service.info.dir=conf/services emayor.service.classes.dir=conf/services/classes
    */
   public java.lang.String getEMayorTmpDir(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setEMayorTmpDir( java.lang.String value ) ;

   /**
    * email on the emayor platform
    */
   public java.lang.String getEMayorOperationModeEmail(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setEMayorOperationModeEmail( java.lang.String value ) ;

   /**
    * email on the emayor platform
    */
   public java.lang.String getEMayorEmailTestUserAddress(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setEMayorEmailTestUserAddress( java.lang.String value ) ;

   /**
    * forward manager
    */
   public java.lang.String getForwardManagerQueueHost(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setForwardManagerQueueHost( java.lang.String value ) ;

   /**
    * forward manager
    */
   public java.lang.String getForwardManagerQueueName(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setForwardManagerQueueName( java.lang.String value ) ;

   /**
    * forward manager
    */
   public java.lang.String getEMayorOperationModeContentRouting(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setEMayorOperationModeContentRouting( java.lang.String value ) ;

   /**
    * forward manager
    */
   public java.lang.String getForwardManagerTestLocalMunicipalityName(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setForwardManagerTestLocalMunicipalityName( java.lang.String value ) ;

   /**
    * forward manager
    */
   public java.lang.String getForwardManagerTestRemoteMunicipalityName(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setForwardManagerTestRemoteMunicipalityName( java.lang.String value ) ;

   /**
    * forward manager
    */
   public java.lang.String getForwardManagerTestLocalMunicipalityAddress(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setForwardManagerTestLocalMunicipalityAddress( java.lang.String value ) ;

   /**
    * forward manager
    */
   public java.lang.String getForwardManagerTestRemoteMunicipalityAddress(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setForwardManagerTestRemoteMunicipalityAddress( java.lang.String value ) ;

   /**
    * forward manager
    */
   public java.lang.String getForwardManagerTestRemoteProfileID(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setForwardManagerTestRemoteProfileID( java.lang.String value ) ;

   /**
    * forward manager
    */
   public java.lang.String getEMayorServiceInvokerEndpoint(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setEMayorServiceInvokerEndpoint( java.lang.String value ) ;

   /**
    * eMayor admin interface
    */
   public java.lang.String getEMayorAdminInterfaceIsEnabled(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setEMayorAdminInterfaceIsEnabled( java.lang.String value ) ;

   /**
    * eMayor admin interface
    */
   public java.lang.String getEMayorAdminInterfaceUserID(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setEMayorAdminInterfaceUserID( java.lang.String value ) ;

   /**
    * eMayor admin interface
    */
   public java.lang.String getEMayorAdminInterfacePassword(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setEMayorAdminInterfacePassword( java.lang.String value ) ;

   /**
    * bpel engine initial context configuration for the UTWrapper application
    */
   public java.lang.String getBpelEngineUtInitialContextFactory(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setBpelEngineUtInitialContextFactory( java.lang.String value ) ;

   /**
    * bpel engine initial context configuration for the UTWrapper application
    */
   public java.lang.String getBpelEngineUtSecurityPrincipal(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setBpelEngineUtSecurityPrincipal( java.lang.String value ) ;

   /**
    * bpel engine initial context configuration for the UTWrapper application
    */
   public java.lang.String getBpelEngineUtSecurityCredentials(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setBpelEngineUtSecurityCredentials( java.lang.String value ) ;

   /**
    * bpel engine initial context configuration for the UTWrapper application
    */
   public java.lang.String getBpelEngineUtProviderURL(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setBpelEngineUtProviderURL( java.lang.String value ) ;

   /**
    * bpel engine initial context configuration for the UTWrapper application
    */
   public java.lang.String getBpelEngineUtSecurityDomain(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setBpelEngineUtSecurityDomain( java.lang.String value ) ;

   /**
    * bpel engine initial context configuration for the UTWrapper application
    */
   public java.lang.String getBpelEngineUtSecurityDomainPassword(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setBpelEngineUtSecurityDomainPassword( java.lang.String value ) ;

   /**
    * Policy Enforcer Configurartion
    */
   public java.lang.String getEMayorPeInfoDir(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setEMayorPeInfoDir( java.lang.String value ) ;

   /**
    * Notification (Email Gateway) Configuration
    */
   public java.lang.String getEMayorNotificationEmailSMTPHost(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setEMayorNotificationEmailSMTPHost( java.lang.String value ) ;

   /**
    * Notification (Email Gateway) Configuration
    */
   public java.lang.String getEMayorNotificationEmailSMTPUser(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setEMayorNotificationEmailSMTPUser( java.lang.String value ) ;

   /**
    * Notification (Email Gateway) Configuration
    */
   public java.lang.String getEMayorNotificationEmailSMTPPass(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setEMayorNotificationEmailSMTPPass( java.lang.String value ) ;

   /**
    * Notification (Email Gateway) Configuration
    */
   public java.lang.String getEMayorNotificationEmailSMTPAuth(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setEMayorNotificationEmailSMTPAuth( java.lang.String value ) ;

   /**
    * marker for active configuration
    */
   public java.lang.Boolean getIsActive(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setIsActive( java.lang.Boolean value ) ;

   /**
    * content routing local inquiry URL
    */
   public java.lang.String getEMayorContentRoutingLocalInquiryURL(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setEMayorContentRoutingLocalInquiryURL( java.lang.String value ) ;

   /**
    * content routing remote inquiry URL
    */
   public java.lang.String getEMayorContentRoutingRemoteInquiryURL(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setEMayorContentRoutingRemoteInquiryURL( java.lang.String value ) ;

   /**
    * content routing local publish URL
    */
   public java.lang.String getEMayorContentRoutingLocalPublishURL(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setEMayorContentRoutingLocalPublishURL( java.lang.String value ) ;

   /**
    * content routing juddi userid
    */
   public java.lang.String getEMayorContentRoutingUserID(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setEMayorContentRoutingUserID( java.lang.String value ) ;

   /**
    * content routing juddi userid
    */
   public java.lang.String getEMayorContentRoutingPassword(  ) ;

   /**
    * Setter for CMP Field
    */
   public void setEMayorContentRoutingPassword( java.lang.String value ) ;
   
	/**
	 * PolicyEnforcer CRL Distribution URL
	 */
	public String getEMayorPeCrlDistributionURL();

	/**
	 * Setter for CMP Field
	 */
	public void setEMayorPeCrlDistributionURL(String value);

	/**
	 * PolicyEnforcer CRL Distribution URL as default only
	 */
	public Boolean getEMayorPeCrlUseDefaultDistributionURL();

	/**
	 * Setter for CMP Field
	 */
	public void setEMayorPeCrlUseDefaultDistributionURL(Boolean value);
	
	/**
	 * PolicyEnforcer Check Signatures or not
	 */
	public Boolean getEMayorPeCheckSignature();

	/**
	 * Setter for CMP Field
	 */
	public void setEMayorPeCheckSignature(Boolean value);	
	
	/**
	 * HTTP Session max. time to live
	 */
	public Integer getEMayorHTTPSessionMaxTimeToLive();

	/**
	 * Setter for CMP Field
	 */
	public void setEMayorHTTPSessionMaxTimeToLive(Integer value);
	

}
