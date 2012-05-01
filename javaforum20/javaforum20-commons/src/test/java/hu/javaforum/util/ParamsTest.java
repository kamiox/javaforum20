/*
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.util;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

/**
 * Test to the Params class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-07-31)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class ParamsTest
{

  /**
   * The default constructor.
   */
  public ParamsTest()
  {
    super();
  }

  /**
   * Test of constructor, of class Params.
   */
  @Test
  public final void testInit()
  {
    Params params = new Params();
    params.put("a", "a value");
    assertEquals(params.get("a"), "a value", "values are not equal");
  }
}
