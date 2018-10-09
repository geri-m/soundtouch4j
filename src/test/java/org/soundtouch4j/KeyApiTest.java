package org.soundtouch4j;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.HttpTesting;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.client.xml.Xml;


public class KeyApiTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(KeyApiTest.class);


  private final HttpTransport transport = new MockHttpTransport() {
    @Override
    public LowLevelHttpRequest buildRequest(final String method, final String url) {
      return new MockLowLevelHttpRequest() {
        @Override
        public LowLevelHttpResponse execute() {
          final MockLowLevelHttpResponse result = new MockLowLevelHttpResponse();
          result.setContentType(Xml.MEDIA_TYPE);
          result.setContent("<?xml version=\"1.0\" encoding=\"UTF-8\" ?><status>/key</status>");
          return result;
        }
      };
    }
  };

  @Test
  public void test01_power() {
    LOGGER.info("test01_power started");
    final SoundTouch soundTouchApi = new SoundTouchApi(HttpTesting.SIMPLE_GENERIC_URL.toURL(), transport);
    try {
      soundTouchApi.getKeyApi()
          .power();
    } catch (final SoundTouchApiException e) {
      LOGGER.error("Unable to get the basic information: {}", e.getMessage());
      fail();
    }
    LOGGER.info("test01_power done");
  }

  @Test
  public void test02_powerBrokenResponse() {
    LOGGER.info("test02_powerBrokenResponse started");
    final HttpTransport transport = Const.getBrokenResponse();

    final SoundTouch soundTouchApi = new SoundTouchApi(HttpTesting.SIMPLE_GENERIC_URL.toURL(), transport);
    try {
      soundTouchApi.getKeyApi()
          .power();
      fail();
    } catch (final SoundTouchApiException e) {
      LOGGER.error("Unable to get the basic information: {}", e.getMessage());

    }
    LOGGER.info("test02_powerBrokenResponse completed");
  }

  @Test
  public void test03_powerIncorrectResponse() {
    LOGGER.info("test03_powerIncorrectResponse started");
    final HttpTransport transport = Const.getIncorrectStatusResponse("NOTPower");
    final SoundTouch soundTouchApi = new SoundTouchApi(HttpTesting.SIMPLE_GENERIC_URL.toURL(), transport);
    try {
      soundTouchApi.getKeyApi()
          .power();
      fail();
    } catch (final SoundTouchApiException e) {
      LOGGER.error("Unable to get the basic information: {}", e.getMessage());
      assertEquals("Invalid Response from Speaker. Response was '/NOTPower'", e.getMessage());
    }
    LOGGER.info("test03_powerIncorrectResponse completed");
  }


  @Test
  public void test04_mute() {
    LOGGER.info("test04_mute started");
    final SoundTouch soundTouchApi = new SoundTouchApi(HttpTesting.SIMPLE_GENERIC_URL.toURL(), transport);
    try {
      soundTouchApi.getKeyApi()
          .mute();
    } catch (final SoundTouchApiException e) {
      LOGGER.error("Unable to get the basic information: {}", e.getMessage());
      fail();
    }
    LOGGER.info("test04_mute done");
  }

  @Test
  public void test05_muteBrokenResponse() {
    LOGGER.info("test05_muteBrokenResponse started");
    final HttpTransport transport = Const.getBrokenResponse();

    final SoundTouch soundTouchApi = new SoundTouchApi(HttpTesting.SIMPLE_GENERIC_URL.toURL(), transport);
    try {
      soundTouchApi.getKeyApi()
          .mute();
      fail();
    } catch (final SoundTouchApiException e) {
      LOGGER.error("Unable to get the basic information: {}", e.getMessage());

    }
    LOGGER.info("test05_muteBrokenResponse completed");
  }

  @Test
  public void test06_muteIncorrectResponse() {
    LOGGER.info("test06_muteIncorrectResponse started");
    final HttpTransport transport = Const.getIncorrectStatusResponse("NOTMute");
    final SoundTouch soundTouchApi = new SoundTouchApi(HttpTesting.SIMPLE_GENERIC_URL.toURL(), transport);
    try {
      soundTouchApi.getKeyApi()
          .mute();
      fail();
    } catch (final SoundTouchApiException e) {
      LOGGER.error("Unable to get the basic information: {}", e.getMessage());
      assertEquals("Invalid Response from Speaker. Response was '/NOTMute'", e.getMessage());
    }
    LOGGER.info("test06_muteIncorrectResponse completed");
  }

}
