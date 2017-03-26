# Java Mail 

## Introduction
- Demo how to use java mail send 
- The sample use gmail
Three example:
- single thread
- multiple threads
- multiple threads by spring

## Test Url:
- param: to(required, it is your e-mail), text
- Test Url: http://localhost:9090?to=user@gmail.com
- Test Url: http://localhost:9090/async?to=user@gmail.com
- Test Url: http://localhost:9090/async-spring?to=user@gmail.com

## Result
You can see log how the three case are different.

## log4j2 config
Config pom: <br>
-- Not Use logback -- 
```xml
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
```
-- Use log4j2 -- 
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-log4j2</artifactId>
</dependency>
```
Add application.properties:
- logging.config=classpath:log4j2.xml << xml config demo for file

