INSERT INTO PLATFORMCONFIG (
CONFIGID,
emayor_platform_instance_id,
emayor_municipality_name,
emayor_operating_mode,
emayor_operating_mode_forward,
emayor_tmp_dir,
emayor_operating_mode_email,
emayor_email_test_user_address,
forward_manager_queue_host,
forward_manager_queue_name,
emayor_operation_mode_content_routing,
forward_manager_test_local_municipality_name,
forward_manager_test_remote_municipality_name,
forward_manager_test_local_municipality_address,
forward_manager_test_remote_municipality_address,
forward_manager_test_remote_profile_id,
emayor_service_invoker_endpoint,
emayor_admin_interface_is_enabled,
emayor_admin_interface_userid,
emayor_admin_interface_password,
bpel_engine_ut_initial_context_factory,
bpel_engine_ut_security_principal,
bpel_engine_ut_security_credentials,
bpel_engine_ut_provider_url,
bpel_engine_ut_security_domain,
bpel_engine_ut_security_domain_password,
emayor_pe_info_dir,
emayor_notification_email_smtp_host,
emayor_notification_email_smtp_user,
emayor_notification_email_smtp_pass,
emayor_notification_email_smtp_auth,
emayor_content_routing_local_inquiry,
emayor_content_routing_remote_inquiry,
emayor_content_routing_local_publish,
emayor_content_routing_userid,
emayor_content_routing_password,
config_is_active,
emayor_pe_crl_distribution_url,
emayor_pe_crl_use_default_distribution_url,
emayor_pe_check_signature,
EMAYOR_HTTP_SESSION_MAX_TIME_TO_LIVE,
EMAYOR_E2M_CONTEXT,
EMAYOR_NOTIFICATION_EMAIL_REPLYTO
) VALUES (
@CONFIG_ID,
@MUNICIPALITY_ID,
@MUNICIPALITY_NAME,
@EMAYOR_OPERATING_MODE,
@EMAYOR_OPERATING_MODE_FORWARD,
'tmp/emayor',
@EMAYOR_OPERATING_MODE_EMAIL,
@EMAYOR_NOTIFICATION_EMAIL_TESTADDRESS,
@FORWARD_MANAGER_QUEUE_HOST,
'queue/eMayor-ForwardQueue',
@EMAYOR_OPERATING_MODE_CONTENT_ROUTING,
@FORWARD_MANAGER_TEST_LOCAL_MUNICIPALITY_NAME,
@FORWARD_MANAGER_TEST_REMOTE_MUNICIPALITY_NAME,
@FORWARD_MANAGER_TEST_LOCAL_MUNICIPALITY_ADDRESS,
@FORWARD_MANAGER_TEST_REMOTE_MUNICIPALITY_ADDRESS,
'server2',
@EMAYOR_SERVICE_INVOKER_ENDPOINT,
'YES',
'admin',
'admin123','com.evermind.server.rmi.RMIInitialContextFactory',
'admin',
'welcome',
'rmi://localhost/UTWrapperApp',
@BPEL_ENGINE_UT_SECURITY_DOMAIN_NAME,
@BPEL_ENGINE_UT_SECURITY_DOMAIN_PASSWORD,
'conf/policies',@EMAYOR_NOTIFICATION_EMAIL_SMTP_HOST,@EMAYOR_NOTIFICATION_EMAIL_SMTP_USER,@EMAYOR_NOTIFICATION_EMAIL_SMTP_PASS,@EMAYOR_NOTIFICATION_EMAIL_SMTP_AUTH,
@EMAYOR_CONTENTROUTING_LOCAL_INQUIRY,
@EMAYOR_CONTENTROUTING_REMOTE_INQUIRY,
@EMAYOR_CONTENTROUTING_LOCAL_PUBLISH,
@EMAYOR_CONTENTROUTING_USERID,
@EMAYOR_CONTENTROUTING_PASSWORD,
@CONFIG_IS_ACTIVE,
@EMAYOR_PE_CRL_DISTRIBUTION_URL,
'1',
@EMAYOR_PE_CHECK_SIGNATURE,
2000,
@EMAYOR_E2M_CONTEXT,
@EMAYOR_NOTIFICATION_EMAIL_REPLYTO
);