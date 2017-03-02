# xml rpc 

## Introduction
Use spring boot to demo xml-rpc (JAXB) to request for servlet and Resolve xml to transfer for API call

Object Information:
BaseRequest: Used to solve which API call.
MethodCall:  Used to invoke API for doXXX method

EX: GetUserDetail API call
req:
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<methodCall>
    <methodName>GetUserDetail</methodName>
    <requestBy>TEST</requestBy>
    <requestID>1488468774571</requestID>
    <requestDateTime>20170302233254</requestDateTime>
    <username>Max</username>
</methodCall>

res:
<methodResponse>
    <responseDateTime>20170302233254</responseDateTime>
    <responseCode>0</responseCode>
    <responseMessage>test response OK</responseMessage>
</methodResponse>

# log4j2 config
Config pom:
-- Not Use logback -- 
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter</artifactId>
	<exclusions>
		<exclusion>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-logging</artifactId>
		</exclusion>
	</exclusions>
</dependency>
-- Use log4j2 -- 
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-log4j2</artifactId>
</dependency>

Add application.properties:
logging.config=classpath:log4j2.xml << xml config demo for file

