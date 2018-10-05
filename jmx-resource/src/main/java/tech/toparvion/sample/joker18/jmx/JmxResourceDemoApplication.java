package tech.toparvion.sample.joker18.jmx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JmxResourceDemoApplication {

  /* Uncomment the following line to reveal another consequence of the root problem */
  //  @Autowired MyJmxResource myJmxResource;

  public static void main(String[] args) {
    SpringApplication.run(JmxResourceDemoApplication.class, args);
  }
}
