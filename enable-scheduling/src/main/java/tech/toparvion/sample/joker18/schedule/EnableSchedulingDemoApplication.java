package tech.toparvion.sample.joker18.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
//@EnableScheduling     // needed for Spring Boot 2.x only
public class EnableSchedulingDemoApplication {
  private static final Logger log = LoggerFactory.getLogger(EnableSchedulingDemoApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(EnableSchedulingDemoApplication.class, args);
  }

  @Scheduled(fixedRate = 3000L)
  public void doOnSchedule() {
    log.info("Another 3000 milliseconds have passed...");
  }
}
