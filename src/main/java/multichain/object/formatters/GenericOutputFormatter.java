/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.formatters;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0.1
 */
public class GenericOutputFormatter {
  /**
   * 
   */
  private GenericOutputFormatter() {
    super();
  }


  public static final Object format(Object jsonValue, Class<?>[] valueTypes) {
    int indexType = 0;
    boolean formatted = false;
    Object returnedValue = null;

    while (indexType < valueTypes.length && !formatted) {
      try {
        returnedValue = format(jsonValue, valueTypes[indexType]);
        formatted = true;
      } catch (Exception e) {
        indexType++;
        formatted = false;
      }

    }
    return returnedValue;
  }


  public static final <T> T format(Object jsonValue, Class<T> valueType) {
    T returnedValue = null;

    if (jsonValue != null
        && (LinkedTreeMap.class.isInstance(jsonValue) || valueType.isInstance(jsonValue))) {
      GsonBuilder builder = new GsonBuilder();
      Gson gson = builder.create();

      String nomalizedJsonValue = gson.toJson(jsonValue);
      returnedValue = gson.fromJson(nomalizedJsonValue, valueType);
    }

    return returnedValue;
  }

  @SuppressWarnings("unchecked")
  public static final <T> List<T> formatList(Object jsonValues, Class<?>[] valueTypes) {
    List<T> returnedValue = new ArrayList<>();

    if (jsonValues != null && ArrayList.class.isInstance(jsonValues)) {
      for (Object jsonValue : (ArrayList<Object>) jsonValues) {
        returnedValue.add((T) format(jsonValue, valueTypes));
      }
    }

    return returnedValue;
  }

}
