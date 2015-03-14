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

/**
 * Utility methods to transform checked exceptions into unchecked exceptions.
 */
public final class Unchecked {

  private Unchecked() {}

  /**
   * Returns the throwable itself, but in a way that leads the compiler to believe that it is an unchecked exception.
   * @param t a Throwable, which may be a checked exception
   * @return the throwable itself, but in a way that leads the compiler to believe that it is an unchecked exception.
   */
  public static <T> T uncheck(Throwable t) {
    return Unchecked.<RuntimeException, T>rethrow(t);
  }

  @SuppressWarnings("unchecked")
  private static <E extends Throwable, T> T rethrow(Throwable t) throws E {
    throw (E) t;
  }
}
