/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.util;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Test to the NullSafe class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-03-14)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class NullSafeTest
{

  /**
   * The default constructor.
   */
  public NullSafeTest()
  {
    super();
  }

  /**
   * Test of compare(Comparable, Comparable) method, of class NullSafe.
   */
  @Test
  public final void testCompareComparableComparable()
  {
    String object = null;
    String other = null;
    int expResult = 0;
    int result = NullSafe.compare(object, other);
    assertEquals(expResult, result, "values are not equal");

    object = null;
    other = "abc";
    expResult = -1;
    result = NullSafe.compare(object, other);
    assertEquals(expResult, result, "values are not equal");

    object = "abc";
    other = null;
    expResult = 1;
    result = NullSafe.compare(object, other);
    assertEquals(expResult, result, "values are not equal");

    object = "abc";
    other = "abc";
    expResult = 0;
    result = NullSafe.compare(object, other);
    assertEquals(expResult, result, "values are not equal");

    object = "abc";
    other = "bcd";
    expResult = -1;
    result = NullSafe.compare(object, other);
    assertEquals(expResult, result, "values are not equal");

    object = "bcd";
    other = "abc";
    expResult = 1;
    result = NullSafe.compare(object, other);
    assertEquals(expResult, result, "values are not equal");

    try
    {
      object = "abc";
      Integer otherInteger = 1;
      NullSafe.compare(object, otherInteger);
      fail("illegal state");
    } catch (ClassCastException except)
    {
      assertNotNull(except, "value is null");
    }
  }

  /**
   * Test of compare(int, Comparable, Comparable) method, of class NullSafe.
   */
  @Test
  public final void testCompareIntComparableComparable()
  {
    String object = null;
    String other = null;
    int expResult = 0;
    int result = NullSafe.compare(0, object, other);
    assertEquals(expResult, result, "values are not equal");

    object = null;
    other = "abc";
    expResult = -1;
    result = NullSafe.compare(0, object, other);
    assertEquals(expResult, result, "values are not equal");

    object = "abc";
    other = null;
    expResult = 1;
    result = NullSafe.compare(0, object, other);
    assertEquals(expResult, result, "values are not equal");

    object = "abc";
    other = "abc";
    expResult = 0;
    result = NullSafe.compare(0, object, other);
    assertEquals(expResult, result, "values are not equal");

    object = "abc";
    other = "bcd";
    expResult = -1;
    result = NullSafe.compare(0, object, other);
    assertEquals(expResult, result, "values are not equal");

    object = "bcd";
    other = "abc";
    expResult = 1;
    result = NullSafe.compare(0, object, other);
    assertEquals(expResult, result, "values are not equal");

    object = null;
    other = null;
    expResult = 1;
    result = NullSafe.compare(1, object, other);
    assertEquals(expResult, result, "values are not equal");

    object = null;
    other = "abc";
    expResult = 1;
    result = NullSafe.compare(1, object, other);
    assertEquals(expResult, result, "values are not equal");

    object = "abc";
    other = null;
    expResult = 1;
    result = NullSafe.compare(1, object, other);
    assertEquals(expResult, result, "values are not equal");

    object = "abc";
    other = "abc";
    expResult = 1;
    result = NullSafe.compare(1, object, other);
    assertEquals(expResult, result, "values are not equal");

    object = "abc";
    other = "bcd";
    expResult = 1;
    result = NullSafe.compare(1, object, other);
    assertEquals(expResult, result, "values are not equal");

    object = "bcd";
    other = "abc";
    expResult = 1;
    result = NullSafe.compare(1, object, other);
    assertEquals(expResult, result, "values are not equal");

    try
    {
      object = "abc";
      Integer otherInteger = 1;
      NullSafe.compare(0, object, otherInteger);
      fail("illegal state");
    } catch (ClassCastException except)
    {
      assertNotNull(except, "value is null");
    }
  }

  /**
   * Test of hashCode(Object) method, of class NullSafe.
   */
  @Test
  public final void testHashCodeObject()
  {
    String object = null;
    int expResult = 0;
    int result = NullSafe.hashCode(object);
    assertEquals(expResult, result, "values are not equal");

    object = "test";
    expResult = 3556498;
    result = NullSafe.hashCode(object);
    assertEquals(expResult, result, "values are not equal");
  }
}
