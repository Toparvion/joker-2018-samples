package tech.toparvion.sample.joker18.jmx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(description = "A bussines resource that can be controlled over JMX")
@EnableAsync
public class MyJmxResource {

  @ManagedOperation(description = "Launch some heavy long-lasting job")
  @Async      // in order to avoid waiting for completion in JMX console
  public void launchLongLastingJob() throws InterruptedException {
    Logger log = LoggerFactory.getLogger(getClass());
    log.info("Starting job in thread '{}'...", Thread.currentThread().getName());
    Thread.sleep(3000L);
    log.info("Job has finished.");
  }
}
