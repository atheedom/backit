/*
 * Copyright 2014 Yann Le Tallec.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package je.backit.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Utility methods to create and populate maps on the fly.
 */
public final class Maps {

  private Maps() {}

  /**
   * Returns a map containing the given key value pairs. Example usage:
   * <pre> {@code
   * Map<String, Integer> m = map("a", 1, "b", 2, "c", 3);
   * }</pre>
   *
   * @param key   the first key to put in the map
   * @param value the first value to put in the map
   * @param kvs   the other key/value pairs to put in the map
   *
   * @return a map containing the given key value pairs.
   */
  public static <K, V> Map<K, V> map(K key, V value, Object... kvs) {
    return map(HashMap::new, key, value, kvs);
  }

  /**
   * Returns a new map containing the given key value pairs. Example usage:
   * <pre> {@code
   * Map<String, Integer> m = map(LinkedHashMap::new, "a", 1, "b", 2, "c", 3);
   * }</pre>
   *
   * @param mapFactory A Map constructor that accepts a capacity and loading factor as arguments.
   * @param key   the first key to put in the map
   * @param value the first value to put in the map
   * @param kvs   the other key/value pairs to put in the map
   *
   * @return a new map containing the given key value pairs.
   */
  @SuppressWarnings("unchecked")
  public static <K, V, T extends Map<K, V>> T map(BiFunction<Integer, Float, T> mapFactory, K key, V value, Object... kvs) {
    T m = mapFactory.apply(kvs.length / 2 + 1, 1f);
    m.put(key, value);
    for (int i = 0; i < kvs.length;) {
      K k = (K) kvs[i++];
      V v = (V) kvs[i++];
      if (k != null && v != null) {
        m.put(k, v);
      }
    }
    return m;
  }
}
