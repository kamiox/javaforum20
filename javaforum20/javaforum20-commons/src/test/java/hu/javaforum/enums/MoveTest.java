/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.enums;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

/**
 * Test of the Move class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-06-22)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class MoveTest
{

  /**
   * The default constructor.
   */
  public MoveTest()
  {
    super();
  }

  /**
   * Test of values method, of class Move.
   */
  @Test
  public final void testValues()
  {
    Move[] expResult =
    {
      Move.UP, Move.DOWN, Move.TOP, Move.BOTTOM,
      Move.LEFT, Move.RIGHT, Move.FIRST, Move.LAST
    };
    Move[] result = Move.values();
    assertEquals(expResult, result, "values are not equal");
  }

  /**
   * Test of valueOf method, of class Move.
   */
  @Test
  public final void testValueOf()
  {
    assertEquals(Move.UP, Move.valueOf("UP"), "values are not equal");
    assertEquals(Move.DOWN, Move.valueOf("DOWN"), "values are not equal");
    assertEquals(Move.TOP, Move.valueOf("TOP"), "values are not equal");
    assertEquals(Move.BOTTOM, Move.valueOf("BOTTOM"), "values are not equal");
    assertEquals(Move.LEFT, Move.valueOf("LEFT"), "values are not equal");
    assertEquals(Move.RIGHT, Move.valueOf("RIGHT"), "values are not equal");
    assertEquals(Move.FIRST, Move.valueOf("FIRST"), "values are not equal");
    assertEquals(Move.LAST, Move.valueOf("LAST"), "values are not equal");
  }
}
