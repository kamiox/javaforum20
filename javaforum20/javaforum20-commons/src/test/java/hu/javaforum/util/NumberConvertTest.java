/*
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.util;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

/**
 * Test to the NumberConvert class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * The first implementation (2009-06-14)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class NumberConvertTest
{

  /**
   * The default constructor.
   */
  public NumberConvertTest()
  {
    super();
  }

  /**
   * Test of doubleValue method, of class NumberConvert.
   */
  @Test
  public final void testDoubleValueString()
  {
    String text = "1.23E+1";
    Double expResult = 12.3;
    Double result = NumberConvert.doubleValue(text);
    assertEquals(expResult, result, "values are not equal");

    text = "a";
    expResult = null;
    result = NumberConvert.doubleValue(text);
    assertEquals(expResult, result, "values are not equal");
  }

  /**
   * Test of doubleValue method, of class NumberConvert.
   */
  @Test
  public final void testDoubleValueStringDouble()
  {
    String text = "1.23E+1";
    Double expResult = 12.3;
    Double result = NumberConvert.doubleValue(text, 0.0);
    assertEquals(expResult, result, "values are not equal");

    text = "a";
    expResult = 0.0;
    result = NumberConvert.doubleValue(text, 0.0);
    assertEquals(expResult, result, "values are not equal");
  }

  /**
   * Test of intValue method, of class NumberConvert.
   */
  @Test
  public final void testIntValueString()
  {
    String text = "1";
    Integer expResult = 1;
    Integer result = NumberConvert.intValue(text);
    assertEquals(expResult, result, "values are not equal");

    text = "a";
    expResult = null;
    result = NumberConvert.intValue(text);
    assertEquals(expResult, result, "values are not equal");
  }

  /**
   * Test of intValue method, of class NumberConvert.
   */
  @Test
  public final void testIntValueStringInteger()
  {
    String text = "1";
    Integer expResult = 1;
    Integer result = NumberConvert.intValue(text, 0);
    assertEquals(expResult, result, "values are not equal");

    text = "a";
    expResult = 0;
    result = NumberConvert.intValue(text, 0);
    assertEquals(expResult, result, "values are not equal");
  }

  /**
   * Test of longValue method, of class NumberConvert.
   */
  @Test
  public final void testLongValueString()
  {
    String text = "123";
    Long expResult = 123L;
    Long result = NumberConvert.longValue(text);
    assertEquals(expResult, result, "values are not equal");

    text = "a";
    expResult = null;
    result = NumberConvert.longValue(text);
    assertEquals(expResult, result, "values are not equal");
  }

  /**
   * Test of longValue method, of class NumberConvert.
   */
  @Test
  public final void testLongValueStringLong()
  {
    String text = "123";
    Long expResult = 123L;
    Long result = NumberConvert.longValue(text, 0L);
    assertEquals(expResult, result, "values are not equal");

    text = "a";
    expResult = 0L;
    result = NumberConvert.longValue(text, 0L);
    assertEquals(expResult, result, "values are not equal");
  }
}
