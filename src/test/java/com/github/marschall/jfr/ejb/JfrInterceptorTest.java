package com.github.marschall.jfr.ejb;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.interceptor.InvocationContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JfrInterceptorTest {

  private JfrInterceptor interceptor;

  @BeforeEach
  void setUp() {
    this.interceptor = new JfrInterceptor();
  }

  @Test
  void test() throws Exception {
    // arrange
    InvocationContext ctx = mock(InvocationContext.class);
    Target target = new Target();
    Result result = new Result();

    when(ctx.getTarget()).thenReturn(target);
    when(ctx.getMethod()).thenReturn(Target.class.getDeclaredMethod("intercepted"));
    when(ctx.proceed()).thenReturn(result);

    // act
    Object invocationResult = this.interceptor.invoke(ctx);

    // assert
    verify(ctx, times(1)).proceed();
    assertSame(result, invocationResult);
  }

  static final class Target {

    public void intercepted() {

    }

  }

  static final class Result {

  }

}
