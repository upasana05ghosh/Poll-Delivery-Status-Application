# Poll-Delivery-Status-Application
Spring Boot application to poll delivery status after certain intervals

## Introduction
This is a sample polling application using Apache camel and spring boot
that polls delivery status after certain interval.

## Steps to create application

1. Create a spring boot application using https://start.spring.io/
2. Add dependecy of Apache camel or we can add it in pom.xml too if it's a maven project

```
    <dependency>
        <groupId>org.apache.camel</groupId>
        <artifactId>camel-spring-boot-starter</artifactId>
        <version>2.22.0</version>
    </dependency>
```

3.  Create a camel router by extending RouteBuilder class.
	- Here we need to provide a configue() function which specifies refresh interval, delay interval
	   and the process that you want to execute in that router.
	 
```
	 public void configure() throws Exception {

		from("timer:pollDeliveryStatusRoute?period=" + properties.getRefreshInterval()).autoStartup(true)
				.routeId(ROUTE_NAME).delay(properties.getRefreshStartUpDelay()).process(processor);

	}
```
	
4. Create a processor function or a processor class

```
	@Override
	public void process(Exchange exchange) throws Exception {
		log.info("Polling started.......");
		pollDeliveryService.poll();    //perform the service
		log.info("Polling completed......");
	}
```

5. To ensure the application keeps running until stopped (it it's an standalone application),
	add the following property in application.properties file
	
	```
	camel.springboot.main-run-controller = true
	```
	
6. Output of the application:
![Output of the application](https://github.com/upasana05ghosh/Poll-Delivery-Status-Application/blob/main/ApplicationOutput.png)


### Reference
https://camel.apache.org/camel-spring-boot/latest/

