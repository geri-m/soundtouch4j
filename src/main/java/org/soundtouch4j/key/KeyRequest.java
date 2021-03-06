package org.soundtouch4j.key;

import org.soundtouch4j.common.Request;
import com.google.api.client.util.Key;

/**
 * Request Object for the '/key' HTTP-POST Request. Requires the Key as well as the Key State
 */

public class KeyRequest implements Request {

  public static final String ELEMENT_NAME = "key";
  private static final String GABBO = "Gabbo";

  // This value is always "Gabbo" - see documentation.
  @Key("@sender")
  private final String sender = GABBO;
  @Key("text()")
  private final String key;
  @Key("@state")
  private String keyState;


  public KeyRequest(final KeyPressValueEnum key, final KeyStateEnum keyState) {
    super();
    this.keyState = keyState.getValue();
    this.key = key.name();
  }

}
