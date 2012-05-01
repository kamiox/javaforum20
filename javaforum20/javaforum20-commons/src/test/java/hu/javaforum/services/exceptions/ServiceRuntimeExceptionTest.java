/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.services.exceptions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

/**
 * Test to the ServiceRuntimeException class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-07-31)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class ServiceRuntimeExceptionTest
{

  /**
   * The default constructor.
   */
  public ServiceRuntimeExceptionTest()
  {
    super();
  }

  /**
   * Test the constructors of exception.
   */
  @Test
  public final void testInit()
  {
    Exception except = new ServiceRuntimeException();
    assertNotNull(except, "value is null");
    except = new ServiceRuntimeException("message");
    assertNotNull(except, "value is null");
    assertEquals(except.getMessage(), "message", "value are not equal");
    except = new ServiceRuntimeException("npe", new NullPointerException());
    assertNotNull(except, "value is null");
    assertNotNull(except.getCause(), "value is null");
    assertEquals(except.getMessage(), "npe", "value are not equal");
  }
}
