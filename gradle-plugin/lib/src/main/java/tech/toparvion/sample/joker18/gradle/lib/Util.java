package tech.toparvion.sample.joker18.gradle.lib;

public abstract class Util {

  public static String getAppVersion(Class<?> appClass) {
    return appClass.getPackage().getImplementationVersion();
  }
}
