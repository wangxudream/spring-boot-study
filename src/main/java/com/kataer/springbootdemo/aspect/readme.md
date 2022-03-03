### SpringAOP学习

#### AOP

```text
AOP为Aspect Oriented Programming的缩写
面向切面编程，通过预编译方式和运行期间动态代理实现程序功能的统一维护
可以降低程序的耦合度，提高代码的复用性
```

#### SpringAOP

##### 使用

```xml

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

```java
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ControllerAspect {
  @Pointcut("this(com.kataer.springbootdemo.controller.AspectController)")
  public void ControllerAspect() {

  }

  /**
   * 前置通知
   *
   * @param joinPoint
   */
  @Before("ControllerAspect()")
  public void doBefore(JoinPoint joinPoint) {
    log.info("before------------>");
  }

  /**
   * 最终通知
   *
   * @param joinPoint
   */
  @After("ControllerAspect()")
  public void doAfter(JoinPoint joinPoint) {
    log.info("after------------>");
  }

  /**
   * 异常通知
   *
   * @param ex
   */
  @AfterThrowing(throwing = "ex", pointcut = "ControllerAspect()")
  public void afterThrow(Throwable ex) {
    log.info("throw------------>");
    log.info(ex.toString());
  }

  /**
   * 后置通知
   *
   * @param rv
   */
  @AfterReturning(returning = "rv", pointcut = "ControllerAspect()")
  public void afterReturn(Object rv) {
    log.info("after return------------>");
  }

  /**
   * 环绕通知
   *
   * @param joinPoint
   * @throws Throwable
   */
  @Around("ControllerAspect()")
  public void deAround(ProceedingJoinPoint joinPoint) throws Throwable {
    log.info("around start----------->");
    try {
      Object result = joinPoint.proceed();
    } catch (Exception e) {

    } finally {

    }
    log.info("around end----------->");
  }
}
```
```text
未发生异常切面执行顺序
 * around start----------->
 * before------------>
 * after return------------>
 * after------------>
 * around end----------->
发生异常切面执行顺序
 * around start----------->
 * before------------>
 * throw------------>
 * java.lang.RuntimeException: 异常
 * after------------>
 * around end----------->
```