/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.services;

import hu.javaforum.services.exceptions.ServiceException;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

/**
 * Test of the CommonResponse class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-06-22)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class CommonResponseTest
{

  /**
   * The default constructor.
   */
  public CommonResponseTest()
  {
    super();
  }

  /**
   * Test of validate method, of class CommonResponse.
   *
   * @throws Exception Exception
   */
  @Test
  public final void testValidate() throws Exception
  {
    CommonResponse instance = new CommonResponseImpl();
    assertNotNull(instance, "value is null");
    instance.validate();
  }

  /**
   * A CommonResponse implementation.
   */
  public class CommonResponseImpl extends CommonResponse
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
