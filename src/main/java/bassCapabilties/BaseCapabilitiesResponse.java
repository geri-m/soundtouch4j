package bassCapabilties;

import org.soundtouch4j.common.Response;
import com.google.api.client.util.Key;

public class BaseCapabilitiesResponse implements Response {

  @Key("@deviceID")
  private String deviceID;

  @Key("bassAvailable")
  private boolean bassAvailable;

  @Key("bassMin")
  private int bassMin;

  @Key("bassMax")
  private int bassMax;

  @Key("bassDefault")
  private int bassDefault;

  public BaseCapabilitiesResponse() {
  }

  public boolean isBassAvailable() {
    return bassAvailable;
  }

  public int getBassMin() {
    return bassMin;
  }

  public int getBassMax() {
    return bassMax;
  }

  public int getBassDefault() {
    return bassDefault;
  }

  public String isDeviceID() {
    return deviceID;
  }

  @Override
  public String toString() {
    return "BaseCapabilitiesResponse{" + "deviceID=" + deviceID + ", bassAvailable=" + bassAvailable + ", bassMin=" + bassMin + ", bassMax=" + bassMax + ", bassDefault=" + bassDefault + '}';
  }
}
