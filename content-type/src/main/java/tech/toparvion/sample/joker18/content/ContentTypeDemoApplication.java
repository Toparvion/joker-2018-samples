package tech.toparvion.sample.joker18.content;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static org.springframework.http.MediaType.*;

@SpringBootApplication
@RestController
public class ContentTypeDemoApplication {
  private static final Logger log = LoggerFactory.getLogger(ContentTypeDemoApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(ContentTypeDemoApplication.class, args);
  }

  /**
   * Generates a file with given name and a content inferred from the file extension. The {@code Content-Type}
   * response header value depends both on requested file extension and request's {@code Accept} header. The priority
   * between these facilities is defined by Spring Framework version and can be controlled with
   * {@code spring.mvc.contentnegotiation.favor-path-extension} parameter.
   * @param fileName the name of the file to generate and download
   * @return generated file (deliberately without {@code Content-Disposition} header to avoid actual downloading)
   */
  @GetMapping(value = "/download/{fileName:.+}",
              produces = {TEXT_HTML_VALUE, APPLICATION_JSON_UTF8_VALUE, TEXT_PLAIN_VALUE})
  public ResponseEntity<Resource> download(@PathVariable String fileName) {
    log.info("Processing file: '{}'...", fileName);
    String extension = Objects.requireNonNull(StringUtils.getFilenameExtension(fileName)).toUpperCase();
    String responseText;
    switch (extension) {
      case "HTML":
        responseText = "<!DOCTYPE html>RESPONSE IN HTML FORMAT";
        break;
      case "JSON":
        responseText = "{\"responseInJsonFormat\": true}";
        break;
      default:
        responseText = "IT'S JUST A PLAIN TEXT RESPONSE";
    }
    Resource resource = new ByteArrayResource(responseText.getBytes());
    return new ResponseEntity<>(resource, HttpStatus.OK);
  }
}
