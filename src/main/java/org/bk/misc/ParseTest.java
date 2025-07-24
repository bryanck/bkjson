package org.bk.misc;

import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public class ParseTest {

  public static void main(String[] args) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.getFactory().setStreamReadConstraints(
        StreamReadConstraints.builder()
            .maxStringLength(25_000_000)
            .build()
    );

    // file is on iCloud Drive, under /Work/Netflix
    try (InputStream in = new GZIPInputStream(new FileInputStream("metadata-big-prop.json.gz"))) {
      mapper.readTree(in);
    }
  }
}
