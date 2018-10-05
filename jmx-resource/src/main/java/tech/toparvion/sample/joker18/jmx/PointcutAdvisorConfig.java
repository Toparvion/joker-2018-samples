package tech.toparvion.sample.joker18.jmx;

import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.aop.support.RootClassFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationInterceptor;

/**
 * Rename this class to {@code AdvisorConfig} (or any other name starting with a letter less than 'M') to avoid the
 * problem
 */
@Configuration
public class PointcutAdvisorConfig {

  /**
   * The simplest proxy creator. In a real application it may be provided by some 3rd party component, e.g.
   * monitoring tool
   */
  @Bean
 	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
    return new DefaultAdvisorAutoProxyCreator();
 	}

  /**
   * A trivial advisor applying {@link MethodValidationInterceptor} to {@link MyJmxResource#launchLongLastingJob()}.
   * It is completely irrelevant which particular advisor/advice to select as it does not actually get applied.
   * The only requirement is to make it applicable (i.e. appropriate) for {@link MyJmxResource#launchLongLastingJob()}
   * because it would be ignored otherwise.
   */
  @Bean
 	public PointcutAdvisor pointcutAdvisor() {
    NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
    advisor.setClassFilter(new RootClassFilter(MyJmxResource.class));
    advisor.setMappedName("launchLongLastingJob");
    advisor.setAdvice(new MethodValidationInterceptor());
    return advisor;
  }

}
