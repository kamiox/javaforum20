/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * The MapKeyToEnumeration class creates an enumeration from the map keys.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * The first implementation (2009-01-27)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class MapKeyToEnumeration implements Enumeration
{

  /**
   * The iterator.
   */
  private final Iterator mapIterator;

  /**
   * The constructor.
   *
   * @param map The map
   */
  public MapKeyToEnumeration(final Map map)
  {
    if (map == null)
    {
      this.mapIterator = new HashMap().keySet().iterator();
    } else
    {
      this.mapIterator = map.keySet().iterator();
    }
  }

  /**
   * Gets the hasNext from the iterator.
   *
   * @return True, if has element in the iterator
   */
  @Override
  public final boolean hasMoreElements()
  {
    return mapIterator.hasNext();
  }

  /**
   * Gets the next element from the iterator.
   *
   * @return The next element
   */
  @Override
  public final Object nextElement()
  {
    return mapIterator.next();
  }
}
