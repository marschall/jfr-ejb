package com.github.marschall.jfr.ejb;

import javax.interceptor.InvocationContext;

import jdk.jfr.Category;
import jdk.jfr.Description;
import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.StackTrace;

/**
 * An EJB interceptor that generates JFR events.
 */
public class JfrInterceptor {

  public Object invoke(InvocationContext ctx) throws Exception {
    EjbEvent event = new EjbEvent();
    event.setEjbClass(ctx.getTarget().getClass());
    event.setMethodName(ctx.getMethod().getName());
    try {
      return ctx.proceed();
    } finally {
      event.end();
      event.commit();
    }
  }

  @Label("EJB call")
  @Description("An call to an EJB")
  @Category("EJB")
  @StackTrace(false)
  static class EjbEvent extends Event {

    @Label("EJB Class")
    @Description("The class of the EJB")
    private Class<?> ejbClass;

    @Label("Method Name")
    @Description("The name of the invoked method")
    private String methodName;

    Class<?> getEjbClass() {
      return ejbClass;
    }

    void setEjbClass(Class<?> ejbClass) {
      this.ejbClass = ejbClass;
    }

    String getMethodName() {
      return methodName;
    }

    void setMethodName(String methodName) {
      this.methodName = methodName;
    }

  }

}
