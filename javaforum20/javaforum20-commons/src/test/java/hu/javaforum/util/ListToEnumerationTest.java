/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.util;

import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Test to the ListToEnumeration class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * The first implementation (2009-06-14)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class ListToEnumerationTest
{

  /**
   * The default constructor.
   */
  public ListToEnumerationTest()
  {
    super();
  }

  /**
   * Test of hasMoreElements method, of class ListToEnumeration.
   */
  @Test
  public final void testHasMoreElements()
  {
    List<String> list = new ArrayList<String>();
    list.add("a");
    list.add("b");
    ListToEnumeration instance = new ListToEnumeration(list);

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
    assertTrue(result, "values is false");

    result = instance.hasMoreElements();
    if (result)
    {
      instance.nextElement();
    }
    assertFalse(result, "value is true");

    instance = new ListToEnumeration(null);
    result = instance.hasMoreElements();
    assertFalse(result, "value is true");
  }

  /**
   * Test of nextElement method, of class ListToEnumeration.
   */
  @Test
  public final void testNextElement()
  {
    List<String> list = new ArrayList<String>();
    list.add("a");
    list.add("b");
    ListToEnumeration instance = new ListToEnumeration(list);

    Object result = null;
    if (instance.hasMoreElements())
    {
      result = instance.nextElement();
    }
    assertEquals("a", result, "values are not equal");

    result = null;
    if (instance.hasMoreElements())
    {
      result = instance.nextElement();
    }
    assertEquals("b", result, "values are not equal");

    result = null;
    if (instance.hasMoreElements())
    {
      result = instance.nextElement();
    }
    assertNull(result, "value is not null");
  }
}
