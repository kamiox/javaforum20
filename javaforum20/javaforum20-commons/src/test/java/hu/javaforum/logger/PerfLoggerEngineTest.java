/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.logger;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Test of the PerfLoggerEngine class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-06-14)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class PerfLoggerEngineTest
{

  /**
   * The default constructor.
   */
  public PerfLoggerEngineTest()
  {
    super();
  }

  /**
   * Test of doLog method, of class PerfLoggerEngine.
   */
  @Test
  public final void testDoLog()
  {
    Logger logger = new Logger(PerfLoggerEngineTest.class);
    logger.setForcedLevel(Level.DEBUG);
    PerfLoggerEngine instance = new PerfLoggerEngine(logger);
    assertNotNull(instance, "value is null");
    instance.doLog(Level.TRACE, "message", null, null);
    instance.doLog(Level.DEBUG, "message", null, null);
    instance.doLog(Level.ERROR, "message", null, null);
    instance.doLog(Level.DEBUG, "message", "additional", null);
    instance.doLog(Level.DEBUG, "message", "additional", new Exception());
  }

  /**
   * Test of getPointOfCall method, of class PerfLoggerEngine.
   */
  @Test
  public final void testGetPointOfCall()
  {
    Logger logger = new Logger(PerfLoggerEngineTest.class);
    PerfLoggerEngine instance = new PerfLoggerEngine(logger);

    StackTraceElement[] elements = new StackTraceElement[5];
    elements[2] = new StackTraceElement("java.lang.Object", "someMethod", "irrelevant", 123);
    elements[3] = new StackTraceElement("hu.javaforum.logger", "someMethod", "irrelevant", 123);
    elements[4] = new StackTraceElement("hu.javaforum.SomeClass", "someMethod", "irrelevant", 123);
    assertEquals(instance.getPointOfCall(elements), elements[4], "values are not equal");

    elements[4] = new StackTraceElement("hu.javaforum.logger", "someMethod", "irrelevant", 123);
    assertNull(instance.getPointOfCall(elements), "value is not null");
  }

  /**
   * Test of getTime method, of class PerfLoggerEngine.
   */
  @Test
  public final void testGetTime()
  {
    Logger logger = new Logger(PerfLoggerEngineTest.class);
    logger.setForcedLevel(Level.DEBUG);
    PerfLoggerEngine instance = new PerfLoggerEngine(logger);
    double result = instance.getTime();
    assertTrue(result >= 0, "evaluation is false");
  }

  /**
   * Test of getTime method, of class PerfLoggerEngine.
   */
  @Test
  public final void testGetTimeLong()
  {
    double result = PerfLoggerEngine.getTime(0L);
    assertTrue(result > 0, "evaluation is false");

    result = PerfLoggerEngine.getTime(null);
    assertEquals(result, 0.0d, 0.0d, "values are not equal");
  }

  /**
   * Test of isLevel method, of class PerfLoggerEngine.
   */
  @Test
  public final void testIsLevel()
  {
    Logger logger = new Logger(PerfLoggerEngineTest.class);
    logger.setForcedLevel(Level.INFO);
    PerfLoggerEngine instance = new PerfLoggerEngine(logger);

    assertFalse(instance.isLevel(Level.DEBUG), "value is true");
    assertTrue(instance.isLevel(Level.INFO), "value is false");
  }

  /**
   * Test of format method, of class PerfLoggerEngine.
   */
  @Test
  public final void testFormat()
  {
    String result = PerfLoggerEngine.format("%1$s", "abc");
    assertEquals(result, "abc", "values are not equal");
  }

  /**
   * Test of getCause method, of class PerfLoggerEngine.
   */
  @Test
  public final void testGetCause()
  {
    Exception except = new Exception();
    Exception anotherExcept = new Exception(except);

    assertEquals(PerfLoggerEngine.getCause(except), except, "values are not equal");
    assertEquals(PerfLoggerEngine.getCause(anotherExcept), except, "values are not equal");
  }
}
