/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.util;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

/**
 * Test to the NameHelper class.
 *
 * Changelog:
 * First implementation (2012-04-30)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class NameHelperTest
{

  /**
   * The default constructor.
   */
  public NameHelperTest()
  {
    super();
  }

  /**
   * Test of constructor, of class NameHelper.
   */
  @Test
  public final void testConstructor()
  {
    assertNotNull(NameHelper.INSTANCE, "value is null");
  }

  /**
   * Test of firstToLowerCase() method, of class NameHelper.
   */
  @Test
  public final void testFirstToLowerCase()
  {
    char[] lowerCase1 = "toLowerCase".toCharArray();
    char[] lowerCase2 = "ToLowerCase".toCharArray();
    assertEquals(lowerCase1, NameHelper.firstToLowerCase("ToLowerCase"), "values are not equal");
    assertEquals(lowerCase1, NameHelper.firstToLowerCase("toLowerCase"), "values are not equal");
    assertEquals("".toCharArray(), NameHelper.firstToLowerCase(""), "values are not equal");
    assertEquals("".toCharArray(), NameHelper.firstToLowerCase(null), "values are not equal");
    assertEquals(lowerCase2, NameHelper.firstToLowerCase("ToLowerCase".toCharArray(), false), "values are not equal");
    assertEquals("".toCharArray(), NameHelper.firstToLowerCase("".toCharArray(), false), "values are not equal");
    assertEquals("".toCharArray(), NameHelper.firstToLowerCase(null, false), "values are not equal");
  }

  /**
   * Test of firstToUpperCase() method, of class NameHelper.
   */
  @Test
  public final void testFirstToUpperCase()
  {
    char[] lowerCase1 = "toUpperCase".toCharArray();
    char[] lowerCase2 = "ToUpperCase".toCharArray();
    assertEquals(lowerCase2, NameHelper.firstToUpperCase("ToUpperCase"), "values are not equal");
    assertEquals(lowerCase2, NameHelper.firstToUpperCase("toUpperCase"), "values are not equal");
    assertEquals("".toCharArray(), NameHelper.firstToUpperCase(""), "values are not equal");
    assertEquals("".toCharArray(), NameHelper.firstToUpperCase(null), "values are not equal");
    assertEquals(lowerCase1, NameHelper.firstToUpperCase("toUpperCase".toCharArray(), false), "values are not equal");
    assertEquals("".toCharArray(), NameHelper.firstToUpperCase("".toCharArray(), false), "values are not equal");
    assertEquals("".toCharArray(), NameHelper.firstToUpperCase(null, false), "values are not equal");
  }
}
