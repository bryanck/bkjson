package org.bk.misc;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.iceberg.util.JsonUtil;

import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReflectionTest {

  public static void main(String[] args) throws Exception {
    Field field = JsonUtil.class.getDeclaredField("MAPPER");
    field.setAccessible(true);
    ObjectMapper mapper = (ObjectMapper)field.get(null);
    mapper.getFactory().configure(JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW, false);

    String json = Files.readString(Paths.get("test.json"));
    String name = JsonUtil.parse(json, ReflectionTest::fromJson);
    System.out.println(name);
  }

  public static String fromJson(JsonNode jsonNode) {
    return jsonNode.get("name").asText();
  }

}
