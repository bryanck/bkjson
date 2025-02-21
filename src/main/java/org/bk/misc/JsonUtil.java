package org.bk.misc;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
  private static final JsonFactory FACTORY =
      new JsonFactoryBuilder().build();

  private static final ObjectMapper MAPPER = new ObjectMapper(FACTORY);

}
