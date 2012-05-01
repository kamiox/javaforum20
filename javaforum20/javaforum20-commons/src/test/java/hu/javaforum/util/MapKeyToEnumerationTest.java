/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.util;

import java.util.Map;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Test to the MapKeyToEnumeration class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * The first implementation (2009-06-14)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class MapKeyToEnumerationTest
{

  /**
   * The default constructor.
   */
  public MapKeyToEnumerationTest()
  {
    super();
  }

  /**
   * Test of hasMoreElements method, of class MapKeyToEnumeration.
   */
  @Test
  public final void testHasMoreElements()
  {
    Map<String, String> map = new Params();
    map.put("a", "a value");
    map.put("b", "b value");
    MapKeyToEnumeration instance = new MapKeyToEnumeration(map);

    boolean result = instance.hasMoreElements();
    if (result)
    {
      instance.nextElement();
    }
    assertTrue(result, "value is false");

    result = instance.hasMoreElements();
    if (result)
    {
      instance.nextElement();
    }
    assertTrue(result, "value is false");

    result = instance.hasMoreElements();
    if (result)
    {
      instance.nextElement();
    }
    assertFalse(result, "value is false");

    instance = new MapKeyToEnumeration(null);
    result = instance.hasMoreElements();
    assertFalse(result, "value is false");
  }

  /**
   * Test of nextElement method, of class MapKeyToEnumeration.
   */
  @Test
  public final void testNextElement()
  {
    Map<String, String> map = new Params();
    map.put("a", "a value");
    map.put("b", "b value");
    MapKeyToEnumeration instance = new MapKeyToEnumeration(map);

    Object result = null;
    if (instance.hasMoreElements())
    {
      result = instance.nextElement();
    }
    assertTrue("a".equals(result) || "b".equals(result), "value is false");

    result = null;
    if (instance.hasMoreElements())
    {
      result = instance.nextElement();
    }
    assertTrue("a".equals(result) || "b".equals(result), "value is false");

    result = null;
    if (instance.hasMoreElements())
    {
      result = instance.nextElement();
    }
    assertNull(result, "value is not null");
  }
}
