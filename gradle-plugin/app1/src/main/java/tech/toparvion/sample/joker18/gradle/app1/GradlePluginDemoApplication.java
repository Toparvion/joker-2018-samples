package tech.toparvion.sample.joker18.gradle.app1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.toparvion.sample.joker18.gradle.lib.Util;

@SpringBootApplication
public class GradlePluginDemoApplication implements ApplicationRunner {
  private static final Logger log = LoggerFactory.getLogger(GradlePluginDemoApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(GradlePluginDemoApplication.class, args);
  }

  @Override
  public void run(ApplicationArguments args) {
    String appVersion = Util.getAppVersion(getClass());
    log.info("Current application version: {}", appVersion);
  }
}
