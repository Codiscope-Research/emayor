create database Siena;

GRANT ALL PRIVILEGES ON Siena.* TO jboss@localhost IDENTIFIED BY 'emayor';

use Siena;

SOURCE create_config_table.sql

### default config ###
SET @CONFIG_ID = 'Siena';
SET @MUNICIPALITY_ID = 'Siena';
SET @MUNICIPALITY_NAME = 'Municipality of Siena';

SET @BPEL_ENGINE_UT_SECURITY_DOMAIN_NAME = 'Siena';
SET @BPEL_ENGINE_UT_SECURITY_DOMAIN_PASSWORD = 'bpel';

SET @FORWARD_MANAGER_QUEUE_HOST = 'localhost:1099';
SET @FORWARD_MANAGER_TEST_LOCAL_MUNICIPALITY_NAME = 'Siena';
SET @FORWARD_MANAGER_TEST_LOCAL_MUNICIPALITY_ADDRESS = 'https://localhost:8443/eMayorEJB/ForwardManager';
SET @FORWARD_MANAGER_TEST_REMOTE_MUNICIPALITY_NAME = 'Bozen';
SET @FORWARD_MANAGER_TEST_REMOTE_MUNICIPALITY_ADDRESS = 'https://localhost:18443/eMayorEJB/ForwardManager';

SET @EMAYOR_CONTENTROUTING_LOCAL_INQUIRY = 'http://localhost:28080/juddi/inquiry';
SET @EMAYOR_CONTENTROUTING_LOCAL_PUBLISH = 'http://localhost:28080/juddi/publish';
SET @EMAYOR_CONTENTROUTING_REMOTE_INQUIRY = 'http://localhost:28080/juddi/inquiry';
SET @EMAYOR_CONTENTROUTING_USERID = 'juddi';
SET @EMAYOR_CONTENTROUTING_PASSWORD = 'juddi';

SET @CONFIG_IS_ACTIVE = '1';

SET @EMAYOR_OPERATING_MODE = 'production';
SET @EMAYOR_OPERATING_MODE_CONTENT_ROUTING = 'production';
SET @EMAYOR_OPERATING_MODE_EMAIL = 'test';
SET @EMAYOR_OPERATING_MODE_FORWARD = 'production';

SET @EMAYOR_E2M_CONTEXT = '//localhost:2001/Siena/E2MServer';

SET @EMAYOR_NOTIFICATION_EMAIL_REPLYTO = 'emayor@emayor.org';

SOURCE create_config_instance.sql;
SOURCE admin_services.sql; 
SOURCE RCS_v10.sql;
