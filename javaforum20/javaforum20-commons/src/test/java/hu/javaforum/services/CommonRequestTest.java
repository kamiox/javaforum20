/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.services;

import hu.javaforum.services.exceptions.ServiceException;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

/**
 * Test of the CommonRequest class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-06-22)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class CommonRequestTest
{

  /**
   * The default constructor.
   */
  public CommonRequestTest()
  {
    super();
  }

  /**
   * Test of validate method, of class CommonRequest.
   *
   * @throws Exception Exception
   */
  @Test
  public final void testValidate() throws Exception
  {
    CommonRequest instance = new CommonRequestImpl();
    assertNotNull(instance, "value is null");
    instance.validate();
  }

  /**
   * A CommonRequest implementation.
   */
  public class CommonRequestImpl extends CommonRequest
  {

    /**
     * Implements the validate method.
     *
     * @throws ServiceException ServiceException
     */
    public final void validate() throws ServiceException
    {
      assertNotNull(this, "value is null");
    }
  }
}
