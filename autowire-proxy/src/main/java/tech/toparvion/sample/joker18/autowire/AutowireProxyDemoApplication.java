package tech.toparvion.sample.joker18.autowire;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class AutowireProxyDemoApplication implements ApplicationRunner {
  private static final Logger log = LoggerFactory.getLogger(AutowireProxyDemoApplication.class);

  @Autowired
  private AsyncTaskRunner taskRunner;

  public static void main(String[] args) {
    SpringApplication.run(AutowireProxyDemoApplication.class, args);
  }


  @Override
  public void run(ApplicationArguments args) {
    log.info("Class of task runner: {}", taskRunner.getClass().getSimpleName());
    taskRunner.runTask(AutowireProxyDemoApplication::sleep);
  }

  private static void sleep() {
    try {
      Thread.sleep(3000L);
    } catch (InterruptedException e) {
      log.error("Failed to sleep", e);
    }
  }
}
