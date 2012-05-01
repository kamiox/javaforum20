/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.logger;

import hu.javaforum.services.CommonEntity;
import hu.javaforum.services.CommonRequest;
import hu.javaforum.services.CommonResponse;
import hu.javaforum.services.exceptions.ServiceException;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

/**
 * Test of the PerfTracer class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-06-14)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class PerfTracerTest
{

  /**
   * The default constructor.
   */
  public PerfTracerTest()
  {
    super();
  }

  /**
   * Test of entry method, of class PerfTracer.
   */
  @Test
  public final void testEntry()
  {
    PerfTracer instance = new PerfTracer(new Tracer(PerfTracerTest.class));
    assertNotNull(instance, "value is null");
    instance.entry();
  }

  /**
   * Test of entry method, of class PerfTracer.
   */
  @Test
  public final void testEntryCommonEntity()
  {
    PerfTracer instance = new PerfTracer(new Tracer(PerfTracerTest.class));
    assertNotNull(instance, "value is null");
    instance.entry(new TestEntity());
  }

  /**
   * Test of entry method, of class PerfTracer.
   */
  @Test
  public final void testEntryCommonRequest()
  {
    PerfTracer instance = new PerfTracer(new Tracer(PerfTracerTest.class));
    assertNotNull(instance, "value is null");
    instance.entry(new TestRequest());
  }

  /**
   * Test of exit method, of class PerfTracer.
   */
  @Test
  public final void testExit()
  {
    PerfTracer instance = new PerfTracer(new Tracer(PerfTracerTest.class));
    assertNotNull(instance, "value is null");
    instance.exit();
  }

  /**
   * Test of exit method, of class PerfTracer.
   */
  @Test
  public final void testExitCommonEntity()
  {
    PerfTracer instance = new PerfTracer(new Tracer(PerfTracerTest.class));
    assertNotNull(instance, "value is null");
    instance.exit(new TestEntity());
  }

  /**
   * Test of exit method, of class PerfTracer.
   */
  @Test
  public final void testExitCommonResponse()
  {
    PerfTracer instance = new PerfTracer(new Tracer(PerfTracerTest.class));
    assertNotNull(instance, "value is null");
    instance.exit(new TestResponse());
  }

  /**
   * TestEntity to CommonEntity entry and exit log.
   */
  protected class TestEntity extends CommonEntity
  {

    /**
     * Mock validate method. Throws exception.
     *
     * @param create NA
     * @throws ServiceException NA
     */
    @Override
    public final void validate(final boolean create) throws ServiceException
    {
      throw new UnsupportedOperationException("Not supported yet.");
    }
  }

  /**
   * TestRequest to CommonRequest entry log.
   */
  protected class TestRequest extends CommonRequest
  {

    /**
     * Mock validate method. Throws exception.
     *
     * @throws ServiceException NA
     */
    @Override
    public final void validate() throws ServiceException
    {
      throw new UnsupportedOperationException("Not supported yet.");
    }
  }

  /**
   * TestResponse to CommonResponse exit log.
   */
  protected class TestResponse extends CommonResponse
  {

    /**
     * Mock validate method. Throws exception.
     *
     * @throws ServiceException NA
     */
    @Override
    public final void validate() throws ServiceException
    {
      throw new UnsupportedOperationException("Not supported yet.");
    }
  }
}
