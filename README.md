JFR EJB
=======

An EJB interceptor that generates JFR events.

Contains only one class `com.github.marschall.jfr.ejb.JfrInterceptor` which only records the class and method name of the EJB.

Usage
-----

```java
import javax.interceptor.Interceptors;

import com.github.marschall.jfr.ejb.JfrInterceptor;

@Interceptors(JfrInterceptor.class)
public class SampleEjb {

}
```