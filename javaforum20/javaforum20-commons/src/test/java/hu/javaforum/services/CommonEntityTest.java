/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.services;

import hu.javaforum.services.exceptions.ServiceException;
import java.util.Date;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Test to the CommonEntity class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-06-22)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class CommonEntityTest
{

  /**
   * The default constructor.
   */
  public CommonEntityTest()
  {
    super();
  }

  /**
   * Test of getCreated and setCreated methods, of class CommonEntity.
   */
  @Test
  public final void testCreated()
  {
    CommonEntity instance = new CommonEntityImpl();
    assertEquals(null, instance.getCreated(), "values are not equal");
    instance.setCreated(null);
    assertNull(instance.getCreated(), "value is not null");
    instance.setCreated(new Date());
    assertNotNull(instance.getCreated(), "value is null");
    assertTrue(instance.getCreated().getTime() <= new Date().getTime(), "value is false");
  }

  /**
   * Test of getApproved and setApproved methods, of class CommonEntity.
   */
  @Test
  public final void testApproved()
  {
    CommonEntity instance = new CommonEntityImpl();
    assertEquals(null, instance.getApproved(), "values are not equal");
    instance.setApproved(null);
    assertNull(instance.getApproved(), "value is not null");
    instance.setApproved(new Date());
    assertNotNull(instance.getApproved(), "value is null");
    assertTrue(instance.getApproved().getTime() <= new Date().getTime(), "value is false");
  }

  /**
   * Test of getExpired and setExpired methods, of class CommonEntity.
   */
  @Test
  public final void testExpired()
  {
    CommonEntity instance = new CommonEntityImpl();
    assertEquals(null, instance.getExpired(), "values are not equal");
    instance.setExpired(null);
    assertNull(instance.getExpired(), "value is not null");
    instance.setExpired(new Date());
    assertNotNull(instance.getExpired(), "value is null");
    assertTrue(instance.getExpired().getTime() <= new Date().getTime(), "value is false");
  }

  /**
   * Test of getModified and setModified methods, of class CommonEntity.
   */
  @Test
  public final void testModified()
  {
    CommonEntity instance = new CommonEntityImpl();
    assertEquals(null, instance.getModified(), "values are not equal");
    instance.setModified(null);
    assertNull(instance.getModified(), "value is not null");
    instance.setModified(new Date());
    assertNotNull(instance.getModified(), "value is null");
    assertTrue(instance.getModified().getTime() <= new Date().getTime(), "value is false");
  }

  /**
   * Test of getDeleted and setDeleted methods, of class CommonEntity.
   */
  @Test
  public final void testDeleted()
  {
    CommonEntity instance = new CommonEntityImpl();
    assertEquals(null, instance.getDeleted(), "values are not equal");
    instance.setDeleted(null);
    assertNull(instance.getDeleted(), "value is not null");
    instance.setDeleted(new Date());
    assertNotNull(instance.getDeleted(), "value is null");
    assertTrue(instance.getDeleted().getTime() <= new Date().getTime(), "value is false");
  }

  /**
   * A CommonEntity implementation.
   */
  public class CommonEntityImpl extends CommonEntity
  {

    /**
     * Validates the fields.
     *
     * @param create True, if the validate is called from create (or persist)
     * @throws ServiceException ServiceException
     */
    @Override
    public final void validate(final boolean create) throws ServiceException
    {
      assertNotNull(create, "value is null");
    }
  }
}
