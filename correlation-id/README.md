Correlation ID Plugin
=====================

The Correlation-Id is a UUID that can be used for troubleshooting and for correlating
multiple requests or sub-requests across multiple web services.

If a request includes the Correlation-Id header, the value will be made available via
org.restexpress.util.RequestContext.  RequestContext is a singleton thread safe instance
that maintains mapped diagnostic values (key/value pairs).

If the Correlation-Id header is not present a new random UUID will be created.

Example to get Correlation-Id value:
```Java
String correlationIdValue = (String) RequestContext.get("Correlation-Id");
```

The Correlation-Id is also returned as a header in the Response.

Logged messages should include the Correlation ID.  This will allow for specific correlation
from a consumer result to a specific exception instance.

Plugin implementation example:

```Java
RestExpress server = new RestExpress()...

new CorrelationIdPlugin()
    .register(server);
```

Maven Usage
===========
Stable:
```xml
		<dependency>
			<groupId>com.strategicgains.plugin-express</groupId>
			<artifactId>CorrelationIdPlugin</artifactId>
			<version>0.2.6</version>
		</dependency>
```
Development:
```xml
		<dependency>
			<groupId>com.strategicgains.plugin-express</groupId>
			<artifactId>CorrelationIdPlugin</artifactId>
			<version>0.2.7-SNAPSHOT</version>
		</dependency>
```
Or download the jar directly from: 
http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22LoggingPlugin%22

Note that to use the SNAPSHOT version, you must enable snapshots and a repository in your pom (or settings.xml) file as follows:
```xml
  <profiles>
    <profile>
       <id>allow-snapshots</id>
          <activation><activeByDefault>true</activeByDefault></activation>
       <repositories>
         <repository>
           <id>snapshots-repo</id>
           <url>https://oss.sonatype.org/content/repositories/snapshots</url>
           <releases><enabled>false</enabled></releases>
           <snapshots><enabled>true</enabled></snapshots>
         </repository>
       </repositories>
     </profile>
  </profiles>
```

