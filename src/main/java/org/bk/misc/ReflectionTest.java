package org.bk.misc;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bk.misc.json.JsonUtil;

import java.lang.reflect.Field;

public class ReflectionTest {

  public static void main(String[] args) throws Exception {
    Field field = JsonUtil.class.getDeclaredField("MAPPER");
    field.setAccessible(true);
    ObjectMapper mapper = (ObjectMapper)field.get(null);
    mapper.getFactory().configure(JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW, false);

    JsonUtil.parse();
  }
}
