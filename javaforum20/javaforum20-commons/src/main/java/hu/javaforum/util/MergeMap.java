/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.util;

import java.util.HashMap;
import java.util.Map;

/**
 * The MergeMap creates a new Map instance from two Map instance.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * The first implementation (2009-01-31)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public final class MergeMap
{

  /**
   * The static instance (singleton pattern).
   */
  public static final MergeMap INSTANCE = new MergeMap();

  /**
   * The private constructor, because "all" methods are static.
   */
  private MergeMap()
  {
    super();
  }

  /**
   * Creates a new HashMap instance from the 'map' and the 'otherMap' instance.
   * If the any key already exists in the 'otherMap', the value from the 'map'
   * overwritted from the value of the 'otherMap'.
   *
   * @param map The map
   * @param otherMap The other map
   * @return The merged map
   */
  public static Map<Object, Object> merge(final Map<Object, Object> map, final Map<Object, Object> otherMap)
  {
    Map<Object, Object> result = new HashMap<Object, Object>();

    if (map != null)
    {
      for (Map.Entry<Object, Object> item : map.entrySet())
      {
        result.put(item.getKey(), item.getValue());
      }
    }

    if (otherMap != null)
    {
      for (Map.Entry<Object, Object> item : otherMap.entrySet())
      {
        result.put(item.getKey(), item.getValue());
      }
    }

    return result;
  }
}
