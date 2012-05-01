/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.logger;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

/**
 * Test of the Level class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-06-14)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class LevelTest
{

  /**
   * The default constructor.
   */
  public LevelTest()
  {
    super();
  }

  /**
   * Test of values method, of class Level.
   */
  @Test
  public final void testValues()
  {
    Level[] expResult =
    {
      Level.TRACE, Level.DEBUG, Level.INFO, Level.WARN, Level.ERROR
    };
    Level[] result = Level.values();
    assertEquals(expResult, result, "values are not equal");
  }

  /**
   * Test of valueOf method, of class Level.
   */
  @Test
  public final void testValueOf()
  {
    assertEquals(Level.DEBUG, Level.valueOf("DEBUG"), "values are not equal");
    assertEquals(Level.ERROR, Level.valueOf("ERROR"), "values are not equal");
    assertEquals(Level.INFO, Level.valueOf("INFO"), "values are not equal");
    assertEquals(Level.TRACE, Level.valueOf("TRACE"), "values are not equal");
    assertEquals(Level.WARN, Level.valueOf("WARN"), "values are not equal");
  }
}
