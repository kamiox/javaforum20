/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.services.exceptions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

/**
 * Test to the WrongAttributeException class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-07-31)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class WrongAttributeExceptionTest
{

  /**
   * The default constructor.
   */
  public WrongAttributeExceptionTest()
  {
    super();
  }

  /**
   * Test the constructors of exception.
   */
  @Test
  public final void testInit()
  {
    Exception except = new WrongAttributeException();
    assertNotNull(except, "value is null");
    except = new WrongAttributeException("message");
    assertNotNull(except, "value is null");
    assertEquals(except.getMessage(), "message", "value are not equal");
    except = new WrongAttributeException("npe", new NullPointerException());
    assertNotNull(except, "value is null");
    assertNotNull(except.getCause(), "value is null");
    assertEquals(except.getMessage(), "npe", "value are not equal");
  }
}
