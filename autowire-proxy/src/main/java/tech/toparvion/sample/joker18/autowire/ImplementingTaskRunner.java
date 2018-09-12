package tech.toparvion.sample.joker18.autowire;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync(/*proxyTargetClass = true*/)
public class ImplementingTaskRunner implements TaskRunner {
  private static final Logger log = LoggerFactory.getLogger(ImplementingTaskRunner.class);

  @Async
  @Override
  public void runTask(Runnable task) {
    log.info("Running the task in thread '{}'...", Thread.currentThread().getName());
    task.run();
    log.info("The task has been successfully executed.");
  }
}
