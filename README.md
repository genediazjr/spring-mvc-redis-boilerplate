## Spring MVC Redis Boilerplate

Base code for Spring MVC and Redis implementation.

**Technologies:**
* Spring MVC `v3.2.4.RELEASE`
* Spring Security `v3.1.4.RELEASE`
* Jedis `v2.1`
* JEE `v7.0`

### Usage
Modify **pom.xml**
```xml
<groupId>com.blumoon</groupId>
<artifactId>app-name-here</artifactId>
<version>0.1</version>
<packaging>war</packaging>
```
```xml
<name>app-name-here</name>
```
```xml
<build>
    <finalName>app-name-here</finalName>
    <plugins>
        <plugin>
```
Modify **context.xml**
```xml
<Context antiJARLocking="true" path="/app-url-here" />
```
Modify **config.properties**
```properties
redis.host = 127.0.0.1
redis.port = 6379
```

####IMPORTANT

`log4j` is set on debug logging mode

Upon build, copy all jars from `/target/app-name/WEB-INF/lib` to your tomcat `/lib`



### Scaffolding
**com.blumoon.app-name.domain** - encapsulation (setter-getters)

**com.blumoon.app-name.keys** - redis keys (strings, sets, sortedsets, lists, hashes)

**com.blumoon.app-name.rest** - controllers

**com.blumoon.app-name.service** - data access (SpringRedisTemplate)

**com.blumoon.app-name.util** - utility classes



