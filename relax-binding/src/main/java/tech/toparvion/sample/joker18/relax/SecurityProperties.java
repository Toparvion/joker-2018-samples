package tech.toparvion.sample.joker18.relax;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@SuppressWarnings({"unused", "WeakerAccess"})
@Component
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {
  private String keystorePath;
  private String keystoreType;

  public String getKeystorePath() {
    return keystorePath;
  }

  public void setKeystorePath(String keystorePath) {
    this.keystorePath = keystorePath;
  }

  public String getKeyStoreType() {
    return keystoreType;
  }

  public void setKeystoreType(String keystoreType) {
    this.keystoreType = keystoreType;
  }

  @Override
  public String toString() {
    return "SecurityProperties{" +
        "keystoreType='" + keystoreType + '\'' +
        ", keystorePath='" + keystorePath + '\'' +
        '}';
  }
}
