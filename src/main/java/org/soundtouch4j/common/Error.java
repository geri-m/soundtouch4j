package org.soundtouch4j.common;

import com.google.api.client.util.Key;

public class Error {

  @Key("@value")
  private int value;

  @Key("@name")
  private ErrorEnum name;

  @Key("@severity")
  private String severity;

  @Key("text()")
  private String text;

  public Error() {
  }

  public int getValue() {
    return value;
  }

  public ErrorEnum getName() {
    return name;
  }

  public String getSeverity() {
    return severity;
  }

  public String getText() {
    return text;
  }

  @Override
  public String toString() {
    return "Error{" + "value=" + value + ", name=" + name + ", severity='" + severity + '\'' + ", text='" + text + '\'' + '}';
  }
}
