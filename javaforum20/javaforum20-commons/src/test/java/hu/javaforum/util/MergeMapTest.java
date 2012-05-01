/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.util;

import java.util.HashMap;
import java.util.Map;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Test to the MergeMap class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * The first implementation (2009-06-14)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class MergeMapTest
{

  /**
   * The default constructor.
   */
  public MergeMapTest()
  {
    super();
  }

  /**
   * Test of merge method, of class MergeMap.
   */
  @Test
  public final void testMerge()
  {
    Map<Object, Object> map = new HashMap<Object, Object>();
    map.put("a", "a value");
    map.put("b", "b value");
    Map<Object, Object> otherMap = new HashMap<Object, Object>();
    otherMap.put("b", "b value");
    otherMap.put("c", "c value");
    Map<Object, Object> result = MergeMap.merge(map, otherMap);
    assertNotNull(result, "value is null");
    assertTrue(result.containsKey("a"), "value is false");
    assertTrue(result.containsKey("b"), "value is false");
    assertTrue(result.containsKey("c"), "value is false");
    assertEquals("a value", result.get("a"), "values are not equal");
    assertEquals("b value", result.get("b"), "values are not equal");
    assertEquals("c value", result.get("c"), "values are not equal");

    result = MergeMap.merge(null, otherMap);
    assertFalse(result.containsKey("a"), "value is true");
    assertTrue(result.containsKey("b"), "value is false");
    assertTrue(result.containsKey("c"), "value is false");
    assertNull(result.get("a"), "value is not null");
    assertEquals("b value", result.get("b"), "values are not equal");
    assertEquals("c value", result.get("c"), "values are not equal");

    result = MergeMap.merge(map, null);
    assertTrue(result.containsKey("a"), "value is false");
    assertTrue(result.containsKey("b"), "value is false");
    assertFalse(result.containsKey("c"), "value is true");
    assertEquals("a value", result.get("a"), "values are not equal");
    assertEquals("b value", result.get("b"), "values are not equal");
    assertNull(result.get("c"), "value is not null");
  }
}
