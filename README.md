JFR EJB [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.marschall/jfr-ejb/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.marschall/jfr-ejb) [![Javadocs](https://www.javadoc.io/badge/com.github.marschall/jfr-ejb.svg)](https://www.javadoc.io/doc/com.github.marschall/jfr-ejb)
=======

An EJB interceptor that generates JFR events.

Contains only one class `com.github.marschall.jfr.ejb.JfrInterceptor` which only records the class and method name of the EJB.

```
<dependency>
  <groupId>com.github.marschall</groupId>
  <artifactId>jfr-ejb</artifactId>
  <version>2.0.0</version>
</dependency>
```

Versions 2.x are for the `jakarta.*` namespace, versions 1.x are for the `javax.*` namespace.

Usage
-----

```java
import jakarta.interceptor.Interceptors;

import com.github.marschall.jfr.ejb.JfrInterceptor;

@Interceptors(JfrInterceptor.class)
public class SampleEjb {

}
```
