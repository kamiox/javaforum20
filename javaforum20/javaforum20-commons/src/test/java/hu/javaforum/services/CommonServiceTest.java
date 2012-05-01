/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.services;

import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

/**
 * Test of the CommonService class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-06-22)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class CommonServiceTest
{

  /**
   * The default constructor.
   */
  public CommonServiceTest()
  {
    super();
  }

  /**
   * Test of constructor, of class CommonService.
   *
   * @throws Exception Exception
   */
  @Test
  public final void testConstructor() throws Exception
  {
    CommonService instance = new CommonServiceImpl();
    assertNotNull(instance, "value is null");
  }

  /**
   * A CommonService implementation.
   */
  public class CommonServiceImpl extends CommonService
  {

    /**
     * The constructor.
     */
    public CommonServiceImpl()
    {
      super();
    }
  }
}
