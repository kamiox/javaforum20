/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.util;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

/**
 * Test to the CreateSystemName class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * The first implementation (2009-06-14)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class CreateSystemNameTest
{

  /**
   * The default constructor.
   */
  public CreateSystemNameTest()
  {
    super();
  }

  /**
   * Test of toDeAccent method, of class CreateSystemName.
   */
  @Test
  public final void testToDeAccent()
  {
    String text = "árvíztűrő tükörfúrógép -_+;";
    String expResult = "arvizturo_tukorfurogep_____";
    String result = CreateSystemName.toDeAccent(text);
    assertEquals(expResult, result, "values are not equal");
  }
}
