/*
 * Copyright (C) 2019 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.formatters;

import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0.1
 */
public class HexFormatter {
  private HexFormatter() {
    super();
  }

  public static String toHex(String asciiValue) {
    return Hex.encodeHexString(asciiValue.getBytes(StandardCharsets.UTF_8));
  }

  public static String fromHex(String hexValue) {
    try {
      final byte[] bytes = Hex.decodeHex(hexValue.toCharArray());
      return new String(bytes, StandardCharsets.UTF_8);
    } catch (DecoderException e) {
      return null;
    }
  }

}
