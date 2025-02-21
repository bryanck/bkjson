package org.bk.misc.json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonUtil {
  private static final JsonFactory FACTORY =
      new JsonFactoryBuilder().build();

  private static final ObjectMapper MAPPER = new ObjectMapper(FACTORY);

  public static void parse() throws Exception {
    MAPPER.readTree(new File("./test.json"));
  }

}
