@setlocal
@echo off

@set AH=e:\lib\axis

set CP=%AH%\lib\axis-ant.jar
set CP=%CP%;%AH%\lib\axis.jar
set CP=%CP%;%AH%\lib\commons-discovery.jar
set CP=%CP%;%AH%\lib\commons-logging.jar
set CP=%CP%;%AH%\lib\jaxrpc.jar
set CP=%CP%;%AH%\lib\log4j-1.2.8.jar
set CP=%CP%;%AH%\lib\saaj.jar
set CP=%CP%;%AH%\lib\wsdl4j.jar
set CP=%CP%;..\..\classes

java -cp %CP% org.apache.axis.wsdl.Java2WSDL -u LITERAL -y DOCUMENT -l "http://localhost:80/eMayor/ForwardManager" -o ForwardManagerWS.wsdl --PkgtoNS "org.emayor.servicehandling.kernel.forward"="uri:org.emayor.servicehandling.kernel.forward" org.emayor.servicehandling.kernel.forward.IForward

@endlocal