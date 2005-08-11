-- MySQL dump 10.9
--
-- Host: localhost    Database: aachen
-- ------------------------------------------------------
-- Server version	4.1.12a-nt

CREATE TABLE `SERVICE_INFO` (
  `SERVICEID` varchar(100) NOT NULL default '',
  `SERVICEVERSION` varchar(20) default NULL,
  `SERVICENAME` varchar(100) default NULL,
  `SERVICECLASSNAME` varchar(200) default NULL,
  `SERVICEFACTORYCLASSNAME` varchar(100) default NULL,
  `SERVICEDECRIPTION` text,
  `SERVICEENDPOINT` varchar(250) default NULL,
  `ACTIVE` tinyint(1) default NULL,
  `INSTANCES` int(11) default NULL,
  `SERVICECLASS` blob,
  `SERVICEFACTORYCLASS` blob,
  PRIMARY KEY  (`SERVICEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



/*!40000 ALTER TABLE `SERVICE_INFO` DISABLE KEYS */;
LOCK TABLES `SERVICE_INFO` WRITE;
INSERT INTO `SERVICE_INFO` VALUES ('AdminService_v10','1.0','Platform Administration Service','org.emayor.services.admin.AdminService','org.emayor.services.admin.AdminServiceFactory','This service provides the functionality needed to maintance the eMayor platform. It could be only use by the user in the role admin.','---',1,6,'����\0\0\0.\0K\0&org/emayor/services/admin/AdminService\0\07org/emayor/servicehandling/kernel/AbstracteMayorService\0\0log\0Lorg/apache/log4j/Logger;\0class$0\0Ljava/lang/Class;\0	Synthetic\0<clinit>\0()V\0Code\0\0	\0\0\r\0&org.emayor.services.admin.AdminService\0\0java/lang/Class\0\0forName\0%(Ljava/lang/String;)Ljava/lang/Class;\0\0\n\0\0\0java/lang/NoClassDefFoundError\0\0java/lang/Throwable\0\0\ngetMessage\0()Ljava/lang/String;\0\0\n\0\Z\0\0<init>\0(Ljava/lang/String;)V\0\0 \n\0\0!\0org/apache/log4j/Logger\0#\0	getLogger\0,(Ljava/lang/Class;)Lorg/apache/log4j/Logger;\0%\0&\n\0$\0\'\0\0	\0\0)\0 java/lang/ClassNotFoundException\0+\0LineNumberTable\0LocalVariableTable\0\0\n\0\0/\0isDebugEnabled\0()Z\01\02\n\0$\03\0-> start processing ...\05\0debug\0(Ljava/lang/Object;)V\07\08\n\0$\09\0-> ... processing DONE!\0;\0this\0(Lorg/emayor/services/admin/AdminService;\0startService\0\'(Ljava/lang/String;Ljava/lang/String;)V\0\nExceptions\08org/emayor/servicehandling/kernel/eMayorServiceException\0B\0uid\0Ljava/lang/String;\0ssid\09(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V\0requestDocument\0\nSourceFile\0AdminService.java\0!\0\0\0\0\0\0\Z\0\0\0\0\0\0\0\0	\0\0\0\0\0\0\0\n\0\0\0\0\0\0S\0\0\0\0\0\0\'�\0Y�\0W�\0Y�\0�\0�\0Z_�\0�\0\"��\0(�\0*�\0\0\0\r\0\0,\0\0-\0\0\0\n\0\0\0\0\0&\0\0.\0\0\0\0\0\0\0\0\0\0\0\0\0X\0\0\0\0\0*�\00�\0*�\04�\0�\0*6�\0:�\0*<�\0:�\0\0\0\0-\0\0\0\0\0\0\0\0\0\0\r\0\0\0\0\0\0.\0\0\0\0\0\0\0\0=\0>\0\0\0\0?\0@\0\0A\0\0\0\0\0C\0\0\0\0d\0\0\0\0\0\Z�\0*�\04�\0�\0*6�\0:�\0*<�\0:�\0\0\0\0-\0\0\0\0\0\0\0!\0	\0\"\0\0#\0\0%\0.\0\0\0 \0\0\0\0\Z\0=\0>\0\0\0\0\0\Z\0D\0E\0\0\0\0\Z\0F\0E\0\0\0?\0G\0\0A\0\0\0\0\0C\0\0\0\0n\0\0\0\0\0\Z�\0*�\04�\0�\0*6�\0:�\0*<�\0:�\0\0\0\0-\0\0\0\0\0\0\0/\0	\00\0\01\0\03\0.\0\0\0*\0\0\0\0\Z\0=\0>\0\0\0\0\0\Z\0D\0E\0\0\0\0\Z\0F\0E\0\0\0\0\Z\0H\0E\0\0\0I\0\0\0\0J','����\0\0\0.\0D\0-org/emayor/services/admin/AdminServiceFactory\0\06org/emayor/servicehandling/kernel/eMayorServiceFactory\0\0log\0Lorg/apache/log4j/Logger;\0class$0\0Ljava/lang/Class;\0	Synthetic\0<clinit>\0()V\0Code\0\0	\0\0\r\0-org.emayor.services.admin.AdminServiceFactory\0\0java/lang/Class\0\0forName\0%(Ljava/lang/String;)Ljava/lang/Class;\0\0\n\0\0\0java/lang/NoClassDefFoundError\0\0java/lang/Throwable\0\0\ngetMessage\0()Ljava/lang/String;\0\0\n\0\Z\0\0<init>\0(Ljava/lang/String;)V\0\0 \n\0\0!\0org/apache/log4j/Logger\0#\0	getLogger\0,(Ljava/lang/Class;)Lorg/apache/log4j/Logger;\0%\0&\n\0$\0\'\0\0	\0\0)\0 java/lang/ClassNotFoundException\0+\0LineNumberTable\0LocalVariableTable\0\nExceptions\08org/emayor/servicehandling/kernel/eMayorServiceException\00\0\0\n\0\02\0isDebugEnabled\0()Z\04\05\n\0$\06\0-> start processing ...\08\0debug\0(Ljava/lang/Object;)V\0:\0;\n\0$\0<\0-> ... processing DONE!\0>\0this\0/Lorg/emayor/services/admin/AdminServiceFactory;\0\nSourceFile\0AdminServiceFactory.java\0!\0\0\0\0\0\0\Z\0\0\0\0\0\0\0\0	\0\0\0\0\0\0\0\n\0\0\0\0\0\0W\0\0\0\0\0\0\'�\0Y�\0W�\0Y�\0�\0�\0Z_�\0�\0\"��\0(�\0*�\0\0\0\r\0\0,\0\0-\0\0\0\0\0\0\0\0#\0\0&\0\0.\0\0\0\0\0\0\0\0\0\0/\0\0\0\0\01\0\0\0\0X\0\0\0\0\0*�\03�\0*�\07�\0�\0*9�\0=�\0*?�\0=�\0\0\0\0-\0\0\0\0\0\0\0\0\0\0\r\0\0\0\Z\0\0\0.\0\0\0\0\0\0\0\0@\0A\0\0\0\0B\0\0\0\0C'),('PEAdminService_v10','1.0','Policy Enforcer Administration Service','org.emayor.services.peadmin.PolicyEnforcerAdminService','org.emayor.services.peadmin.PolicyEnforcerAdminServiceFactory','Policy Enforcer Administration Service.','---',1,7,'����\0\0\0.\0K\06org/emayor/services/peadmin/PolicyEnforcerAdminService\0\07org/emayor/servicehandling/kernel/AbstracteMayorService\0\0log\0Lorg/apache/log4j/Logger;\0class$0\0Ljava/lang/Class;\0	Synthetic\0<clinit>\0()V\0Code\0\0	\0\0\r\06org.emayor.services.peadmin.PolicyEnforcerAdminService\0\0java/lang/Class\0\0forName\0%(Ljava/lang/String;)Ljava/lang/Class;\0\0\n\0\0\0java/lang/NoClassDefFoundError\0\0java/lang/Throwable\0\0\ngetMessage\0()Ljava/lang/String;\0\0\n\0\Z\0\0<init>\0(Ljava/lang/String;)V\0\0 \n\0\0!\0org/apache/log4j/Logger\0#\0	getLogger\0,(Ljava/lang/Class;)Lorg/apache/log4j/Logger;\0%\0&\n\0$\0\'\0\0	\0\0)\0 java/lang/ClassNotFoundException\0+\0LineNumberTable\0LocalVariableTable\0\0\n\0\0/\0isDebugEnabled\0()Z\01\02\n\0$\03\0-> start processing ...\05\0debug\0(Ljava/lang/Object;)V\07\08\n\0$\09\0-> ... processing DONE!\0;\0this\08Lorg/emayor/services/peadmin/PolicyEnforcerAdminService;\0startService\0\'(Ljava/lang/String;Ljava/lang/String;)V\0\nExceptions\08org/emayor/servicehandling/kernel/eMayorServiceException\0B\0uid\0Ljava/lang/String;\0ssid\09(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V\0requestDocument\0\nSourceFile\0PolicyEnforcerAdminService.java\0!\0\0\0\0\0\0\Z\0\0\0\0\0\0\0\0	\0\0\0\0\0\0\0\n\0\0\0\0\0\0W\0\0\0\0\0\0\'�\0Y�\0W�\0Y�\0�\0�\0Z_�\0�\0\"��\0(�\0*�\0\0\0\r\0\0,\0\0-\0\0\0\0\0\0\0\0#\0\0&\0\0.\0\0\0\0\0\0\0\0\0\0\0\0\0X\0\0\0\0\0*�\00�\0*�\04�\0�\0*6�\0:�\0*<�\0:�\0\0\0\0-\0\0\0\0\0\0\0\0\0\0\r\0\0\0\0\0\0.\0\0\0\0\0\0\0\0=\0>\0\0\0\0?\0@\0\0A\0\0\0\0\0C\0\0\0\0d\0\0\0\0\0\Z�\0*�\04�\0�\0*6�\0:�\0*<�\0:�\0\0\0\0-\0\0\0\0\0\0\0\"\0	\0#\0\0$\0\0&\0.\0\0\0 \0\0\0\0\Z\0=\0>\0\0\0\0\0\Z\0D\0E\0\0\0\0\Z\0F\0E\0\0\0?\0G\0\0A\0\0\0\0\0C\0\0\0\0n\0\0\0\0\0\Z�\0*�\04�\0�\0*6�\0:�\0*<�\0:�\0\0\0\0-\0\0\0\0\0\0\00\0	\01\0\02\0\04\0.\0\0\0*\0\0\0\0\Z\0=\0>\0\0\0\0\0\Z\0D\0E\0\0\0\0\Z\0F\0E\0\0\0\0\Z\0H\0E\0\0\0I\0\0\0\0J','����\0\0\0.\0D\0=org/emayor/services/peadmin/PolicyEnforcerAdminServiceFactory\0\06org/emayor/servicehandling/kernel/eMayorServiceFactory\0\0log\0Lorg/apache/log4j/Logger;\0class$0\0Ljava/lang/Class;\0	Synthetic\0<clinit>\0()V\0Code\0\0	\0\0\r\0=org.emayor.services.peadmin.PolicyEnforcerAdminServiceFactory\0\0java/lang/Class\0\0forName\0%(Ljava/lang/String;)Ljava/lang/Class;\0\0\n\0\0\0java/lang/NoClassDefFoundError\0\0java/lang/Throwable\0\0\ngetMessage\0()Ljava/lang/String;\0\0\n\0\Z\0\0<init>\0(Ljava/lang/String;)V\0\0 \n\0\0!\0org/apache/log4j/Logger\0#\0	getLogger\0,(Ljava/lang/Class;)Lorg/apache/log4j/Logger;\0%\0&\n\0$\0\'\0\0	\0\0)\0 java/lang/ClassNotFoundException\0+\0LineNumberTable\0LocalVariableTable\0\nExceptions\08org/emayor/servicehandling/kernel/eMayorServiceException\00\0\0\n\0\02\0isDebugEnabled\0()Z\04\05\n\0$\06\0-> start processing ...\08\0debug\0(Ljava/lang/Object;)V\0:\0;\n\0$\0<\0-> ... processing DONE!\0>\0this\0?Lorg/emayor/services/peadmin/PolicyEnforcerAdminServiceFactory;\0\nSourceFile\0&PolicyEnforcerAdminServiceFactory.java\0!\0\0\0\0\0\0\Z\0\0\0\0\0\0\0\0	\0\0\0\0\0\0\0\n\0\0\0\0\0\0W\0\0\0\0\0\0\'�\0Y�\0W�\0Y�\0�\0�\0Z_�\0�\0\"��\0(�\0*�\0\0\0\r\0\0,\0\0-\0\0\0\0\0\0\0\0#\0\0&\0\0.\0\0\0\0\0\0\0\0\0\0/\0\0\0\0\01\0\0\0\0X\0\0\0\0\0*�\03�\0*�\07�\0�\0*9�\0=�\0*?�\0=�\0\0\0\0-\0\0\0\0\0\0\0\0\0\0\r\0\Z\0\0\0\0\0.\0\0\0\0\0\0\0\0@\0A\0\0\0\0B\0\0\0\0C');
UNLOCK TABLES;
/*!40000 ALTER TABLE `SERVICE_INFO` ENABLE KEYS */;