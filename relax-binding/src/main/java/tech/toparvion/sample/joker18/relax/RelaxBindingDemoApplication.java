package tech.toparvion.sample.joker18.relax;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class RelaxBindingDemoApplication implements ApplicationRunner {
  private static final Logger log = LoggerFactory.getLogger(RelaxBindingDemoApplication.class);

  @Autowired
  private SecurityProperties securityProperties;

	public static void main(String[] args) {
		SpringApplication.run(RelaxBindingDemoApplication.class, args);
	}

  @Override
  public void run(ApplicationArguments args) {
    log.info("keystore type: {}", securityProperties.getKeyStoreType());
  }
}