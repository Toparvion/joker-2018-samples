package tech.toparvion.sample.joker18.autowire;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProxyFactoryTest {
  private static final Logger log = LoggerFactory.getLogger(ProxyFactoryTest.class);

  @Test
  @DisplayName("Класс, имплементирующий какой-либо интерфейс, проксируется при помощи JDK")
  void classWithInterfaceIsProxiedByJDK() {
    ImplementingTaskRunner targetObject = new ImplementingTaskRunner();
    ProxyFactory proxyFactory = new ProxyFactory(targetObject);
    Object proxyObject = proxyFactory.getProxy();
    log.info("Класс прокси: {}", proxyObject.getClass());
    assertTrue(AopUtils.isJdkDynamicProxy(proxyObject));
  }

  @Test
  @DisplayName("Класс, не имплементирующий каких интерфейсов, проксируется при помощи CGLIB")
  void classWithoutInterfaceIsProxiedByCGLIB() {
    NotImplementingTaskRunner targetObject = new NotImplementingTaskRunner();
    ProxyFactory proxyFactory = new ProxyFactory(targetObject);
    Object proxyObject = proxyFactory.getProxy();
    log.info("Класс прокси: {}", proxyObject.getClass());
    assertTrue(AopUtils.isCglibProxy(proxyObject));
  }
}